package com.example.fragmentinsidefragmentpractice.fragment.tabFragment;

import android.content.Context;
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

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Shops extends Fragment {
    private RecyclerView recyclerView;
    FragmentActivity fragmentActivity = getActivity();
    Context context = fragmentActivity;

    public Shops() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_shops, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewShops);
         recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(fragmentActivity, 3));//numberOfColumns

        List<Integer> shopsImage = new ArrayList<>();
        shopsImage.add(R.drawable.sumash_tech);
        shopsImage.add(R.drawable.rio_international);
        ///
        //shopsImage.add(Glide.with())

        ///
        shopsImage.add(R.drawable.star_tech);
        shopsImage.add(R.drawable.samsung);
        shopsImage.add(R.drawable.new_camera_world);
        shopsImage.add(R.drawable.hero);
        shopsImage.add(R.drawable.book_market);
        shopsImage.add(R.drawable.kham_express);
        shopsImage.add(R.drawable.e_dokandar);
        final List<String> shopsItem = new ArrayList<>();
        shopsItem.add("Sumash Tech");
        shopsItem.add("Rio International");
        shopsItem.add("Star Tech");
        shopsItem.add("Samsung");
        shopsItem.add(getString(R.string.newCameraWorld));
        shopsItem.add("Hero");
        shopsItem.add("বই বাজার");
        shopsItem.add("Kham Express");
        shopsItem.add("E Dokandar");


        CustomAdapter adapter = new CustomAdapter(getContext(), shopsItem, shopsImage);
        recyclerView.setAdapter(adapter);
        //recyclerView.addItemDecoration(new MyRecyclerViewDividerItemDecoration(getContext(), GridLayoutManager.HORIZONTAL, 16));
       // recyclerView.addItemDecoration(new MyRecyclerViewDividerItemDecoration(getContext(), GridLayoutManager.VERTICAL, 20));
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getContext(), "" + shopsItem.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return view;
    }
}
