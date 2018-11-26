package com.example.l.jugaodome;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.l.jugaodome.base.BaseActivity;

import butterknife.BindView;


public class Main2Activity extends BaseActivity {
    @BindView(R.id.search_frame)
    FrameLayout searchFrame;

    @BindView(R.id.btn1)
    LinearLayout btn1;

    @BindView(R.id.btn2)
    LinearLayout btn2;

    @BindView(R.id.view1)
    View view1;

    @BindView(R.id.view2)
    View view2;

    @Override
    protected int getLayout() {
        return R.layout.activity_main2;
    }


    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {
        super.initEvent();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1.setBackgroundColor(Color.parseColor("#FF4081"));
                view2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                getSupportFragmentManager().beginTransaction().replace(R.id.search_frame,new FragmentOne()).commit();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view2.setBackgroundColor(Color.parseColor("#FF4081"));
                view1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                getSupportFragmentManager().beginTransaction().replace(R.id.search_frame,new FragmentOne()).commit();
            }
        });
    }

    /**
     * 跳转到本页面
     *
     * @param activity
     */
    public static void jumpHere(Activity activity) {
        activity.startActivity(new Intent(activity, Main2Activity.class));
    }
}
