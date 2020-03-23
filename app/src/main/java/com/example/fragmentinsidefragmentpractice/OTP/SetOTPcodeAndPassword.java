package com.example.fragmentinsidefragmentpractice.OTP;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentinsidefragmentpractice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SetOTPcodeAndPassword extends Fragment {

    public SetOTPcodeAndPassword() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_set_o_t_pcode_and_password, container, false);
    }
}
