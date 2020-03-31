package com.example.fragmentinsidefragmentpractice.subCatagories;

import com.example.fragmentinsidefragmentpractice.R;

import java.util.List;

public class CustomSubCatagoriesModel {

    List<String> subItem;
    List<Integer> subImage;
    int catagoriesPosition;
    int selectShopTabs;
    //bagSubCatagories
    String bagSubCatagoriesName[] = {"Backpack", "Card Holders", "Clutches", "Designers Bag", "Crossbody Bags", "Office Bag", "Shoulder Bag", "Wallets", "Kids School Bags", "Laptop & Tablet Bag"};
    int bagSubCatagoriesImage[] = {R.drawable.bath_and_body, R.drawable.beauty_tools, R.drawable.beauty_tools2, R.drawable.facial_cleansing_brushes, R.drawable.fragrances,
            R.drawable.gift_sets, R.drawable.hair_care, R.drawable.makeupball, R.drawable.mans_care, R.drawable.sexul_wellness, R.drawable.skin_and_beauty_care};
    //bag shops
    String bagsProvidersName[] = {"amazonBdEcomarce", "eshaShop", "khanPrintingMuseum", "shoppersHubBd", "superMarketBd"};
    int bagsProvidersImage[] = {R.drawable.amazon_bd_ecommarce, R.drawable.esha_shop, R.drawable.khan_printing_museum, R.drawable.shoppers_hub_bd,
            R.drawable.super_market_bd};
    //body care shops
    String bodyCareProvidersName[] = {"amazonBdEcomarce", "eshaShop", "khanPrintingMuseum", "shoppersHubBd", "superMarketBd"};
    int bodyCareProvidersImage[] = {R.drawable.amazon_bd_ecommarce, R.drawable.esha_shop, R.drawable.khan_printing_museum, R.drawable.shoppers_hub_bd,
            R.drawable.super_market_bd};
    //bodyCareSubCatagories
    String bodyCareSubCatagoriesName[] = {"Bath & Body", "Beauty Tools", "Beauty Tools", "Facial Cleansing Brushes", "Fragrances", "Gift Sets", "Hair Care",
            "MakeupBall", "Men's Care", "Sexual Wellness", "Skin & Body Care"};
    int bodyCareSubCatagoriesImage[] = {R.drawable.bath_and_body, R.drawable.beauty_tools, R.drawable.beauty_tools2, R.drawable.facial_cleansing_brushes, R.drawable.fragrances,
            R.drawable.gift_sets, R.drawable.hair_care, R.drawable.makeupball, R.drawable.mans_care, R.drawable.sexul_wellness, R.drawable.skin_and_beauty_care};

    public CustomSubCatagoriesModel(List<String> subItem, List<Integer> subImage, int catagoriesPosition, int selectShopsTabs) {
        this.subItem = subItem;
        this.subImage = subImage;
        this.catagoriesPosition = catagoriesPosition;
        this.selectShopTabs = selectShopsTabs;
        if (catagoriesPosition == 0) {//jodi bag click hoi
            if (selectShopTabs == 1) {//jodi shops tab e jai
                subItem.removeAll(subItem);//list e ja store ase sob clear korar jonno
                subImage.removeAll(subImage);//list e ja store ase sob clear korar jonno
                for (int i = 0; i < bagsProvidersName.length; i++) {//set shops for bag catagories.
                    this.subItem.add(bagsProvidersName[i]);
                    this.subImage.add(bagsProvidersImage[i]);
                }
            } else {//jodi shops tab e na na jai
                bagSubCatagories();//set sunCatagories for bag catagories.
            }
        }
        if (catagoriesPosition == 1) {//jodi body care click hoi
            if (selectShopTabs == 1) {//jodi shops tab e jai
                subItem.removeAll(subItem);//list e ja store ase sob clear korar jonno
                subImage.removeAll(subImage);//list e ja store ase sob clear korar jonno
                for (int i = 0; i < bodyCareProvidersName.length; i++) {//set shops for bodyCare catagories
                    this.subItem.add(bodyCareProvidersName[i]);
                    this.subImage.add(bodyCareProvidersImage[i]);
                }
            } else {
                bodyCareSubCtagories();//jodi shops tab e na na jai tahole sub catagories e jabe bodyCare catagories er jonno.
            }
        }
    }

    private void bagSubCatagories() {

        subItem.removeAll(subItem);//list e ja store ase sob clear korar jonno
        subImage.removeAll(subImage);//list e ja store ase sob clear korar jonno
        for (int i = 0; i < bagSubCatagoriesName.length; i++) {
            this.subItem.add(bagSubCatagoriesName[i]);
            this.subImage.add(bagSubCatagoriesImage[i]);
        }
    }

    private void bodyCareSubCtagories() {
        subItem.removeAll(subItem);//list e ja store ase sob clear korar jonno
        subImage.removeAll(subImage);//list e ja store ase sob clear korar jonno.
        for (int i = 0; i < bodyCareSubCatagoriesName.length; i++) {
            this.subItem.add(bodyCareSubCatagoriesName[i]);
            this.subImage.add(bodyCareSubCatagoriesImage[i]);
        }
    }
}
