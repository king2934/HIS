package com.lanhuispace.his.assemblys;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AssemblyMouseEventButtonMinimize extends JPanel implements MouseListener
{
	private JFrame mContext;
	public AssemblyMouseEventButtonMinimize()
	{
		initialize();
	}
	
	public AssemblyMouseEventButtonMinimize(JFrame jframe)
	{
		this.mContext = jframe;
		initialize();
	}
	
	private void initialize()
	{		
		this.setBackground(new Color(1,119,178,0));//背景色
		//this.setOpaque(false);//透明
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // 经过时变成小手
		this.setPreferredSize(new Dimension(50,40)); // 宽度同窗体 高度40
		this.addMouseListener(this);//增加监听事件
	}
	
	// 重写(覆盖)JPanel的paint方法
	public void paint(Graphics g)
	{
		// 1、调用父类函数，完成初始化任务
        super.paint(g);
		
		Graphics2D g2 = (Graphics2D)g;  //g是Graphics对象
		g2.setStroke(new BasicStroke(3.0f));			
		g2.setColor(new Color(255,255,255));			
		g2.drawLine(18,19,31,19);// x1,y1,x2,y2
	}
	
	@Override
    public void mouseClicked(MouseEvent e)
	{
		this.mContext.setExtendedState(JFrame.ICONIFIED);//最小化
    }

    @Override
    public void mousePressed(MouseEvent e)
	{

    }

    @Override
    public void mouseReleased(MouseEvent e)
	{
		
    }

	//鼠标进入组件时调用
    @Override
    public void mouseEntered(MouseEvent e)
	{
		this.setBackground(new Color(1,119,178,255));//背景色
    }

	//鼠标退出组件时调用
    @Override
    public void mouseExited(MouseEvent e)
	{
		this.setBackground(null);//背景色
    }
}