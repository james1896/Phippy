package com.tiffany.phippy.me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tiffany.phippy.R;

/**
 * Created by moses on 09/06/2017.
 */

public class MeFragment extends Fragment {
    protected View contentView;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        contentView = inflater.inflate(R.layout.me_fragment, container, false);

//        ListView listView = (ListView) contentView.findViewById(R.id.me_listView);
//        listView.setAdapter(new MedicineListAdapter(getContext(),null));

        return contentView;
    }
}
