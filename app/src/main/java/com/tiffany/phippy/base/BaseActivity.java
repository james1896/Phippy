package com.tiffany.phippy.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.tiffany.phippy.R;

import org.w3c.dom.Text;

/**
 * Created by moses on 17/06/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    View toolbar;
    protected String toolbarTitle;
    private TextView toolbarTilteTV;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        //toolbar
        toolbar = (View) findViewById(R.id.toobar_back);


        //-----------------------------------
        //如果toolbar上有返回按钮 设置返回点击事件
        //-----------------------------------
        ImageView back = (ImageView)findViewById(R.id.toolbar_back_button);
        if(back != null){
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("BaseActivity","touch back button");
                    finish();
                }
            });
        }

        //-----------------------------------
        //如果toolbar上有title textview
        //-----------------------------------
        this.toolbarTilteTV = (TextView) findViewById(R.id.toolbar_back_title);

        init();
    }

    public String getToolbarTitle() {
        return toolbarTitle;
    }

    public void setToolbarTitle(String toolbarTitle) {

        Log.e("setting11","1");
        if(this.toolbarTilteTV != null && toolbarTitle != null){
            Log.e("setting11","2");
            this.toolbarTilteTV.setText(toolbarTitle);

            this.toolbarTitle = toolbarTitle;
        }

    }

    protected abstract int getContentView();
    /**
     * 初始化操作
     */
    protected abstract void init();
}
