package com.example.fragmentinsidefragmentpractice.fragment.tabFragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fragmentinsidefragmentpractice.R;
import com.example.fragmentinsidefragmentpractice.recyclerAll.CustomAdapter;
import com.example.fragmentinsidefragmentpractice.recyclerViewClickAndDeviderHundle.MyRecyclerViewDividerItemDecoration;
import com.example.fragmentinsidefragmentpractice.recyclerViewClickAndDeviderHundle.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Brands extends Fragment {
    private RecyclerView recyclerView;
    FragmentActivity fragmentActivity = getActivity();
    Context context = fragmentActivity;

    public Brands() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_brands, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewBrands);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(fragmentActivity, 3));//numberOfColumns
        List<Integer> brandsImage = new ArrayList<>();
        brandsImage.add(R.drawable.toyota);
        brandsImage.add(R.drawable.individual_collection);
        brandsImage.add(R.drawable.hp);
        brandsImage.add(R.drawable.aks);
        brandsImage.add(R.drawable.aci);
        brandsImage.add(R.drawable.samsung);
        brandsImage.add(R.drawable.xiaomi);
        brandsImage.add(R.drawable.fresh);
        brandsImage.add(R.drawable.bashundhara);
        final List<String> brandsItem = new ArrayList<>();
        brandsItem.add("Toyota");
        brandsItem.add("Individual Collection");
        brandsItem.add("Hp");
        brandsItem.add("AKS");
        brandsItem.add("Aci");
        brandsItem.add("Samsung");
        brandsItem.add("Xiaomi");
        brandsItem.add("Fresh");
        brandsItem.add("Bashundhara");
        CustomAdapter adapter = new CustomAdapter(getContext(), brandsItem, brandsImage);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new MyRecyclerViewDividerItemDecoration(getContext(), GridLayoutManager.HORIZONTAL, 16));
        recyclerView.addItemDecoration(new MyRecyclerViewDividerItemDecoration(getContext(), GridLayoutManager.VERTICAL, 20));
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getContext(), ""+brandsItem.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        return view;
    }
}
