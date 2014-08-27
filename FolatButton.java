﻿package org.crazyit.codeview;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class CodeView extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final Button bn = (Button) findViewById(R.id.alert);
		bn.setOnTouchListener(new OnTouchListener() {
			int[] temp = new int[] { 0, 0 };

			public boolean onTouch(View v, MotionEvent event) {
				int eventaction = event.getAction();

				int x = (int) event.getRawX();
				int y = (int) event.getRawY();

				switch (eventaction) {

				case MotionEvent.ACTION_DOWN: // touch down so check if the
					temp[0] = (int) event.getX();
					temp[1] = y - v.getTop();
					break;

				case MotionEvent.ACTION_MOVE: // touch drag with the ball
					v.layout(x - temp[0], y - temp[1], x + v.getWidth()
							- temp[0], y - temp[1] + v.getHeight());

					// v.postInvalidate();
					break;

				case MotionEvent.ACTION_UP:
					break;
				}

				return false;
			}

		});
	}
}
