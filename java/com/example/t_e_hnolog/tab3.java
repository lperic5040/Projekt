package com.example.t_e_hnolog;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class tab3 extends Fragment {
    private Api apiOs;
    private Api apiDj;
    private Api apiZu;
    private Api apiVr;
    private Api apiCa;
    private Api apiSlj;
    private TextView tv;
    private TextView tvOs;
    private TextView tvTwo;
    private TextView tvDj;
    private TextView tvThree;
    private TextView tvZu;
    private TextView tvFour;
    private TextView tvVr;
    private TextView tvFive;
    private TextView tvCa;
    private TextView tvSix;
    private TextView tvSlj;


    public tab3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab3, container, false);

        tvOs = (TextView) view.findViewById(R.id.tvOsijek);
        tv =(TextView) view.findViewById(R.id.tvTemp);
        tvDj = (TextView) view.findViewById(R.id.tvĐakovo);
        tvTwo = (TextView) view.findViewById(R.id.tvTempDj);
        tvZu = (TextView) view.findViewById(R.id.tvZupanja);
        tvThree = (TextView) view.findViewById(R.id.tvTempZu);
        tvVr = (TextView) view.findViewById(R.id.tvVrbanja);
        tvFour = (TextView) view.findViewById(R.id.tvTempVr);
        tvCa = (TextView) view.findViewById(R.id.tvCadavica);
        tvFive = (TextView) view.findViewById(R.id.tvTempCa);
        tvSlj = (TextView) view.findViewById(R.id.tvSljivosevci);
        tvSix = (TextView) view.findViewById(R.id.tvTempSlj);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://openweathermap.org/data/2.5/").addConverterFactory(GsonConverterFactory.create()).build();
        apiOs=retrofit.create(Api.class);

        Retrofit retrofittwo = new Retrofit.Builder().baseUrl("https://openweathermap.org/data/2.5/").addConverterFactory(GsonConverterFactory.create()).build();
        apiDj=retrofittwo.create(Api.class);

        Retrofit retrofitthree = new Retrofit.Builder().baseUrl("https://openweathermap.org/data/2.5/").addConverterFactory(GsonConverterFactory.create()).build();
        apiZu=retrofitthree.create(Api.class);

        Retrofit retrofitfour = new Retrofit.Builder().baseUrl("https://openweathermap.org/data/2.5/").addConverterFactory(GsonConverterFactory.create()).build();
        apiVr=retrofitfour.create(Api.class);

        Retrofit retrofitfive = new Retrofit.Builder().baseUrl("https://openweathermap.org/data/2.5/").addConverterFactory(GsonConverterFactory.create()).build();
        apiCa=retrofitfour.create(Api.class);

        Retrofit retrofitsix = new Retrofit.Builder().baseUrl("https://openweathermap.org/data/2.5/").addConverterFactory(GsonConverterFactory.create()).build();
        apiSlj=retrofitfour.create(Api.class);

        getWheaterDetailsOs();
        getWheaterDetailsDj();
        getWheaterDetailsZu();
        getWheaterDetailsVr();
        getWheaterDetailsCa();
        getWheaterDetailsSlj();

        return view;
    }

    public void getWheaterDetailsOs(){
        Call<WheaterDetails> call= apiOs.getWheaterDetails("Osijek", "439d4b804bc8187953eb36d2a8c26a02");

        call.enqueue(new Callback<WheaterDetails>() {
            @Override
            public void onResponse(Call<WheaterDetails> call, Response<WheaterDetails> response) {
                if(!response.isSuccessful()) {
                    tv.setText("Code: " + response.code());
                    return;
                }
                WheaterDetails details = response.body();

                String content="";
                content+="Temperatura: " + details.getMain().getTemp() + " °C";

                tv.setText(content);
            }

            @Override
            public void onFailure(Call<WheaterDetails> call, Throwable t) {
                tv.setText(t.getMessage());
            }
        });
    }

    public void getWheaterDetailsDj(){
        Call<WheaterDetails> call= apiDj.getWheaterDetails("Đakovo", "439d4b804bc8187953eb36d2a8c26a02");

        call.enqueue(new Callback<WheaterDetails>() {
            @Override
            public void onResponse(Call<WheaterDetails> call, Response<WheaterDetails> response) {
                if(!response.isSuccessful()){
                    tvTwo.setText("Code: " + response.code());
                    return;
                }
                WheaterDetails details = response.body();

                String content="";
                content+="Temperatura: " + details.getMain().getTemp() + " °C";

                tvTwo.setText(content);
            }

            @Override
            public void onFailure(Call<WheaterDetails> call, Throwable t) {
                tvTwo.setText(t.getMessage());
            }
        });
    }

    public void getWheaterDetailsZu(){
        Call<WheaterDetails> call= apiZu.getWheaterDetails("Županja", "439d4b804bc8187953eb36d2a8c26a02");

        call.enqueue(new Callback<WheaterDetails>() {
            @Override
            public void onResponse(Call<WheaterDetails> call, Response<WheaterDetails> response) {
                if(!response.isSuccessful()){
                    tvThree.setText("Code: " + response.code());
                    return;
                }
                WheaterDetails details = response.body();

                String content="";
                content+="Temperatura: " + details.getMain().getTemp() + " °C";

                tvThree.setText(content);
            }

            @Override
            public void onFailure(Call<WheaterDetails> call, Throwable t) {
                tvThree.setText(t.getMessage());
            }
        });
    }

    public void getWheaterDetailsVr(){
        Call<WheaterDetails> call= apiVr.getWheaterDetails("Vrbanja", "439d4b804bc8187953eb36d2a8c26a02");

        call.enqueue(new Callback<WheaterDetails>() {
            @Override
            public void onResponse(Call<WheaterDetails> call, Response<WheaterDetails> response) {
                if(!response.isSuccessful()){
                    tvFour.setText("Code: " + response.code());
                    return;
                }
                WheaterDetails details = response.body();

                String content="";
                content+="Temperatura: " + details.getMain().getTemp() + " °C";

                tvFour.setText(content);
            }

            @Override
            public void onFailure(Call<WheaterDetails> call, Throwable t) {
                tvFour.setText(t.getMessage());
            }
        });
    }

    public void getWheaterDetailsCa(){
        Call<WheaterDetails> call= apiCa.getWheaterDetails("Čađavica", "439d4b804bc8187953eb36d2a8c26a02");

        call.enqueue(new Callback<WheaterDetails>() {
            @Override
            public void onResponse(Call<WheaterDetails> call, Response<WheaterDetails> response) {
                if(!response.isSuccessful()) {
                    tvFive.setText("Code: " + response.code());
                    return;
                }
                WheaterDetails details = response.body();

                String content="";
                content+="Temperatura: " + details.getMain().getTemp() + " °C";

                tvFive.setText(content);
            }

            @Override
            public void onFailure(Call<WheaterDetails> call, Throwable t) {
                tvFive.setText(t.getMessage());
            }
        });
    }

    public void getWheaterDetailsSlj(){
        Call<WheaterDetails> call= apiSlj.getWheaterDetails("Šljivoševci", "439d4b804bc8187953eb36d2a8c26a02");

        call.enqueue(new Callback<WheaterDetails>() {
            @Override
            public void onResponse(Call<WheaterDetails> call, Response<WheaterDetails> response) {
                if(!response.isSuccessful()) {
                    tvSix.setText("Code: " + response.code());
                    return;
                }
                WheaterDetails details = response.body();

                String content="";
                content+="Temperatura: " + details.getMain().getTemp() + " °C";

                tvSix.setText(content);
            }

            @Override
            public void onFailure(Call<WheaterDetails> call, Throwable t) {
                tvSix.setText(t.getMessage());
            }
        });
    }
}
