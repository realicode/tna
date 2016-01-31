package com.realaicy.tna.modules.core.utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * 线程相关工具类.
 *
 * @author realaicy
 */
@SuppressWarnings("unused")
public final class Threads {
    /**
     * Do not instantiate Threads.
     */
    private Threads() {

    }

    /**
     * sleep等待, 单位为毫秒.
     *
     * @param durationMillis the duration millis
     */
    public static void sleep(final long durationMillis) {
        try {
            Thread.sleep(durationMillis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * sleep等待.
     *
     * @param duration the duration
     * @param unit     the unit
     */
    public static void sleep(final long duration, final TimeUnit unit) {
        try {
            Thread.sleep(unit.toMillis(duration));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 创建ThreadFactory，使得创建的线程有自己的名字而不是默认的"pool-x-thread-y"，
     * 在用threaddump查看线程时特别有用。 格式如"mythread-%d"，使用了Guava的工具类
     *
     * @param nameFormat the name format
     * @return the thread factory
     */
    public static ThreadFactory buildJobFactory(final String nameFormat) {
        return new ThreadFactoryBuilder().setNameFormat(nameFormat).build();
    }

    /**
     * 按照ExecutorService JavaDoc示例代码编写的Graceful Shutdown方法.
     * 先使用shutdown, 停止接收新任务并尝试完成所有已存在任务.
     * 如果超时, 则调用shutdownNow, 取消在workQueue中Pending的任务,并中断所有阻塞函数.
     * 如果仍然超時，則強制退出.
     * 另对在shutdown时线程本身被调用中断做了处理.
     *
     * @param pool               the pool
     * @param shutdownTimeout    the shutdown timeout
     * @param shutdownNowTimeout the shutdown now timeout
     * @param timeUnit           the time unit
     */
    public static void gracefulShutdown(final ExecutorService pool, final int shutdownTimeout,
                                        final int shutdownNowTimeout,
                                        final TimeUnit timeUnit) {
        pool.shutdown(); // Disable new tasks from being submitted
        try {
            // Wait a while for existing tasks to terminate
            if (!pool.awaitTermination(shutdownTimeout, timeUnit)) {
                pool.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!pool.awaitTermination(shutdownNowTimeout, timeUnit)) {
                    System.err.println("Pool did not terminated");
                }
            }
        } catch (InterruptedException ie) {
            // (Re-)Cancel if current thread also interrupted
            pool.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 直接调用shutdownNow的方法, 有timeout控制.取消在workQueue中Pending的任务,并中断所有阻塞函数.
     *
     * @param pool     the pool
     * @param timeout  the timeout
     * @param timeUnit the time unit
     */
    public static void normalShutdown(final ExecutorService pool, final int timeout, final TimeUnit timeUnit) {
        try {
            pool.shutdownNow();
            if (!pool.awaitTermination(timeout, timeUnit)) {
                System.err.println("Pool did not terminated");
            }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 保证不会有Exception抛出到线程池的Runnable，防止用户没有捕捉异常导致中断了线程池中的线程。
     *//*
    public static class WrapExceptionRunnable implements Runnable {

        *//**
     * XXX
     *//*
        private static Logger logger = LoggerFactory.getLogger(WrapExceptionRunnable.class);
        *//**
     * 保证不会有Exception抛出到线程池的Runnable，防止用户没有捕捉异常导致中断了线程池中的线程。
     *//*
        private Runnable runnable;

        *//**
     * Instantiates a new Wrap exception runnable.
     *
     * @param runnable the runnable
     *//*
        public WrapExceptionRunnable(final Runnable runnable) {
            this.runnable = runnable;
        }

        *//**
     * {@inheritDoc}
     *//*
        public void run() {
            try {
                runnable.run();
            } catch (Throwable e) {
                // catch any exception, because the scheduled thread will break if the exception thrown outside.
                logger.error("Unexpected error occurred in task", e);
            }
        }
    }*/

}
