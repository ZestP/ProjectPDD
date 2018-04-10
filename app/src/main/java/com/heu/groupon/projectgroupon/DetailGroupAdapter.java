package com.heu.groupon.projectgroupon;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zest on 2018/3/28.
 */

public class DetailGroupAdapter extends BaseAdapter {
    ArrayList<DetailGroupData> mDetailGroupList;
    Context mContext;

    public DetailGroupAdapter(Context mContext, ArrayList<DetailGroupData> rid) {
        this.mContext = mContext;
        this.mDetailGroupList = rid;
    }

    @Override
    public int getCount() {
        return mDetailGroupList.size();
    }

    @Override
    public Object getItem(int i) {
        return mDetailGroupList.get(i);
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

    public void addItem(DetailGroupData m) {
        mDetailGroupList.add(m);
    }

    public void removeItem(int position) {
        mDetailGroupList.remove(position);
    }

    private View createView(ViewGroup parent) {
        // TODO Auto-generated method stub
        View convertView;
        com.heu.groupon.projectgroupon.DetailGroupAdapter.ViewHolder vh = new com.heu.groupon.projectgroupon.DetailGroupAdapter.ViewHolder();
        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_group, parent, false);
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
