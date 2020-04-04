package com.example.fragmentinsidefragmentpractice.fragment.tabFragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentinsidefragmentpractice.R;
import com.example.fragmentinsidefragmentpractice.recyclerAll.CustomAdapter;
import com.example.fragmentinsidefragmentpractice.recyclerViewClickAndDeviderHundle.MyRecyclerViewDividerItemDecoration;
import com.example.fragmentinsidefragmentpractice.recyclerViewClickAndDeviderHundle.RecyclerTouchListener;
import com.example.fragmentinsidefragmentpractice.subCatagories.SubCatagories;
import com.example.fragmentinsidefragmentpractice.util.UseUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Catagories extends Fragment {
    public static int catagoriesItemPosition;

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

        List<Integer> image = new ArrayList<>();//for add categories image.
        for (int i=0;i<TabUtil.categoriesImage.length;i++){
            image.add(TabUtil.categoriesImage[i]);
        }
        final List<String> item = new ArrayList<>();//for add categories item.
        for (int i=0;i<TabUtil.catagoriesItems.length;i++){
            item.add(TabUtil.catagoriesItems[i]);
        }
        CustomAdapter adapter = new CustomAdapter(getContext(), item, image);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new MyRecyclerViewDividerItemDecoration(getContext(), GridLayoutManager.HORIZONTAL, 40));
        recyclerView.addItemDecoration(new MyRecyclerViewDividerItemDecoration(getContext(), GridLayoutManager.VERTICAL, 50));
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                catagoriesItemPosition = position;
                Toast.makeText(getContext(), "" + item.get(position), Toast.LENGTH_SHORT).show();
                moveSubCatagories();//for move sub catagories fragment
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        return view;
    }

    private FragmentTransaction moveSubCatagories() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(UseUtil.changeFragmentAnimation1st, UseUtil.changeFragmentAnimation2nd, UseUtil
                        .changeFragmentAnimation3rd, UseUtil.changeFragmentAnimation4th);
        transaction.replace(R.id.fragment, new SubCatagories(), "catagories").addToBackStack(null).commit();
        return transaction;
    }
}
