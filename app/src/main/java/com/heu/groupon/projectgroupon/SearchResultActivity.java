package com.heu.groupon.projectgroupon;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SearchResultActivity extends Activity {
    JSONArray result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
//                    Map<String,String> ms=new HashMap<String,String >();
//                    ms.put("goodname","6");
//        AsyncGetResultTask at=new AsyncGetResultTask();
//        at.execute(ms);
        ArrayList<ResultItemData> rid=new ArrayList<ResultItemData>();
        for(int i=0;i<100;i++)
        {
            ResultItemData tmp=new ResultItemData();


            rid.add(tmp);
        }

        ResultGridAdapter rg=new ResultGridAdapter(SearchResultActivity.this,rid);
        GridView gv=findViewById(R.id.result_grid);
        gv.setAdapter(rg);
    }
    private class AsyncGetResultTask extends AsyncTask<Map<String,String>,Object,Long>
    {
        @Override
        protected Long doInBackground(Map<String, String>[] maps) {
            try {
//                    Map<String,String> ms=new HashMap<String,String >();
//                    ms.put("goodname","6");
                String tmp=NetUtil.doPostString("http://192.168.2.28:8080/ForPDD/GetGoods",maps[0]);
                Log.i("ZX",tmp);
                try {
                    result=new JSONArray(tmp);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Long aLong) {
            ArrayList<ResultItemData> rid=new ArrayList<ResultItemData>();
            for(int i=0;i<result.length();i++)
            {
                ResultItemData tmp=new ResultItemData();
                try {
                    JSONObject tj=result.getJSONObject(i);
                    tmp.name=tj.getString("goodname");
                    tmp.price=Float.parseFloat(tj.getString("teamprice"));
                    //tmp.buycnt= Integer.parseInt(tj.getString("teamprice"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                rid.add(tmp);
            }

            ResultGridAdapter rg=new ResultGridAdapter(SearchResultActivity.this,rid);
            GridView gv=findViewById(R.id.result_grid);
            gv.setAdapter(rg);
        }
    }
}
