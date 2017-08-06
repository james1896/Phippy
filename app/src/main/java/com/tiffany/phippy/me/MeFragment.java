package com.tiffany.phippy.me;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.tiffany.phippy.base.BaseFragment;
import com.tiffany.phippy.R;
import com.tiffany.phippy.base.LoginActivity;
import com.tiffany.phippy.base.ShowAddressActivity;
import com.tiffany.phippy.base.db.DBDebugActivity;
import com.tiffany.phippy.me.order.OrderActivity;

/**
 * Created by moses on 09/06/2017.
 */

public class MeFragment extends BaseFragment {

    @Override
    public int getContentView() {
        return R.layout.fragment_me;
    }


    @Override
    public void init() {
        ListView listview = (ListView) contentView.findViewById(R.id.me_listview);

        LinearLayout mLoadingLayout = (LinearLayout) View.inflate(getContext(), R.layout.me_header, null);

//        跑马灯
        TextView tv = (TextView) mLoadingLayout.findViewById(R.id.tv_marquee);
        tv.setText("123 如果个韩国 如果个韩国 i 恶化个啊个啊 啊份萨嘎 萨嘎 人个如果个韩国 i 恶化个啊个啊 啊份萨嘎 萨嘎 人个如果个韩国 i 恶化个啊个啊 啊份萨嘎 萨嘎 人个i 恶化个啊个啊 啊份萨嘎 萨嘎 人个");
        tv.setVisibility(View.VISIBLE);


//      登录
        mLoadingLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
//        TextView headerText = (TextView) mLoadingLayout.findViewById(R.id.header_text);
//        headerText.setText("猜你喜欢");
        listview.addHeaderView(mLoadingLayout);
        listview.setAdapter(new MeListAdapter(getContext(),null));
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){

                    case 1:{
                        //常用设置
                        Intent intent = new Intent(getActivity(),OrderActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 3:{
                        //常用设置
                        Intent intent = new Intent(getActivity(),SettingActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 8:{
//                        DB 调试
                        Intent intent = new Intent(getActivity(),DBDebugActivity.class);
                        startActivity(intent);
                        break;
                    }
                    default:
                        Log.e("点击",""+i);
                        Intent intent = new Intent(getActivity(), ShowAddressActivity.class);
                        startActivity(intent);
                }


            }
        });
    }
}
