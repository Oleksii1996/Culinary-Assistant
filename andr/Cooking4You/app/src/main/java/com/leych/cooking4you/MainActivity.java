package com.leych.cooking4you;

        import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
        import android.widget.ListView;
        import android.widget.SimpleAdapter;

        import com.leych.cooking4you.entity.Ingridient;
        import com.leych.cooking4you.retrofit.IngridientOps;
        import com.leych.cooking4you.retrofit.RetrofitFactory;

        import org.json.JSONArray;
        import org.json.JSONObject;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

        import static android.R.id.list;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.TabLayout);
        tabLayout.setupWithViewPager(viewPager);


    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1(), "В холодильнике");
        adapter.addFragment(new Tab2(), "Кулинарная книга");
        //adapter.addFragment(new PeopleFragment(), "Calls");
        viewPager.setAdapter(adapter);
    }





   void addprod(View view)
   {

                   Intent intent = new Intent(MainActivity.this, listprod.class);
                   startActivity(intent);


   }

    }
