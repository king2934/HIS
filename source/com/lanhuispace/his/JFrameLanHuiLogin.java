package com.lanhuispace.his;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.lanhuispace.his.events.MouseEventButtonMinimize;
import com.lanhuispace.his.events.MouseEventButtonClose;

import com.lanhuispace.his.assemblys.AssemblyMouseEventCustomTitleBarLogin;
import com.lanhuispace.his.assemblys.AssemblyMouseEventButtonMinimize;
import com.lanhuispace.his.assemblys.AssemblyMouseEventButtonClose;

public class JFrameLanHuiLogin extends JFrame
{
	private JLabel mJLabel;
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
		this.img_title_url = JFrameLanHuiLogin.class.getResource("/images/image_title.png");
		this.image_title = Toolkit.getDefaultToolkit().getImage(img_title_url);

		this.layout_top = new AssemblyMouseEventCustomTitleBarLogin(this);
		this.layout_bottom = new JPanel();
		this.layout_left = new JPanel();
		this.layout_right = new JPanel();
		this.layout_center = new JPanel();
		
		this.layout_top.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));// 右对齐 水平间距0 垂直间距0
		
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
		
		/*
		JButton btn_minim = new JButton(); // 最小化
		JButton btn_close = new JButton(); // 关闭
		
		//btn_minim.setText("最小化");
		//btn_close.setText("关闭");
		
		btn_minim.setPreferredSize(new Dimension(50,40));//设置大小
		btn_close.setPreferredSize(new Dimension(50,40));//设置大小
				
		btn_minim.setBorderPainted(false); // 是否绘制边框
		btn_close.setBorderPainted(false); // 是否绘制边框
		
		btn_minim.setMargin(new Insets(0,0,0,0)); // 设置边距
		btn_close.setMargin(new Insets(0,0,0,0)); // 设置边距
		
		btn_minim.setFocusPainted(false);//去掉焦点边框
		btn_close.setFocusPainted(false);//去掉焦点边框		
		
		//btn_close.setPressedIcon(new ImageIcon("button_press.png")); // 设置按钮被点击时的图片
		//btn_close.setContentAreaFilled(false);//去掉按钮填充
		//btn_close.setForeground(new Color(4,163,242,76)); // 76 ≈ 30% 字体颜色
		
		btn_minim.setIcon(new ImageIcon(JFrameLanHuiLogin.class.getResource("/images/btn_minim.png"))); //
		btn_close.setIcon(new ImageIcon(JFrameLanHuiLogin.class.getResource("/images/btn_close.png"))); //
		
		//btn_minim.setPressedIcon(new ImageIcon(JFrameLanHuiLogin.class.getResource("/images/btn_minim.png"))); //
		//btn_close.setPressedIcon(new ImageIcon(JFrameLanHuiLogin.class.getResource("/images/btn_close.png"))); //
		
		btn_minim.setBackground(new Color(4,163,242,0)); // 背景色 76 ≈ 30% 背景色
		btn_close.setBackground(new Color(4,163,242,0)); // 背景色 76 ≈ 30% 背景色
		*/
		
		
		////
		this.mJLabel = new JLabel("我是一个标签",JLabel.CENTER) ;   // 实例化标签对象
		this.mJLabel.setSize(200, 0);
		this.layout_bottom.add(this.mJLabel);


		//最小化
		//MouseEventButtonMinimize meb_min = new MouseEventButtonMinimize(this,btn_minim);
		//MouseEventButtonClose meb_close = new MouseEventButtonClose(this,btn_close,this.mJLabel);
		
		//btn_minim.addMouseListener(meb_min);//
		//btn_close.addMouseListener(meb_close);//

		//btn_minim.setOpaque(false);//透明
		//btn_close.setOpaque(false);//透明
		
		AssemblyMouseEventButtonMinimize btn_minim = new AssemblyMouseEventButtonMinimize(this);
		AssemblyMouseEventButtonClose btn_close = new AssemblyMouseEventButtonClose();
		
		
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
		
		this.layout_top.add(btn_minim);
		this.layout_top.add(btn_close);
		
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