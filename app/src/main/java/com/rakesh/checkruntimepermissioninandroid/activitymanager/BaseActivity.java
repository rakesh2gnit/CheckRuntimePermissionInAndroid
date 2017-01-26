package com.rakesh.checkruntimepermissioninandroid.activitymanager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.rakesh.checkruntimepermissioninandroid.R;

/**
 * Created by Admin on 26-01-2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Toolbar toolbar;
    protected TextView toolbar_title;
    public ProgressDialog mProgressDialog;

    protected abstract int getLayoutResId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitNetwork().build();
        StrictMode.setThreadPolicy(policy);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar_title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        /*toolbar_menu = (TextView) toolbar.findViewById(R.id.toolbar_menu);
        toolbar_subtitle = (TextView) toolbar.findViewById(R.id.toolbar_subtitle);
        toolbar_search = (EditText) toolbar.findViewById(R.id.toolbar_search);
        toolbar_iv_search = (ImageView) toolbar.findViewById(R.id.toolbar_iv_search);*/
        /*toolbar_title.setTypeface(FontManager.getOpenSansLightFont(this));
        toolbar_subtitle.setTypeface(FontManager.getOpenSansLightFont(this));
        toolbar_menu.setTypeface(FontManager.getOpenSansSemiBoldFont(this));*/
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //toolbar.setNavigationIcon(R.drawable.ic_action_navigation_arrow_back);
        //toolbar.setTitle(getTitle());

        /*toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                onBackPressed();
            }
        });*/
    }
}
