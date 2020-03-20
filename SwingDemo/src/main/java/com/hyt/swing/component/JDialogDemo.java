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
public class JDialogDemo extends JDialog {

    public JDialogDemo(JFrame frame, String title) {
        /**
         * 第一个参数：父窗体对象
         * 第二个参数：对话框标题
         * 第三个参数：是否阻塞父窗体
         */
        super(frame, title, true);

        this.setSize(400, 300);
        // 获得显示器大小对象
        Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize();
        // 获得窗口大小对象
        Dimension dialogSize = this.getSize();
        if (dialogSize.width > displaySize.width) {
            // 窗口的宽度不能大于显示器的宽度
            dialogSize.width = displaySize.width;
        }
        if (dialogSize.height > displaySize.height) {
            // 窗口的高度不能大于显示器的高度
            dialogSize.height = displaySize.height;
        }
        // 设置窗口居中显示器显示
        this.setLocation((displaySize.width - dialogSize.width) / 2, (displaySize.height - dialogSize.height) / 2);

        Container contentPane = this.getContentPane();
        JLabel label = new JLabel("lable");
        contentPane.add(label);
        frame.validate();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        final JFrame frame = new JFrameDemo();
        frame.setVisible(true);

        Container container = frame.getContentPane();
        JButton button = new JButton("弹出对话框");
        // 设置布局，使用流布局
        container.setLayout(new FlowLayout());
        container.add(button);
        container.validate();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
