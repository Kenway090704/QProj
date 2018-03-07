package com.aoben.qproj.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * The universal uitl
 * Created by kenway on 17/5/22 16:07
 * Email : xiaokai090704@126.com
 */

public class Util {

    private static final String TAG = "utils.Util";

    /**
     * buildInAESKey
     * 长度为16的 0--15的十六进制字节数组
     */
    private static final byte[] buildInAESKey = {(int) 0x00, (int) 0x01, (int) 0x02, (int) 0x03, (int) 0x04, (int) 0x05, (int) 0x06, (int) 0x07, (int) 0x08, (int) 0x09, (int) 0x0a, (int) 0x0b, (int) 0x0c, (int) 0x0d, (int) 0x0e,
            (int) 0x0f};

    /**
     * 生成AES key
     * 正常现在是生成128长度
     *
     * @return
     */
    public static byte[] geneAESKey() {
        KeyGenerator kg = null;
        try {
            kg = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            LogUtils.e(TAG, "%s", e.toString());
            return buildInAESKey;
        }

        // can be 128,192,256
        kg.init(128);
        SecretKey sk = kg.generateKey();
        if (Util.isNull(sk)) {
            LogUtils.e(TAG, "sk is null");
            return buildInAESKey;
        }

        byte[] ret = sk.getEncoded();
        if (Util.isNullOrNil(ret)) {
            LogUtils.e(TAG, "generate aes key fail!!!, ret is null or nil");
            return buildInAESKey;
        }

        LogUtils.d(TAG, "build aes ramdon key successful, length = %d", ret.length);
        return ret;
    }

    /**
     * The method check the string whether is null or nil or normally.
     *
     * @param str
     * @return
     */
    public static boolean isNullOrNil(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * The method check the string whether is null or blank.
     *
     * @param str
     * @return
     */
    public static boolean isNullOrBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    /**
     * The method check the byte array is valid or not
     *
     * @param object
     * @return
     */
    public static boolean isNullOrNil(final byte[] object) {
        if ((object == null) || (object.length <= 0)) {
            return true;
        }
        return false;
    }

    /**
     * The method check the object is null or not
     *
     * @param aObject
     * @return
     */
    public static boolean isNull(Object aObject) {
        return null == aObject;
    }

    /**
     * The method will return 0 when the given i is null.
     *
     * @param i
     * @return
     */
    public static Integer nullAsNil(Integer i) {
        if (i == null) {
            return 0;
        }
        return i;
    }

    public static String nullAsNil(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    /**
     * 判断是否为零
     *
     * @param data
     * @return
     */
    public static boolean isZore(int data) {
        if (data == 0) {
            return true;
        }
        return false;
    }

    /**
     * Get the suffix of the given file name.
     *
     * @param fileName
     * @return
     */
    public static String getSuffix(String fileName) {
        if (isNullOrNil(fileName)) {
            return null;
        }
        int lastIndex = fileName.lastIndexOf(".");
        if (lastIndex == -1 || fileName.length() == (lastIndex + 1)) {
            return null;
        }
        return fileName.substring(lastIndex + 1);
    }

    /**
     * Check whether the string suffix is match the given.
     *
     * @param str
     * @param suffix
     * @return
     */
    public static boolean isMatchSuffix(String str, String suffix) {
        if (isNullOrNil(str) || isNullOrNil(suffix)) {
            return false;
        }
        return suffix.equals(getSuffix(str));
    }


    /**
     * Check whether the string suffix is match the given when ignore case.
     *
     * @param str
     * @param suffix
     * @return
     */
    public static boolean isMatchSuffixIgnoreCase(String str, String suffix) {
        if (isNullOrNil(str) || isNullOrNil(suffix)) {
            return false;
        }
        return suffix.equalsIgnoreCase(getSuffix(str));
    }

    public static String getStack(Throwable throwable) {
        if (throwable == null) {
            return "";
        }
        ByteArrayOutputStream baos = null;
        PrintStream ps = null;
        try {
            baos = new ByteArrayOutputStream();
            ps = new PrintStream(baos);
            throwable.printStackTrace(ps);
            return baos.toString();
        } catch (Exception e) {
            return "";
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
