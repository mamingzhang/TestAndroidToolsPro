package com.example.testandroidtoolspro;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;

public class StrictModeActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectAll().detectDiskReads().detectDiskWrites()
				.detectNetwork().penaltyDropBox().penaltyDeath().build());
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
				.detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()
				.build());

		String eol = System.getProperty("line.separator");
		try
		{
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					openFileOutput("myfile", MODE_WORLD_WRITEABLE)));
			writer.write("This is a test1." + eol);
			writer.write("This is a test2." + eol);
			writer.write("This is a test3." + eol);
			writer.write("This is a test4." + eol);
			writer.write("This is a test5." + eol);
			writer.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
