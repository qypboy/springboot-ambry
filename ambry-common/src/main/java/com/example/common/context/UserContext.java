package com.example.common.context;

public final class UserContext {
    private static final ThreadLocal<LoginUser> HOLDER = new ThreadLocal<>();

    private UserContext() {
    }

    public static void set(LoginUser user) {
        HOLDER.set(user);
    }

    public static LoginUser get() {
        LoginUser user = HOLDER.get();
        return user == null ? LoginUser.anonymous() : user;
    }

    public static void clear() {
        HOLDER.remove();
    }
}
