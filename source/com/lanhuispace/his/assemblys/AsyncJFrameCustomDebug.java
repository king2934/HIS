package com.lanhuispace.his.assemblys;

import com.lanhuispace.his.utils.UtilHttpUrl;
import com.lanhuispace.his.interfaces.CallBack;

public class AsyncJFrameCustomDebug implements Runnable,CallBack
{
	private Thread mThread;
	private String mThreadName;
	private JFrameCustomDebug mJFrameDebug; // 调试窗口
	
	public AsyncJFrameCustomDebug()
	{
	}
	
	public AsyncJFrameCustomDebug(JFrameCustomDebug jframe)
	{
		this.mJFrameDebug = jframe;
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
		UtilHttpUrl http = new UtilHttpUrl("http://47.114.36.177:8080/HIS//api/index");
		http.doGet();
		this.result(http.getResult());
	}
	
	@Override
	public void result(String result)
	{
		this.mJFrameDebug.addItemText("调试代码..."+result);
	}
}