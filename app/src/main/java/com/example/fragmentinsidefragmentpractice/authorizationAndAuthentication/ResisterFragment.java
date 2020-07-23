package com.example.fragmentinsidefragmentpractice.authorizationAndAuthentication;

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
import android.widget.Toast;

import com.example.fragmentinsidefragmentpractice.OTP.SetOTPcodeAndPassword;
import com.example.fragmentinsidefragmentpractice.R;
import com.example.fragmentinsidefragmentpractice.model.UserPojo;
import com.example.fragmentinsidefragmentpractice.util.UseUtil;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResisterFragment extends Fragment implements View.OnClickListener {
    View view;
    EditText name, phone, invitationCode;
    CheckBox checkBox;
    Button signUp;
    DatabaseReference databaseReference;
    String code;
    public ResisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_resister, container, false);
        databaseReference = FirebaseDatabase.getInstance().getReference("user");
        findAll();
        signUp.setOnClickListener(this);


        return view;
    }

    private void findAll() {
        name = view.findViewById(R.id.name);
        phone = view.findViewById(R.id.phone);
        invitationCode = view.findViewById(R.id.invitationCode);
        checkBox = view.findViewById(R.id.saveLoginCheckBox);
        signUp = view.findViewById(R.id.signupBtn);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.signupBtn) {
            if (name.getText().toString().isEmpty()) {
                name.setError("Name is empty");
                name.requestFocus();
                return;
            }
            if (phone.getText().toString().isEmpty()) {
                phone.setError("Invalid Number");
                phone.requestFocus();
                return;
            }
            if (!phone.getText().toString().startsWith("01")) {
                phone.setError("make sure number start with 01");
            }
            saveData();

        }
    }

    private void saveData() {
        String key = databaseReference.push().getKey();
        if (checkBox.isChecked()) {
            if (invitationCode.getText().toString().equals(null)) {
                databaseReference.child(key).setValue(new UserPojo(name.getText().toString(), phone.getText().toString()));
//                OTPAuth();
            } else if (!invitationCode.getText().toString().equals(null)) {
                databaseReference.child(key).setValue(new UserPojo(name.getText().toString(), phone.getText().toString(), invitationCode.getText().toString()));
//                OTPAuth();
            }
            Toast.makeText(getContext(), "data added", Toast.LENGTH_LONG).show();
            //after all check
            FragmentTransaction transaction = getFragmentManager().beginTransaction()
                    .setCustomAnimations(UseUtil.changeFragmentAnimation1st, UseUtil.changeFragmentAnimation2nd, UseUtil.changeFragmentAnimation3rd, UseUtil.changeFragmentAnimation4th);
            transaction.replace(R.id.fragment, new SetOTPcodeAndPassword(), "kkkkkk").addToBackStack(null).commit();

        } else if (!checkBox.isChecked()) {
            Toast.makeText(getContext(), "Please agree with our trams and conditions", Toast.LENGTH_SHORT).show();
        }
    }

//    private void OTPAuth() {
//        PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                "+88" + phone.getText().toString().trim(),// Phone number to verify
//                60,                 // Timeout duration
//                TimeUnit.SECONDS,   // Unit of timeout
//                this,               // Activity (for callback binding)
//                mCallbacks);        // OnVerificationStateChangedCallbacks
//
//    }
//    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//        @Override
//        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
//            code = phoneAuthCredential.getSmsCode();
//            if (code != null) {
//                verifyET.setText(code);
//                verify(code);
//            }}
//
//        }

    }
