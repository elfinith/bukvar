package com.example.bukvar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements  OnTouchListener{

	final String ALPHABET = "ÉÖÓÊÅÍÃØÙÇÕÚÔÛÂÀÏÐÎËÄÆÝß×ÑÌÈÒÜÁÞ¨ÉÖÓÊÅÍÃØÙÇÕÚÔÛÂÀÏÐÎËÄÆÝß×ÑÌÈÒÜÁÞ¨ÉÖÓÊÅÍÃØÙÇÕÚÔÛÂÀÏÐÎËÄÆÝß×ÑÌÈÒÜÁÞ¨";
	final int DIRECTION_FORWARD = 1;
	final int DIRECTION_REVERSE = 2;

	LinearLayout llMain;
	TextView tvLetter1, tvLetter2, tvLetter3, tvLetter4, tvLetter5;

	float x0, y0, x1, y1;
	int iDirection;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		llMain = (LinearLayout) findViewById(R.id.LinearLayout1);
		tvLetter1 = (TextView) findViewById(R.id.textView5);
		tvLetter2 = (TextView) findViewById(R.id.textView1);		
		tvLetter3 = (TextView) findViewById(R.id.textView2);
		tvLetter4 = (TextView) findViewById(R.id.textView3);		
		tvLetter5 = (TextView) findViewById(R.id.textView4);

		tvLetter1.setOnTouchListener(this);
		tvLetter2.setOnTouchListener(this);	
		tvLetter3.setOnTouchListener(this);	
		tvLetter4.setOnTouchListener(this);	
		tvLetter5.setOnTouchListener(this);		

		llMain.setBackgroundResource(R.color.llBackgroundColor);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		int iNewLetter = (int) Math.round(Math.random()*ALPHABET.length());	
		switch (arg1.getAction()) {
		case MotionEvent.ACTION_DOWN:
			x0 = arg1.getX();
			y0 = arg1.getY();				
			break;
		case MotionEvent.ACTION_MOVE:
			x1 = arg1.getX();
			y1 = arg1.getY();
			if (y1 > y0) {
				iDirection = DIRECTION_FORWARD;
			}
			else {
				iDirection = DIRECTION_REVERSE; 
			}
			break;
		case MotionEvent.ACTION_UP:
		case MotionEvent.ACTION_CANCEL:
			switch (iDirection) {
			case DIRECTION_FORWARD:
				tvLetter5.setText(tvLetter4.getText().toString());
				tvLetter4.setText(tvLetter3.getText().toString());
				tvLetter3.setText(tvLetter2.getText().toString());
				tvLetter2.setText(tvLetter1.getText().toString());		
				tvLetter1.setText(String.valueOf(ALPHABET.charAt(iNewLetter)));					
				break;
			case DIRECTION_REVERSE:
				tvLetter1.setText(tvLetter2.getText().toString());
				tvLetter2.setText(tvLetter3.getText().toString());
				tvLetter3.setText(tvLetter4.getText().toString());
				tvLetter4.setText(tvLetter5.getText().toString());		
				tvLetter5.setText(String.valueOf(ALPHABET.charAt(iNewLetter)));					
				break;
			}
			break;
		}
		return true;
	}

}
