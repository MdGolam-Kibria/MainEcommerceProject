package com.example.fragmentinsidefragmentpractice.fragment.tabFragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentinsidefragmentpractice.R;
import com.example.fragmentinsidefragmentpractice.recyclerAll.CustomAdapter;
import com.example.fragmentinsidefragmentpractice.recyclerViewClickAndDeviderHundle.MyRecyclerViewDividerItemDecoration;
import com.example.fragmentinsidefragmentpractice.recyclerViewClickAndDeviderHundle.RecyclerTouchListener;
import com.example.fragmentinsidefragmentpractice.subCatagories.SubCatagories;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Catagories extends Fragment implements View.OnClickListener {


    private RecyclerView recyclerView;
    FragmentActivity fragmentActivity = getActivity();

    Context context = fragmentActivity;

    public Catagories() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_catagories, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewCatagories);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(fragmentActivity, 3));//numberOfColumns
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

        CustomAdapter adapter = new CustomAdapter(getContext(), item, image);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new MyRecyclerViewDividerItemDecoration(getContext(), GridLayoutManager.HORIZONTAL, 16));
        recyclerView.addItemDecoration(new MyRecyclerViewDividerItemDecoration(getContext(), GridLayoutManager.VERTICAL, 20));
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getContext(), "" + item.get(position), Toast.LENGTH_SHORT).show();
                switch (position){
                    case 0:
                        startActivity(new Intent(getActivity(), SubCatagories.class));
                            //  * below animation for fragment to activity.
                        ((Activity) getActivity()).overridePendingTransition(R.animator.enter_from_right, R.animator.exit_to_left);
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
