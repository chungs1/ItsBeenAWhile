package com.example.itsbeenawhile;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Fareki on 9/28/13.
 * Hijacked by Ongman shortly after.
 */
public class NewTaskActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_newtask);
        LinearLayout dateAndTime = (LinearLayout) findViewById(R.id.newTask);
        LayoutInflater li = getLayoutInflater();
        LinearLayout tmp = (LinearLayout) li.inflate(R.layout.custom_layout, null);
        dateAndTime.addView(tmp);

    }
    
    public void getUserInput(View v) {
        Dialog dialog = new Dialog(getBaseContext());
        dialog.setContentView(R.id.datePicker);
        saveTask(v);
    }

    public void saveTask(View view) {
    	try{
    	Calendar calendar = Calendar.getInstance();
    	long c = calendar.getTimeInMillis()/1000;
    	String task = "task" + Long.toString(c);
    	byte[] dateBytes = new byte[5];
    	dateBytes[0] = (byte) 2;
    	dateBytes[1] = (byte) 2;
    	dateBytes[2] = (byte) 2;
    	dateBytes[3] = (byte) 2;
    	
    	File file = new File("data/data/com.example.itsbeenawhile/task.txt");
    	FileOutputStream fos = getApplicationContext().openFileOutput(task+".txt", Context.MODE_PRIVATE);
    	fos.write(dateBytes);
    	fos.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	super.onBackPressed();
    }

}