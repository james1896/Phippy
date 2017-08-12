package com.tiffany.phippy.food;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.tiffany.phippy.base.BaseFragment;
import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseModel;
import com.tiffany.phippy.base.JsonParse;
import com.tiffany.phippy.food.detail.FoodDetailActivity;
import com.tiffany.phippy.venv.RequestCallBack;
import com.tiffany.phippy.venv.RequestManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    ArrayList<FoodModel> dataArray;
    FoodListAdapter adapter;
    public FoodFragment() {
        // Required empty public constructor
    }

    //通过包名打开微信app
//    //参考文献
//    //http://blog.csdn.net/lovexieyuan520/article/details/44301753
//    try {
//        PackageManager packageManager = getPackageManager();
//        Intent intent=new Intent();
//        intent = packageManager.getLaunchIntentForPackage("com.tencent.mm");
//        startActivity(intent);
//    } catch (Exception e) {
//        e.printStackTrace();
//        Intent viewIntent = new
//                Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com/"));
//        startActivity(viewIntent);
//    }

    @Override
    public int getContentView() {
        return R.layout.fragment_food;
    }

    @Override
    protected void viewWillAppear() {
        super.viewWillAppear();

        //类型2 表示餐馆
        RequestManager.getInstant().getStore("2", new RequestCallBack() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                super.onSuccess(s, call, response);
                BaseModel<ArrayList<FoodModel>> model = JsonParse.parser.fromJson(s, new TypeToken<BaseModel<ArrayList<FoodModel>>>(){}.getType());

                dataArray = model.getData();
                adapter.setDataList(dataArray);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void init() {

        //------------------
        //        Picasso.with(this).load("http://img.my.csdn.net/uploads/201407/26/1406383243_5120.jpg").into(iv_picasso);
        //------------------


        if(dataArray == null){
            ArrayList<FoodModel> l = new ArrayList<>();
            l.add(new FoodModel());
            this.dataArray = l;
        }

        adapter = new FoodListAdapter(getContext(),this.dataArray);

        ListView listview = (ListView) contentView.findViewById(R.id.food_listview);
        LinearLayout mLoadingLayout = (LinearLayout) View.inflate(getContext(), R.layout.img_and_text_header, null);
        TextView headerText = (TextView) mLoadingLayout.findViewById(R.id.header_text);
        headerText.setText("猜你喜欢");
        listview.setOnItemClickListener(this);
        listview.addHeaderView(mLoadingLayout);
        listview.setAdapter(adapter);
        listview.setDividerHeight(0);


        ViewGroup upleft = (ViewGroup) mLoadingLayout.findViewById(R.id.upleft);
        ViewGroup upright = (ViewGroup) mLoadingLayout.findViewById(R.id.upright);
        ViewGroup downleft = (ViewGroup) mLoadingLayout.findViewById(R.id.downleft);
        ViewGroup downright = (ViewGroup) mLoadingLayout.findViewById(R.id.downright);

        upleft.setOnClickListener(this);
        upright.setOnClickListener(this);
        downleft.setOnClickListener(this);
        downright.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
//        Intent intent = new Intent(getActivity(),FoodRecActivity.class);
//        startActivity(intent);
        switch (view.getId()){
            case R.id.upleft:{


                final ProgressDialog dialog = new ProgressDialog(getActivity());

                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);// 设置进度条的形式为圆形转动的进度条
                dialog.setCancelable(true);// 设置是否可以通过点击Back键取消
                dialog.setCanceledOnTouchOutside(false);// 设置在点击Dialog外是否取消Dialog进度条
                // 设置提示的title的图标，默认是没有的，如果没有设置title的话只设置Icon是不会显示图标的
                dialog.setTitle("提示");
                // dismiss监听
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {

                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        // TODO Auto-generated method stub

                    }
                });
                // 监听Key事件被传递给dialog
                dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {

                    @Override
                    public boolean onKey(DialogInterface dialog, int keyCode,
                                         KeyEvent event) {
                        // TODO Auto-generated method stub
                        return false;
                    }
                });
                // 监听cancel事件
                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

                    @Override
                    public void onCancel(DialogInterface dialog) {
                        // TODO Auto-generated method stub

                    }
                });
                //设置可点击的按钮，最多有三个(默认情况下)
                dialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub

                            }
                        });
                dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub

                            }
                        });
//        dialog.setButton(DialogInterface.BUTTON_NEUTRAL, "中立",
//                new DialogInterface.OnClickListener() {
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        // TODO Auto-generated method stub
//
//                    }
//                });
                dialog.setMessage("这是一个圆形进度条");
                dialog.show();
                break;
            }

            case R.id.upright:{

                break;
            }

            case R.id.downleft:{
                break;
            }

            case R.id.downright:{
                break;
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getActivity(),FoodDetailActivity.class);
        if(i != 0){
            //去掉 headerview
            FoodModel model = this.dataArray.get(i-1);

//        imageview.setImageResource(R.mipmap.food_rec_header_img);
            intent.putExtra("com.tiffany.food.fooddetail.Resource",R.mipmap.food_rec_header_img);
            intent.putExtra("com.tiffany.food.fooddetail.title", model.getName());
            startActivity(intent);
        }


    }

    private ArrayList<Map> getDataList(){
        ArrayList<Map> list = new ArrayList<>();

        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("title","金手勺东北情餐厅");
//        map1.put("resId",R.drawable.me_list_zengsong);
        map1.put("deliveryTime","8:00 ~ 24:00");
        map1.put("qisongcondition","188P");
        map1.put("address","a街道b胡同");
        map1.put("contact","微信hhhhh33424");

        list.add(map1);

        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("title","金手勺东北情餐厅");
//        map1.put("resId",R.drawable.me_list_zengsong);
        map2.put("deliveryTime","8:00 ~ 24:00");
        map2.put("qisongcondition","188P");
        map2.put("address","a街道b胡同");
        map2.put("contact","微信hhhhh33424");
        list.add(map2);

        Map<String,Object> map3 = new HashMap<String,Object>();
        map3.put("title","金手勺东北情餐厅");
//        map1.put("resId",R.drawable.me_list_zengsong);
        map3.put("deliveryTime","8:00 ~ 24:00");
        map3.put("qisongcondition","188P");
        map3.put("address","a街道b胡同");
        map3.put("contact","微信hhhhh33424");
        list.add(map3);

        Map<String,Object> map4 = new HashMap<String,Object>();
        map4.put("title","金手勺东北情餐厅");
//        map1.put("resId",R.drawable.me_list_zengsong);
        map4.put("deliveryTime","8:00 ~ 24:00");
        map4.put("qisongcondition","188P");
        map4.put("address","a街道b胡同");
        map4.put("contact","微信hhhhh33424");
        list.add(map4);

        Map<String,Object> map5 = new HashMap<String,Object>();
        map5.put("title","金手勺东北情餐厅");
//        map1.put("resId",R.drawable.me_list_zengsong);
        map5.put("deliveryTime","8:00 ~ 24:00");
        map5.put("qisongcondition","188P");
        map5.put("address","a街道b胡同");
        map5.put("contact","微信hhhhh33424");
        list.add(map5);
        return list;

    }
}
