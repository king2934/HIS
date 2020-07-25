package com.lanhuispace.his.assemblys;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;

import com.lanhuispace.his.assemblys.JFrameCustomDebug;

public class AssemblyCustomLoginButton extends JPanel implements MouseListener
{
	private static final int WIDTH = 320; //窗口宽度
	private static final int HEIGHT = 46; //窗口高度
	
	private JFrameCustomDebug mJFrameDebug; // 调试窗口
	private AsyncJFrameCustomDebug mAsyncDebug; //
	private JLabel mTextLoginSafe;
	
	public AssemblyCustomLoginButton()
	{
		initialize();
	}
	
	//
	private void initialize()
	{
		this.mJFrameDebug = new JFrameCustomDebug(); // 调试窗口
		this.mAsyncDebug = new AsyncJFrameCustomDebug(this.mJFrameDebug);  // 调试窗口 异步处理	 AsyncHttpUrlResult	
		
		this.mTextLoginSafe = new JLabel();
		this.mTextLoginSafe.setFont(new Font("Microsoft YaHei",Font.BOLD,24));
		this.mTextLoginSafe.setForeground(Color.white);
		this.mTextLoginSafe.setText("安 全 登 录");
				
		this.setBackground(new Color(0,80,140));//
		this.setOpaque(true);
		this.setLayout(new FlowLayout(FlowLayout.CENTER,0,4));
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // 经过时变成小手
		this.add(this.mTextLoginSafe);
		
		this.addMouseListener(this);//增加监听事件
	}
	
	/***
	白色	white	255	255	255
	浅灰色	lightGray	192	192	192
	灰色	gray	128	128	128
	深灰色	darkGray	64	64	64
	黑色	black	0	0	0
	红色	red	255	0	0
	粉色	pink	255	175	175
	橙色	orange	255	200	0
	黄色	yellow	255	255	0
	绿色	green	0	255	0
	品红色	magenta	255	0	255
	青色	cyan	0	255	255
	蓝色	blue
	***/
	//鼠标按下弹开时调用
	@Override
    public void mouseClicked(MouseEvent e)
	{
		this.setBackground(new Color(0,160,220));
		if ( !this.mJFrameDebug.isVisible() )
		{
			this.mJFrameDebug.setVisible(true);
		}

		AsyncJFrameCustomDebug httpRequest = new AsyncJFrameCustomDebug(this.mJFrameDebug);
		httpRequest.setThreadName("网络请求...");
		httpRequest.start();
		
		//窗口层次		
		// if( !this.mJFrameDebug.isAlwaysOnTop() )
		// {
			// this.mJFrameDebug.setAlwaysOnTop(true);
		// }
    }
	
	//鼠标时调用
    @Override
    public void mousePressed(MouseEvent e)
	{
		this.setBackground(new Color(0,140,140));
    }

	
    @Override
    public void mouseReleased(MouseEvent e)
	{
		//this.setBackground(new Color(0,60,120));//黑色
    }

	//鼠标经过时调用
    @Override
    public void mouseEntered(MouseEvent e)
	{
		this.setBackground(new Color(0,120,180));//
    }

	//鼠标移开时调用
    @Override
    public void mouseExited(MouseEvent e)
	{
		this.setBackground(new Color(0,80,140));//yellow
    }
}