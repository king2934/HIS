package com.lanhuispace.his.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import java.net.URL;
import java.net.HttpURLConnection;

public class UtilHttpUrl
{
	private String mUrlStr;
	private URL mUrl;
	private HttpURLConnection mConn = null;
	
	private String mJsonDataParams = null;
	private String mResult = null;
	
	public UtilHttpUrl()
	{
	}
	
	public UtilHttpUrl(String url)
	{
		this.mUrlStr = url;
	}
	
	//
	private void initConn(String method)
	{
		try
		{
			this.mUrl = new URL(this.mUrlStr);
			this.mConn = (HttpURLConnection)this.mUrl.openConnection();
			this.mConn.setDoInput(true);
            this.mConn.setDoOutput(true);
			this.mConn.setUseCaches(false);
			this.mConn.setRequestProperty("Content-Type","application/json;charset=UTF-8");
			// this.mConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");//k1=v1&k2=v2&...n
			this.mConn.setRequestMethod(method);
			this.mConn.setConnectTimeout(5000); // 设置连接超时时间
			this.mConn.setReadTimeout(5000); // 设置读取超时时间
			this.mConn.connect();
			
			if ( this.mJsonDataParams != null)
			{
				OutputStream os = this.mConn.getOutputStream();
				os.write(this.mJsonDataParams.getBytes());
				os.flush();
				os.close();
			}
			
            
			
			int response = this.mConn.getResponseCode();			
			if ( response == HttpURLConnection.HTTP_OK )
			{
				InputStream is = this.mConn.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line = null;
                StringBuffer sb = new StringBuffer();
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
				this.mResult = sb.toString();
			}
		}
		catch (Exception e)
		{
			//e.printStackTrace();
		}
		finally
		{
			if( this.mConn != null)
			{
				try
				{
					this.mConn.disconnect();
				}
				catch (Exception e)
				{
					e.getLocalizedMessage();//
				}
			}
		}
	}
	
	//
	public void doGet()
	{
		this.initConn("GET");
	}
	
	//
	public void doPost()
	{
		this.initConn("POST");
	}
	
	//
	public String getResult()
	{
		return this.mResult;
	}
}