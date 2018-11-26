package com.example.l.jugaodome;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.l.jugaodome.base.BaseActivity;
import com.example.l.jugaodome.presenter.MainPresenter;
import com.example.l.jugaodome.presenter.impl.MainPresenterImpl;

import java.io.UnsupportedEncodingException;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainView {
    //展示的ip地址
    @BindView(R.id.ip_address)
    TextView ipAddress;
    //跳转第二个界面
    @BindView(R.id.jump_main2)
    TextView jumpMain2;
    //开始请求
    @BindView(R.id.start)
    Button start;
    //获取到的ipd地址
    private String ipadressstr = "";
    private MainPresenter presenter;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        presenter = new MainPresenterImpl();
        presenter.attachView(this);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        ipadressstr = Utils.getIP(this);
        ipAddress.setText(ipadressstr);
        Log.e("getOperatorName", Utils.getOperatorName(this));
        jumpMain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main2Activity.jumpHere(MainActivity.this);
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    presenter.requestAdvertisement("com.jieanda.quanguossgjcx", Utils.changeURLEncoding("全国公交查询"), Utils.changeURLEncoding(Utils.getUserAgent(MainActivity.this)), "1.1.0", ipadressstr, "nokia", "n70", Utils.getIMEI(MainActivity.this), 720, 1280);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
