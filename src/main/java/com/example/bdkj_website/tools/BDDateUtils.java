package com.example.bdkj_website.tools;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

/**
 * <p>Title: BDDateUtils</p>
 * <p>Description: 日期工具类</p>
 * <p>Company: 成都邦道科技有限公司</p>
 *
 * @author zhanghw
 * @date 2020/3/26 4:17 PM
 */
public class BDDateUtils {
    public static String timezone = "Asia/Shanghai";
    public static final String DATE_FORMAT = "yyyyMMdd";
    public static final String DATE_FORMAT_WITHOUT_TIME = "yyyyMMddHHmmss";
    public static final String DATE_FORMAT_SPLIT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_SPLIT_SECOND = "yyyy/MM/dd";
    public static final String DATE_FORMAT_SPLIT_MINUTE_SECOND = "yyyy/MM/dd HH:mm";
    public static final String HOUR_MINUTE_SECOND = "HH:mm:ss";
    public static final String DATE_FORMAT_SPLIT_YEAR_MONTH = "yyyy-MM";
    public static final String DATE_FORMAT_CHINESE = "yyyy年MM月dd日";
    public static final String DATE_FORMAT_CHINESE_YEAR_MONTH = "yyyy年MM月";
    public static final String DATE_FORMAT_NOT_DAY_CHINESE = "yyyy年MM月";
    public static final String BIRTHDAY_FORMAT = "MMdd";
    public static final String YEAR_FORMAT = "yyyy";
    public static final String YEAR_MONTH_FORMAT = "yyyyMM";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_FORMAT_TO_MINUTE = "yyyy-MM-dd HH:mm";
    public static final String DATE_TIME_FORMAT_CHINESE = "yyyy年MM月dd日 HH:mm:ss";
    public static final Long MILLS_PER_SECOND = 1000L;
    public static final Long MILLS_PER_HOUR = 60 * 60 * 1000L;
    public static final Long MILLS_PER_DAY = 24 * 60 * 60 * 1000L;
    public static final Long MILLS_PER_MONTH = 30 * 24 * 60 * 60 * 1000L;
    public static final Long MILLS_HALF_MONTH = 15 * 24 * 60 * 60 * 1000L;//半个月
    public static final Long MILLS_OF_TWO_HOURS = 2 * 60 * 60 * 1000L;
    public static final Long MILLS_OF_NINE_HOURS = 9 * 60 * 60 * 1000L;
    public static final long MILLS_PER_MINUTE = 60 * 1000L;
    public static final int SECONDS_PER_DAY = 24 * 60 * 60;
    public static final int YEAR_IN_DAYS = 365;
    public static final int WEEK_IN_DAYS = 7;
    public static final int YEAR_IN_MONTHS = 12;

    /**
     * 获取当天00:00:00的时间
     *
     * @return
     */
    public static long nowDateInMillis() {
        return nowDate()
                .withHourOfDay(0)
                .withMinuteOfHour(0)
                .withSecondOfMinute(0)
                .withMillisOfSecond(0)
                .getMillis();
    }

    /**
     * 获取当天00:00:00时刻往后推hour小时的时间
     *
     * @param hour
     * @return
     */
    public static long nowDateInMillsWithHour(int hour) {
        return nowDate()
                .withHourOfDay(hour)
                .withMinuteOfHour(0)
                .withSecondOfMinute(0)
                .withMillisOfSecond(0)
                .getMillis();
    }

    /**
     * 设置时区
     *
     * @param timezoneId
     */
    public static void setTimeZone(String timezoneId) {
        timezone = timezoneId;
    }

    /**
     * 获取beforeDays天前的00:00:00的时间 单位／毫秒
     *
     * @param daysAgo
     * @return
     */
    public static long daysAgoInMillis(int daysAgo) {
        return nowDateInMillis() - MILLS_PER_DAY * daysAgo;
    }

    /**
     * 获取afterDays天后的00:00:00的时间 单位／毫秒
     *
     * @param afterDays
     * @return
     */
    public static long daysAfterInMills(int afterDays) {
        return nowDateInMillis() + MILLS_PER_DAY * afterDays;
    }

    /**
     * 某个时间往后推afterDays天
     *
     * @param timeStamp
     * @param afterDays
     * @return
     */
    public static long daysAfterInMills(Long timeStamp, int afterDays) {
        return timeStamp + MILLS_PER_DAY * afterDays;
    }

    /**
     * 当前时间往前推n个小时
     *
     * @param hoursAgo
     * @return
     */
    public static long hoursAgoInMills(int hoursAgo) {
        return BDDateUtils.now() - MILLS_PER_HOUR * hoursAgo;
    }

    /**
     * 某一时间往前推n个小时
     *
     * @param time
     * @param hoursAgo
     * @return
     */
    public static long timeHoursAgoInMills(long time, int hoursAgo) {
        return time - MILLS_PER_HOUR * hoursAgo;
    }

    /**
     * 某一时间往后推n个小时
     *
     * @param time
     * @param hoursAfter
     * @return
     */
    public static long timeHoursAfterInMills(long time, int hoursAfter) {
        return time + MILLS_PER_HOUR * hoursAfter;
    }

    /**
     * 当前时间往前推n个月
     *
     * @param monthsAgo
     * @return
     */
    public static long monthsAgoInMills(int monthsAgo) {
        return nowDateInMillis() - MILLS_PER_MONTH * monthsAgo;
    }

    /**
     * 获取当月第一天的00:00:00时间
     *
     * @return
     */
    public static long nowMonthInMillis() {
        return nowDate()
                .withDayOfMonth(1)
                .withHourOfDay(0)
                .withMinuteOfHour(0)
                .withSecondOfMinute(0)
                .withMillisOfSecond(0)
                .getMillis();
    }

    /**
     * 获取某个月第一天的00:00:00时间
     *
     * @param timestamp
     * @return
     */
    public static long getMinMillisOfMonth(Long timestamp) {
        return BDDateUtils.getMinMillisOfDay(
                new DateTime(timestamp, getTimeZone())
                        .withDayOfMonth(1)
                        .getMillis());
    }

    /**
     * 获取某年的第一天的00:00:00时间
     *
     * @param
     * @return
     */
    public static long getMinMillisOfYear(Integer year) {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, year);
        instance.set(Calendar.MONTH, 0);
        long minMillisOfYear = BDDateUtils.getMinMillisOfMonth(instance.getTimeInMillis());
        return minMillisOfYear;
    }

    /**
     * 获取某月的第一天的00:00:00时间
     *
     * @param
     * @return
     */
    public static long getMinMillisOfMonth(Integer year, Integer month) {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, year);
        instance.set(Calendar.MONTH, month - 1);
        long minMillisOfYear = BDDateUtils.getMinMillisOfMonth(instance.getTimeInMillis());
        return minMillisOfYear;
    }

    /**
     * 获取某年的最后一一天的00:00:00时间
     *
     * @param
     * @return
     */
    public static long getMinMillisOfYearEndDay(Integer year) {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, year);
        instance.set(Calendar.MONTH, 11);
        long minMillisOfYear = BDDateUtils.getMaxMillisOfMonth(instance.getTimeInMillis());
        return minMillisOfYear;
    }

    /**
     * 获取某月的最后一一天的00:00:00时间
     *
     * @param
     * @return
     */
    public static long getMinMillisOfMonthEndDay(Integer year, Integer month) {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, year);
        instance.set(Calendar.MONTH, month - 1);
        long minMillisOfYear = BDDateUtils.getMaxMillisOfMonth(instance.getTimeInMillis());
        return minMillisOfYear;
    }


    /**
     * 获取本月最后一天最后时候
     *
     * @param timestamp
     * @return
     */
    public static long getMaxMillisOfMonth(Long timestamp) {
        return BDDateUtils.getMaxMillisOfDay(
                new DateTime(timestamp, getTimeZone())
                        .plusMonths(1)
                        .withDayOfMonth(1)
                        .minusDays(1)
                        .getMillis());
    }

    /**
     * 现在到月底所剩时间毫秒数
     *
     * @return
     */
    public static long getRemainingMillisOfMonth() {
        return getMaxMillisOfMonth(now()) - now();
    }

    /**
     * 现在到今天结束所剩时间毫秒数
     *
     * @return
     */
    public static long getRemainingMillisOfDay() {
        return getMaxMillisOfDay(now()) - now();
    }

    /**
     * 本周第一天开始时间
     *
     * @return
     */
    public static long nowWeekInMillis() {
        return nowDate()
                .withDayOfWeek(1)
                .withHourOfDay(0)
                .withMinuteOfHour(0)
                .withSecondOfMinute(0)
                .withMillisOfSecond(0)
                .getMillis();
    }

    /**
     * 当前时间毫秒数
     *
     * @return
     */
    public static long now() {
        return nowDate().getMillis();
    }

    public static DateTimeZone getTimeZone() {
        return DateTimeZone.forID(timezone);
    }

    /**
     * 当前时间DateTime
     *
     * @return
     */
    public static DateTime nowDate() {
        return new DateTime(getTimeZone());
    }

    /**
     * 某年起始时刻
     *
     * @param year
     * @return
     */
    public static DateTime dateOfYear(int year) {
        return new DateTime(getTimeZone())
                .withYear(year)
                .withMonthOfYear(1)
                .withDayOfMonth(1)
                .withHourOfDay(0)
                .withMinuteOfHour(0)
                .withSecondOfMinute(0)
                .withMillisOfSecond(0);
    }

    /**
     * 毫秒数转化为DataeTime类型
     *
     * @param timestamp
     * @return
     */
    public static DateTime date(Long timestamp) {
        return new DateTime(timestamp, getTimeZone());
    }

    /**
     * 获取某天的00:00:00的时间
     *
     * @param timestamp
     * @return
     */
    public static long dateInMills(Long timestamp) {
        return new DateTime(timestamp, getTimeZone())
                .withHourOfDay(0)
                .withMinuteOfHour(0)
                .withSecondOfMinute(0)
                .withMillisOfSecond(0)
                .getMillis();
    }

    /**
     * 某月第一天开始时间
     *
     * @param timestamp
     * @return
     */
    public static long monthInMills(Long timestamp) {
        return new DateTime(timestamp, getTimeZone())
                .withDayOfMonth(1)
                .withHourOfDay(0)
                .withMinuteOfHour(0)
                .withSecondOfMinute(0)
                .withMillisOfSecond(0)
                .getMillis();
    }

    /**
     * 某周第一天开始时间
     *
     * @param timestamp
     * @return
     */
    public static long weekInMills(Long timestamp) {
        return new DateTime(timestamp, getTimeZone())
                .withDayOfWeek(1)
                .withHourOfDay(0)
                .withMinuteOfHour(0)
                .withSecondOfMinute(0)
                .withMillisOfSecond(0)
                .getMillis();
    }

    public static void setDaysAgo(int daysAgo) {
        setCurrentTime();
        DateTimeUtils.setCurrentMillisOffset(-Duration.ofDays(daysAgo).toMillis());
    }

    public static void setDaysAfter(int daysAfter) {
        setCurrentTime();
        DateTimeUtils.setCurrentMillisOffset(Duration.ofDays(daysAfter).toMillis());
    }

    public static void setDaysAfter(long now, int daysAfter) {
        DateTimeUtils.setCurrentMillisFixed(now + Duration.ofDays(daysAfter).toMillis());
    }

    public static void setMinutesAgo(int minutesAgo) {
        setCurrentTime();
        DateTimeUtils.setCurrentMillisOffset(-Duration.ofMinutes(minutesAgo).toMillis());
    }

    public static void setMinutesAfter(int minutesAfter) {
        setCurrentTime();
        DateTimeUtils.setCurrentMillisOffset(Duration.ofMinutes(minutesAfter).toMillis());
    }

    public static void setMillisAgo(long millisAgo) {
        setCurrentTime();
        DateTimeUtils.setCurrentMillisOffset(-Duration.ofMillis(millisAgo).toMillis());
    }

    public static void setMillisAfter(long millisAfter) {
        setCurrentTime();
        DateTimeUtils.setCurrentMillisOffset(Duration.ofMillis(millisAfter).toMillis());
    }

    /**
     * 设置系统时间为当前时间
     */
    public static void setCurrentTime() {
        DateTimeUtils.setCurrentMillisSystem();
    }

    /**
     * 设置系统时间
     *
     * @param now
     */
    public static void setTime(Long now) {
        DateTimeUtils.setCurrentMillisFixed(now);
    }

    public static long getMinMillisOfDay(Long millis) {
        return BDDateUtils.date(millis).millisOfDay().withMinimumValue().getMillis();
    }

    //计算天数,计头计尾
    public static int getDaysWithHeadAndTail(long startMillis, long endMills) {
        if (endMills < startMillis) {
            throw new RuntimeException("参数异常,endMills必须不小于startMillis");
        }
        long maxMillisOfFirstDay = getMaxMillisOfDay(startMillis);
        if (maxMillisOfFirstDay > endMills) {
            return 1;
        }
        long leftMillis = endMills - maxMillisOfFirstDay;
        int leftDays = (int) (leftMillis % MILLS_PER_DAY == 0 ? leftMillis / MILLS_PER_DAY : (leftMillis / MILLS_PER_DAY + 1));
        return leftDays + 1;
    }

    /**
     * 当天最后时刻时间点
     *
     * @param millis
     * @return
     */
    public static long getMaxMillisOfDay(Long millis) {
        return BDDateUtils.date(millis).millisOfDay().withMaximumValue().getMillis();
    }

    public static int getDaysBetween(Long startMillis, Long endMills) {
        return Days.daysBetween(BDDateUtils.date(startMillis), BDDateUtils.date(endMills)).getDays() + 1;
    }

    public static int getDaysWithHeadBetween(Long startMillis, Long endMills) {
        if (endMills < startMillis) {
            throw new RuntimeException("参数异常,endMills必须不小于startMillis");
        }
        int days = Days.daysBetween(BDDateUtils.date(startMillis), BDDateUtils.date(endMills)).getDays();
        if (days == 0) {
            days++;
        }
        return days;
    }

    public static int getMonthsBetween(Long startMillis, Long endMills) {
        return Months.monthsBetween(BDDateUtils.date(startMillis), BDDateUtils.date(endMills)).getMonths() + 1;
    }

    /**
     * @param startMillis
     * @param endMills
     * @return 获取两个日期之间的月数差，不要求月份中的日期
     */
    public static int getRoughMonthsBetween(Long startMillis, Long endMills) {
        if (startMillis > endMills) {
            throw new RuntimeException("参数异常,endMills必须不小于startMillis");
        }
        DateTime startDate = BDDateUtils.date(startMillis);
        DateTime endDate = BDDateUtils.date(endMills);
        return YEAR_IN_MONTHS * (endDate.getYear() - startDate.getYear()) + (endDate.getMonthOfYear() - startDate.getMonthOfYear());
    }

    /**
     * 获取两个日期之间的天数差
     */
    public static int getCalenderDaysBetween(Long startMillis, Long endMills) {
        return Days.daysBetween(BDDateUtils.date(BDDateUtils.getMinMillisOfDay(startMillis)),
                BDDateUtils.date(BDDateUtils.getMinMillisOfDay(endMills)))
                .getDays();
    }

    /**
     * 两个日期之间的小时差
     *
     * @param startMillis
     * @param endMills
     * @return
     */
    public static int getHoursBetween(Long startMillis, Long endMills) {
        return Hours.hoursBetween(BDDateUtils.date(startMillis), BDDateUtils.date(endMills)).getHours() + 1;
    }

    /**
     * 两个日期之间的分钟差
     *
     * @param startMillis
     * @param endMills
     * @return
     */
    public static int getMinutesBetween(Long startMillis, Long endMills) {
        return Minutes.minutesBetween(BDDateUtils.date(startMillis), BDDateUtils.date(endMills)).getMinutes() + 1;
    }

    /**
     * 两个日期之间的秒数差
     *
     * @param startMillis
     * @param endMills
     * @return
     */
    public static long getSecondsBetween(Long startMillis, Long endMills) {
        return (endMills - startMillis) / 1000;
    }

    /**
     * 到今天结束所剩秒数
     *
     * @return
     */
    public static int getRemainingSecondOfDay() {
        return BDDateUtils.nowDate().secondOfDay().withMaximumValue().getSecondOfDay() - BDDateUtils.nowDate().getSecondOfDay();
    }

    /**
     * 字符串毫秒数转化为DateTime类型
     *
     * @param dateStr
     * @return
     */
    public static DateTime jodaDateTimeFromString(String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        return BDDateUtils.date(Long.valueOf(dateStr));
    }

    /**
     * 世界标准时间日期格式化
     *
     * @param timestamp
     * @return
     */
    public static String utcDateTimeStringFromTimestamp(Long timestamp) {
        if (null == timestamp) {
            return null;
        }
        return new DateTime(timestamp, DateTimeZone.UTC).toString(DateTimeFormat.forPattern(DATE_TIME_FORMAT));
    }

    /**
     * 中国时区日期格式化
     *
     * @param timestamp
     * @return
     */
    public static String dateTimeStringFromTimestamp(Long timestamp) {
        return dateTimeStringFromTimestamp(timestamp, DATE_TIME_FORMAT);
    }

    /**
     * 根据给定格式，格式化日期
     *
     * @param timestamp
     * @param format
     * @return
     */

    public static String dateTimeStringFromTimestamp(Long timestamp, String format) {
        if (null == timestamp) {
            return null;
        }
        return date(timestamp).toString(DateTimeFormat.forPattern(format));
    }

    /**
     * 格式化日期 yyyyMMdd
     *
     * @param timestamp
     * @return
     */
    public static String dateString(Long timestamp) {
        return date(timestamp).toString(DATE_FORMAT);
    }

    public static String dateString(Long timestamp, String format) {
        return date(timestamp).toString(format);
    }

    public static String dateStringChinese(Long timestamp) {
        return date(timestamp).toString(DATE_FORMAT_CHINESE);
    }

    public static String dateStringHour(Long timestamp) {
        return date(timestamp).toString("HH:mm:ss");
    }

    public static String birthdayString(Long timestamp) {
        return date(timestamp).toString(BIRTHDAY_FORMAT);
    }

    public static Long getDateWithFormat(String voucherDateStr) {
        Long aLong;
        if (voucherDateStr.indexOf("/") != -1) {
            aLong = dateStringToLong(voucherDateStr, BDDateUtils.DATE_FORMAT_SPLIT_SECOND);
        } else if (voucherDateStr.indexOf("-") != -1) {
            aLong = dateStringToLong(voucherDateStr, BDDateUtils.DATE_FORMAT_SPLIT);
        } else {
            aLong = null;
        }
        return aLong;
    }

    /**
     * 解析字符串，转化为日期格式
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static Long dateStringToLong(String dateStr, String format) {
        if (dateStr == null) {
            return 0L;
        }
        long timestampUTC = DateTimeFormat.forPattern(format).withZoneUTC().parseDateTime(dateStr).getMillis();
        int offset = getTimeZone().toTimeZone().getRawOffset();
        return timestampUTC - offset;
    }

    public static int dayOfMonth(Long timestamp) {
        return BDDateUtils.date(timestamp).dayOfMonth().get();
    }

    public static int hourOfDay(Long timestamp) {
        return BDDateUtils.date(timestamp).hourOfDay().get();
    }

    public static int year(long timestamp) {
        return BDDateUtils.date(timestamp).year().get();
    }

    public static int monthOfYear(long timestamp) {
        return BDDateUtils.date(timestamp).monthOfYear().get();
    }

    public static boolean millisIsDate(long millis) {
        return Long.compare(getMinMillisOfDay(millis), millis) == 0;
    }

    public static long sameDayOfMonthsAfter(long millis, int months) {
        return date(millis)
                .plusMonths(months)
                .getMillis();
    }

    public static long getHoursBefore(long millis, int hours) {
        return date(millis)
                .minusHours(hours)
                .getMillis();
    }

    public static long sameDayOfYearsAfter(long millis, int years) {
        return date(millis)
                .plusYears(years)
                .getMillis();
    }

    public static Calendar getCalendar() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(getTimeZone().toTimeZone());
        return cal;
    }

    public static int getDaysOfCurrentMonth(Long currentMonthTimestamp) {
        Calendar cal = getCalendar();
        int currentMonth = date(currentMonthTimestamp).getMonthOfYear();
        cal.set(Calendar.MONTH, currentMonth - 1);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static long nowDateWithHour(int hour) {
        return nowDate()
                .withHourOfDay(hour)
                .withMinuteOfHour(0)
                .withSecondOfMinute(0)
                .withMillisOfSecond(0)
                .getMillis();
    }

    public static long nowHour() {
        return nowDate()
                .withMinuteOfHour(0)
                .withSecondOfMinute(0)
                .withMillisOfSecond(0)
                .getMillis();
    }

    public static long getTimestampWithDayAndHour(Long dayTimestamp, int hour) {
        return date(dayTimestamp)
                .withHourOfDay(hour)
                .withMinuteOfHour(0)
                .withSecondOfMinute(0)
                .withMillisOfSecond(0)
                .getMillis();
    }

    public static long getDateWithDay(long millis, int day) {
        return date(millis)
                .withDayOfMonth(day)
                .getMillis();
    }

    public static int compareDateOnly(long timestamp1, long timestamp2) {
        return DateTimeComparator.getDateOnlyInstance().compare(timestamp1, timestamp2);
    }

    public static boolean isWeekend(long timestamp) {
        int weekday = date(timestamp).getDayOfWeek();
        if (weekday > 5) {
            return true;
        } else {
            return false;
        }
    }

    public static int getCalenderMonthsBetween(Long startDate, Long endDate) {
        return BDDateUtils.monthOfYear(endDate) + 12 * (BDDateUtils.year(endDate) - BDDateUtils.year(startDate)) - BDDateUtils.monthOfYear(startDate);
    }

    /**
     * 将时间毫秒数转换成时分秒
     *
     * @return
     */
    public static String millsConvertToTime(long ms) {
        if (ms > BDDateUtils.MILLS_PER_DAY) {
            return String.valueOf(ms);
        }
        String format = "";
        if (ms < BDDateUtils.MILLS_PER_HOUR) {
            format = "m:ss";
        } else if (ms >= BDDateUtils.MILLS_PER_HOUR && ms <= BDDateUtils.MILLS_PER_DAY) {
            format = "H:mm:ss";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);//这里想要只保留分秒可以写成"mm:ss"
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        String hms = formatter.format(ms);
        return hms;
    }

    public static String mixDayByMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DATE);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        return sdf.format(cal.getTime());
    }

    public static String mixDayByMonthChina(int year, int month) {
        Calendar cal = Calendar.getInstance();
// 设置年份
        cal.set(Calendar.YEAR, year);
// 设置当前获取月份的下一个月
        cal.set(Calendar.MONTH, month);
// 获取某月的下一个月的第一天
        int startDay = cal.getMinimum(Calendar.DATE);
// 设置日下一个月的第一天减去1天
        cal.set(Calendar.DAY_OF_MONTH, startDay - 1);
// 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    /**
     * 获得某月第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String minDayByMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最小天数
        int firstDay = cal.getMinimum(Calendar.DATE);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        return sdf.format(cal.getTime());
    }

    public static String minDayByMonthChina(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最小天数
        int firstDay = cal.getMinimum(Calendar.DATE);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    public static List<String> getMonthBetween(String minDate, String maxDate) throws ParseException {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }
        return result;
    }


    /**
     * 二个月之间所有的月份
     *
     * @param startMoth
     * @param endYearMonth
     * @return
     */
    public static List<String> monthCount(String startMoth, String endYearMonth) {
        String y1 = startMoth;// 开始时间
        String y2 = endYearMonth;// 结束时间
        List<String> list = new ArrayList<String>();
        try {
            Date startDate = new Date();
            Date endDate = new Date();
            if (startMoth.contains("年")) {
                startDate = new SimpleDateFormat("yyyy年MM").parse(y1);
                endDate = new SimpleDateFormat("yyyy年MM").parse(y2);
            } else {
                startDate = new SimpleDateFormat("yyyy-MM").parse(y1);
                endDate = new SimpleDateFormat("yyyy-MM").parse(y2);
            }


            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            // 获取开始年份和开始月份
            int startYear = calendar.get(Calendar.YEAR);
            int startMonth = calendar.get(Calendar.MONTH);
            // 获取结束年份和结束月份
            calendar.setTime(endDate);
            int endYear = calendar.get(Calendar.YEAR);
            int endMonth = calendar.get(Calendar.MONTH);
            //

            for (int i = startYear; i <= endYear; i++) {
                String date = "";
                if (startYear == endYear) {
                    for (int j = startMonth; j <= endMonth; j++) {
                        if (j < 9) {
                            date = i + "年0" + (j + 1) + "月";
                        } else {
                            date = i + "年" + (j + 1) + "月";
                        }
                        list.add(date);
                    }

                } else {
                    if (i == startYear) {
                        for (int j = startMonth; j < 12; j++) {
                            if (j < 9) {
                                date = i + "年0" + (j + 1) + "月";
                            } else {
                                date = i + "年" + (j + 1) + "月";
                            }
                            list.add(date);
                        }
                    } else if (i == endYear) {
                        for (int j = 0; j <= endMonth; j++) {
                            if (j < 9) {
                                date = i + "年0" + (j + 1) + "月";
                            } else {
                                date = i + "年" + (j + 1) + "月";
                            }
                            list.add(date);
                        }
                    } else {
                        for (int j = 0; j < 12; j++) {
                            if (j < 9) {
                                date = i + "年0" + (j + 1) + "月";
                            } else {
                                date = i + "年" + (j + 1) + "月";
                            }
                            list.add(date);
                        }
                    }

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public static List<String> getMonthBetween(Date minDate, Date maxDate) {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(minDate);
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(maxDate);
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }
        return result;
    }

    public static List<String> getMonthBetween(Date minDate, Date maxDate, String format) {
        ArrayList<String> result = new ArrayList<String>();
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(minDate);
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(maxDate);
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            result.add(dateString(curr.getTime().getTime(), format));
            curr.add(Calendar.MONTH, 1);
        }
        return result;
    }


    /**
     * 某一个月第一天和最后一天
     *
     * @param date             指定日期
     * @param pattern          日期格式
     * @param isNeedHms是否需要时分秒
     * @return
     */
    public static Map<String, Object> getFirstLastDayByMonth(Date date,
                                                             String pattern, boolean isNeedHms) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        Date theDate = calendar.getTime();

        // 第一天
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first);
        if (isNeedHms)
            str.append(" 00:00:00");
        day_first = str.toString();

        // 最后一天
        calendar.add(Calendar.MONTH, 1); // 加一个月
        calendar.set(Calendar.DATE, 1); // 设置为该月第一天
        calendar.add(Calendar.DATE, -1); // 再减一天即为上个月最后一天
        String day_last = df.format(calendar.getTime());
        StringBuffer endStr = new StringBuffer().append(day_last);
        if (isNeedHms)
            endStr.append(" 23:59:59");
        day_last = endStr.toString();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("first", day_first);
        map.put("last", day_last);
        return map;
    }


    /**
     * 获取当前季度
     */
    public static String getQuarter() {
        Calendar c = Calendar.getInstance();
        int month = c.get(c.MONTH) + 1;
        int quarter = 0;
        if (month >= 1 && month <= 3) {
            quarter = 1;
        } else if (month >= 4 && month <= 6) {
            quarter = 2;
        } else if (month >= 7 && month <= 9) {
            quarter = 3;
        } else {
            quarter = 4;
        }
        return quarter + "";
    }

    /**
     * 获取某季度的第一天和最后一天
     *
     * @param num第几季度
     */
    public static String[] getCurrQuarter(int num) {
        String[] s = new String[2];
        String str = "";
        // 设置本年的季
        Calendar quarterCalendar = null;
        switch (num) {
            case 1: // 本年到现在经过了一个季度，在加上前4个季度
                quarterCalendar = Calendar.getInstance();
                quarterCalendar.set(Calendar.MONTH, 3);
                quarterCalendar.set(Calendar.DATE, 1);
                quarterCalendar.add(Calendar.DATE, -1);
                str = dateString(quarterCalendar.getTime().getTime(), "yyyy-MM-dd");
                s[0] = str.substring(0, str.length() - 5) + "01-01";
                s[1] = str;
                break;
            case 2: // 本年到现在经过了二个季度，在加上前三个季度
                quarterCalendar = Calendar.getInstance();
                quarterCalendar.set(Calendar.MONTH, 6);
                quarterCalendar.set(Calendar.DATE, 1);
                quarterCalendar.add(Calendar.DATE, -1);
                str = dateString(quarterCalendar.getTime().getTime(), "yyyy-MM-dd");
                s[0] = str.substring(0, str.length() - 5) + "04-01";
                s[1] = str;
                break;
            case 3:// 本年到现在经过了三个季度，在加上前二个季度
                quarterCalendar = Calendar.getInstance();
                quarterCalendar.set(Calendar.MONTH, 9);
                quarterCalendar.set(Calendar.DATE, 1);
                quarterCalendar.add(Calendar.DATE, -1);
                str = dateString(quarterCalendar.getTime().getTime(), "yyyy-MM-dd");
                s[0] = str.substring(0, str.length() - 5) + "07-01";
                s[1] = str;
                break;
            case 4:// 本年到现在经过了四个季度，在加上前一个季度
                quarterCalendar = Calendar.getInstance();
                str = dateString(quarterCalendar.getTime().getTime(), "yyyy-MM-dd");
                s[0] = str.substring(0, str.length() - 5) + "10-01";
                s[1] = str.substring(0, str.length() - 5) + "12-31";
                break;
        }
        return s;
    }


    /**
     * 获取某年某季度的第一天和最后一天
     *
     * @param num第几季度
     */
    public static String[] getCurrQuarter(int num, int year) {
        String[] s = new String[2];
        String str = "";
        // 设置本年的季
        Calendar quarterCalendar = null;
        switch (num) {
            case 1: // 本年到现在经过了一个季度，在加上前4个季度
                quarterCalendar = Calendar.getInstance();
                quarterCalendar.set(Calendar.YEAR, year);
                quarterCalendar.set(Calendar.MONTH, 3);
                quarterCalendar.set(Calendar.DATE, 1);
                quarterCalendar.add(Calendar.DATE, -1);
                str = dateString(quarterCalendar.getTime().getTime(), "yyyy-MM-dd");
                s[0] = str.substring(0, str.length() - 5) + "01-01";
                s[1] = str;
                break;
            case 2: // 本年到现在经过了二个季度，在加上前三个季度
                quarterCalendar = Calendar.getInstance();
                quarterCalendar.set(Calendar.YEAR, year);
                quarterCalendar.set(Calendar.MONTH, 6);
                quarterCalendar.set(Calendar.DATE, 1);
                quarterCalendar.add(Calendar.DATE, -1);
                str = dateString(quarterCalendar.getTime().getTime(), "yyyy-MM-dd");
                s[0] = str.substring(0, str.length() - 5) + "04-01";
                s[1] = str;
                break;
            case 3:// 本年到现在经过了三个季度，在加上前二个季度
                quarterCalendar = Calendar.getInstance();
                quarterCalendar.set(Calendar.YEAR, year);
                quarterCalendar.set(Calendar.MONTH, 9);
                quarterCalendar.set(Calendar.DATE, 1);
                quarterCalendar.add(Calendar.DATE, -1);
                str = dateString(quarterCalendar.getTime().getTime(), "yyyy-MM-dd");
                s[0] = str.substring(0, str.length() - 5) + "07-01";
                s[1] = str;
                break;
            case 4:// 本年到现在经过了四个季度，在加上前一个季度
                /*quarterCalendar = Calendar.getInstance();
                str = dateString(quarterCalendar.getTime().getTime(), "yyyy-MM-dd");*/
                s[0] = year + "-10-01";
                s[1] = year + "-12-31";
                break;
        }
        return s;
    }


    /**
     * 根据季度获取该季度下的月份数组
     *
     * @param quater
     * @return
     */
    public static Integer[] getMonthsArray(Integer quater) {
        switch (quater) {
            case 1:
                return new Integer[]{1, 2, 3};
            case 2:
                return new Integer[]{4, 5, 6};
            case 3:
                return new Integer[]{7, 8, 9};
            case 4:
                return new Integer[]{10, 11, 12};
            default:
                return new Integer[3];
        }
    }

    /**
     * 根据季度获取该季度下的月份数组
     *
     * @return
     */
    public static Integer[] getAllMonthsArray() {
        return new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    }

    /**
     * 根据月份获取季度
     *
     * @param month
     * @return
     */
    public static Integer getQuaterWithMonth(Integer month) {
        int quarter = (month - 1) / 3 + 1;
        return quarter;
    }

    /**
     * 用途：以指定的格式格式化日期字符串
     *
     * @param pattern     字符串的格式
     * @param currentDate 被格式化日期
     * @return String 已格式化的日期字符串
     * @throws NullPointerException 如果参数为空
     */
    public static String formatDate(Date currentDate, String pattern) {
        if (currentDate == null || "".equals(pattern) || pattern == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(currentDate);
    }

    /**
     * 获取某月最后一天的时间
     *
     * @return
     */
    public static Date getCurrentMonthLastDay(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        Date time = calendar.getTime();
        return time;
    }


    /**
     * @param year
     * @param month
     * @return
     */
    public static long[] getMinMillsAndMaxMills(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, 1);
        long time = calendar.getTime().getTime();
        long minMillisOfMonth = BDDateUtils.getMinMillisOfMonth(time);
        long maxMillisOfMonth = BDDateUtils.getMaxMillisOfMonth(time);
        long[] longs = {minMillisOfMonth, maxMillisOfMonth};
        return longs;
    }

    /**
     * @param date
     * @return
     */
    public static long[] getMinMillsAndMaxMills(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        long time = calendar.getTime().getTime();
        long minMillisOfMonth = BDDateUtils.getMinMillisOfMonth(time);
        long maxMillisOfMonth = BDDateUtils.getMaxMillisOfMonth(time);
        long[] longs = {minMillisOfMonth, maxMillisOfMonth};
        return longs;
    }


    public static List<Map<String, Object>> getMonthBetweenMap(Date minDate, Date maxDate) {
        List<Map<String, Object>> list = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");//格式化为年月
        String ada = sdf.format(minDate);
        String ada12 = sdf.format(maxDate);

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(minDate);
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(maxDate);
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            Map<String, Object> result = new HashMap<>();
            String a = sdf.format(curr.getTime());
            Long b = curr.getTimeInMillis();
            result.put("dateFormat", a);
            result.put("mills", b);
            list.add(result);
            curr.add(Calendar.MONTH, 1);
        }
        return list;
    }

    /**
     * 获取上一个月的年月
     *
     * @param aLong
     * @return
     */
    public static Integer[] getCurrentYearAndMonth(Long aLong) {
        Integer[] integers = new Integer[2];
        Date time = new Date(aLong);
        int year1 = time.getYear()+1900;
        int month1 = time.getMonth()+1;
        integers[0] = year1;
        integers[1] = month1;
        return integers;
    }


    /**
     * 获取上一个月的年月
     *
     * @param year
     * @param month
     * @return
     */
    public static Integer[] getLastYearAndMonth(int year, int month) {
        Integer[] integers = new Integer[2];
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, year);
        instance.set(Calendar.MONTH, month - 2);
        Date time = instance.getTime();
        int year1 = time.getYear()+1900;
        int month1 = time.getMonth()+1;
        integers[0] = year1;
        integers[1] = month1;
        return integers;
    }

    /**
     * 获取下一个月的年月
     * @param year
     * @param month
     * @return
     */
    public static Integer[] getNextYearAndMonth(int year, int month){
        Integer[] integers = new Integer[2];
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, year);
        instance.set(Calendar.MONTH, month);
        Date time = instance.getTime();
        int year1 = time.getYear()+1900;
        int month1 = time.getMonth()+1;
        integers[0] = year1;
        integers[1] = month1;
        return integers;
    }


    /**
     * 给月份补全前面的零
     *
     * @param month
     * @return
     */
    public static String supplyZeroForMonth(Integer month) {
        String result = month + "";
        if (month <= 9) {
            result = "0" + month;
        }
        return result;
    }

    /**
     * 根据年月分别获取对应的年和月
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static Integer[] getYearAndMonthWithFormat(String dateStr, String format) {
        Integer[] array = new Integer[2];
        Long aLong = BDDateUtils.dateStringToLong(dateStr, format);
        Date date = new Date(aLong);
        int year = date.getYear();
        int month = date.getMonth();
        array[0] = year + 1900;
        array[1] = month + 1;
        return array;
    }


    /*public static void main(String[] args) {
        Integer year = 2020;
        Integer month = 02;
        Integer endYear =2020;
        Integer endMonth = 03;
       long yearLng=    BDDateUtils.getMinMillisOfYear(year);
        String ss = BDDateUtils.minDayByMonthChina(year, month);
        String a= ss + " 00:00:00";
      long  startLang=    BDDateUtils.dateStringToLong(a,BDDateUtils.DATE_TIME_FORMAT);
        String sa = BDDateUtils.mixDayByMonthChina(endYear, endMonth);
        String b= sa + " 23:59:59";
       long endLnag=   BDDateUtils.dateStringToLong(b,BDDateUtils.DATE_TIME_FORMAT);

    }*/


    /**
     * 获取当月及到年初之间的月份
     * @param month
     */
    public static List<Integer> getmonthsDown(Integer month) {
        List<Integer> list = Lists.newArrayList();
        for (int i = 1; i <= month; i++) {
            list.add(i);
        }
        return list;
    }

    /**
     * 获取某个季度之前的所有月份
     * @param quater
     */
    public static List<Integer> getmonthsDownQuater(Integer quater) {
        int lastMonth = quater * 3;
        return getmonthsDown(lastMonth);
    }


    /**
     * 根据时间和格式返回字符串，如果时间为空，则返回空串
     * @param time
     * @param dateFormatSplit
     * @return
     */
    public static String getDateStr(Date time, String dateFormatSplit) {
        if (time == null){
            return "";
        }
        String dateString = BDDateUtils.dateString(time.getTime(), dateFormatSplit);
        return dateString;
    }

    /**
     * 查询五年前的年份
     * @return
     */
    public static int getFiveBeforeYear() {
        int year = year(now()) - 4;
        return year;
    }

    public static Integer[] getFiveYearArray(Integer year){
        Integer[] array = new Integer[5];
        for (int i = 0; i < 5; i++) {
            array[i] = year + i;
        }
        return array;
    }

    public static  int getAge(Date birthDay) throws Exception {
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) { //出生日期晚于当前时间，无法计算
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);  //当前年份
        int monthNow = cal.get(Calendar.MONTH);  //当前月份
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;   //计算整岁数
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;//当前日期在生日之前，年龄减一
            }else{
                age--;//当前月份在生日之前，年龄减一
            }
        }
        return age;
    }

    public static void main(String[] args) {
        Long aLong = BDDateUtils.dateStringToLong("2001-12-12", BDDateUtils.DATE_FORMAT_SPLIT);
        Date date = new Date(aLong);
        int age = 0;
        try {
            age = getAge(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(age);
    }

}
