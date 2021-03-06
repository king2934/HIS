package com.lanhuispace.his;

import javax.swing.border.*;
import javax.swing.*;

import java.awt.*;
import java.awt.Color;
import java.net.URL;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.lanhuispace.his.events.MouseEventButtonMinimize;
import com.lanhuispace.his.events.MouseEventButtonClose;

import com.lanhuispace.his.assemblys.AssemblyMouseEventCustomTitleBarLogin;
import com.lanhuispace.his.assemblys.AssemblyMouseEventButtonMinimize;
import com.lanhuispace.his.assemblys.AssemblyMouseEventButtonClose;
import com.lanhuispace.his.assemblys.AssemblyClientNameManagement;
import com.lanhuispace.his.assemblys.AssemblyLayoutLoginInput;
import com.lanhuispace.his.assemblys.AssemblyEventKeyButtonLogin;
import com.lanhuispace.his.assemblys.AssemblyCustomLoginButton;

public class JFrameLanHuiLogin extends JFrame
{
	private JLabel mLabelHospitalName;
	private static final int WIDTH = 800; //窗口宽度
	private static final int HEIGHT = 480; //窗口高度
	
	private URL img_title_url; // 标题栏图片的URL
	private Image image_title; // 标题栏图片对像

	private JPanel layout_top;		// 上
	private JPanel layout_bottom;	// 下
	private JPanel layout_left;		// 左
	private JPanel layout_right;	// 右
	private JPanel layout_center;	// 中
	
	private JTextField mTextUserName;
	private JPasswordField mTextPassWord;

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
		//this.layout_left = new JPanel();
		//this.layout_right = new JPanel();
		this.layout_center = new JPanel();
		
		this.layout_top.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));// 右对齐 水平间距0 垂直间距0
		this.layout_center.setLayout(new FlowLayout(FlowLayout.CENTER,0,36));
		this.layout_bottom.setLayout(new FlowLayout(FlowLayout.CENTER,0,20));
		
		this.layout_top.setBounds(0, 0, WIDTH, 40); //x、y、w、h
		this.layout_bottom.setBounds(0, 180, WIDTH, 300); //x、y、w、h
		this.layout_center.setBounds(0, 40, WIDTH, 140); //x、y、w、h
		
		this.layout_top.setPreferredSize(new Dimension(WIDTH,40)); // 宽度同窗体 高度40
		this.layout_bottom.setPreferredSize(new Dimension(WIDTH,40)); // 宽度同窗体 高度40
		//this.layout_left.setPreferredSize(new Dimension(40,HEIGHT)); // 宽度同窗体 高度40
		//this.layout_right.setPreferredSize(new Dimension(40,HEIGHT)); // 宽度同窗体 高度40
		
		this.layout_top.setBackground(new Color(0,102,153,255));
		this.layout_bottom.setBackground(new Color(0,102,153,255));
		//this.layout_left.setBackground(new Color(0,102,153,255));
		//this.layout_right.setBackground(new Color(0,102,153,255));
		this.layout_center.setBackground(Color.white);
		
		////
		JPanel layout_user_pass = new JPanel();
		layout_user_pass.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
		layout_user_pass.setPreferredSize(new Dimension(320,220));
		layout_user_pass.setBackground(null);
		layout_user_pass.setOpaque(true);		
		
		//
		AssemblyLayoutLoginInput layout_username = new AssemblyLayoutLoginInput();
		AssemblyLayoutLoginInput layout_password = new AssemblyLayoutLoginInput();
		
		this.mTextUserName = new JTextField();
		this.mTextPassWord = new JPasswordField();
		
		this.mTextUserName.setBackground(Color.white);
		this.mTextPassWord.setBackground(Color.white);
		
		this.mTextUserName.setFont(new Font("Microsoft YaHei",Font.BOLD,18));
		this.mTextPassWord.setFont(new Font("Microsoft YaHei",Font.BOLD,18));
		
		this.mTextUserName.setBorder(null);//
		this.mTextPassWord.setBorder(null);//
		
		AssemblyEventKeyButtonLogin login_key_user = new AssemblyEventKeyButtonLogin(this.mTextUserName);
		AssemblyEventKeyButtonLogin login_key_pass = new AssemblyEventKeyButtonLogin(this.mTextUserName,this.mTextPassWord);
		
		login_key_user.setClassTips(layout_username);
		login_key_pass.setClassTips(layout_username,layout_password);
		
		this.mTextUserName.addKeyListener(login_key_user);
		this.mTextPassWord.addKeyListener(login_key_pass);		
		
		layout_username.setTextFieldUserName(this.mTextUserName);
		layout_password.setTextFieldPassWord(this.mTextPassWord);
		
		layout_username.setType(1);
		layout_password.setType(2);
		
		AssemblyCustomLoginButton layout_login = new AssemblyCustomLoginButton();
		
		layout_user_pass.add(layout_username);
		layout_user_pass.add(layout_password);
		layout_user_pass.add(layout_login);
		
		
	
		
		////
		this.mLabelHospitalName = new AssemblyClientNameManagement() ;   // 实例化标签对象
		//this.mJLabel.setBounds(0,0,600,80);//x、y、w、h
		this.layout_center.add(this.mLabelHospitalName);
		//this.layout_bottom.add(this.mJLabel);


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
		
		this.layout_bottom.add(layout_user_pass);
		
		///
		this.add(this.layout_top);
		this.add(this.layout_center);
		this.add(this.layout_bottom);
		//this.add(this.layout_left);
		//this.add(this.layout_right);
		
		
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