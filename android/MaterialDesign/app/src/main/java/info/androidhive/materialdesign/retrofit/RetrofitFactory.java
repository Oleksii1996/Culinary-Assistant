package info.androidhive.materialdesign.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by leych on 15.02.2017.
 */

public class RetrofitFactory {

        public static final String BASE_ADDRESS = "https://lit-reaches-17435.herokuapp.com/";

        public static IngredientOps getIngridientOps(){
            Retrofit.Builder retrofiBuilder = new Retrofit.Builder();
            retrofiBuilder.baseUrl(BASE_ADDRESS);
            retrofiBuilder.addConverterFactory(GsonConverterFactory.create());
            Retrofit retrofit = retrofiBuilder.build();

            return retrofit.create(IngredientOps.class);
        }
    }

