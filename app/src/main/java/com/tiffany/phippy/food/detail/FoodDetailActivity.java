package com.tiffany.phippy.food.detail;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.baoyz.actionsheet.ActionSheet;
import com.google.gson.reflect.TypeToken;
import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseActivity;
import com.tiffany.phippy.base.BaseModel;
import com.tiffany.phippy.base.JsonParse;

import com.tiffany.phippy.food.FoodRecRecyclerAdapter;
import com.tiffany.phippy.food.order.OrderActivity;
import com.tiffany.phippy.venv.RequestCallBack;
import com.tiffany.phippy.venv.RequestManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

public class FoodDetailActivity extends BaseActivity implements ActionSheet.ActionSheetListener, FoodInterface, View.OnClickListener {

    private String[] chatStr = new String[]{"1", "2", "3", "4", "5", "6"};


    private String[] localCartoonText = {"名侦探柯南", "死亡笔记", "火影忍者", "海贼王"};
    private String[] imgURL ={"http://img1.imgtn.bdimg.com/it/u=3350993068,3652800343&fm=21&gp=0.jpg", "http://img0.imgtn.bdimg.com/it/u=2545030489,2226096219&fm=21&gp=0.jpg", "http://img3.imgtn.bdimg.com/it/u=3171772449,1023293196&fm=21&gp=0.jpg", "http://img0.imgtn.bdimg.com/it/u=820734872,552500686&fm=21&gp=0.jpg"};
    private FoodDetailListAdapter detailAdapter;


    @Override
    protected int getContentView() {
        return R.layout.activity_food_detail;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
//        intent.putExtra("com.tiffany.food.fooddetail.Resource",R.mipmap.food_rec_header_img);


        String title = intent.getStringExtra("com.tiffany.food.fooddetail.title");
        int resourceId = intent.getIntExtra("com.tiffany.food.fooddetail.Resource", 0);
        Log.e("food", ""+title);

//        LinearLayout mLoadingLayout = (LinearLayout) View.inflate(this, R.layout.tour_or_food_rec_header, null);
//        TextView textView = (TextView) mLoadingLayout.findViewById(R.id.tf_rec_header_title);
//        textView.setText(title);
//        ImageView img = (ImageView) mLoadingLayout.findViewById(R.id.tf_rec_header_groundimage);
//        img.setImageResource(resourceId);

        ListView listview = (ListView) findViewById(R.id.food_detai_listView);
        this.detailAdapter = new FoodDetailListAdapter(this,getDataList());
        detailAdapter.setFoodInterface(this);

        listview.setAdapter(detailAdapter);

        setToolbarTitle(title);
        TextView right = (TextView) findViewById(R.id.toolbar_right_button);
        right.setText("提交订单");
        right.setTextSize(15);
        right.setOnClickListener(this);



    }


    @Override
    public void onDismiss(ActionSheet actionSheet, boolean isCancel) {

    }

    @Override
    public void onOtherButtonClick(ActionSheet actionSheet, int index) {
        Log.e("onOtherButtonClick",""+index);

        if(index == 1) {
            //打开微信
            //参考文献
//                http://blog.csdn.net/lovexieyuan520/article/details/44301753
            try {
                PackageManager packageManager = getPackageManager();
                Intent intent = new Intent();
                intent = packageManager.getLaunchIntentForPackage("com.tencent.mm");
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                Intent viewIntent = new
                        Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com/"));
                startActivity(viewIntent);
            }
        }else if (index == 2){

            //打电话

            if (ActivityCompat.checkSelfPermission(FoodDetailActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            Uri uri = Uri.parse("tel:" + 123);
            Intent intent = new Intent(Intent.ACTION_CALL, uri);
            startActivity(intent);
        }
    }

    @Override
    public void foodMenuSelectedAt(int section, int row) {
        Log.e("food","section:"+section+"row:"+row);
    }

    public ArrayList<Map> getDataList(){
        ArrayList<Map> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("title","第一季");

        ArrayList<GridItem> mGridData = new ArrayList<GridItem>();
        for (int i=0; i<40; i++) {
            GridItem item1 = new GridItem();
            item1.setTitle(localCartoonText[i%4]);
            item1.setImage(imgURL[i%4]);
            item1.setCheck(false);
            item1.setPrice(50+i*4);
            item1.setCount(1);
            mGridData.add(item1);
        }
        map1.put("data",mGridData);
        list.add(map1);

        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("title","第二季");
        ArrayList<GridItem> mGridData2 = new ArrayList<GridItem>();
        for (int i=0; i<40; i++) {
            GridItem item1 = new GridItem();
            item1.setTitle(localCartoonText[i%4]);
            item1.setImage(imgURL[i%4]);
            item1.setCheck(false);
            item1.setPrice(50+i*4);
            item1.setCount(1);
            mGridData2.add(item1);
        }
        map2.put("data",mGridData2);
        list.add(map2);

        Map<String,Object> map3 = new HashMap<String,Object>();
        map3.put("title","第三季");
        ArrayList<GridItem> mGridData3 = new ArrayList<GridItem>();
        for (int i=0; i<40; i++) {
            GridItem item1 = new GridItem();
            item1.setTitle(localCartoonText[i%4]);
            item1.setImage(imgURL[i%4]);
            item1.setCheck(false);
            item1.setPrice(50+i*4);
            item1.setCount(1);
            mGridData3.add(item1);
        }
        map3.put("data",mGridData3);
        list.add(map3);

        return list;

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.toolbar_right_button){

            ArrayList<Map> list = this.detailAdapter.getDataList();

            ArrayList<GridItem>  data = new ArrayList<>();

            for(Map<String,Object> map :list){
                ArrayList<GridItem> tmpList = (ArrayList<GridItem>) map.get("data");

                for(GridItem item:tmpList){
                    if(item.getCheck()){
                        data.add(item);
                    }
                }
            }


            Intent intent = new Intent(FoodDetailActivity.this, OrderActivity.class);
            intent.putExtra("GridItem", (Serializable) data);
            startActivity(intent);
        }
    }
}




//          2017.7.26
//
//    RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.food_detail_RecyclerView);
//    //设置线性管理器
////        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//    //设置表格管理器
//
//
//    GridLayoutManager gridLayoutManager = new GridLayoutManager(this, FoodRecRecyclerAdapter.PHI_SPAN_COUNT);
//        mRecyclerView.setLayoutManager(gridLayoutManager);
//                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//@Override
//public int getSpanSize(int position) {
//        if (position == 0) {
//        return FoodRecRecyclerAdapter.PHI_SPAN_COUNT;
//        } else if (position == 11) {
//        return FoodRecRecyclerAdapter.PHI_SPAN_COUNT;
//        } else {
//        return 1;
//        }
//        }
//        });
//
//
//        List<String> mDataList = new ArrayList<String>();
//        for (int i = 0; i < 10; i++) {
//        mDataList.add("内容 - " + i);
//        }
//        /*
//        设置适配器
//         */
//        FoodRecRecyclerAdapter adapter = new FoodRecRecyclerAdapter(mDataList);
//        View header = LayoutInflater.from(this).inflate(R.layout.recyclerview_header_footer, mRecyclerView, false);
//        adapter.setHeaderView(header);
//
//        View footer = LayoutInflater.from(this).inflate(R.layout.recycler_footer, mRecyclerView, false);
//        adapter.setFooterView(footer);
//
//        mRecyclerView.setAdapter(adapter);
//
//        adapter.setOnItemClickListener(new FoodRecRecyclerAdapter.OnItemClickListener() {
//@Override
//public void onItemClick(View view, int position) {
//        Log.e("onItem", "" + position);
//        }
//        });










//new View.OnClickListener() {
//@Override
//public void onClick(View view) {
//////                Window window = myDialog.getWindow();
////                new AlertDialog.Builder(FoodDetailActivity.this)
////                        .setMessage("退出当前账号不会删除任何历史数据，下次登录依然可以使用本账号")
////                        .setPositiveButton("微信", new DialogInterface.OnClickListener() {
////                            @Override
////                            public void onClick(DialogInterface dialog, int which) {
//////                                              //参考文献
//////                http://blog.csdn.net/lovexieyuan520/article/details/44301753
////                                try {
////                                    PackageManager packageManager = getPackageManager();
////                                    Intent intent = new Intent();
////                                    intent = packageManager.getLaunchIntentForPackage("com.tencent.mm");
////                                    startActivity(intent);
////                                } catch (Exception e) {
////                                    e.printStackTrace();
////                                    Intent viewIntent = new
////                                            Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com/"));
////                                    startActivity(viewIntent);
////                                }
////                            }
////                        }).setNegativeButton("电话", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialog, int which) {
////
////                        if (ActivityCompat.checkSelfPermission(FoodDetailActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
////                            // TODO: Consider calling
////                            //    ActivityCompat#requestPermissions
////                            // here to request the missing permissions, and then overriding
////                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
////                            //                                          int[] grantResults)
////                            // to handle the case where the user grants the permission. See the documentation
////                            // for ActivityCompat#requestPermissions for more details.
////                            return;
////                        }
////                        Uri uri = Uri.parse("tel:" + 123);
////                        Intent intent = new Intent(Intent.ACTION_CALL, uri);
////                        startActivity(intent);
////                    }
////                }).setNegativeButton("短信", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialogInterface, int i) {
////
//////                        Intent intentFinalMessage = new Intent(Intent.ACTION_VIEW);
//////                        intentFinalMessage.setType("vnd.android-dir/mms-sms");
////////                        打开系统短信界面
//////                        startActivity(intentFinalMessage);
//////                        创建Uri，设置行为和号码
////                        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+"123"));
//////                        创建意图
////                        intent.putExtra("sms_body", "aaa");
//////                        打开系统短信界面，号码已经填写，只需填写要发送
////                        startActivity(intent);
////                    }
////                }).show();
//
//
//        ActionSheet.createBuilder(FoodDetailActivity.this, getSupportFragmentManager())
//        .setCancelButtonTitle("Cancel")
//        .setOtherButtonTitles("订单系统正在跟商家协调，内部测试中，敬请期待哦，亲", "Item2", "Item3", "Item4")
//        .setCancelableOnTouchOutside(true)
//        .setListener(FoodDetailActivity.this).show();
//
//
//        }
//        });
//
//
//
////        RequestManager.getInstant().getgoods("1001", new RequestCallBack() {
////            @Override
////            public void onSuccess(String s, Call call, Response response) {
////                super.onSuccess(s, call, response);
////
////                BaseModel<List<FoodDetailModel>> model = JsonParse.parser.fromJson(s, new TypeToken<BaseModel<List<FoodDetailModel>>>(){}.getType());
////
////                Log.e("FoodModel",""+model);
////            }
////        }