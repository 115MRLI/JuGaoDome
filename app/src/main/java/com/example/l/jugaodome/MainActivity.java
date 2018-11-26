package com.example.l.jugaodome;


import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.l.jugaodome.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    //展示的ip地址
    @BindView(R.id.ip_address)
    TextView ipAddress;
    //跳转第二个界面
    @BindView(R.id.jump_main2)
    TextView jumpMain2;
    //获取到的ipd地址
    private String ipadressstr = "";

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
        Log.e("getOperatorName", Utils.getOperatorName(this));
        jumpMain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main2Activity.jumpHere(MainActivity.this);
            }
        });
    }
}
