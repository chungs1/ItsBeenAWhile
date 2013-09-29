package com.example.itsbeenawhile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void newItem(View view) {
        Intent intent = new Intent(this, NewTaskActivity.class);
        startActivity(intent);
    }
    
    
    
    public class CustomList extends ListActivity {
    	private LayoutInflater minflater;
    	private Vector<RowData> data;
    	
    	public void onCreate(Bundle savedInstanceState) {
    		super.onCreate(savedInstanceState);
    		setContentView(R.layout.activity_main);
    		minflater = (LayoutInflater) getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
    		
    		InputStream in = null;
    		try {
    			in = openFileInput("data/data/com.example.itsbeenawhile/task.txt");
    			if (in != null) {
    				InputStreamReader isr = new InputStreamReader(in);
    				BufferedReader br = new BufferedReader(isr);
    				String receiveString = "";
    				StringBuilder stringBuild = new StringBuilder();
    				
    				while((receiveString = br.readLine()) != null) {
    					stringBuild.append(receiveString);
    				}
    			}
    		} catch (FileNotFoundException e){
    			// do nothing
    		}
    		data = new Vector<RowData>;
    		RowData rd = new RowData()
    	}

		private InputStream BufferedInputStream(FileInputStream fileInputStream) {
			// TODO Auto-generated method stub
			return null;
		}
    }
    
    private class RowData {
    	
    }
    
}
