package com.lanhuispace.his.assemblys;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.Color;

import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;

public class JFrameCustomDebug extends JFrame
{
	private static final int WIDTH = 500; //窗口宽度
	private static final int HEIGHT = 400; //窗口高度
	
	private JPanel mScrollBox;
	private JScrollPane mJScrollPane;
	private JLabel mJLabelTexts;
	private String mHtmls;

	public JFrameCustomDebug()
	{
		initialize();//窗口初始化
	}
	
	/**
		1. 边框布局管理器 BorderLayout
		2. 流式布局管理器 FlowLayout
		3. 卡片布局管理器 CardLayout
		4. 网格布局管理器 GridLayout
		5. 网格包布局管理器 GridBagLayout
		6. 盒布局管理器 BoxLayout
	**/
	
	//窗口初始化
	private void initialize()
	{
		URL imgUrl = this.getClass().getResource("/images/image_title.png");
		Image imgIocn = Toolkit.getDefaultToolkit().getImage(imgUrl);
		
		this.setTitle("调试窗口");
		this.setSize(WIDTH,HEIGHT);//宽,高
		this.setLocationRelativeTo(null);//居中
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//隐藏窗口
		this.setIconImage(imgIocn);//图像
		
		//
		this.mScrollBox = new JPanel();// JComponent  JPanel
		//this.mScrollBox.setBackground(Color.darkGray);
		this.mScrollBox.setLayout(new FlowLayout(FlowLayout.LEADING));//		
		/**
		垂直滚动条
		ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED    // 需要时显示（默认）
		ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER        // 从不显示
		ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS       // 总是显示
		
		水平滚动条
		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED  // 需要时显示（默认）
		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER      // 从不显示
		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS     // 总是显示
		**/
		this.mJScrollPane = new JScrollPane();
		this.mJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // 设置垂直滚动条的显示策略 
		this.mJScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // 设置水平滚动条的显示策略
		//this.mJScrollPane.setWheelScrollingEnabled();// 是否响应鼠标滚动事件，默认响应
		
		this.mJLabelTexts = new JLabel();
		this.mHtmls = "调试开始...";
		this.mJLabelTexts.setText("<html>"+this.mHtmls+"</html>");
		
		this.mScrollBox.add(this.mJLabelTexts);
		
		this.mJScrollPane.setViewportView(this.mScrollBox);
		
		this.setContentPane(this.mJScrollPane);
		//this.setVisible(true);//显示窗口
	}
	
	//
	public void addItemText(String str)
	{
		this.mHtmls = this.mHtmls + "<p>"+str+"</p>";
		this.mJLabelTexts.setText("<html>"+this.mHtmls+"</html>");
	
		this.mScrollBox.add(this.mJLabelTexts);
	}
}