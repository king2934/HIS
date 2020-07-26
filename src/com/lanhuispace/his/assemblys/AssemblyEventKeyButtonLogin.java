package com.lanhuispace.his.assemblys;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import com.lanhuispace.his.assemblys.AssemblyLayoutLoginInput;
import com.lanhuispace.his.utils.UtilLogManage;

public class AssemblyEventKeyButtonLogin implements KeyListener
{
	private JTextField mTextUserName = null;
	private JPasswordField mTextPassWord = null;

	private String mUserName;
	private String mPassWord;
	
	private AssemblyLayoutLoginInput mClassTipsUserName;
	private AssemblyLayoutLoginInput mClassTipsPassWord;
	private JLabel mJLabelTips;
	
	public AssemblyEventKeyButtonLogin(JTextField Tuser)
	{
		this.mTextUserName = Tuser;
	}
	
	public AssemblyEventKeyButtonLogin(JTextField Tuser,JPasswordField Tpass)
	{
		this.mTextUserName = Tuser;
		this.mTextPassWord = Tpass;
	}
	
	public void setAlert(JLabel lable)
	{
		this.mJLabelTips = lable;
	}
	
	//
	public void setClassTips(AssemblyLayoutLoginInput userTip)
	{
		this.mClassTipsUserName = userTip;
	}
	
	//
	public void setClassTips(AssemblyLayoutLoginInput userTip,AssemblyLayoutLoginInput passTip)
	{
		this.mClassTipsUserName = userTip;
		this.mClassTipsPassWord = passTip;
	}
	
	//
	public void keyPressed(KeyEvent e)
	{
		int keyCode  = e.getKeyCode();
		char keyChar = e.getKeyChar();
	}
	
	//
	public void keyReleased(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_ENTER)
		{
			this.mUserName = this.mTextUserName.getText().trim();
			
			if( mTextPassWord != null )
			{
				this.mPassWord = String.valueOf(this.mTextPassWord.getPassword()).trim();
				
				UtilLogManage logM = new UtilLogManage();
				logM.setThreadName("Thread login UserName And PassWord:");
				logM.putMessage("username:"+this.mUserName+",password:"+this.mPassWord);
				logM.start();
				
				this.mClassTipsUserName.setText("user:"+this.mUserName);
				this.mClassTipsPassWord.setText("pass:"+this.mPassWord);
			}			
		}
	}
	
	//
	public void keyTyped(KeyEvent e)
	{
		char keyChar = e.getKeyChar();
		if( !Pattern.matches("([a-z]|[A-Z]|[0-9]|-|_|!|@|#)",String.valueOf(keyChar)) || keyChar == ' ')
		{
			e.consume();
		}			
	}
}