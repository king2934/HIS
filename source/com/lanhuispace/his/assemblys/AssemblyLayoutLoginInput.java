package com.lanhuispace.his.assemblys;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class AssemblyLayoutLoginInput extends JPanel
{
	private JLabel mJLabelTips;
	public AssemblyLayoutLoginInput()
	{
		initialize();
	}
	
	private void initialize()
	{
		this.mJLabelTips = new JLabel();
		this.setText("提示");
		this.mJLabelTips.setForeground(Color.red);
		
		this.setBackground(Color.blue);//
		this.setLayout(new GridLayout(1,3,0,0)); //默认为1行，n列；1行3列，水平间距0，垂直间距0
		this.setPreferredSize(new Dimension(360,36));
		
		this.add(this.mJLabelTips);
		
	}
	
	public void setText(String str)
	{
		this.mJLabelTips.setText(str);
	}
}