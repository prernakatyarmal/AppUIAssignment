package com.uiassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnScrollView, btnTextpattern, btnColorActivity, btnViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inflateXml();

    }

    private void inflateXml() {
        btnColorActivity = (Button) findViewById(R.id.button_color);
        btnTextpattern = (Button) findViewById(R.id.button_text_pattern);
        btnViewPager = (Button) findViewById(R.id.button_view_pager);
        btnScrollView = (Button) findViewById(R.id.button_horizontal_scroll);
        btnColorActivity.setOnClickListener(this);
        btnTextpattern.setOnClickListener(this);
        btnViewPager.setOnClickListener(this);
        btnScrollView.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_horizontal_scroll:
                Intent intent=new Intent(MainActivity.this,HorizontalScrollActivity.class);
                startActivity(intent);
                break;
            case R.id.button_color:
                Intent intent2=new Intent(MainActivity.this,ColorButtonsActivity.class);
                startActivity(intent2);
                break;
            case R.id.button_view_pager:
                Intent intent3=new Intent(MainActivity.this,ViewPagerActivity.class);
                startActivity(intent3);
                break;
            case R.id.button_text_pattern:
                Intent intent4=new Intent(MainActivity.this,TextViewPatternActivity.class);
                startActivity(intent4);
                break;
        }
    }
}
