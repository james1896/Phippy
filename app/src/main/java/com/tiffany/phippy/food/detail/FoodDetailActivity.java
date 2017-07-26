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

import com.google.gson.reflect.TypeToken;
import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseActivity;
import com.tiffany.phippy.base.BaseModel;
import com.tiffany.phippy.base.JsonParse;
import com.tiffany.phippy.base.actionSheet.AndroidActionSheetFragment;
import com.tiffany.phippy.food.FoodRecRecyclerAdapter;
import com.tiffany.phippy.venv.RequestCallBack;
import com.tiffany.phippy.venv.RequestManager;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class FoodDetailActivity extends BaseActivity {

    private String[] chatStr = new String[]{"1", "2", "3", "4", "5", "6"};
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
        Log.e("food", title);

//        LinearLayout mLoadingLayout = (LinearLayout) View.inflate(this, R.layout.tour_or_food_rec_header, null);
//        TextView textView = (TextView) mLoadingLayout.findViewById(R.id.tf_rec_header_title);
//        textView.setText(title);
//        ImageView img = (ImageView) mLoadingLayout.findViewById(R.id.tf_rec_header_groundimage);
//        img.setImageResource(resourceId);

        ListView listview = (ListView) findViewById(R.id.food_detai_listView);
        listview.setAdapter(new FoodDetailListAdapter(this,null));

        setToolbarTitle(title);
        TextView right = (TextView) findViewById(R.id.toolbar_right_button);
        right.setText("联系商家");
        right.setTextSize(15);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
////                Window window = myDialog.getWindow();
//                new AlertDialog.Builder(FoodDetailActivity.this)
//                        .setMessage("退出当前账号不会删除任何历史数据，下次登录依然可以使用本账号")
//                        .setPositiveButton("微信", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
////                                              //参考文献
////                http://blog.csdn.net/lovexieyuan520/article/details/44301753
//                                try {
//                                    PackageManager packageManager = getPackageManager();
//                                    Intent intent = new Intent();
//                                    intent = packageManager.getLaunchIntentForPackage("com.tencent.mm");
//                                    startActivity(intent);
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                    Intent viewIntent = new
//                                            Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com/"));
//                                    startActivity(viewIntent);
//                                }
//                            }
//                        }).setNegativeButton("电话", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        if (ActivityCompat.checkSelfPermission(FoodDetailActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                            // TODO: Consider calling
//                            //    ActivityCompat#requestPermissions
//                            // here to request the missing permissions, and then overriding
//                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                            //                                          int[] grantResults)
//                            // to handle the case where the user grants the permission. See the documentation
//                            // for ActivityCompat#requestPermissions for more details.
//                            return;
//                        }
//                        Uri uri = Uri.parse("tel:" + 123);
//                        Intent intent = new Intent(Intent.ACTION_CALL, uri);
//                        startActivity(intent);
//                    }
//                }).setNegativeButton("短信", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
////                        Intent intentFinalMessage = new Intent(Intent.ACTION_VIEW);
////                        intentFinalMessage.setType("vnd.android-dir/mms-sms");
//////                        打开系统短信界面
////                        startActivity(intentFinalMessage);
////                        创建Uri，设置行为和号码
//                        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+"123"));
////                        创建意图
//                        intent.putExtra("sms_body", "aaa");
////                        打开系统短信界面，号码已经填写，只需填写要发送
//                        startActivity(intent);
//                    }
//                }).show();


                AndroidActionSheetFragment.build(getSupportFragmentManager()).setChoice(AndroidActionSheetFragment.Builder.CHOICE.ITEM).setTitle("标题").setTag("MainActivity")
                        .setItems(chatStr).setOnItemClickListener(new AndroidActionSheetFragment.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Log.e("actionSheet",""+chatStr[position]);
                    }
                }).show();
            }
        });


        RequestManager.getInstant().getgoods("1001", new RequestCallBack() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                super.onSuccess(s, call, response);

                BaseModel<List<FoodDetailModel>> model = JsonParse.parser.fromJson(s, new TypeToken<BaseModel<List<FoodDetailModel>>>(){}.getType());

                Log.e("FoodModel",""+model);
            }
        });

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