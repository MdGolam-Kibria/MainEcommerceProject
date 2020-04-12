package com.example.fragmentinsidefragmentpractice.adminPanel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.fragmentinsidefragmentpractice.R;
import com.example.fragmentinsidefragmentpractice.fragment.tabFragment.Catagories;
import com.example.fragmentinsidefragmentpractice.fragment.tabFragment.TabUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminWelcome extends Fragment implements View.OnClickListener {
    View view;
    LinearLayout linearLayout, afterWelcomeAdminPage;
    Button manageUser, manageApp;
    Spinner selectRootTab, selectItemForC_B_Shops;


    public AdminWelcome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_admin_welcome, container, false);
        manageUser = view.findViewById(R.id.manageUser);
        manageApp = view.findViewById(R.id.manageApp);
        linearLayout = view.findViewById(R.id.welcomeScr);
        selectRootTab = view.findViewById(R.id.selectRootTab);
        selectItemForC_B_Shops = view.findViewById(R.id.selectItemForC_B_Shops);
        afterWelcomeAdminPage = view.findViewById(R.id.afterWelcomeAdminPage);
        manageApp.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.manageApp) {
            linearLayout.setVisibility(View.GONE);
            afterWelcomeAdminPage.setVisibility(View.VISIBLE);
            selectRootTabShow();
            selectItemForCategories_Brands_Shops();
        }
////      if (v.getId()==R.id.selectRootTab){
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
//                R.array.selectAdminFastPageTab, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//      }
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
//                R.array.selectAdminFastPageTab, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
    }

    private void selectItemForCategories_Brands_Shops() {

        List<String> allItemIndexList = new ArrayList<String>();
        for (int i = 0; i < TabUtil.catagoriesItemsLength; i++) {
            allItemIndexList.add(TabUtil.catagoriesItems[i]);
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, allItemIndexList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectItemForC_B_Shops.setAdapter(dataAdapter);
    }

    private void selectRootTabShow() {
        List<String> list = new ArrayList<String>();
        list.add("Categories");
        list.add("Brands");
        list.add("Shops");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectRootTab.setAdapter(dataAdapter);

    }
}
