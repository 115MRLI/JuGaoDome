package com.example.l.jugaodome.presenter.impl;

import android.util.Log;
import android.widget.Toast;

import com.example.l.jugaodome.MainView;
import com.example.l.jugaodome.ResponseData;
import com.example.l.jugaodome.Utils;
import com.example.l.jugaodome.app.App;
import com.example.l.jugaodome.http.response.JuGaoModel;
import com.example.l.jugaodome.presenter.MainPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenterImpl<T extends MainView> implements MainPresenter<T> {
    private T baseView;
    private JuGaoModel model;
    private boolean isStrart = true;

    public MainPresenterImpl() {
        model = new JuGaoModel();
    }

    @Override
    public void requestAdvertisement(String pkgname, String appname, String ua, String appv, String ip, String brand, String models, String uuid, int pw, int ph) {
        if (isStrart == false) {
            return;
        }
        if (Utils.isNetConnected(App.getmContext())) {
            model.requestAdvertisement(pkgname, appname, ua, appv, ip, brand, models, uuid, pw, ph, new Callback<ResponseData>() {

                @Override
                public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                    Log.e("Response", response.toString());
                }

                @Override
                public void onFailure(Call<ResponseData> call, Throwable t) {

                }
            });

        } else {
            Toast.makeText(App.getmContext(), "请检查网络连接", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void stopOrStart(boolean isStar) {
        this.isStrart = isStar;
    }

    @Override
    public void attachView(T baseView) {
        this.baseView = baseView;
    }

    @Override
    public void detachView() {
        baseView = null;
    }
}
