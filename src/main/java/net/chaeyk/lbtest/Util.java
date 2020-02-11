package net.chaeyk.lbtest;

import org.springframework.boot.convert.DurationStyle;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
    private static String hostname = null;

    public static String getHostname() {
        if (hostname == null) {
            hostname = getHostnameImpl();
        }
        return hostname;
    }

    private static String getHostnameImpl() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return "Unknown";
        }
    }

    private static ZoneId zoneId = ZoneId.of("Asia/Seoul");
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public static String now() {
        ZonedDateTime dt = ZonedDateTime.now(zoneId);
        return dt.format(formatter);
    }

    public static void sleep(String delayStr) throws InterruptedException {
        Duration delay = DurationStyle.detectAndParse(delayStr);
        Thread.sleep(delay.toMillis());
    }
}
