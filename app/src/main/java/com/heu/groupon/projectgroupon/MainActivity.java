package com.heu.groupon.projectgroupon;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView mBottomHome,mBottomSearch,mBottomMe;
    private HomeFragment mHome;
    private SearchFragment mSearch;
    private MyFragment mMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitRef();
        InitBtns();
        InitFrags();

    }
    protected void InitRef()
    {
        mBottomHome=findViewById(R.id.main_bottombar_btnhome);
        mBottomSearch=findViewById(R.id.main_bottombar_btsearch);
        mBottomMe=findViewById(R.id.main_bottombar_btnme);
    }
    protected void InitBtns()
    {
        mBottomHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(mHome);
            }
        });
        mBottomSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(mSearch);
            }
        });
        mBottomMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(mMy);
            }
        });
    }
    protected void InitFrags()
    {
        mHome=new HomeFragment(this);
        mSearch=new SearchFragment(this);
        mMy=new MyFragment();
        setFragment(mHome);
    }
    protected void setFragment(Fragment frag)
    {
         FragmentManager fm = getFragmentManager();
         FragmentTransaction transaction = fm.beginTransaction();
         transaction.replace(R.id.main_frame, frag);
         transaction.commit();
    }

}
