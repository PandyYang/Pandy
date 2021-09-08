package com.pandy.test;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class TimeTest {
    public static void main(String[] args) {
        Map<String, String> codeAndOpenIdMap = new ConcurrentHashMap<>();
        codeAndOpenIdMap.put("time", "1");
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(() -> {
            codeAndOpenIdMap.keySet().parallelStream().filter(Objects::nonNull).forEach(res -> {
                Instant createTime = Instant.parse(res.substring('_') + 1);
                if (Duration.between(createTime, Instant.now()).toMinutes() < 5) {
                    codeAndOpenIdMap.remove(res);
                }
            });
        }, 10, 60, TimeUnit.MINUTES);
    }
}
