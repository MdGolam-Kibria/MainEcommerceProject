package com.example.fragmentinsidefragmentpractice.authorizationAndAuthentication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.fragmentinsidefragmentpractice.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class SignupBottomSHeetFragment extends BottomSheetDialogFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.signup_buttom_sheet, container, false);
        return view;
    }
}
