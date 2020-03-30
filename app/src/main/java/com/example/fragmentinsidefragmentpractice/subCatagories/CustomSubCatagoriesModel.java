package com.example.fragmentinsidefragmentpractice.subCatagories;

import android.graphics.Color;
import android.widget.TextView;

import com.captaindroid.tvg.Tvg;
import com.example.fragmentinsidefragmentpractice.R;

import java.util.ArrayList;
import java.util.List;

public class CustomSubCatagoriesModel {

    List<String> subBagItem;
    List<Integer> subBagimage;
    int catagoriesPosition;


    public CustomSubCatagoriesModel(List<String> subBagItem, List<Integer> subBagimage, int catagoriesPosition) {
        this.subBagItem = subBagItem;
        this.subBagimage = subBagimage;
        this.catagoriesPosition = catagoriesPosition;
        if (catagoriesPosition == 0) {
            bagSubCatagories();
        }
        if (catagoriesPosition == 1) {
            bodyCareSubCtagories();
        }
    }

    private void bagSubCatagories() {
//        subBagTitle.setText("Bag Sub Catagories");
//        Tvg.change((TextView) subBagTitle, new int[]{
//                Color.parseColor("#F97C3C"),
//                Color.parseColor("#FDB54E"),
//                Color.parseColor("#64B678"),
//                Color.parseColor("#478AEA"),
//                Color.parseColor("#8446CC"),
//        });
        //item
        this.subBagItem.add("Backpack");
        this.subBagItem.add("Card Holders");
        this.subBagItem.add("Clutches");
        this.subBagItem.add("Designers Bag");
        this.subBagItem.add("Crossbody Bags");
        this.subBagItem.add("Office Bag");
        this.subBagItem.add("Shoulder Bag");
        this.subBagItem.add("Wallets");
        this.subBagItem.add("Kids School Bags");
        this.subBagItem.add("Laptop & Tablet Bag");
        //image
        this.subBagimage.add(R.drawable.bag);
        this.subBagimage.add(R.drawable.card_holders);
        this.subBagimage.add(R.drawable.clutches);
        this.subBagimage.add(R.drawable.designers_bag);
        this.subBagimage.add(R.drawable.cross_body_bags);
        this.subBagimage.add(R.drawable.office_bag);
        this.subBagimage.add(R.drawable.shoulder);
        this.subBagimage.add(R.drawable.wallets);
        this.subBagimage.add(R.drawable.kids_school_bags);
        this.subBagimage.add(R.drawable.laptop_and_tablet_bags);
    }

    private void bodyCareSubCtagories() {
//        subBagTitle.setText("Body Care Sub Catagories");
//        Tvg.change((TextView) subBagTitle, new int[]{
//                Color.parseColor("#F97C3C"),
//                Color.parseColor("#FDB54E"),
//                Color.parseColor("#64B678"),
//                Color.parseColor("#478AEA"),
//                Color.parseColor("#8446CC"),
//        });
        //item
        this.subBagItem.add("Bath & Body");
        this.subBagItem.add("Beauty Tools");
        this.subBagItem.add("Beauty Tools");
        this.subBagItem.add("Facial Cleansing Brushes");
        this.subBagItem.add("Fragrances");
        this.subBagItem.add("Gift Sets");
        this.subBagItem.add("Hair Care");
        this.subBagItem.add("Makeupball");
        this.subBagItem.add("Man's care");
        this.subBagItem.add("Sexual Wellness");
        this.subBagItem.add("Skin & Body Care");
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

}
