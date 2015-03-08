package com.mwchen.virtualcash;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;


public class TestFlip extends ActionBarActivity
        implements GestureDetector.OnGestureListener {

    private ViewFlipper flipper;
    private GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_flip);

        //Initialize touch detector
        detector = new GestureDetector(this.getApplicationContext(), this);

        //get ViewFlipper instance
        flipper = (ViewFlipper) this.findViewById(R.id.ViewFlipper01);

        //add View to flipper queue
        flipper.addView(addTextView("step 1"));
        flipper.addView(addTextView("step 2"));
        flipper.addView(addTextView("step 3"));
        flipper.addView(addTextView("step 4"));
        flipper.addView(addTextView("step 5"));
    }

    private View addTextView(String text) {
        TextView tv = new TextView(this);
        tv.setText(text);
        tv.setGravity(1);
        return tv;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.detector.onTouchEvent(event);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_flip, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                           float velocityY) {
        //display next view in flipper queue
        this.flipper.showNext();
        return true;
    }
}
