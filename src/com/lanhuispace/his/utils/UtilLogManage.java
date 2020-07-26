package com.lanhuispace.his.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;

import com.lanhuispace.his.interfaces.CallBack;
import com.lanhuispace.his.assemblys.JFrameCustomDebug;

public class UtilLogManage implements Runnable,CallBack
{
	private static final String mLogsDirectory = "logs";
	
	private Thread mThread;
	private String mThreadName;
	private JFrameCustomDebug mJFrameDebug; // 调试窗口
	
	private String mLogMessage;
	
	public UtilLogManage()
	{
		init();
	}
	
	//
	private void init()
	{
		File dirLogs = new File(this.mLogsDirectory);
		if( !dirLogs.exists() ){
			dirLogs.mkdirs();
		}
	}
	
	public void putMessage(String msg)
	{
		this.mLogMessage = msg;
	}
	
	public void putLog(String str)
	{
		String logFilePath = this.mLogsDirectory+"/log.txt";
		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(logFilePath,true));
			out.write(str+"\n");
			out.close();
		}
		catch (IOException e)
		{			
		}
	}
	
	//
	public void setThreadName(String str)
	{
		this.mThreadName = str;
	}
	
	//
	public void start()
	{
		if( this.mThread == null )
		{
			this.mThread = new Thread (this,this.mThreadName);
			this.mThread.start();
		}
	}
	
	@Override
	public synchronized void run()
	{
		this.result(this.mThreadName+this.mLogMessage);
	}
	
	@Override
	public void result(String result)
	{
		String logFilePath = this.mLogsDirectory+"/log.txt";
		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(logFilePath,true));
			out.write(result+"\n");
			out.close();
		}
		catch (IOException e)
		{			
		}
	}
}