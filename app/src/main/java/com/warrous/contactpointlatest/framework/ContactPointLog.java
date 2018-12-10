package com.warrous.contactpointlatest.framework;

import android.util.Log;

public class ContactPointLog {
    private static final String TAG = ContactPointLog.class.getSimpleName();
    private static final int LEVEL_ERROR = 0;
    private static final int LEVEL_INFO = 1;
    private static final int LEVEL_DEBUG = 2;
    private static ContactPointLog ourInstance = new ContactPointLog();
    private int logLevel = LEVEL_ERROR;

    private ContactPointLog() {
    }

    public static ContactPointLog getInstance() {
        return ourInstance;
    }

    public void info(String msg) {
        if (logLevel >= LEVEL_INFO) {
            Log.i(TAG, ""+msg);
        }
    }

    public void debug(String msg) {
        if (logLevel >= LEVEL_DEBUG) {
            Log.d(TAG, ""+msg);
        }
    }

    public void error(String msg) {
        if (logLevel >= LEVEL_ERROR) {
            Log.e(TAG, ""+msg);
        }
    }

    public void info(String tag, String msg) {
        if (logLevel >= LEVEL_INFO) {
            Log.i(tag, ""+msg);
        }
    }

    public void debug(String tag, String msg) {
        if (logLevel >= LEVEL_DEBUG) {
            Log.d(tag, ""+msg);
        }
    }

    public void error(String tag, String msg) {
        if (logLevel >= LEVEL_ERROR) {
            Log.e(tag, ""+msg);
        }
    }
}
