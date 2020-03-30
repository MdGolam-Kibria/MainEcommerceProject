package com.example.fragmentinsidefragmentpractice.subCatagories;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.captaindroid.tvg.Tvg;
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
        new CustomSubCatagories(textView, bagItem, subBagimage, Catagories.returnPosition);//set every catarories view
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
