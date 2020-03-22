package com.example.fragmentinsidefragmentpractice.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.fragmentinsidefragmentpractice.MainActivity;
import com.example.fragmentinsidefragmentpractice.R;
import com.example.fragmentinsidefragmentpractice.authorizationAndAuthentication.ResisterFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoard extends Fragment implements View.OnClickListener {
    EditText phone, password;
    Button login;
    LinearLayout resister;
    private CheckBox saveLoginCheckBox;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private FirebaseAuth mAuth;


    public DashBoard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dash_board, container, false);
        mAuth = FirebaseAuth.getInstance();
        phone = view.findViewById(R.id.phone);
        password = view.findViewById(R.id.password);
        login = view.findViewById(R.id.login);
        resister = view.findViewById(R.id.resister);
        saveLoginCheckBox = view.findViewById(R.id.saveLoginCheckBox);
        login.setOnClickListener(this);
        resister.setOnClickListener(this);
        if (saveLoginCheckBox.isChecked()) {
            String userPhone = phone.getText().toString();
            String userPassword = password.getText().toString();
            if (userPhone.equals(null) || password.equals(null)) {
                Toast.makeText(getContext(), "Data not entered", Toast.LENGTH_SHORT).show();
            } else {
                //writing data in sharedprefernce/stores the data
                SharedPreferences sharedPreferences = getContext().getSharedPreferences("UserDetails", getContext().MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("userPhoneKey", userPhone);
                editor.putString("passwordKey", userPassword);
                editor.commit();
                phone.setText("");
                password.setText("");
                Toast.makeText(getContext(), "Data Stoared sucessful", Toast.LENGTH_SHORT).show();
            }
        }

        return view;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.login) {
            String userPhone = phone.getText().toString();
            String userPassword = password.getText().toString();
            if (userPassword.isEmpty() || userPassword.length() <= 8) {
                password.setError("Must have 9 character");
                password.requestFocus();
            }
            if (userPhone.length() != 11 || userPhone.isEmpty() || !userPhone.startsWith("01")) {
                phone.setError("Must have 11 charecter");
                phone.requestFocus();
            }
            //connect to firebase

//            mAuth.signInWithEmailAndPassword(userPhone, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                    if (task.isSuccessful()) {
//                        Toast.makeText(getContext(), "signIn Successful", Toast.LENGTH_LONG).show();
//                    } else {
//                        Toast.makeText(getContext(), "signIn unsuccesfull", Toast.LENGTH_LONG).show();
//                    }
//                }
//            });
        }
        if (v.getId() == R.id.resister) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment, new ResisterFragment(),"mm").addToBackStack(null).commit();
        }
    }
}
