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
    String bagsShopsName[] = {"amazonBdEcomarce", "eshaShop", "khanPrintingMuseum", "shoppersHubBd", "superMarketBd"};
    int bagsShopsImage[] = {R.drawable.amazon_bd_ecommarce, R.drawable.esha_shop, R.drawable.khan_printing_museum, R.drawable.shoppers_hub_bd,
            R.drawable.super_market_bd};
    //body care shops
    String bodyCareShopsName[] = {"amazonBdEcomarce", "eshaShop", "khanPrintingMuseum", "shoppersHubBd", "superMarketBd"};
    int bodyCareShopsImage[] = {R.drawable.amazon_bd_ecommarce, R.drawable.esha_shop, R.drawable.khan_printing_museum, R.drawable.shoppers_hub_bd,
            R.drawable.super_market_bd};
    //bodyCareSubCatagories
    String bodyCareSubCatagoriesName[] = {"Bath & Body", "Beauty Tools", "Beauty Tools", "Facial Cleansing Brushes", "Fragrances", "Gift Sets", "Hair Care",
            "MakeupBall", "Men's Care", "Sexual Wellness", "Skin & Body Care"};
    int bodyCareSubCatagoriesImage[] = {R.drawable.bath_and_body, R.drawable.beauty_tools, R.drawable.beauty_tools2, R.drawable.facial_cleansing_brushes, R.drawable.fragrances,
            R.drawable.gift_sets, R.drawable.hair_care, R.drawable.makeupball, R.drawable.mans_care, R.drawable.sexul_wellness, R.drawable.skin_and_beauty_care};
    //Book Shops
    String booksShopsName[] = {"Boi Ghor", "BS Gatget BD", "Cittron", "Feri Wala", "Amazon Bd Ecommarce", "Gyan Bitan Publication", "Rokomari 99", "Sikder Books Cornar"};
    int booksShopsImage[] = {R.drawable.boi_ghor, R.drawable.bs_gatget_bd, R.drawable.cittron, R.drawable.feri_wala, R.drawable.amazon_bd_ecommarce, R.drawable.gyan_bitan_publications,
            R.drawable.rokomari_99, R.drawable.sikder_books_cornar};
    //BooksSubCatagories
    String booksSubCatagoriesName[] = {"Bangali Books On Interest", "Books For Kids", "English Books On Interest", "Others Books",
            "Stationeries", "Text Books"};
    int booksSubCatagoriesImage[] = {R.drawable.bangali_books_on_interest, R.drawable.books_for_kids, R.drawable.english_books_on_interest,
            R.drawable.others_books, R.drawable.stationeries, R.drawable.text_books};

    public CustomSubCatagoriesModel(List<String> subItem, List<Integer> subImage, int catagoriesPosition, int selectShopsTabs) {
        this.subItem = subItem;
        this.subImage = subImage;
        this.catagoriesPosition = catagoriesPosition;
        this.selectShopTabs = selectShopsTabs;
        if (catagoriesPosition == 0) {//jodi bag click hoi
            if (selectShopTabs == 1) {//jodi shops tab e jai
                subItem.removeAll(subItem);//list e ja store ase sob clear korar jonno
                subImage.removeAll(subImage);//list e ja store ase sob clear korar jonno
                for (int i = 0; i < bagsShopsName.length; i++) {//set shops for bag catagories.
                    this.subItem.add(bagsShopsName[i]);
                    this.subImage.add(bagsShopsImage[i]);
                }
            } else {//jodi shops tab e na na jai
                bagSubCatagories();//set sunCatagories for bag catagories.
            }
        }
        if (catagoriesPosition == 1) {//jodi body care click hoi
            if (selectShopTabs == 1) {//jodi shops tab e jai
                subItem.removeAll(subItem);//list e ja store ase sob clear korar jonno
                subImage.removeAll(subImage);//list e ja store ase sob clear korar jonno
                for (int i = 0; i < bodyCareShopsName.length; i++) {//set shops for bodyCare catagories
                    this.subItem.add(bodyCareShopsName[i]);
                    this.subImage.add(bodyCareShopsImage[i]);
                }
            } else {
                bodyCareSubCtagories();//jodi shops tab e na na jai tahole sub catagories e jabe bodyCare catagories er jonno.
            }
        }
        if (catagoriesPosition == 2) {//jodi Books click hoi
            if (selectShopTabs == 1) {//jodi shops tab e jai
                subItem.removeAll(subItem);//list e ja store ase sob clear korar jonno
                subImage.removeAll(subImage);//list e ja store ase sob clear korar jonno
                for (int i = 0; i < booksShopsName.length; i++) {//set shops for books catagories
                    this.subItem.add(booksShopsName[i]);
                    this.subImage.add(booksShopsImage[i]);
                }
            } else {
                booksSubCatagoriess();//jodi shops tab e na na jai tahole sub catagories e jabe books catagories er jonno.
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

    private void booksSubCatagoriess() {
        subItem.removeAll(subItem);//list e ja store ase sob clear korar jonno
        subImage.removeAll(subImage);//list e ja store ase sob clear korar jonno
        for (int i = 0; i < booksSubCatagoriesName.length; i++) {//set books for books catagories
            this.subItem.add(booksSubCatagoriesName[i]);
            this.subImage.add(booksSubCatagoriesImage[i]);
        }
    }
}
