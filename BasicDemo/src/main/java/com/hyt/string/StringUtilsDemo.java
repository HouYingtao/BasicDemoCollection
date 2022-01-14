package com.hyt.string;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * 功能介绍
 *
 * @author hou
 * @version 1.0
 * @date 2020-09-03 23:35
 * @since 1.8
 **/
public class StringUtilsDemo {

    @Test
    public void abbreviateTest() {
        String test = "This is a test of the abbreviation.";
        String test2 = "Test";

        System.out.println( StringUtils.abbreviate( test, 15 ) );
        System.out.println( StringUtils.abbreviate( test, 5,15 ) );
        System.out.println( StringUtils.abbreviate( test, 6,15 ) );
        System.out.println( StringUtils.abbreviate( test2, 10 ) );
        // This is a te...
        // ...is a test...
        // ...s a test ...
        // Test
    }
    @Test
    public void centerTest() {
        System.out.println( StringUtils.center( "China", 11,"*"));
        System.out.println( StringUtils.center( "China", 12,"*"));
        System.out.println( StringUtils.center( "China", 12,"abc"));
        System.out.println( StringUtils.center( "China", 14,"abc"));
    }
}
