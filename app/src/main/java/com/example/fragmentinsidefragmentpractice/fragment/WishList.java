package com.example.fragmentinsidefragmentpractice.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentinsidefragmentpractice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WishList extends Fragment {

    public WishList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_wish_list, container, false);


        return view;
    }
}
