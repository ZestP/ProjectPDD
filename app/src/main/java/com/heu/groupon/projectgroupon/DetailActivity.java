package com.heu.groupon.projectgroupon;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends Activity {
    TextView mOriginalPrice;
    ViewPager mBigPics;
    ArrayList<View> mBigPicsArr;
    ListView mDetailGroupList;
    ArrayList<DetailGroupData> mDetailGroupData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mOriginalPrice=findViewById(R.id.detail_oriprice);
        mOriginalPrice.setPaintFlags(mOriginalPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        mBigPicsArr=new ArrayList<View>();
        mBigPics=findViewById(R.id.detail_pics);
        LayoutInflater inflater=getLayoutInflater().from(this);
        for(int i=1;i<=3;i++)
        {
            View tmp=inflater.inflate(R.layout.detail_bigpic,mBigPics,false);
            mBigPicsArr.add(tmp);
        }

        mBigPics.setAdapter(new BigPicsAdapter(mBigPicsArr));
        mDetailGroupData=new ArrayList<DetailGroupData>();
        for(int i=1;i<=10;i++)
        {
            mDetailGroupData.add(new DetailGroupData());
        }
        mDetailGroupList=findViewById(R.id.detail_grouplist);
        mDetailGroupList.setAdapter(new DetailGroupAdapter(this,mDetailGroupData));
        setListViewHeightBasedOnChildren(mDetailGroupList);
        findViewById(R.id.detail_announce).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPickupDialog();
            }
        });
    }
    public void showPickupDialog()
    {
        PickupDialog.Builder builder=new PickupDialog.Builder(this,R.style.Dialog_FS);
        PickupDialog dialog=builder.createDialog();
        dialog.show();
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        Window win = dialog.getWindow();
        win.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = win.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = (int)display.getHeight()/2;
        lp.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lp.dimAmount = 0.5f;
        lp.gravity= Gravity.BOTTOM;
        win.setAttributes(lp);
    }
    public void setListViewHeightBasedOnChildren(ListView listView) {

        ListAdapter listAdapter = listView.getAdapter();

        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;

        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();

        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));

        //((ViewGroup.MarginLayoutParams) params).setMargins(10, 10, 10, 10); // 可删除

        listView.setLayoutParams(params);
    }
}