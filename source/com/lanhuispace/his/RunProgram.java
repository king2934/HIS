package com.lanhuispace.his;

public class RunProgram implements Runnable
{
	@Override
	public synchronized void run()
	{
		try {
			JFrameLanHuiMain window = new JFrameLanHuiMain();
			//window.mJFrame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}