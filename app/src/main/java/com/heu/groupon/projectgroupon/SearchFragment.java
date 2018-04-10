package com.heu.groupon.projectgroupon;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SearchFragment extends Fragment {
    View mView;
    EditText mSearchEdit;
    Context mContext;
    public SearchFragment()
    {}
    public SearchFragment(Context con)
    {
        mContext=con;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_search, container, false);
        InitView();
        return mView;
    }
    protected void InitView()
    {
        mSearchEdit=mView.findViewById(R.id.search_input);
        mSearchEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i == EditorInfo.IME_ACTION_SEARCH) {

                    Toast.makeText(mContext, "Search", Toast.LENGTH_SHORT).show();
                    // search pressed and perform your functionality.
                }
                if(!mSearchEdit.getText().equals(""))
                {
                    Intent myintent = new Intent();
                    myintent.setClass(mContext, SearchResultActivity.class);
                    startActivity(myintent);
                }
                return false;
            }
        });
    }
}
