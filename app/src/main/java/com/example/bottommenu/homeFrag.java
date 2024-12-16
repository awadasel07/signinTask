package com.example.bottommenu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;


public class homeFrag extends Fragment {
   private ExtendedFloatingActionButton btn_logout;
   private Button showProducts;

    public homeFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_home, container, false);
       btn_logout=view.findViewById(R.id.btn_logout);
       showProducts=view.findViewById(R.id.btnProduct);
       showProducts.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(getActivity(),ProductActivity.class);
               getActivity().finish();
           }
       });
       btn_logout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               LogOut();
           }
       });
       return view;
    }
    public void LogOut(){
        FirebaseAuth.getInstance().signOut();
        MainActivity.isLog=false;
        MainActivity.homeFrame.setVisibility(View.INVISIBLE);
        MainActivity.dashFrame.setVisibility(View.INVISIBLE);
        MainActivity.loginFrame.setVisibility(View.VISIBLE);

    }
}