package com.heu.groupon.projectgroupon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeListAdapter extends BaseAdapter {
    ArrayList<HomeListData> mHomeList;
    Context mContext;

    public HomeListAdapter(Context mContext, ArrayList<HomeListData> rid) {
        this.mContext = mContext;
        this.mHomeList = rid;
    }

    @Override
    public int getCount() {
        return mHomeList.size();
    }

    @Override
    public Object getItem(int i) {
        return mHomeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        if (convertView == null) {
            convertView = createView(parent);
        }
        bindViewWithData(position, convertView);
        return convertView;
    }

    public void addItem(HomeListData m) {
        mHomeList.add(m);
    }

    public void removeItem(int position) {
        mHomeList.remove(position);
    }

    private View createView(ViewGroup parent) {
        // TODO Auto-generated method stub
        View convertView;
        HomeListAdapter.ViewHolder vh = new HomeListAdapter.ViewHolder();
        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_home, parent, false);
        convertView.setTag(vh);
        return convertView;
    }

    private void bindViewWithData(int position, View convertView) {
        //com.heu.groupon.projectgroupon.ResultGridAdapter.ViewHolder vh = (com.heu.groupon.projectgroupon.ResultGridAdapter.ViewHolder) convertView.getTag();
        //vh.mName.setText(mResultItemList.get(position).name);

    }

    public class ViewHolder {
        public TextView mPrice, mName, mBuyCnt;
    }
}
