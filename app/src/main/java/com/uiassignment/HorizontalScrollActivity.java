package com.uiassignment;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class HorizontalScrollActivity extends Activity implements View.OnClickListener {

    private LayoutParams params;
    private int viewWidth;
    private GestureDetector gestureDetector = null;
    private HorizontalScrollView horizontalScrollView;
    private ArrayList<LinearLayout> layouts;
    private int mWidth;
    private int currPosition;
    private LinearLayout layoutItem1;
    private LinearLayout layoutItem2;
    private LinearLayout layoutItem3;
    private LinearLayout layoutItem4;
    private LinearLayout layoutItem5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_scroll);

        inflateXml();

        horizontalScrollView.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (gestureDetector.onTouchEvent(event)) {


                    Log.v("onSingleTapConfirmed", String.valueOf(event.getX()) + String.valueOf(event.getY()));
                    return true;
                }
                return false;

            }
        });

    }


    /**
     * To inflate XML layout and  initalize other objects
     */
    private void inflateXml() {
        horizontalScrollView = (HorizontalScrollView) findViewById(R.id.horizontalScrollView);
        gestureDetector = new GestureDetector(new MyGestureDetector());
        layoutItem1 = (LinearLayout) findViewById(R.id.layout_item_1);
        layoutItem2 = (LinearLayout) findViewById(R.id.layout_item_2);
        layoutItem3 = (LinearLayout) findViewById(R.id.layout_item_3);
        layoutItem4= (LinearLayout) findViewById(R.id.layout_item_4);
        layoutItem5 = (LinearLayout) findViewById(R.id.layout_item_5);
        Display display = getWindowManager().getDefaultDisplay();
        mWidth = display.getWidth();
        viewWidth = mWidth / 3;
        layouts = new ArrayList<LinearLayout>();
        params = new LayoutParams(viewWidth, LayoutParams.WRAP_CONTENT);
        layoutItem1.setLayoutParams(params);
        layoutItem2.setLayoutParams(params);
        layoutItem3.setLayoutParams(params);
        layoutItem4.setLayoutParams(params);
        layoutItem5.setLayoutParams(params);
        layouts.add(layoutItem1);
        layouts.add(layoutItem2);
        layouts.add(layoutItem3);
        layouts.add(layoutItem4);
        layouts.add(layoutItem5);

        setClickListner();


    }

    /*Setting onClick Listner for Horizontal Scroll view items*/
    private void setClickListner() {
        layoutItem1.setOnClickListener(this);
        layoutItem2.setOnClickListener(this);
        layoutItem3.setOnClickListener(this);
        layoutItem4.setOnClickListener(this);
        layoutItem5.setOnClickListener(this);
    }

    /**
     * Start activity to show name of clicked item
     * @param v
     */
    private void startNextActivity(View v){
        LinearLayout layout=(LinearLayout)v;
        TextView txt= (TextView) layout.getChildAt(1);
        Intent intent=new Intent(HorizontalScrollActivity.this,DetailsViewActivity.class);
        intent.putExtra("ITEM_NAME",txt.getText());
        startActivity(intent);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_item_1:
                startNextActivity(v);
                break;
            case R.id.layout_item_2:
                startNextActivity(v);
                break;
            case R.id.layout_item_3:
                startNextActivity(v);
                break;
            case R.id.layout_item_4:
                startNextActivity(v);
                break;
            case R.id.layout_item_5:
                startNextActivity(v);
                break;

        }
    }

    /**
     * Class to add gesture detector to scroll horizontal scroll view
     */
    class MyGestureDetector extends SimpleOnGestureListener {

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            try {
                if (e1.getX() < e2.getX()) {
                    currPosition = getVisibleViews("left");
                } else {
                    currPosition = getVisibleViews("right");
                }

                horizontalScrollView.smoothScrollTo(layouts.get(currPosition)
                        .getLeft(), 0);
                return true;
            }
            catch (Exception e){
                return false;
            }
        }



    }


    /**
     * Get position of visible views in horizontal scroll view
     * @param direction
     * @return
     */
    public int getVisibleViews(String direction) {
        Rect hitRect = new Rect();
        int position = 0;
        int rightCounter = 0;
        for (int i = 0; i < layouts.size(); i++) {
            if (layouts.get(i).getLocalVisibleRect(hitRect)) {
                if (direction.equals("left")) {
                    position = i;
                    break;
                } else if (direction.equals("right")) {
                    rightCounter++;
                    position = i;
                    if (rightCounter == 2)
                        break;
                }
            }
        }
        return position;
    }
}