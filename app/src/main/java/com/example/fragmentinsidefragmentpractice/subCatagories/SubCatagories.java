package com.example.fragmentinsidefragmentpractice.subCatagories;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragmentinsidefragmentpractice.R;
import com.example.fragmentinsidefragmentpractice.animation.ZoomOutPageTransformer;
import com.example.fragmentinsidefragmentpractice.fragment.tabFragment.Brands;
import com.example.fragmentinsidefragmentpractice.fragment.tabFragment.Catagories;
import com.example.fragmentinsidefragmentpractice.fragment.tabFragment.Shops;
import com.example.fragmentinsidefragmentpractice.recyclerAll.CustomAdapter;
import com.example.fragmentinsidefragmentpractice.recyclerViewClickAndDeviderHundle.MyRecyclerViewDividerItemDecoration;
import com.example.fragmentinsidefragmentpractice.recyclerViewClickAndDeviderHundle.RecyclerTouchListener;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class SubCatagories extends Fragment {


    View view;
    ViewPager viewPager;
    TabLayout tabLayout;

    public SubCatagories() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sub_catagories1, container, false);
        tabLayout = view.findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Sub Categories"));
        tabLayout.addTab(tabLayout.newTab().setText("Shops"));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager = view.findViewById(R.id.viewPagerForSubCatagories);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer()); //here view pager animations.

        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new SubCtatagoriesView(0);

                    case 1:
                        return new SubCtatagoriesView(1);// Parameter 1 dissi ai jonno je tablayout with viewPager er 2 number tab er load er source hisebe dewa.
                }
                return null;
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return view;
    }
}
