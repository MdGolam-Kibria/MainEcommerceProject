package com.example.fragmentinsidefragmentpractice.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.captaindroid.tvg.Tvg;
import com.example.fragmentinsidefragmentpractice.R;
import com.example.fragmentinsidefragmentpractice.animation.ZoomOutPageTransformer;
import com.example.fragmentinsidefragmentpractice.fragment.tabFragment.Brands;
import com.example.fragmentinsidefragmentpractice.fragment.tabFragment.Catagories;
import com.example.fragmentinsidefragmentpractice.fragment.tabFragment.Shops;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    View view;
    ViewPager viewPager;
    TabLayout tabLayout;

    public HomeFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        tabLayout = view.findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.categories));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.brands));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.shops));
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
        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer()); //here view pager animations.

        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new Catagories();
                    case 1:
                        return new Brands();
                    case 2:
                        return new Shops();
                }
                return null;
            }

            @Override
            public int getCount() {
                return 3;
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
                //if you want to more change here
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }
}
