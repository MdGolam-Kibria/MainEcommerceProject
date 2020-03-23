package com.example.fragmentinsidefragmentpractice.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

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
    TextView catagoriesTab, brandsTab, shopsTab;

    public HomeFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setPageTransformer(true,new ZoomOutPageTransformer());//here view pager animations.
        catagoriesTab = view.findViewById(R.id.categories);
        brandsTab = view.findViewById(R.id.brands);
        shopsTab = view.findViewById(R.id.shops);
        catagoriesTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
        brandsTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
        shopsTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
            }
        });

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
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                selectTabs(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return view;

    }


    @SuppressLint("ResourceAsColor")
    private void selectTabs(int position) {
        if (position == 0) {
//            brandsTab.setTextColor(R.color.tab);
//            shopsTab.setTextColor(R.color.tab);

            catagoriesTab.setTextSize(20f);
        }
        if (position == 1) {

            //  catagoriesTab.setBackgroundColor(R.color.black);

//            catagoriesTab.setTextColor(R.color.tab);
//            shopsTab.setTextColor(R.color.tab);
        }
        if (position == 2) {
//            brandsTab.setTextColor(R.color.tab);
//            catagoriesTab.setTextColor(R.color.tab);
        }
    }


}
