package com.example.fragmentinsidefragmentpractice.subCatagories;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragmentinsidefragmentpractice.R;
import com.example.fragmentinsidefragmentpractice.fragment.tabFragment.Catagories;
import com.example.fragmentinsidefragmentpractice.recyclerAll.CustomAdapter;
import com.example.fragmentinsidefragmentpractice.recyclerViewClickAndDeviderHundle.MyRecyclerViewDividerItemDecoration;
import com.example.fragmentinsidefragmentpractice.recyclerViewClickAndDeviderHundle.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;


public class SubCatagoriesForBag extends Fragment {
    RecyclerView recyclerView;
    List<Integer> subBagimage = new ArrayList<>();
    List<String> bagItem = new ArrayList<>();
    TextView textView;

    public SubCatagoriesForBag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sub_catagories1, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewBagSubCatagories);
        textView = view.findViewById(R.id.subCatagoriesTitle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));//numberOfColumns
        Toast.makeText(getContext(), "This is click position = " + Catagories.returnPosition, Toast.LENGTH_LONG).show();


        if (Catagories.returnPosition == 0) {
            textView.setText("Bag Sub Catagories");
            bagItem.add("Backpack");
            bagItem.add("Card Holders");
            bagItem.add("Clutches");
            bagItem.add("Designers Bag");
            bagItem.add("Crossbody Bags");
            bagItem.add("Office Bag");
            bagItem.add("Shoulder Bag");
            bagItem.add("Wallets");
            bagItem.add("Kids School Bags");
            bagItem.add("Laptop & Tablet Bag");
            //image
            subBagimage.add(R.drawable.bag);
            subBagimage.add(R.drawable.card_holders);
            subBagimage.add(R.drawable.clutches);
            subBagimage.add(R.drawable.designers_bag);
            subBagimage.add(R.drawable.cross_body_bags);
            subBagimage.add(R.drawable.office_bag);
            subBagimage.add(R.drawable.shoulder);
            subBagimage.add(R.drawable.wallets);
            subBagimage.add(R.drawable.kids_school_bags);
            subBagimage.add(R.drawable.laptop_and_tablet_bags);
        }
        if (Catagories.returnPosition == 1) {
            textView.setText("Body Care Sub Catagories");
            bagItem.add("Bath & Body");
            bagItem.add("Beauty Tools");
            bagItem.add("Beauty Tools");
            bagItem.add("Facial Cleansing Brushes");
            bagItem.add("Fragrances");
            bagItem.add("Gift Sets");
            bagItem.add("Hair Care");
            bagItem.add("Makeupball");
            bagItem.add("Man's care");
            bagItem.add("Sexual Wellness");
            bagItem.add("Skin & Body Care");
            //image
            subBagimage.add(R.drawable.bath_and_body);
            subBagimage.add(R.drawable.beauty_tools);
            subBagimage.add(R.drawable.beauty_tools2);
            subBagimage.add(R.drawable.facial_cleansing_brushes);
            subBagimage.add(R.drawable.fragrances);
            subBagimage.add(R.drawable.gift_sets);
            subBagimage.add(R.drawable.hair_care);
            subBagimage.add(R.drawable.makeupball);
            subBagimage.add(R.drawable.mans_care);
            subBagimage.add(R.drawable.sexul_wellness);
            subBagimage.add(R.drawable.skin_and_beauty_care);
        }
        CustomAdapter adapter = new CustomAdapter(getContext(), bagItem, subBagimage);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new MyRecyclerViewDividerItemDecoration(getContext(), GridLayoutManager.HORIZONTAL, 16));
        recyclerView.addItemDecoration(new MyRecyclerViewDividerItemDecoration(getContext(), GridLayoutManager.VERTICAL, 20));
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        return view;
    }
}
