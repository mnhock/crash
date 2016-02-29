package com.github.example.crash;

import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExecutorMetrics {
    private final ThreadPoolExecutor executor;

    public ThreadPoolExecutorMetrics(ThreadPoolExecutor executor) {
        this.executor = executor;
    }

    public int getActiveCount() {
        return this.executor.getActiveCount();
    }

    public long getTaskCount() {
        return this.executor.getTaskCount();
    }

    public long getCompletedTaskCount() {
        return this.executor.getCompletedTaskCount();
    }

    public int getCorePoolSize() {
        return this.executor.getCorePoolSize();
    }

    public int getLargestPoolSize() {
        return this.executor.getLargestPoolSize();
    }

    public int getMaximumPoolSize() {
        return this.executor.getMaximumPoolSize();
    }
}