package com.hyt.swing.component;

import org.junit.Test;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * 功能介绍
 *
 * @author hou
 * @version 1.0
 * @date 2020-03-15 23:06
 * @since 1.8
 **/
public class JLabelDemo {

    public static void main(String[] args) {

    }

    @Test
    public void showLabelTest() {
        JFrame frame = new JFrameDemo();
        Container container = frame.getContentPane();

        // 参数标签内容
        JLabel label = new JLabel("lable");
        // 设置标签内容
        label.setText("resetText");
        // 设置字体：字体，样式，大小
        label.setFont(new Font("微软雅黑", Font.BOLD & Font.CENTER_BASELINE, 16));
        label.setForeground(Color.RED);
        container.add(label);
        frame.setVisible(true);
        frame.validate();
    }

    @Test
    public void showImgTest() {
        JFrame frame = new JFrameDemo();
        Container container = frame.getContentPane();

        // 参数标签内容
        JLabel label = new JLabel("imgLabel");

        // 获取图片URL
        URL url = this.getClass().getClassLoader().getResource("icon.png");
        ImageIcon image = new ImageIcon(url);
        image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
        label.setIcon(image);

        container.add(label);
        frame.validate();
        frame.setVisible(true);
        // Junit 测试结束会直接关闭线程导致窗口关闭
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
