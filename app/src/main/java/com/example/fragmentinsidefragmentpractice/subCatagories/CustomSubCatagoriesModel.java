package com.example.fragmentinsidefragmentpractice.subCatagories;

import com.example.fragmentinsidefragmentpractice.R;

import java.util.List;

public class CustomSubCatagoriesModel {

    List<String> subItem;
    List<Integer> subImage;
    int catagoriesPosition;
    int selectShopTabs;

    public CustomSubCatagoriesModel(List<String> subItem, List<Integer> subImage, int catagoriesPosition, int selectShopsTabs) {
        this.subItem = subItem;
        this.subImage = subImage;
        this.catagoriesPosition = catagoriesPosition;
        this.selectShopTabs = selectShopsTabs;
        if (catagoriesPosition == 0) {//jodi bag click hoi
            if (selectShopTabs == 1) {//jodi shops tab e jai
                subItem.removeAll(subItem);//list e ja store ase sob clear korar jonno
                subImage.removeAll(subImage);//list e ja store ase sob clear korar jonno
                for (int i = 0; i < CustomSubCatagoriesModelResource.bagsShopsName.length; i++) {//set shops for bag catagories.
                    this.subItem.add(CustomSubCatagoriesModelResource.bagsShopsName[i]);
                    this.subImage.add(CustomSubCatagoriesModelResource.bagsShopsImage[i]);
                }
            } else {//jodi shops tab e na na jai
                bagSubCatagories();//set sunCatagories for bag catagories.
            }
        }
        if (catagoriesPosition == 1) {//jodi body care click hoi
            if (selectShopTabs == 1) {//jodi shops tab e jai
                subItem.removeAll(subItem);//list e ja store ase sob clear korar jonno
                subImage.removeAll(subImage);//list e ja store ase sob clear korar jonno
                for (int i = 0; i < CustomSubCatagoriesModelResource.bodyCareShopsName.length; i++) {//set shops for bodyCare catagories
                    this.subItem.add(CustomSubCatagoriesModelResource.bodyCareShopsName[i]);
                    this.subImage.add(CustomSubCatagoriesModelResource.bodyCareShopsImage[i]);
                }
            } else {
                bodyCareSubCtagories();//jodi shops tab e na na jai tahole sub catagories e jabe bodyCare catagories er jonno.
            }
        }
        if (catagoriesPosition == 2) {//jodi Books click hoi
            if (selectShopTabs == 1) {//jodi shops tab e jai
                subItem.removeAll(subItem);//list e ja store ase sob clear korar jonno
                subImage.removeAll(subImage);//list e ja store ase sob clear korar jonno
                for (int i = 0; i < CustomSubCatagoriesModelResource.booksShopsName.length; i++) {//set shops for books catagories
                    this.subItem.add(CustomSubCatagoriesModelResource.booksShopsName[i]);
                    this.subImage.add(CustomSubCatagoriesModelResource.booksShopsImage[i]);
                }
            } else {
                booksSubCatagoriess();//jodi shops tab e na na jai tahole sub catagories e jabe books catagories er jonno.
            }
        }
    }

    private void bagSubCatagories() {

        subItem.removeAll(subItem);//list e ja store ase sob clear korar jonno
        subImage.removeAll(subImage);//list e ja store ase sob clear korar jonno
        for (int i = 0; i < CustomSubCatagoriesModelResource.bagSubCatagoriesName.length; i++) {
            this.subItem.add(CustomSubCatagoriesModelResource.bagSubCatagoriesName[i]);
            this.subImage.add(CustomSubCatagoriesModelResource.bagSubCatagoriesImage[i]);
        }
    }

    private void bodyCareSubCtagories() {
        subItem.removeAll(subItem);//list e ja store ase sob clear korar jonno
        subImage.removeAll(subImage);//list e ja store ase sob clear korar jonno.
        for (int i = 0; i < CustomSubCatagoriesModelResource.bodyCareSubCatagoriesName.length; i++) {
            this.subItem.add(CustomSubCatagoriesModelResource.bodyCareSubCatagoriesName[i]);
            this.subImage.add(CustomSubCatagoriesModelResource.bodyCareSubCatagoriesImage[i]);
        }
    }

    private void booksSubCatagoriess() {
        subItem.removeAll(subItem);//list e ja store ase sob clear korar jonno
        subImage.removeAll(subImage);//list e ja store ase sob clear korar jonno
        for (int i = 0; i < CustomSubCatagoriesModelResource.booksSubCatagoriesName.length; i++) {//set books for books catagories
            this.subItem.add(CustomSubCatagoriesModelResource.booksSubCatagoriesName[i]);
            this.subImage.add(CustomSubCatagoriesModelResource.booksSubCatagoriesImage[i]);
        }
    }
}
