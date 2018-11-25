package com.example.l.jugaodome.http.response;

import com.example.l.jugaodome.http.api.JuGaoApi;
import com.example.l.jugaodome.http.api.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * 聚告请求网络控制器
 */
public class JuGaoModel {
    private JuGaoApi JuGaoApi;

    public JuGaoModel() {
        ServiceGenerator.changeApiBaseUrl("http://app-test.adinall.com/");//测试环境
//        ServiceGenerator.changeApiBaseUrl("http://app.adinall.com/");//生产环境
        JuGaoApi = ServiceGenerator.createServiceFrom(JuGaoApi.class);
    }
    public <T> void requestAdvertisement(int partner_id, int user_id, String token, Callback<T> callback) {

        Call<T> call = (Call<T>) JuGaoApi.requestAdvertisement("", "", 0, 0,"","","",0,"","",0,0,"","","","",0,0);
        call.enqueue(callback);
    }
}
