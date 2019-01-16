package com.zxin.shortbd.util;

import android.database.Cursor;
import java.io.Closeable;
import java.io.IOException;

/**
 * @author liukui 2018/04/18
 */
public class CloseHelper {

    public static void close(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }


    public static void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException var2) {

        }
    }
}
