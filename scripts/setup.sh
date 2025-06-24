#!/bin/bash

npm install -g @typespec/compiler

EXTENSIONS_FILE=".vscode/extensions.json"


if [ ! -f "$EXTENSIONS_FILE" ]; then
  echo "File $EXTENSIONS_FILE not exists."
  exit 1
fi


extensions=$(jq -r '.recommendations[]' "$EXTENSIONS_FILE")


if [ -z "$extensions" ]; then
  echo "No extensions found in $EXTENSIONS_FILE"
  exit 1
fi


for ext in $extensions; do
  echo "Installing extension: $ext"
  code --install-extension "$ext"
done

echo "All recommended extensions have been installed."
