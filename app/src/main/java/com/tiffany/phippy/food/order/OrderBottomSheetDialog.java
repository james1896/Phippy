package com.tiffany.phippy.food.order;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;
import android.widget.TextView;

import com.tiffany.phippy.R;

/**
 * Created by moses on 10/08/2017.
 */

public class OrderBottomSheetDialog extends BottomSheetDialog {


    public int longClickOnPosition;
    public TextView contentTextView;
    public TextView confirmTextView;
    public TextView cancelTextView;

    public OrderInterface getOrderInterface() {
        return orderInterface;
    }

    public void setOrderInterface(final OrderInterface orderInterface) {
        this.orderInterface = orderInterface;

        this.confirmTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(orderInterface != null){
                    orderInterface.bottomSheetConfirm(OrderBottomSheetDialog.this,longClickOnPosition);
                }
            }
        });

        this.cancelTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(orderInterface != null){
                    orderInterface.bottomSheetCancel(OrderBottomSheetDialog.this);
                }
            }
        });
    }

    private OrderInterface orderInterface;
    public OrderBottomSheetDialog(@NonNull Context context) {
        super(context);
        this.longClickOnPosition = -1;



    }

//    public OrderBottomSheetDialog(Context context, @LayoutRes int layoutResId) {
//        super(context);
//
//        this.longClickOnPosition = -1;
//        this.contentTextView = (TextView) findViewById(R.id.order_dialog_content);
//        this.confirmTextView = (TextView) findViewById(R.id.order_dialog_confirm);
//        this.cancelTextView = (TextView) findViewById(R.id.order_dialog_cancel);
//    }


    public OrderBottomSheetDialog(@NonNull Context context, @StyleRes int theme) {
        super(context, theme);
        this.longClickOnPosition = -1;
    }

    protected OrderBottomSheetDialog(@NonNull Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.longClickOnPosition = -1;
    }
}
