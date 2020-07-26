package com.lanhuispace.his.assemblys;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;

import java.io.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

public class AssemblyClientNameManagement extends JLabel
{
	private String mClientNameString;
	public AssemblyClientNameManagement(ImageIcon ic)
	{
		super(ic);
	}
	
	public AssemblyClientNameManagement(String s){
		super(s);
	}	
	
	public AssemblyClientNameManagement()	
	{
		initialize();
	}
	
	private void initconfigjson()
	{
		File file = new File("config.json");
		if( file.exists() ){
			try
			{
				InputStream  is = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(is);
				JsonReader jsonReader = new JsonReader(isr);
				
				this.mClientNameString = "松江中心医院";
			}
			catch(IOException e)
			{
				
			}
			
		}else{
			this.mClientNameString = "复旦大学附属儿科医院";
		}
	}
	
	private void initialize()
	{
		initconfigjson();
		this.setForeground(Color.darkGray);//字体颜色
		this.setFont(new Font("微软雅黑",Font.BOLD,36));//字体 加粗 36号大小
		this.setText(this.mClientNameString);
	}
}