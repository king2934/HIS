package com.lanhuispace.his.assemblys;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Point;
import java.awt.Color;
import java.awt.Cursor;

public class AssemblyMouseEventCustomTitleBarLogin extends JPanel implements MouseListener,MouseMotionListener
{
	private JFrame mContext;
	
	private Point prePos,curPos,jfPos;
	private static final double Boundary = 15.0;//边界拉伸范围
	private int DragType;
	private static final int Drag_move = 1;
	private static final int Drag_up = 2;
	private static final int Drag_up_left = 3;
	private static final int Drag_up_right = 4;
	private static final int Drag_left = 5;
	private static final int Drag_right = 6;
	private static final int Drag_bottom = 7;
	private static final int Drag_bottom_left = 8;
	private static final int Drag_bottom_right = 9;
	
	public AssemblyMouseEventCustomTitleBarLogin(JFrame jframe)
	{
		this.mContext = jframe;
		initialize();
	}
	
	private void initialize()
	{
		this.setBackground(new Color(0,102,153,76));//
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	private boolean ReSizeScale(Point p)
	{
		double X = p.getX();
		double Y = p.getY();
		double W = this.mContext.getWidth();
		double H = this.mContext.getHeight();
		
		this.mContext.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 默认光标类型
		
		/*
		if( X <= Boundary && Y <= Boundary ){ 
			this.DragType = Drag_up_left;
			this.mContext.setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));//调整窗口左上角大小的光标类型。
		}else if( X > Boundary && X < (W-Boundary) && Y <= Boundary ){ 
			this.DragType = Drag_up;
			this.mContext.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//调整窗口上边框大小的光标类型。
		}else if( X >=(W-Boundary) && Y<=Boundary ){
			this.DragType = Drag_up_right;
			this.mContext.setCursor(new Cursor(Cursor.NE_RESIZE_CURSOR));//调整窗口右上角大小的光标类型。
		}else if( X<=Boundary  && Y<(H-Boundary) && Y>Boundary ){ 
			this.DragType = Drag_left;
			this.mContext.setCursor(new Cursor(Cursor.W_RESIZE_CURSOR));//调整窗口左边框大小的光标类型。
		}else if(X>=(W-Boundary) && p.getY()<(H-Boundary) && Y>Boundary ){ 
			this.DragType = Drag_right;
			this.mContext.setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));//调整窗口右边框大小的光标类型
		}else if( X<=Boundary && Y>=(H-Boundary) ){ 
			this.DragType = Drag_bottom_left;
			this.mContext.setCursor(new Cursor(Cursor.SW_RESIZE_CURSOR));//调整窗口左下角大小的光标类型
		}else if( X>Boundary  && X<(W-Boundary) && Y>=(H-Boundary) ){ 
			this.DragType = Drag_bottom;
			this.mContext.setCursor(new Cursor(Cursor.S_RESIZE_CURSOR));//调整窗口下边框大小的光标类型
		}else if( X>=(W-Boundary) && Y>=(H-Boundary) ){ 
			this.DragType = Drag_bottom_right;
			this.mContext.setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));//调整窗口右下角大小的光标类型
		}else{ 
			this.DragType = Drag_move;
			this.mContext.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 默认光标类型
			return false;
		}
		*/
		return true;
		/*
		CROSSHAIR_CURSOR
				  十字光标类型。
		CUSTOM_CURSOR
				  与所有定制光标有关的类型。
		DEFAULT_CURSOR
				  默认光标类型（如果没有定义光标，则获取该设置）。
		E_RESIZE_CURSOR
				  调整窗口右边框大小的光标类型。
		HAND_CURSOR
				  手状光标类型。
		MOVE_CURSOR
				  移动光标类型。
		N_RESIZE_CURSOR
				  调整窗口上边框大小的光标类型。
		String name
				  光标的用户可视名称。
		NE_RESIZE_CURSOR
				  调整窗口右上角大小的光标类型。
		NW_RESIZE_CURSOR
				  调整窗口左上角大小的光标类型。
		static Cursor[] predefined
				   
		S_RESIZE_CURSOR
				  调整窗口下边框大小的光标类型。
		SE_RESIZE_CURSOR
				  调整窗口右下角大小的光标类型。
		SW_RESIZE_CURSOR
				  调整窗口左下角大小的光标类型。
		TEXT_CURSOR
				  文字光标类型。
		W_RESIZE_CURSOR
				  调整窗口左边框大小的光标类型。
		WAIT_CURSOR
		*/
	}
	
	private void dragAction()
	{
		int W = this.mContext.getWidth();
		int H = this.mContext.getHeight();
		this.mContext.setLocation(jfPos.x+curPos.x-prePos.x,jfPos.y+curPos.y-prePos.y);
		/*
		switch(this.DragType)
		{
			case Drag_move: 
				this.mContext.setLocation(jfPos.x+curPos.x-prePos.x,jfPos.y+curPos.y-prePos.y); 
				break; 
			case Drag_up:	//x位置不变，y位置变化，并且Height变化 
				//this.mContext.setLocation(jfPos.x,jfPos.y+curPos.y-prePos.y); 
				//this.mContext.setSize(W, H-(curPos.y-prePos.y)); 
				this.mContext.setLocation(jfPos.x+curPos.x-prePos.x,jfPos.y+curPos.y-prePos.y); 
				break; 
			case Drag_left:	//y位置不变，x位置变化，width变化 
				this.mContext.setLocation(jfPos.x+curPos.x-prePos.x,jfPos.y); 
				this.mContext.setSize(W-(curPos.x-prePos.x), H); 
				break; 
			case Drag_right: //x,y位置不变，width变化 
				this.mContext.setLocation(jfPos.x,jfPos.y); 
				this.mContext.setSize(W+(curPos.x-prePos.x), H); 
				break; 
			case Drag_bottom: //x,y位置不变，Height变化 
				this.mContext.setLocation(jfPos.x, jfPos.y); 
				this.mContext.setSize(W, H+(curPos.y-prePos.y)); 
				break; 
			case Drag_up_left: //x,y位置均变化，h,w均变化 
				this.mContext.setLocation(jfPos.x+curPos.x-prePos.x,jfPos.y+curPos.y-prePos.y); 
				this.mContext.setSize(W-(curPos.x-prePos.x), H-(curPos.y-prePos.y)); 
				break;
			case Drag_bottom_right: //x,y位置均不变，h,w变化 
				this.mContext.setLocation(jfPos.x, 
				jfPos.y); 
				this.mContext.setSize(W+(curPos.x-prePos.x), H+(curPos.y-prePos.y)); 
				break; 
			case Drag_up_right: //x位置不变，y,w,h变化 
				this.mContext.setLocation(jfPos.x,jfPos.y+curPos.y-prePos.y); 
				this.mContext.setSize(W+(curPos.x-prePos.x), H-(curPos.y-prePos.y)); 
				break; 
			case Drag_bottom_left:// y不变，xwh变化 
				this.mContext.setLocation(jfPos.x+curPos.x-prePos.x,jfPos.y); 
				this.mContext.setSize(W-(curPos.x-prePos.x), H+(curPos.y-prePos.y)); 
				break; 
			default: 
				break; 
		} 
		*/
	}	
	//在组件上单击(按下并释放)鼠标按钮时调用
	@Override
    public void mouseClicked(MouseEvent e)
	{
    }

	//在组件上按下鼠标按钮时调用
    @Override
    public void mousePressed(MouseEvent e)
	{
		prePos = e.getLocationOnScreen();
    }

	//在组件上释放鼠标按钮时调用
    @Override
    public void mouseReleased(MouseEvent e)
	{
    }
	
	//将鼠标光标移动到组件但未按下任何按钮时调用
	@Override
    public void mouseMoved(MouseEvent e)
	{
		ReSizeScale(e.getPoint());
	}
	
	@Override
	public void mouseDragged(MouseEvent e)
	{
		curPos = e.getLocationOnScreen();
		jfPos = this.mContext.getLocation();
		dragAction();
		prePos = curPos;
	}
	
	//鼠标进入组件时调用
    @Override
    public void mouseEntered(MouseEvent e)
	{
    }

	//鼠标退出组件时调用
    @Override
    public void mouseExited(MouseEvent e)
	{
    }
}