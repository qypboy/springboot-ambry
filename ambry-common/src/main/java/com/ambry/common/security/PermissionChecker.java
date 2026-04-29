package com.ambry.common.security;

import java.util.Collection;

public interface PermissionChecker {
    boolean hasAnyPermission(Long userId, Collection<String> permissions);
}

