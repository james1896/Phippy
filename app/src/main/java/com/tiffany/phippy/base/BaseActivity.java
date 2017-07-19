package com.tiffany.phippy.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.tiffany.phippy.R;

/**
 * Created by moses on 17/06/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    View toolbar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        //toolbar
        toolbar = (View) findViewById(R.id.toobar_back);
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
    init();

    }

    protected abstract int getContentView();
    /**
     * 初始化操作
     */
    protected abstract void init();
}
