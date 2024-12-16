package com.example.bottommenu;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    public static ImageView loginFrame;
    private homeFrag homeFrag ;
    private dashFrag dashFrag ;
    private loginFrag loginFrag ;
    private BottomNavigationView bottomNavigationView ;
    public static FrameLayout homeFrame , dashFrame ,loginFrame,signinFrame ;
    public static boolean isLog=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeFrame=findViewById(R.id.home_frame);
        dashFrame=findViewById(R.id.dash_frame);
        loginFrame=findViewById(R.id.login_frame);
        signinFrame=findViewById(R.id.signin_frame);
        bottomNavigationView=findViewById(R.id.bottom_naigation);
        begin();
    }
    private void begin(){
        homeFrag= new homeFrag();
        dashFrag= new dashFrag();
        loginFrag=new loginFrag();
        getSupportFragmentManager().beginTransaction().replace(R.id.home_frame,homeFrag).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.dash_frame,dashFrag).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.login_frame,loginFrag).commit();
        dashFrame.setVisibility(View.INVISIBLE);
        loginFrame.setVisibility(View.INVISIBLE);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home&&isLog) {
                    homeFrame.setVisibility(View.VISIBLE);
                    dashFrame.setVisibility(View.INVISIBLE);
                    loginFrame.setVisibility(View.INVISIBLE);

                }
                if (item.getItemId() == R.id.dashbord&&isLog) {
                    homeFrame.setVisibility(View.INVISIBLE);
                    dashFrame.setVisibility(View.VISIBLE);
                    loginFrame.setVisibility(View.INVISIBLE)
                    ;

                }
                if (item.getItemId() == R.id.login&&!(isLog)) {
                    homeFrame.setVisibility(View.INVISIBLE);
                    dashFrame.setVisibility(View.INVISIBLE);
                    loginFrame.setVisibility(View.VISIBLE);

                }
                return true;
            }
        });

    }
}