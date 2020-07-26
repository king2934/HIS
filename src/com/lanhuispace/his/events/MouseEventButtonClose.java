package com.lanhuispace.his.events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.lanhuispace.his.JFrameLanHuiLogin;
/**
*** void mouseClicked(MouseEvent e)			在组件上单击(按下并释放)鼠标按钮时调用。
*** void mouseEntered(MouseEvent e)			鼠标进入组件时调用。
*** void mouseExited(MouseEvent e)			鼠标退出组件时调用。
*** void mouseReleased(MouseEvent e)		在组件上释放鼠标按钮时调用。
*** void mouseWheelMoved(MouseWheelEvent e)	旋转鼠标滚轮时调用。

implements MouseListener, MouseWheelListener, MouseMotionListener
mouseClicked(MouseEvent e)
mousePressed(MouseEvent e)
mouseReleased(MouseEvent e)
mouseEntered(MouseEvent e)
mouseExited(MouseEvent e)
mouseWheelMoved(MouseWheelEvent e)
mouseDragged(MouseEvent e)
mouseMoved(MouseEvent e)
	
**/

public class MouseEventButtonClose extends MouseAdapter
{
	private JFrame mContext;
	private JButton mJButton;
	private JLabel mJLabel;
	
	//
	public MouseEventButtonClose(JFrame jframe,JButton jbutton)
	{
		this.mContext = jframe;
		this.mJButton = jbutton;
	}
	
	//
	public MouseEventButtonClose(JFrame jframe,JButton jbutton,JLabel jlabel)
	{
		this.mContext = jframe;
		this.mJButton = jbutton;
		this.mJLabel = jlabel;
	}
	
	//在组件上单击(按下并释放)鼠标按钮时调用。
	@Override
	public void mouseClicked(MouseEvent e)
	{
		System.exit(0);//点击退出
	}
	
	//鼠标进入组件时调用
	@Override
	public void mouseEntered(MouseEvent e)
	{
		this.mJButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // 经过时变成小手
		this.mJLabel.setText("关闭");
		//this.mJButton.setBackground(new Color(4,163,242,76)); // 背景色 76 ≈ 30% 背景色
	}
	
	//鼠标退出组件时调用
	@Override
	public void mouseExited(MouseEvent e)
	{
		//this.mJButton.setBackground(new Color(4,163,242,0)); // 背景色 76 ≈ 30% 背景色
	}
	
	// 在组件上释放鼠标按钮时调用
	@Override
	public void mouseReleased(MouseEvent e)
	{
		//this.mJButton.setBackground(new Color(4,163,242,0)); // 背景色 76 ≈ 30% 背景色
	}
}