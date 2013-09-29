package com.example.itsbeenawhile;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TimePicker;

/**
 * Created by Fareki on 9/28/13.
 * Hijacked by Ongman shortly after.
 */
public class NewTaskActivity extends Activity {
    private DatePicker datepicker;
    private TimePicker timepicker;
    private Button save;
    private Calendar c = Calendar.getInstance();
    private int year = c.get(Calendar.YEAR);
    private int month = c.get(Calendar.MONTH);
    private int day = c.get(Calendar.DAY_OF_MONTH);
    private int hour = c.get(Calendar.HOUR);
    private int minute = c.get(Calendar.MINUTE);
    static final int DATE_DIALOG_ID = 100;
    static final int TIME_DIALOG_ID = 200;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newtask);
        /*LinearLayout dateAndTime = (LinearLayout) findViewById(R.id.newTask);
        LayoutInflater li = getLayoutInflater();
        LinearLayout tmp = (LinearLayout) li.inflate(R.layout.custom_layout, null);
        dateAndTime.addView(tmp);*/
        addButtonListener();
        datepicker = (DatePicker) findViewById(R.id.datePicker);
        timepicker = (TimePicker) findViewById(R.id.timePicker);

        datepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DATE_DIALOG_ID);
            }
        });
        timepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(TIME_DIALOG_ID);
            }
        });
    }
    
    public void getUserInput(View v) {

        saveTask(v);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, datePickerListener, year, month, day);
            case TIME_DIALOG_ID:
                return new TimePickerDialog(this, timePickerListener, hour, day, false);
        }
        return null;
    }

    public void addButtonListener() {
        save = (Button) findViewById(R.id.save_task);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hour, int day) {

        }
    };

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;


        }
    };

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
    	
    	File file = new File("data/data/com.example.itsbeenawhile/"+task+".txt");
    	FileOutputStream fos = getApplicationContext().openFileOutput(task+".txt", Context.MODE_PRIVATE);
    	fos.write(dateBytes);
    	fos.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	super.onBackPressed();
    }

}
