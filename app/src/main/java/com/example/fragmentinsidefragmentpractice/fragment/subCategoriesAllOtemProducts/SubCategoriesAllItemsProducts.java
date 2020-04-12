package com.example.fragmentinsidefragmentpractice.fragment.subCategoriesAllOtemProducts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentinsidefragmentpractice.R;
import com.example.fragmentinsidefragmentpractice.subCatagories.SubCatagories;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubCategoriesAllItemsProducts extends Fragment {

    public SubCategoriesAllItemsProducts() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_sub_categories_all_items_products, container, false);
    }
}
