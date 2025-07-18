ARG BASE_IMAGE=node:22-alpine

# Install dependencies only when needed
FROM ${BASE_IMAGE} AS deps
# Check https://github.com/nodejs/docker-node/tree/b4117f9333da4138b03a546ec926ef50a31506c3#nodealpine to understand why libc6-compat might be needed.
RUN apk add --no-cache libc6-compat
WORKDIR /app/hrm-front

# Install dependencies based on the preferred package manager
COPY hrm-front/package.json hrm-front/package-lock.json* ./
RUN npm ci 


# Rebuild the source code only when needed
FROM ${BASE_IMAGE} AS builder
WORKDIR /app/hrm-front
COPY --from=deps /app/hrm-front/node_modules ./node_modules
COPY ./hrm-front .

RUN npm run generate
RUN npm run build

# Production image, copy all the files and run next
FROM ${BASE_IMAGE} AS runner
WORKDIR /app/hrm-front

ENV NODE_ENV=production

ENV NEXT_TELEMETRY_DISABLED=1

RUN addgroup --system --gid 1001 nodejs
RUN adduser --system --uid 1001 nextjs

COPY --from=builder /app/hrm-front/public ./public

# Automatically leverage output traces to reduce image size
# https://nextjs.org/docs/advanced-features/output-file-tracing
COPY --from=builder --chown=nextjs:nodejs /app/hrm-front/.next/standalone ./
COPY --from=builder --chown=nextjs:nodejs /app/hrm-front/.next/static ./.next/static


USER nextjs

EXPOSE 3000

ENV PORT=3000

# server.js is created by next build from the standalone output
# https://nextjs.org/docs/pages/api-reference/config/next-config-js/output
ENV HOSTNAME="0.0.0.0"
CMD ["node", "server.js"]
