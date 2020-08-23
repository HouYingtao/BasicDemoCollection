package com.hyt.regex;

import org.junit.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 功能介绍
 *
 * @author hou
 * @version 1.0
 * @date 2020-08-13 22:26
 * @since 1.8
 **/
public class RegexTest {

    @Test
    public void ipDemo() {
        String ip = "fwing";
        String reg = "fw(?=ing)";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(ip);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
