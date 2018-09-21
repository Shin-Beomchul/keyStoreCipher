package godbeom.com.cipher;

import android.text.TextUtils;
import android.util.Log;

/**
 * extend {@link Log} function. <br><br>
 *

 */
public class DLog {

    private static final boolean DEBUG = BuildConfig.DEBUG;
    private static final String DEFAULT_TAG = "KJS";
    private static final int CALLER_STACK_POS = 2;

    public static void d(String msg) {
        if(DEBUG) Log.d(tag(null), message(msg) );
    }

    public static void v(String msg) {
        if(DEBUG) Log.v(tag(null), message(msg) );
    }

    public static void i(String msg) {
        if(DEBUG) Log.i(tag(null), message(msg) );
    }

    public static void w(String msg) {
        if(DEBUG) Log.w(tag(null), message(msg) );
    }

    public static void e(String msg) {
        if(DEBUG) Log.e(tag(null), message(msg) );
    }

    public static void d(String tag, String msg){
        if(DEBUG) Log.d(tag(tag), message(msg));
    }

    public static void v(String tag, String msg){
        if(DEBUG) Log.v(tag(tag), message(msg));
    }

    public static void i(String tag, String msg) {
        if(DEBUG) Log.i(tag(tag), message(msg));
    }

    public static void w(String tag, String msg) {
        if(DEBUG) Log.w(tag(tag), message(msg));
    }

    public static void e(String tag, String msg) {
        if(DEBUG) Log.e(tag(tag), message(msg));
    }

    private static String tag(String tag) {
        return TextUtils.isEmpty(tag) ? DEFAULT_TAG : tag;
    }

    private static String message(String message) {
        Exception curr_e = new Exception();
        StackTraceElement[] curr_ts = curr_e.getStackTrace();

        if (CALLER_STACK_POS >= curr_ts.length) {
            Log.e(null, "-- target stack_pos = " + CALLER_STACK_POS + "  -- curr_ts.length = " + curr_ts.length);
            return "";
        }

        StackTraceElement curr_t = curr_ts[CALLER_STACK_POS];
        String output = (TextUtils.isEmpty(message) ? "" : message) +
                " [[ at "	+ curr_t.getFileName() + " " + curr_t.getLineNumber() + ", " + curr_t.getMethodName() + "()  in " + curr_t.getClassName() + " ]]";

        return output;
    }


}
