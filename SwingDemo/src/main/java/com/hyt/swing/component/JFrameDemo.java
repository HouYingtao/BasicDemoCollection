package com.hyt.swing.component;

import javax.swing.*;
import java.awt.*;

/**
 * 功能介绍
 *
 * @author hou
 * @version 1.0
 * @date 2020-03-15 20:31
 * @since 1.8
 **/
public class JFrameDemo extends JFrame{

    public JFrameDemo() {
        // 设置标题
        this.setTitle("Title");
        /**
         * 关闭模式
         *
         * EXIT_ON_CLOSE：关闭窗体停止程序
         * DO_NOTHING_ON_CLOSE：无任何操作
         * HIDE_ON_CLOSE：隐藏窗体不停止程序
         * DISPOSE_ON_CLOSE：释放窗体资源
         */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗体大小，单位：像素
        this.setSize(600, 400);
        // 获得显示器大小对象
        Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize();
        // 获得窗口大小对象
        Dimension frameSize = this.getSize();
        if (frameSize.width > displaySize.width) {
            // 窗口的宽度不能大于显示器的宽度
            frameSize.width = displaySize.width;
        }
        if (frameSize.height > displaySize.height) {
            // 窗口的高度不能大于显示器的高度
            frameSize.height = displaySize.height;
        }
        // 设置窗口居中显示器显示
        this.setLocation((displaySize.width - frameSize.width) / 2, (displaySize.height - frameSize.height) / 2);

        // 设置窗口可拖拽最大最小尺寸范围
        // 现在最大不生效，JDK bug!
        this.setMaximumSize(new Dimension(800,600));
        this.setMinimumSize(new Dimension(500,300));

        // 设置左上角图标，默认显示Java图标
        this.setIconImage(new ImageIcon("C:\\Users\\86131\\Desktop\\icon.png").getImage());
        // 设置背景色
        Container contentPane = this.getContentPane();
        contentPane.setBackground(Color.LIGHT_GRAY);

        // 标签的添加与移除
        JLabel jLabel = new JLabel("窗体");
        contentPane.add(jLabel);
        contentPane.remove(jLabel);
        // 刷新容器中的组件，等效frame.setContentPane(contentPane);
        contentPane.validate();

        // 设置背景图片
        /*ImageIcon background = new ImageIcon("C:\\Users\\86131\\Desktop\\icon.png");
        JLabel label = new JLabel(background);
        label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        JPanel imagePanel = (JPanel) this.getContentPane();
        imagePanel.setOpaque(false);
        // 把背景图片添加到分层窗格的最底层作为背景
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));*/
        // 设置窗口是否可拖拽大小，默认可拖拽，false时窗口最大化不可用
        // this.setResizable(false);
        // 获取窗体的横纵坐标
        int x = this.getX();
        int y = this.getY();
    }
    public static void main(String[] args) {
        JFrameDemo jFrameDemo = new JFrameDemo();
        // 设置可见，默认不可见
        jFrameDemo.setVisible(true);
    }
}
