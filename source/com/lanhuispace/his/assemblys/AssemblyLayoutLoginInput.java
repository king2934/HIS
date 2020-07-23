package com.lanhuispace.his.assemblys;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.FlowLayout;

import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class AssemblyLayoutLoginInput extends JPanel
{
	private static final int WIDTH = 320; //窗口宽度
	private static final int HEIGHT = 56; //窗口高度	
	
	private JPanel layout_left;
	private JPanel layout_center;
	private JPanel layout_right;
	private JPanel layout_bottom;
	
	private JLabel mJLabelTips;
	
	public AssemblyLayoutLoginInput()
	{
		initialize();
	}
	
	private void initialize()
	{		
		this.setBackground(null);//
		this.setOpaque(true);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		/***
		jpanel.setBorder(BorderFactory.你需要的样式);
		BorderFactory.createLineBorder(Color.red, 3)        //线边框  
		BorderFactory.createEtchedBorder()                 //蚀刻边框  
		BorderFactory.createRaisedBevelBorder()            //斜面边框(凸)  
		BorderFactory.createLoweredBevelBorder()           //斜面边框(凹)  
		BorderFactory.createTitledBorder("标题")          //标题边框左  
		BorderFactory.createTitledBorder("标题")          //标题边框右  
		setTitleJustification(TitledBorder.RIGHT);  
		BorderFactory.createMatteBorder(1, 5, 1, 1, Color.yellow) //花色边框  
		b1 = BorderFactory.createLineBorder(Color.blue, 2);  //组合边框  
		b2 = BorderFactory.createEtchedBorder();  
		BorderFactory.createCompoundBorder(b1, b2) 
		***/
		//this.setBorder(BorderFactory.createLineBorder(new Color(0,60,90), 3));//蚀刻边框
				
		this.mJLabelTips = new JLabel();
		//this.setText("提示提示提示提示提示提示提示提示");
		this.mJLabelTips.setFont(new Font("宋体",Font.BOLD,14));//PLAIN
		this.mJLabelTips.setForeground(Color.white);//white black

		
		this.layout_left = new JPanel();
		this.layout_center = new JPanel();
		this.layout_right = new JPanel();
		this.layout_bottom = new JPanel();
		
		this.layout_left.setBackground(Color.white);
		this.layout_center.setBackground(Color.white);
		this.layout_right.setBackground(Color.white);
		
		this.layout_left.setBounds(0,0,38,38);//x,y,w,h
		this.layout_center.setBounds(38,0,(WIDTH-38*2),38);//x,y,w,h
		this.layout_right.setBounds((WIDTH-38*2+38),0,38,38);//x,y,w,h
		this.layout_bottom.setBounds(0,(HEIGHT-18),WIDTH,18);//x,y,w,h
		
		this.layout_bottom.setBackground(null);
		this.layout_bottom.setOpaque(true);		
		this.layout_bottom.add(this.mJLabelTips);//
		
		this.add(this.layout_left);
		this.add(this.layout_center);
		this.add(this.layout_right);
		this.add(this.layout_bottom);
		
	}
	
	//改变提示文字
	public void setText(String str)
	{
		this.mJLabelTips.setText(str);
	}
	
	//设置类型
	public void setType(int i)
	{
		URL img_url = this.setTypeSelectImage(i);
		switch(i)
		{
			case 1:
				this.setTypeUserAndPass(img_url);
				break;
			case 2:
				this.setTypeUserAndPass(img_url);
				break;
			case 3:
				break;
		}
	}
	
	//
	private URL setTypeSelectImage(int i)
	{
		URL ico_left_uri = getClass().getResource("/images/login_user.png");
		switch(i)
		{
			case 1:
				ico_left_uri = getClass().getResource("/images/login_user.png");
				break;
			case 2:
				ico_left_uri = getClass().getResource("/images/login_pass.png");
				break;
		}
		return ico_left_uri;
	}
	
	//
	private void setTypeUserAndPass(URL imgUrl)
	{
		Icon ico_left_img = new ImageIcon(imgUrl);
		
		JLabel imgBox = new JLabel(ico_left_img,JLabel.CENTER);
		
		this.layout_left.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		this.layout_left.add(imgBox);
	}
}

















