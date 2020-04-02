package com.example.fragmentinsidefragmentpractice.subCatagories;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fragmentinsidefragmentpractice.R;
import com.example.fragmentinsidefragmentpractice.fragment.tabFragment.Catagories;
import com.example.fragmentinsidefragmentpractice.recyclerAll.CustomAdapter;
import com.example.fragmentinsidefragmentpractice.recyclerViewClickAndDeviderHundle.MyRecyclerViewDividerItemDecoration;
import com.example.fragmentinsidefragmentpractice.recyclerViewClickAndDeviderHundle.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubCtatagoriesView extends Fragment {
    View view;
    RecyclerView recyclerView;
    List<Integer> image = new ArrayList<>();
    List<String> item = new ArrayList<>();
    int selectTabPosition; //2 num tab a click er source constructor theke set kora

    public SubCtatagoriesView() {

    }

    public SubCtatagoriesView(int selectTabs) {//selectTabs click er source
        this.selectTabPosition = selectTabs;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sub_ctatagories_view, container, false);
        //  ((AppCompatActivity) getActivity()).getSupportActionBar().hide();//for hide activity action bar.
        recyclerView = view.findViewById(R.id.recyclerViewForSubCatagories);
        // textView = view.findViewById(R.id.subCatagoriesTitle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));//numberOfColumns
        Toast.makeText(getContext(), "This is click position = " + Catagories.catagoriesItemPosition, Toast.LENGTH_LONG).show();
        // niche CustomSubCatagoriesModel class dara ei fragment er moddhe "Catagories.returnPosition" er dara view load korechi
        new CustomSubCatagoriesModel(item, image, Catagories.catagoriesItemPosition, selectTabPosition);//set every catarories view
        CustomAdapter adapter = new CustomAdapter(getContext(), item, image);//recyclerView configurations.
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new MyRecyclerViewDividerItemDecoration(getContext(), GridLayoutManager.HORIZONTAL, 16));
        recyclerView.addItemDecoration(new MyRecyclerViewDividerItemDecoration(getContext(), GridLayoutManager.VERTICAL, 20));
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                if (Catagories.catagoriesItemPosition == 0 && CustomSubCatagoriesModel.SELECT_TAB_FOR_CATAGORIES == 0) {//for bag catagories
                    Toast.makeText(getContext(), "" + CustomSubCatagoriesModelResource.bagSubCatagoriesName[position], Toast.LENGTH_LONG).show();
                }
               // if (Catagories.catagoriesItemPosition == 0 && CustomSubCatagoriesModel.SELECT_TAB_FOR_SHOP == 1) {//for bag shops
                //    Toast.makeText(getContext(), "" + CustomSubCatagoriesModelResource.bagsShopsName[position], Toast.LENGTH_LONG).show();
                //}
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        return view;
    }
}
