import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class test
{
	private static final String mLogsDirectory = "logs";
	
	public static void main(String[] args)
	{
		new test();
	}
	
	public test()
	{
		init();
	}
	
	private void init()
	{
		File dirLogs = new File(this.mLogsDirectory);
		if( !dirLogs.exists() ){
			dirLogs.mkdirs();
		}
		
		String logFilePath = this.mLogsDirectory+"/log.txt";
		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(logFilePath,true));
			out.write("test 1 ... \n");
			out.close();
			System.out.println("yes write logs/log.txt is ok!");
		}
		catch (IOException e)
		{	
			System.out.println("no ");		
		}		
	}
}