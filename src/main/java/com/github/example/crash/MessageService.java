package com.github.example.crash;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class MessageService {

    private static final int CORE_POOL_SIZE = 2;

    private static final long INITIAL_DELAY = 0;
    private static final long PERIOD = 2;

    private final ScheduledExecutorService executor;

    public MessageService() {
        this.executor = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
    }

    public void startJobs() {
        this.executor.scheduleAtFixedRate(new CratedMessageTask(), INITIAL_DELAY, PERIOD, TimeUnit.SECONDS);
    }

    public ThreadPoolExecutorMetrics getThreadPoolExecutorMetrics() {
        return new ThreadPoolExecutorMetrics((ThreadPoolExecutor) this.executor);
    }

    private class CratedMessageTask implements Runnable {

        private final LocalDateTime created;

        public CratedMessageTask() {
            this.created = LocalDateTime.now();
        }

        @Override
        public void run() {
            System.out.println(String.format("Created on: %s", this.created));
        }
    }
}