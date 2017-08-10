package com.tiffany.phippy.food.order;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseActivity;

/**
 * Created by moses on 10/08/2017.
 */

public class OrderFinishActivity extends BaseActivity {
    @Override
    protected int getContentView() {
        return R.layout.acitvity_order_finish;


    }

    @Override
    protected void init() {
        ImageView back = (ImageView)findViewById(R.id.toolbar_back_button);
        if(back != null){
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("BaseActivity","touch back button");
                    Intent intent = new Intent();
                    //把返回数据存入Intent
//                intent.putExtra("result", "My name is linjiqin");
                    //设置返回数据
                    OrderFinishActivity.this.setResult(103, intent);
                    //关闭Activity
                    OrderFinishActivity.this.finish();
                }
            });
        }
    }
}
