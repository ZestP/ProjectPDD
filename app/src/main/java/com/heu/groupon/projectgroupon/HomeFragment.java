package com.heu.groupon.projectgroupon;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    HorizontalListView hListView;
    HorizontalListViewAdapter hListViewAdapter;
    ImageView previewImg;
    View olderSelectView = null,olderSelected=null;
    View v;
    Context mContext;
    public HomeFragment(){}
    public HomeFragment(Context con)
    {
        mContext=con;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_home, container, false);
        initUI();
        initHomeList();
        return v;
    }
    public void initUI(){
        hListView = (HorizontalListView)v.findViewById(R.id.home_horizontal);
        String[] titles = {"首页", "服饰", "鞋包", "母婴", "百货", "食品", "服饰", "鞋包", "母婴", "百货", "食品"};

        hListViewAdapter = new HorizontalListViewAdapter(mContext,titles);
        hListView.setAdapter(hListViewAdapter);
              hListView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                  @Override
                  public void onItemSelected(AdapterView<?> parent, View view,
                          int position, long id) {
                      // TODO Auto-generated method stub
                      if(olderSelected != null){
                          olderSelected.setSelected(false); //上一个选中的View恢复原背景
                      }
                      olderSelected = view;
                      view.setSelected(true);
                  }

                  @Override
                  public void onNothingSelected(AdapterView<?> parent) {
                      // TODO Auto-generated method stub

                  }
              });
        hListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
              if(olderSelectView == null){
                  olderSelectView = view;
              }else{
                  olderSelectView.setSelected(false);
                  olderSelectView = null;
              }
              olderSelectView = view;
              view.setSelected(true);
                hListViewAdapter.setSelectIndex(position);
                hListViewAdapter.notifyDataSetChanged();

            }
        });

    }
    public void initHomeList()
    {
        ArrayList<HomeListData> rid=new ArrayList<HomeListData>();
        for(int i=0;i<100;i++)
        {
            rid.add(new HomeListData());
        }

        HomeListAdapter rg=new HomeListAdapter(mContext,rid);
        ListView lv=v.findViewById(R.id.home_list);
        lv.setAdapter(rg);
    }
}
