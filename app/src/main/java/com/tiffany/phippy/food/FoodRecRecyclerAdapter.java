package com.tiffany.phippy.food;

/**
 * Created by moses on 19/07/2017.
 */


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tiffany.phippy.R;

import java.util.List;

/**
 * RecyclerView适配器
 * 目前仅支持 添加以后个 header 和一个footer
 */
public class FoodRecRecyclerAdapter extends RecyclerView.Adapter<FoodRecRecyclerAdapter.ViewHolder> implements View.OnClickListener {

    private List<String> mDataList;

    public static final int PHI_SPAN_COUNT = 2; //列数
    public static final int TYPE_HEADER = 0;  //说明是带有Header的
    public static final int TYPE_FOOTER = 1;  //说明是带有Footer的
    public static final int TYPE_NORMAL = 2;  //说明是不带有header和footer的
    private View mHeaderView;
    private View mFooterView;

    private OnItemClickListener mOnItemClickListener = null;

    //HeaderView和FooterView的get和set函数
    public View getHeaderView() {
        return mHeaderView;
    }
    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
//        notifyItemInserted(0);
    }
    public View getFooterView() {
        return mFooterView;
    }
    public void setFooterView(View footerView) {
        mFooterView = footerView;
//        if(mHeaderView != null){
//            notifyItemInserted(getItemCount()+1);
//        }else {
//            notifyItemInserted(getItemCount());
//        }

    }

    /** 重写这个方法，很重要，是加入Header和Footer的关键，我们通过判断item的类型，从而绑定不同的view    * */
    @Override
    public int getItemViewType(int position) {
//        if (mHeaderView == null && mFooterView == null){
//            return TYPE_NORMAL;
//        }

        if (position == 0 && mHeaderView != null){
            //第一个item应该加载Header
            Log.e("getItemCount","1");
            return TYPE_HEADER;
        }
        if(position == getItemCount()-1 && mHeaderView == null && mFooterView != null){
            Log.e("getItemCount","2");
            return TYPE_FOOTER;
        }

        if(position == getItemCount()-1 && mHeaderView != null && mFooterView == null){
            Log.e("getItemCount","3");
            return TYPE_NORMAL;
        }

        if(position == getItemCount()-1 && mHeaderView != null && mFooterView != null){
            Log.e("getItemCount","4");
            return TYPE_FOOTER;
        }
        Log.e("getItemCount","5");
        return TYPE_NORMAL;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    //构造函数
    public FoodRecRecyclerAdapter(List<String> list) {
        mDataList = list;

    }

    public int getItemCount() {
        if(mHeaderView == null && mFooterView == null){
            return mDataList.size();
        }else if(mHeaderView == null && mFooterView != null){
            return mDataList.size() + 1;
        }else if (mHeaderView != null && mFooterView == null){
            return mDataList.size() + 1;
        }else {
//            Log.e("getItemCount",""+(mDataList.size() + 2));
            return mDataList.size() + 2;
        }
    }




    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        int pos = position;

        if(mHeaderView != null){
            pos = position-1;
        }


        if(getItemViewType(position) == TYPE_NORMAL){
            if(holder instanceof ViewHolder) {
                //这里加载数据的时候要注意，是从position-1开始，因为position==0已经被header占用了
                if(pos >= mDataList.size()){
                    return;
                }
                ((ViewHolder) holder).mTvTitle.setText(mDataList.get(pos));
                ((ViewHolder) holder).itemView.setTag(position);
                return;
            }
            return;
        }else if(getItemViewType(position) == TYPE_HEADER){
            return;
        }else{
            return;
        }
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(view,(int)view.getTag());
        }
    }

    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view , int position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(mHeaderView != null && viewType == TYPE_HEADER) {
            return new ViewHolder(mHeaderView);
        }
        if(mFooterView != null && viewType == TYPE_FOOTER){
            return new ViewHolder(mFooterView);
        }
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_detail_item, parent, false);
    layout.setOnClickListener(this);
        return new ViewHolder(layout);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvTitle = (TextView) itemView.findViewById(R.id.food_detail_item_textview);

        }


    }

}