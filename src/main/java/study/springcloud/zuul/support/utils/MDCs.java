package study.springcloud.zuul.support.utils;

import org.slf4j.MDC;

public class MDCs {

    private static final String KEY_URI = "uri";

    private static final String KEY_REQUEST_ID = "request_id";

    public static void put(String uri, String requestId) {
        MDC.put(KEY_URI, uri);
        MDC.put(KEY_REQUEST_ID, requestId);
    }

    public static void remove() {
        MDC.remove(KEY_URI);
        MDC.remove(KEY_REQUEST_ID);
    }
}
