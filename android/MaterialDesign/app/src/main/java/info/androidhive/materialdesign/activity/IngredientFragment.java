package info.androidhive.materialdesign.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import entity.Ingredient;
import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.retrofit.IngredientOps;
import info.androidhive.materialdesign.retrofit.RetrofitFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class IngredientFragment extends Fragment {

    ListView list;
    public String prodName;
    private static IngredientOps ingridientOps;
    private ArrayList<HashMap<String ,Object>> products;
    public String[] arr;








    public IngredientFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ingredient, container, false);
     list = (ListView)rootView.findViewById(R.id.list);
        products = new ArrayList<HashMap<String, Object>>();
        ingridientOps = RetrofitFactory.getIngridientOps();
        ingridientOps.getAll().enqueue(new Callback<List<Ingredient>>() {
            @Override
            public void onResponse(Call<List<Ingredient>> call, Response<List<Ingredient>> response) {
                if (response.body() != null) {
                    arr=new String[response.body().size()];

                    for (int i = 0; i < response.body().size(); i++) {
                       /* HashMap<String, Object> hm;

                        hm = new HashMap<String, Object>();
                        hm.put(prodName, response.body().get(i).getName());
                        products.add(hm);*/
                        arr[i]=response.body().get(i).getName();
                        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_multiple_choice,arr);

                       // SimpleAdapter adapter = new SimpleAdapter(getActivity(), products, R.layout.item, new String[]{prodName}, new int[]{R.id.text});

                       list.setAdapter(adapter1);
                        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

                    }

                }

            }



            @Override
            public void onFailure(Call<List<Ingredient>> call, Throwable t) {
                Log.e("ERROR", Log.getStackTraceString(t));
            }
        });



        ////////////////////////////





        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
