package com.uiassignment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class ColorButtonsActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonColor1;
    private Button buttonColor2;
    private Button buttonColor3;
    private RelativeLayout parentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_buttons);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inflateXml();
    }

    /**
     * Inflate xml view
     */
    private void inflateXml() {
        buttonColor1 = (Button) findViewById(R.id.button_1);
        buttonColor2 = (Button) findViewById(R.id.button_2);
        buttonColor3 = (Button) findViewById(R.id.button_3);
        parentLayout= (RelativeLayout) findViewById(R.id.relative_layout_parent);
        
        setListenerstoViews();
    }

    /**
     * Add on click Listener to views
     */
    private void setListenerstoViews() {
        buttonColor1.setOnClickListener(this);
        buttonColor2.setOnClickListener(this);
        buttonColor3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_1:
                parentLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                break;
            case R.id.button_2:
                parentLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                break;
            case R.id.button_3:
                parentLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                break;
        }

    }
}
