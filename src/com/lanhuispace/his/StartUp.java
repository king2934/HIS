package com.lanhuispace.his;

public class StartUp implements Runnable
{
	@Override
	public synchronized void run()
	{
		try {
			JFrameLanHuiLogin window = new JFrameLanHuiLogin();
			//window.mJFrame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}