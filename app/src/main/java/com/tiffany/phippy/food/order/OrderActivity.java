package com.tiffany.phippy.food.order;

import android.content.Intent;
import android.support.design.widget.BottomSheetDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseActivity;
import com.tiffany.phippy.food.detail.GridItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by moses on 07/08/2017.
 */

public class OrderActivity extends BaseActivity implements OrderInterface {
    @Override
    protected int getContentView() {
        return R.layout.activity_food_order;
    }

    protected OrderListAdapter orderAdapter;
    protected ArrayList<GridItem> dataArray;
    protected OrderBottomSheetDialog sheetDialog;
    @Override
    protected void init() {
        setToolbarTitle("订单详情");

//        得到上个activity传过来的 list
        Intent intentGet = getIntent();
        this.dataArray = (ArrayList<GridItem>) intentGet.getSerializableExtra("GridItem");
        Log.e("data",""+this.dataArray);

//        listview
        ListView lv = (ListView) findViewById(R.id.food_order_listview);
        if(this.dataArray != null){
            ArrayList arr = new ArrayList();
            arr.add(this.dataArray);

            this.orderAdapter = new OrderListAdapter(this,arr);
            this.orderAdapter.setOrderInterface(this);
            lv.setAdapter(this.orderAdapter);
        }

        //bottom弹出 sheet
        LinearLayout dialogView = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.food_order_bottomdialog_sheet,null);
        this.sheetDialog = new OrderBottomSheetDialog(this);
        this.sheetDialog.setContentView(dialogView);

        this.sheetDialog.contentTextView = (TextView) dialogView.findViewById(R.id.order_dialog_content);
        this.sheetDialog.confirmTextView = (TextView) dialogView.findViewById(R.id.order_dialog_confirm);
        this.sheetDialog.cancelTextView = (TextView) dialogView.findViewById(R.id.order_dialog_cancel);
//        必须放在最后面 等 各个控件初始化完成才可以  这应该是个缺陷 后期改进
        this.sheetDialog.setOrderInterface(this);

        //货到付款
        Button btn = (Button) findViewById(R.id.food_order_huodaofukuan);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderActivity.this,OrderFinishActivity.class);
                startActivityForResult(intent,103);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == 103){
            Log.e("A onActivityResult",""+resultCode);
            finish();
        }
    }

    //    订单详情 interface
    @Override
    public void bottomSheetConfirm(BottomSheetDialog dialog, int position) {

        this.dataArray.remove(position);
        ArrayList arr = new ArrayList();
        arr.add(this.dataArray);
        this.orderAdapter.setDataList(arr);
        this.orderAdapter.notifyDataSetChanged();
        dialog.cancel();
    }

    @Override
    public void bottomSheetCancel(BottomSheetDialog dialog) {
        dialog.cancel();
    }


    @Override
    public void orderDetailOnItemLongClick(int position) {
        Log.e("",""+position);

        if(this.dataArray.size() == 1){
            Toast.makeText(this,"亲，当前订单只剩下一个餐品了，别删了好不？",Toast.LENGTH_SHORT).show();
            return;
        }
        GridItem item  = this.dataArray.get(position);
        this.sheetDialog.longClickOnPosition = position;
        this.sheetDialog.contentTextView.setText("确认要删除 "+item.getTitle()+" 吗？");
        this.sheetDialog.show();
    }

    @Override
    public void plusButtonClickOn(int position) {
        Log.e("order","plus"+position);

        GridItem item = this.dataArray.get(position);
        item.setCount(item.getCount()+1);

        ArrayList arr = new ArrayList();
        arr.add(this.dataArray);
        this.orderAdapter.setDataList(arr);
        this.orderAdapter.notifyDataSetChanged();
    }

    @Override
    public void subButtonClickOn(int position) {
        Log.e("order","sub"+position);

        GridItem item = this.dataArray.get(position);

        if(item.getCount() >1){
            item.setCount(item.getCount()-1);
            ArrayList arr = new ArrayList();
            arr.add(this.dataArray);
            this.orderAdapter.setDataList(arr);
            this.orderAdapter.notifyDataSetChanged();
        }else {
            Log.e("order","最小值是 1");
        }

    }
}
