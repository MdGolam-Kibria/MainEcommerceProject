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
    int selectShopTabs;


    public CustomSubCatagoriesModel(List<String> subBagItem, List<Integer> subBagimage, int catagoriesPosition, int selectTabs) {
        this.subBagItem = subBagItem;
        this.subBagimage = subBagimage;
        this.catagoriesPosition = catagoriesPosition;
        this.selectShopTabs = selectTabs;
        if (catagoriesPosition == 0) {//jodi bag click hoi
            if (selectShopTabs == 1) {//jodi shops tab e jai
//                this.subBagItem.add("Backpack");
//                this.subBagItem.add("Card Holders");
//                //image
//                this.subBagimage.add(R.drawable.bag);
//                this.subBagimage.add(R.drawable.card_holders);

                String mainCatagories = "Bags";//catagoriesPosition == 0  manei bag
                Integer shopsImage[] = {
                        R.drawable.amazon_bd_ecommarce,
                        R.drawable.esha_shop,
                        R.drawable.khan_printing_museum,
                        R.drawable.pariza_fashion,
                        R.drawable.shoppers_hub_bd,
                        R.drawable.super_market_bd
                };
                String shopName[] = {"amazonBdEcomarce", "eshaShop", "khanPrintingMuseum", "parizaFashion", "shoppersHubBd", "superMarketBd"};
                String amazonBdEcomarce[] = {"bags", "bodyCare", "books", "glasses", "moderKidsAndtoys", "sports", "vehiclesAndParts", "homeAndLiving",
                        "homeAndAppliance", "grocery", "constructionMaterials", "decoration", "digitalGoods", "electricAndParts", "watchAndClock", "womanFashion",
                        "manFashion", "Furniture"};
                            //below the logic


//                int size = toppings.length;
//                for (int i=0; i<size; i++)
//                {
//                    System.out.println(toppings[i]);
//                }

            } else {//jodi shops tab e na na jai
                bagSubCatagories();
            }
        }
        if (catagoriesPosition == 1) {//jodi body care click hoi
            bodyCareSubCtagories();
        }
    }

    private void bagSubCatagories() {

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
