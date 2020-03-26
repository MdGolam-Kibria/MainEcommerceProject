package com.example.fragmentinsidefragmentpractice.subCatagories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.fragmentinsidefragmentpractice.R;
import com.example.fragmentinsidefragmentpractice.recyclerAll.CustomAdapter;
import com.example.fragmentinsidefragmentpractice.recyclerViewClickAndDeviderHundle.MyRecyclerViewDividerItemDecoration;
import com.example.fragmentinsidefragmentpractice.recyclerViewClickAndDeviderHundle.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

public class SubCatagories extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_catagories);
        customActionBar();
        findAll();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));//numberOfColumns
        // item = getResources().getStringArray(R.array.recyclerItem);
        List<Integer> image = new ArrayList<>();
        image.add(R.drawable.bag);
        image.add(R.drawable.body_care);
        image.add(R.drawable.book);
        image.add(R.drawable.glass);
        image.add(R.drawable.construction_material);
        image.add(R.drawable.decoration_material);
        image.add(R.drawable.digital_good);
        image.add(R.drawable.electric);
        image.add(R.drawable.event);
        image.add(R.drawable.woman_fashion);
        image.add(R.drawable.man_fashion);
        image.add(R.drawable.furniture);

        final List<String> item = new ArrayList<>();
        item.add("Bags");
        item.add("BodyCare");
        item.add("Books");
        item.add("Glasses");
        item.add("Construction materials");
        item.add("Decoration");
        item.add("Digital Goods");
        item.add("Electric");
        item.add("Event");
        item.add("Woman Fashion");
        item.add("Man Fashion");
        item.add("Furniture");

        CustomAdapter adapter = new CustomAdapter(this, item, image);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new MyRecyclerViewDividerItemDecoration(this, GridLayoutManager.HORIZONTAL, 16));
        recyclerView.addItemDecoration(new MyRecyclerViewDividerItemDecoration(this, GridLayoutManager.VERTICAL, 20));
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }

    private void findAll() {
        recyclerView = findViewById(R.id.recyclerViewSubCatagories);
    }

    private void customActionBar() {
        this.setTitle("");
        this.getSupportActionBar().hide();
    }
}
