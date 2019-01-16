package com.zxin.shortbd;

/****
 * liukui 2018/04/18
 */
public class ShortcutBadgeException extends Exception {
    public ShortcutBadgeException(String message) {
        super(message);
    }
    public ShortcutBadgeException(String message, Exception e) {
        super(message, e);
    }
}
