package com.tiffany.phippy.life;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.tiffany.phippy.R;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by moses on 09/06/2017.
 */

public class LifeFragment extends Fragment {
    protected View contentView;


    private ConvenientBanner convenientBanner;
    private ArrayList<Integer> localImages = new ArrayList<Integer>();
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        contentView = inflater.inflate(R.layout.fragment_life, container, false);

        LinearLayout fragment = (LinearLayout) contentView.findViewById(R.id.fragment_life);
        fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"商家正在入驻",Toast.LENGTH_SHORT).show();
            }
        });

        //小娘子药铺
        ImageView xiaoniangzi = (ImageView) contentView.findViewById(R.id.life_medicine);
        xiaoniangzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MedicineActivity.class);
                startActivity(intent);
            }
        });

//        签证
        LinearLayout layoutVisa = (LinearLayout) contentView.findViewById(R.id.life_layout_visa);
        layoutVisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),VisaActivity.class);
                startActivity(intent);
            }
        });
        return contentView;
    }

    /**
     * 通过文件名获取资源id 例子：getResId("icon", R.drawable.class);
     *
     * @param variableName
     * @param c
     * @return
     */
    public static int getResId(String variableName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(variableName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}

