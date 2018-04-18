package cn.jyuyang.tms.Test;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Test {
    public static void main(String[] args) {
        String p = DigestUtils.md5Hex("000000");
        System.out.println(p);
    }
}
