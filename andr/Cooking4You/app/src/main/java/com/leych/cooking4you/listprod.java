package com.leych.cooking4you;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.leych.cooking4you.entity.Ingridient;
import com.leych.cooking4you.retrofit.IngridientOps;
import com.leych.cooking4you.retrofit.RetrofitFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.id.list;

public class listprod extends AppCompatActivity {




    ListView list;
    public String prodName;
    private static IngridientOps ingridientOps;
    private ArrayList<HashMap<String ,Object>> products;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listprod);
        products = new ArrayList<HashMap<String, Object>>();
        list=(ListView)findViewById(R.id.list);
        ingridientOps = RetrofitFactory.getIngridientOps();
        ingridientOps.getAll().enqueue(new Callback<List<Ingridient>>() {
            @Override
            public void onResponse(Call<List<Ingridient>> call, Response<List<Ingridient>> response) {
                if (response.body() != null) {

                    for (int i = 0; i < response.body().size(); i++) {
                        HashMap<String, Object> hm;

                        hm = new HashMap<String, Object>();
                        hm.put(prodName, response.body().get(i).getName());

                        products.add(hm);




                        SimpleAdapter adapter = new SimpleAdapter(listprod.this, products, R.layout.item,
                                new String[]{prodName}, new int[]{R.id.text});

                        list.setAdapter(adapter);
                        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);


                    }

                }

            }
            @Override
            public void onFailure(Call<List<Ingridient>> call, Throwable t) {

            }
        });
    }

}
