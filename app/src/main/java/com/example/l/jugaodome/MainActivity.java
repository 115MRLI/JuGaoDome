package com.example.l.jugaodome;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    //次数
    @BindView(R.id.number)
    EditText number;
    //总次数
    @BindView(R.id.all)
    TextView all;
    //成功次数
    @BindView(R.id.success_number)
    TextView successNumber;
    //一次运行多少ci
    @BindView(R.id.once_number)
    EditText onceNumber;
    //间隔时间
    @BindView(R.id.once_time)
    EditText onceTime;
    //一个ip运行几次
    @BindView(R.id.ip_number)
    EditText ipNumber;
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
        number.setText("40");
        onceNumber.setText("20");
        onceTime.setText("30");
        ipNumber.setText("10");
        Log.e("getOperatorName", Utils.getOperatorName(this)+"            "+android.os.Build.MODEL+"          "+ android.os.Build.MANUFACTURER);
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
                    presenter.requestAdvertisement("com.jieanda.quanguossgjcx", Utils.changeURLEncoding("全国公交查询"), Utils.changeURLEncoding(Utils.getUserAgent(MainActivity.this)), "1.1.0", ipadressstr, " MI 8 SE", "Xiaomi                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      ", Utils.getIMEI(MainActivity.this), 720, 1280);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
