package com.tiffany.phippy.tour;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import com.tiffany.phippy.food.FoodDetailModel;
import com.tiffany.phippy.venv.RequestCallBack;
import com.tiffany.phippy.venv.RequestManager;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class TourFragment extends BaseFragment implements View.OnClickListener {


    public TourFragment() {
        // Required empty public constructor
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_tour, container, false);
//    }

    @Override
    public int getContentView() {
        return R.layout.fragment_tour;
    }

    @Override
    protected void viewWillAppear() {
        super.viewWillAppear();

        RequestManager.getInstant().getarticle("", new RequestCallBack() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                super.onSuccess(s, call, response);
                BaseModel<List<TourModel>> model = JsonParse.parser.fromJson(s, new TypeToken<BaseModel<List<TourModel>>>(){}.getType());

                Log.e("FoodModel",""+model);
            }
        });
    }

    @Override
    public void init() {
        ListView listview = (ListView) contentView.findViewById(R.id.tour_listview);

        LinearLayout mLoadingLayout = (LinearLayout) View.inflate(getContext(), R.layout.img_and_text_header, null);
        listview.addHeaderView(mLoadingLayout);
        listview.setAdapter(new TourListAdapter(getContext(),null));
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(getActivity(),TourRecActivity.class);
//                intent.putExtra("com.tiffany.tour", i);
//                startActivity(intent);
            }
        });

        TextView headerText = (TextView) mLoadingLayout.findViewById(R.id.header_text);
        headerText.setText("推荐攻略");



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
        Intent intent = new Intent(getActivity(),TourRecActivity.class);
        startActivity(intent);
    }
}
