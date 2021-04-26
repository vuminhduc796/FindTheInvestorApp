package com.example.findtheinvestorapp.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.example.findtheinvestorapp.R;
import com.example.findtheinvestorapp.controller.fragment.BusinessFragment;
import com.example.findtheinvestorapp.controller.fragment.InvestorFragment;
import com.example.findtheinvestorapp.controller.fragment.MoreFragment;
import com.example.findtheinvestorapp.controller.fragment.ProposalFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {



    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature ( Window.FEATURE_NO_TITLE );
        getWindow ().setFlags ( WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );

        setContentView(R.layout.activity_main);


        //bottomNavigationView = findViewById ( R.id.bottomNavigationView );
        frameLayout = findViewById ( R.id.frameLayoutId );

        setFragment(new BusinessFragment());

/*        bottomNavigationView.setOnNavigationItemSelectedListener ( new BottomNavigationView.OnNavigationItemSelectedListener ( ) {
            @Override
            public boolean onNavigationItemSelected ( @NonNull MenuItem item ) {

                switch (item.getItemId ()){
                    case R.id.businessId:
                        setFragment(new BusinessFragment ());
                        return true;

                    case R.id. personId:
                        setFragment(new InvestorFragment ());
                        return true;

                    case R.id.moreId:
                        setFragment(new MoreFragment ());
                        return true;

                    default:
                        return false;
                }




            }
        } );
*/
        drawerLayout = findViewById ( R.id.drawerLayout );
        navigationView = findViewById ( R.id.navigation_drawer_view );
        toggle = new ActionBarDrawerToggle ( this, drawerLayout, R.string.start, R.string.close );

        drawerLayout.addDrawerListener ( toggle );
        toggle.syncState ();

        Objects.requireNonNull ( getSupportActionBar ( ) ).setDisplayHomeAsUpEnabled ( true );

        navigationView.setNavigationItemSelectedListener ( this );




    }

    private void setFragment ( Fragment fragment ) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager ().beginTransaction ();
        fragmentTransaction.replace ( R.id.frameLayoutId,fragment );
        fragmentTransaction.commit ();
    }

    @Override
    public boolean onOptionsItemSelected ( @NonNull MenuItem item ) {
        if(toggle.onOptionsItemSelected ( item )){
        return true;
    }
    return true;
    }

    @Override
    public boolean onNavigationItemSelected ( @NonNull MenuItem item ) {
        switch (item.getItemId ()) {
            case R.id.navigation_businessId:
                setFragment(new BusinessFragment ());
                break;
            case R.id.navigation_investorId:
                setFragment(new InvestorFragment());
                break;
            case R.id.navigation_moreId:
                setFragment(new MoreFragment());
                break;
            case R.id.navigation_proposalId:
                setFragment(new ProposalFragment());
                break;

        }
        return true;
    }
}