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

import com.tiffany.phippy.BaseFragment;
import com.tiffany.phippy.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TourFragment extends BaseFragment {


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
    public void init() {
        ListView listview = (ListView) contentView.findViewById(R.id.tour_listview);

        LinearLayout mLoadingLayout = (LinearLayout) View.inflate(getContext(), R.layout.tour_or_food_header, null);
        listview.addHeaderView(mLoadingLayout);
        listview.setAdapter(new TourListAdapter(getContext(),null));
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(),TourRecActivity.class);
                intent.putExtra("com.tiffany.tour", i);
                startActivity(intent);
            }
        });

        TextView headerText = (TextView) mLoadingLayout.findViewById(R.id.header_text);
        headerText.setText("推荐攻略");



        ViewGroup upleft = (ViewGroup) mLoadingLayout.findViewById(R.id.upleft);
        ViewGroup upright = (ViewGroup) mLoadingLayout.findViewById(R.id.upright);
        ViewGroup downleft = (ViewGroup) mLoadingLayout.findViewById(R.id.downleft);
        ViewGroup downright = (ViewGroup) mLoadingLayout.findViewById(R.id.downright);

        upleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("tour","1");
            }
        });
        upright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("tour","2");
            }
        });
        downleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("tour","3");
            }
        });
        downright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("tour","4");
            }
        });

    }
}
