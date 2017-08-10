package com.tiffany.phippy.food.order;

import android.support.design.widget.BottomSheetDialog;

/**
 * Created by moses on 09/08/2017.
 */

public interface OrderInterface {

    public void bottomSheetConfirm(BottomSheetDialog dialog,int position);
    public void bottomSheetCancel(BottomSheetDialog dialog);

    public void orderDetailOnItemLongClick(int position);
    public void plusButtonClickOn(int position);
    public void subButtonClickOn(int position);
}
