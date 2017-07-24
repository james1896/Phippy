package com.tiffany.phippy.food;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.tiffany.phippy.base.BaseFragment;
import com.tiffany.phippy.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    ArrayList<Map> dataArray;
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

        Log.e("foodFragment","init");
    }

    @Override
    public void init() {

        this.dataArray = getDataList();
        ListView listview = (ListView) contentView.findViewById(R.id.food_listview);

        LinearLayout mLoadingLayout = (LinearLayout) View.inflate(getContext(), R.layout.img_and_text_header, null);

        TextView headerText = (TextView) mLoadingLayout.findViewById(R.id.header_text);
        headerText.setText("猜你喜欢");
        listview.setOnItemClickListener(this);
        listview.addHeaderView(mLoadingLayout);
        listview.setAdapter(new FoodListAdapter(getContext(),this.dataArray));


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
        Intent intent = new Intent(getActivity(),FoodRecActivity.class);
        startActivity(intent);
        switch (view.getId()){
            case R.id.upleft:{

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
            Map map = this.dataArray.get(i-1);

//        imageview.setImageResource(R.mipmap.food_rec_header_img);
            intent.putExtra("com.tiffany.food.fooddetail.Resource",R.mipmap.food_rec_header_img);
            intent.putExtra("com.tiffany.food.fooddetail.title", (String) map.get("title"));
            startActivity(intent);
        }


    }

    private ArrayList<Map> getDataList(){
        ArrayList<Map> list = new ArrayList<>();

//        Map<String,Object> map1 = new HashMap<String,Object>();
//        map1.put("title","金手勺东北情餐厅");
////        map1.put("resId",R.drawable.me_list_zengsong);
//        map1.put("add","海鲜大咖套餐1份，有赠品");
//        map1.put("current_price","188");
//        map1.put("original_price","门市价:¥288");
//        map1.put("hot","热度5");
//        list.add(map1);
//
//        Map<String,Object> map2 = new HashMap<String,Object>();
//        map2.put("title","奶茶嫁给粉");
//        map2.put("add","10元代金券1张，可叠加");
//        map2.put("current_price","8.5");
//        map2.put("original_price","门市价:¥10");
//        map2.put("hot","热度5");
//        list.add(map2);
//
//        Map<String,Object> map3 = new HashMap<String,Object>();
//        map3.put("title","全聚德");
//        map3.put("add","精品烤鸭5-6人餐1份");
//        map3.put("current_price","588");
//        map3.put("original_price","门市价:¥736");
//        map3.put("hot","热度5");
//        list.add(map3);
//
//        Map<String,Object> map4 = new HashMap<String,Object>();
//        map4.put("title","后海老炮儿");
//        map4.put("add","海盗船1份，免费包间");
//        map4.put("current_price","98");
//        map4.put("original_price","门市价:¥168");
//        map4.put("hot","热度5");
//        list.add(map4);
//
//        Map<String,Object> map5 = new HashMap<String,Object>();
//        map5.put("title","海鲜大咖");
//        map5.put("add","海货4-6人餐1份");
//        map5.put("current_price","588");
//        map5.put("original_price","门市价:¥888");
//        map5.put("hot","热度5");
//        list.add(map5);


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
