package com.example.bottommenu;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;


public class loginFrag extends Fragment {
    TextInputEditText txtUser, txtPass;
    Button btnLogin;
    private FirebaseAuth mAuth ;

    public loginFrag() {

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mAuth= FirebaseAuth.getInstance();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        txtUser = view.findViewById(R.id.et_name);
        txtPass = view.findViewById(R.id.et_pass);
        btnLogin = view.findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkEmailPass();
            }
        });
        return view;
    }
    @SuppressLint("SuspiciousIndentation")
    private void checkEmailPass(){
        String email , password ;
        email=txtUser.getText().toString();
        password=txtPass.getText().toString();
        if (email!=""|| password!=""){
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                   if (task.isSuccessful()){
                       Toast.makeText(getActivity(),"login successfull",Toast.LENGTH_SHORT).show();
                       MainActivity.homeFrame.setVisibility(View.VISIBLE);
                       MainActivity.dashFrame.setVisibility(View.INVISIBLE);
                       MainActivity.loginFrame.setVisibility(View.INVISIBLE);
                       MainActivity.signinFrame.setVisibility(View.INVISIBLE);
                       MainActivity.isLog=true;
                       txtUser.setText("");
                       txtPass.setText("");

                   }
                }
            });

        }
        else
        Toast.makeText(getActivity(),"please fill in fields",Toast.LENGTH_SHORT).show();
    }
}