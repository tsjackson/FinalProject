package com.example.finalproject.View;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalproject.Model.ApiInterface;
import com.example.finalproject.Model.HearthstoneCardPojo;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CustomViewModel extends ViewModel {
    private static final String TAG = "CustomViewModel";
    private static final String BASE_API_URL = "https://omgvamp-hearthstone-v1.p.rapidapi.com/";
    private OkHttpClient client = new OkHttpClient();

    public LiveData<HearthstoneCardPojo> initRetrofit(Context context) {
        MutableLiveData<HearthstoneCardPojo> dataSetCards = new MutableLiveData<>();
        /*
        client.interceptors().add(chain -> {
            Request request = chain.request();
            request = request.newBuilder()
                    .addHeader("X-RapidAPI-Host", "omgvamp-hearthstone-v1.p.rapidapi.com")
                    .addHeader("X-RapidAPI-Key", "1e21567609mshacbe7fce23662c6p15b71djsn2464b632c33c")
                    .build();

            Response response = chain.proceed(request);
            return response;
        });
        */
        long cacheSize = (5 * 1024 * 1024);
        Cache myCache = new Cache(context.getCacheDir(), cacheSize);
        client = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS).cache(myCache)
                .cache(myCache)
                .addInterceptor((Interceptor) chain -> {
                    Request request = chain.request();
                    if (hasNetwork(context))
                        request = request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build();
                    else
                        request = request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build();
                    return chain.proceed(request);
                })

                .build();
        new Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface.class)
                .getCards()
                .enqueue(new Callback<HearthstoneCardPojo>() {
                            @Override
                            public void onResponse(Call<HearthstoneCardPojo> call,
                                                   retrofit2.Response<HearthstoneCardPojo> response) {
                                if (response.body() != null)
                                    dataSetCards.setValue(response.body());
                                else
                                    Log.e(TAG, "onResponse: No body on response");
                            }

                            @Override
                            public void onFailure(Call<HearthstoneCardPojo> call, Throwable t) {
                                Log.e(TAG, "onFailure: " + t.getMessage());
                            }
                        });
        return dataSetCards;
    }

    private boolean hasNetwork(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
