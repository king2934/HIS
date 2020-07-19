package com.lanhuispace.his;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JFrameLanHuiLogin extends JFrame
{
	private static final int WIDTH = 800; //窗口宽度
	private static final int HEIGHT = 480; //窗口高度
	
	private URL img_title_url; // 标题栏图片的URL
	private Image image_title; // 标题栏图片对像

	private JPanel layout_top;		// 上
	private JPanel layout_bottom;	// 下
	private JPanel layout_left;		// 左
	private JPanel layout_right;	// 右
	private JPanel layout_center;	// 中
	
	public JFrameLanHuiLogin()
	{
		initialize();
	}
	
	private void initialize()
	{
		this.img_title_url = JFrameLanHuiMain.class.getResource("/images/image_title.png");
		this.image_title = Toolkit.getDefaultToolkit().getImage(img_title_url);

		this.layout_top = new JPanel();
		this.layout_bottom = new JPanel();
		this.layout_left = new JPanel();
		this.layout_right = new JPanel();
		this.layout_center = new JPanel();
		
		this.layout_top.setLayout(null);
		
		this.layout_top.setBounds(0, 0, WIDTH, 40); //x、y、w、h
		this.layout_bottom.setBounds(0, 180, WIDTH, 300); //x、y、w、h
		
		this.layout_top.setPreferredSize(new Dimension(WIDTH,40)); // 宽度同窗体 高度40
		this.layout_bottom.setPreferredSize(new Dimension(WIDTH,40)); // 宽度同窗体 高度40
		this.layout_left.setPreferredSize(new Dimension(40,HEIGHT)); // 宽度同窗体 高度40
		this.layout_right.setPreferredSize(new Dimension(40,HEIGHT)); // 宽度同窗体 高度40
		
		this.layout_top.setBackground(new Color(0,102,153,255));
		this.layout_bottom.setBackground(new Color(0,102,153,255));
		this.layout_left.setBackground(new Color(0,102,153,255));
		this.layout_right.setBackground(new Color(0,102,153,255));
		this.layout_center.setBackground(Color.red);
		
		////
		JButton btn_close = new JButton(); // 关闭
		JButton btn_minim = new JButton(); // 最小化
		
		btn_close.setBounds(749,0,50,40);//x、y、w、h
		btn_minim.setBounds(698,0,50,40);//x、y、w、h
		
		btn_close.setBorderPainted(false); // 是否绘制边框
		btn_minim.setBorderPainted(false); // 是否绘制边框
		
		btn_close.setMargin(new Insets(0,0,0,0)); // 设置边距
		btn_minim.setMargin(new Insets(0,0,0,0)); // 设置边距
		
		btn_close.setFocusPainted(false);//去掉焦点边框
		btn_minim.setFocusPainted(false);//去掉焦点边框
		
		//btn_close.setContentAreaFilled(false);//去掉按钮填充
		//btn_close.setForeground(new Color(4,163,242,76)); // 76 ≈ 30% 字体颜色
		
		btn_minim.setBackground(new Color(4,163,242,0)); // 背景色 76 ≈ 30% 背景色
		btn_close.setBackground(new Color(4,163,242,0)); // 背景色 76 ≈ 30% 背景色
		
		this.layout_top.add(btn_close);
		this.layout_top.add(btn_minim);
		
		JLabel label = new JLabel("我是一个标签",JLabel.CENTER) ;   // 实例化标签对象
		label.setSize(200, 0);
		this.layout_bottom.add(label);
		
		this.setTitle("登录");
		this.setSize(WIDTH,HEIGHT);//w,h
		this.setLocationRelativeTo(null);//居中
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(this.image_title);
		this.setUndecorated(true);//默认的边框
		this.setLayout(null);// 空布局
		this.setBackground(Color.white);
		this.getContentPane().setBackground(new Color(200,200,200,1));
		
		this.getRootPane().setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.RED));//边框
		
		///
		this.add(this.layout_top);
		this.add(this.layout_bottom);
		
		
		/*
		this.add(layout_top,BorderLayout.NORTH);	// 上
		this.add(layout_bottom,BorderLayout.SOUTH);	// 下
		this.add(layout_left,BorderLayout.WEST);	// 左
		this.add(layout_right,BorderLayout.EAST);	// 右
		this.add(layout_center,BorderLayout.CENTER);// 中
		*/
		this.setVisible(true);
	}
}