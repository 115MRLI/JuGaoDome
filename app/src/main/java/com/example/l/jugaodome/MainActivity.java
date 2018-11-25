package com.example.l.jugaodome;


import android.widget.TextView;

import com.example.l.jugaodome.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    //展示的ip地址
    @BindView(R.id.ip_address)
    TextView ipAddress;

    //获取到的ipd地址
    private  String ipadressstr = "";
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        ipadressstr = Utils.getIP(this);
        ipAddress.setText(ipadressstr);
    }
}
