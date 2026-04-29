package com.example.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public final class OrderNoUtil {
    private static final AtomicInteger SEQUENCE = new AtomicInteger(1000);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    private OrderNoUtil() {
    }

    public static String next() {
        return "DW" + LocalDateTime.now().format(FORMATTER) + SEQUENCE.incrementAndGet();
    }
}
