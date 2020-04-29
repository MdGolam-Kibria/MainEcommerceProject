package com.example.fragmentinsidefragmentpractice.fragment.subCategoriesAllOtemProducts;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentinsidefragmentpractice.R;
import com.example.fragmentinsidefragmentpractice.recyclerAll.CustomAdapter;
import com.example.fragmentinsidefragmentpractice.recyclerAll.adapterForMainProductShow.CustomAdapterFormainProductShow;
import com.example.fragmentinsidefragmentpractice.recyclerViewClickAndDeviderHundle.MyRecyclerViewDividerItemDecoration;
import com.example.fragmentinsidefragmentpractice.recyclerViewClickAndDeviderHundle.RecyclerTouchListener;
import com.example.fragmentinsidefragmentpractice.subCatagories.CustomSubCatagoriesModelResource;
import com.example.fragmentinsidefragmentpractice.subCatagories.SubCatagories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubCategoriesAllItemsProducts extends Fragment {
    View view;
    int selecttabPosition;
    String itemPositionName;
    RecyclerView recyclerView;
    List<Integer> productImage = new ArrayList<Integer>();
    List<String> productDescription = new ArrayList<>();
    List<String> productCost = new ArrayList<>();


    public SubCategoriesAllItemsProducts() {

    }

    public SubCategoriesAllItemsProducts(int selectTabPosition, String itempositionName) {
        this.selecttabPosition = selectTabPosition;
        this.itemPositionName = itempositionName;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sub_categories_all_items_products, container, false);
        addProduct();
        recyclerView = view.findViewById(R.id.mainItemProductRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));//numberOfColumns
//        final CustomAdapter adapter = new CustomAdapter(getContext(), item, image);
        final CustomAdapterFormainProductShow adapter = new CustomAdapterFormainProductShow(getContext(),productImage,productDescription,productCost);
        recyclerView.setAdapter(adapter);
        //recyclerView.addItemDecoration(new MyRecyclerViewDividerItemDecoration(getContext(), GridLayoutManager.HORIZONTAL, 16));
        //recyclerView.addItemDecoration(new MyRecyclerViewDividerItemDecoration(getContext(), GridLayoutManager.VERTICAL, 20));
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

    private void addProduct() {
        for (int i = 0; i < CustomSubCatagoriesModelResource.bagSubCatagoriesImage.length; i++) {
            productImage.add(CustomSubCatagoriesModelResource.bagSubCatagoriesImage[i]);
            productDescription.add(CustomSubCatagoriesModelResource.bagSubCatagoriesName[i]);
            productCost.add(CustomSubCatagoriesModelResource.bagSubCatagoriesName[i]);
        }
    }
}
