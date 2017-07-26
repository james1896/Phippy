package com.tiffany.phippy.food.detail;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseListAdapter1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by moses on 27/06/2017.
 */

public class FoodDetailListAdapter extends BaseListAdapter1 {


    private String[] localCartoonText = {"名侦探柯南", "死亡笔记", "火影忍者", "海贼王"};
    private String[] imgURL ={"http://img1.imgtn.bdimg.com/it/u=3350993068,3652800343&fm=21&gp=0.jpg", "http://img0.imgtn.bdimg.com/it/u=2545030489,2226096219&fm=21&gp=0.jpg", "http://img3.imgtn.bdimg.com/it/u=3171772449,1023293196&fm=21&gp=0.jpg", "http://img0.imgtn.bdimg.com/it/u=820734872,552500686&fm=21&gp=0.jpg"};
//    private GridView mGridView = null;
//    private GridViewAdapter mGridViewAdapter = null;

   //------------------------------------------------------------


    Context context;
//    protected ArrayList<Map> dataList;

    public FoodDetailListAdapter(Context context, ArrayList<Map> list) {
        super(context,list);
//        //根据context上下文加载布局，这里的是 本身，即this
//        this.mInflater = LayoutInflater.from(context);
        this.dataList = getDataList();
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Map<String,Object> map = this.dataList.get(position);
//
        View item = mInflater.inflate(R.layout.food_detail_listview_item, null);
        TextView titleTV = (TextView)item.findViewById(R.id.header);
        NoScrollGridView gridView = (NoScrollGridView) item.findViewById(R.id.gridview);
//

        String titleStr = (String) map.get("title");
        titleTV.setText(titleStr);
//        String addressStr = (String) map.get("add");
//        String current_priceStr = (String) map.get("current_price");
//        String original_priceStr = (String) map.get("original_price");
//        String hotStr = (String) map.get("hot");


        ArrayList<GridItem> mGridData = new ArrayList<GridItem>();
        for (int i=0; i<imgURL.length; i++) {
            GridItem item1 = new GridItem();
            item1.setTitle(localCartoonText[i]);
            item1.setImage(imgURL[i]);
            mGridData.add(item1);

            Log.e("position"+position,localCartoonText[i]);
        }
        GridViewAdapter mGridViewAdapter = new GridViewAdapter(context, R.layout.food_detail_listview_gridview_item, mGridData);
        mGridViewAdapter.itemNumber = position;
        gridView.setAdapter(mGridViewAdapter);
        return item;
    }

    public ArrayList<Map> getDataList(){
        ArrayList<Map> list = new ArrayList<>();

        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("title","第一季");
//        map1.put("resId",R.drawable.me_list_zengsong);
//        map1.put("add","海鲜大咖套餐1份，有赠品");
//        map1.put("current_price","188");
//        map1.put("original_price","门市价:¥288");
//        map1.put("hot","热度5");
        list.add(map1);

        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("title","第二季");
//        map2.put("add","10元代金券1张，可叠加");
//        map2.put("current_price","8.5");
//        map2.put("original_price","门市价:¥10");
//        map2.put("hot","热度5");
        list.add(map2);

        Map<String,Object> map3 = new HashMap<String,Object>();
        map3.put("title","第三季");
//        map3.put("add","精品烤鸭5-6人餐1份");
//        map3.put("current_price","588");
//        map3.put("original_price","门市价:¥736");
//        map3.put("hot","热度5");
        list.add(map3);

        Map<String,Object> map4 = new HashMap<String,Object>();
        map4.put("title","第四季");
//        map4.put("add","海盗船1份，免费包间");
//        map4.put("current_price","98");
//        map4.put("original_price","门市价:¥168");
//        map4.put("hot","热度5");
        list.add(map4);



        return list;

    }
}
