package com.realaicy.tna.modules.core.utils;

import java.util.Date;

/**
 * 日期提供者，使用它而不是直接取得系统时间，方便测试。
 *
 * @author realaicy
 */
public interface Clock {

    /**
     * The DEFAULT.
     */
    Clock DEFAULT = new DefaultClock();

    /**
     * Gets current date.
     *
     * @return the current date
     */
    Date getCurrentDate();

    /**
     * Gets current time in millis.
     *
     * @return the current time in millis
     */
    long getCurrentTimeInMillis();

    /**
     * 默认时间提供者，返回当前的时间，线程安全。
     */
    class DefaultClock implements Clock {


        /**
         * {@inheritDoc}
         */
        public final Date getCurrentDate() {
            return new Date();
        }

        /**
         * {@inheritDoc}
         */
        public final long getCurrentTimeInMillis() {
            return System.currentTimeMillis();
        }
    }

    /**
     * 可配置的时间提供者，用于测试.
     */
    class MockClock implements Clock {
        /**
         * {@inheritDoc}
         */
        private long time;

        /**
         * Instantiates a new Mock clock.
         */
        public MockClock() {
            this(0);
        }

        /**
         * Instantiates a new Mock clock.
         *
         * @param date the date
         */
        public MockClock(final Date date) {
            this.time = date.getTime();
        }

        /**
         * Instantiates a new Mock clock.
         *
         * @param atime the time
         */
        public MockClock(final long atime) {
            this.time = atime;
        }

        /**
         * {@inheritDoc}
         */
        public final Date getCurrentDate() {
            return new Date(time);
        }

        /**
         * {@inheritDoc}
         */
        public final long getCurrentTimeInMillis() {
            return time;
        }

        /**
         * 重新设置日期。
         *
         * @param newDate the new date
         */
        public final void update(final Date newDate) {
            time = newDate.getTime();
        }

        /**
         * 重新设置时间。
         *
         * @param newTime the new time
         */
        public final void update(final long newTime) {
            this.time = newTime;
        }

        /**
         * 滚动时间.
         *
         * @param millis the millis
         */
        public final void increaseTime(final int millis) {
            time += millis;
        }

        /**
         * 滚动时间.
         *
         * @param millis the millis
         */
        public final void decreaseTime(final int millis) {
            time -= millis;
        }
    }

}
