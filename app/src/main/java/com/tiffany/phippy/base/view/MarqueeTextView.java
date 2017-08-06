package com.tiffany.phippy.base.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by moses on 06/08/2017.
 */

@SuppressLint("AppCompatCustomView")
public class MarqueeTextView extends TextView {

//    可以实现 滚动和暂停
//     if (mMarqueeTextView.getEllipsize() != null) {
//        mMarqueeTextView.setEllipsize(null);
//    } else {
//        mMarqueeTextView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
//    }



//    xml布局
//      <com.tiffany.textviewtest.MarqueeTextView
//    android:id="@+id/tv_marquee"
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:text="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
//    android:singleLine="true"
//    android:ellipsize="marquee"
//    android:marqueeRepeatLimit="marquee_forever" />>

    public MarqueeTextView(Context context) {
        super(context);
    }

    public MarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MarqueeTextView(Context context, AttributeSet attrs, int

            defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}