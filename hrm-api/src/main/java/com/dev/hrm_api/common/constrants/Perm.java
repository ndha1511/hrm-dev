package com.dev.hrm_api.common.constrants;

import java.util.List;
import java.util.Map;

public class Perm {

    public static final int VIEW = 1; // 0001
    public static final int CREATE = 2; // 0010
    public static final int UPDATE = 4; // 0100
    public static final int DELETE = 8; // 1000

    private static final Map<Integer, String> PERM_MAP = Map.of(
            VIEW, "VIEW",
            CREATE, "CREATE",
            UPDATE, "UPDATE",
            DELETE, "DELETE");

    /**
     * Returns a list of permission names based on the provided bitmask value.
     *
     * @param nPerm An integer representing combined permissions using bitmask (e.g.
     *              5 = VIEW + UPDATE)
     * @return A list of permission names (e.g. ["VIEW", "UPDATE"])
     */
    public static List<String> getPermList(int nPerm) {
        return PERM_MAP.entrySet().stream()
                .filter(entry -> (nPerm & entry.getKey()) == entry.getKey())
                .map(Map.Entry::getValue)
                .toList();
    }
}
