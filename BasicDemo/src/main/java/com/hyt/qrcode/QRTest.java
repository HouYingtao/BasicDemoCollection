package com.hyt.qrcode;

import org.junit.Test;

/**
 * 功能介绍
 *
 * @author hou
 * @version 1.0
 * @date 2019-09-24 22:32
 * @since 1.8
 **/
public class QRTest {
    @Test
    public void qrcode(){
        // QRCodeUtil.encodeQRCode("https://blog.csdn.net/qq_21319187/article/details/81411271", "D:\\test\\first11.png");
        QRCodeUtil.encodeQRCode("wxp://f2f0qfPNd1zW4b6gp336wfgOWwyTYZeZJGEE", "D:\\test\\hyt.png");
    }

    @Test
    public void decode(){
        QRCodeUtil.decodeQRCode("D:\\test\\wechat.jpg");
    }

}
