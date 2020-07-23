package com.example.fragmentinsidefragmentpractice.authorizationAndAuthentication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.fragmentinsidefragmentpractice.R;
import com.example.fragmentinsidefragmentpractice.view.DashBoardFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResisterFragment extends Fragment implements View.OnClickListener {
    View view;
    EditText name, phone, location, email, password;
    CheckBox checkBox;
    Button signUp;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    public ResisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_resister, container, false);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Please Wait...");
        progressDialog.setCanceledOnTouchOutside(false);
        findAll();
        signUp.setOnClickListener(this);


        return view;
    }

    private void findAll() {
        name = (EditText) view.findViewById(R.id.name);
        phone =(EditText) view.findViewById(R.id.phone);
        location = (EditText)view.findViewById(R.id.location);
        checkBox = view.findViewById(R.id.saveLoginCheckBox);
        signUp = view.findViewById(R.id.signupBtn);
        email =(EditText) view.findViewById(R.id.emailEt);
        password = (EditText)view.findViewById(R.id.passwordEt);
    }


    String userName, userPhone, userEmail, userPassword, userLocation;

    @Override
    public void onClick(View v) {
        userName = name.getText().toString().trim();
        userPhone = phone.getText().toString().trim();
        userEmail = email.getText().toString().trim();
        userPassword = password.getText().toString();
        userLocation = location.getText().toString().trim();
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
            if (location.getText().toString().trim().isEmpty()) {
                location.setError("location mandatory");
                location.requestFocus();
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
                email.setError("Invalid Email");
                email.requestFocus();
                return;
            }
            authorizeUser();

        }
    }

    private void authorizeUser() {
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(getContext(), "User Sign up successful", Toast.LENGTH_SHORT).show();
                        noteUserData();
                    }
                });
    }


    private void noteUserData() {
        progressDialog.setMessage("saving user account info..");
        progressDialog.show();
        final String timestamp = "" + System.currentTimeMillis();
        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("uid", firebaseAuth.getUid());
        hashMap.put("timestamp", "" + timestamp);
        hashMap.put("accountType", "" + "User");
        hashMap.put("online", "" + "true");
        hashMap.put("name", userName);
        hashMap.put("phone", userPhone);
        hashMap.put("email", userEmail);
        hashMap.put("location", userLocation);


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
        reference.child(firebaseAuth.getUid()).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), "Save Data", Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(getContext(), DashBoardFragment.class));//got to da
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), "" + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
//    private void saveData() {
//        String key = databaseReference.push().getKey();
//        if (checkBox.isChecked()) {
//            if (invitationCode.getText().toString().equals(null)) {
//                databaseReference.child(key).setValue(new UserPojo(name.getText().toString(), phone.getText().toString()));
////                OTPAuth();
//            } else if (!invitationCode.getText().toString().equals(null)) {
//                databaseReference.child(key).setValue(new UserPojo(name.getText().toString(), phone.getText().toString(), invitationCode.getText().toString()));
////                OTPAuth();
//            }
//            Toast.makeText(getContext(), "data added", Toast.LENGTH_LONG).show();
//            //after all check
//            FragmentTransaction transaction = getFragmentManager().beginTransaction()
//                    .setCustomAnimations(UseUtil.changeFragmentAnimation1st, UseUtil.changeFragmentAnimation2nd, UseUtil.changeFragmentAnimation3rd, UseUtil.changeFragmentAnimation4th);
//            transaction.replace(R.id.fragment, new SetOTPcodeAndPassword(), "kkkkkk").addToBackStack(null).commit();
//
//        } else if (!checkBox.isChecked()) {
//            Toast.makeText(getContext(), "Please agree with our trams and conditions", Toast.LENGTH_SHORT).show();
//        }
//    }

}
