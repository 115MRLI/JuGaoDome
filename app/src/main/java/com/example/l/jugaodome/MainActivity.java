package com.example.l.jugaodome;


import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.l.jugaodome.app.App;
import com.example.l.jugaodome.base.BaseActivity;
import com.example.l.jugaodome.popupwindow.CommonPopupWindow;
import com.example.l.jugaodome.presenter.MainPresenter;
import com.example.l.jugaodome.presenter.impl.MainPresenterImpl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainView, CommonPopupWindow.ViewInterface {
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
    //弹出广告频率
    @BindView(R.id.a_number)
    EditText aNumber;
    //弹出广告频率
    @BindView(R.id.b_number)
    EditText bNumber;
    //弹出广告展示时间
    @BindView(R.id.show_time)
    EditText showTime;
    @BindView(R.id.top)
    LinearLayout top;

    //获取到的ipd地址
    private String ipadressstr = "";

    private MainPresenter presenter;
    //是否停止请求
    private boolean isStart = true;
    //要请求的app包名加名字集合
    private List<AppPack> appPacks = new ArrayList<>();

    //请求总次数与成功次数
    private int resNumber = 0, successNum = 0;
    //广告展示
    private CommonPopupWindow popupWindow;
    //展示内容
    private String contexturl;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        presenter = new MainPresenterImpl();
        presenter.attachView(this);
        appPacks.add(new AppPack("全国公交查询", "com.jieanda.quanguossgjcx"));
        appPacks.add(new AppPack("聊天学英语", "com.jieanda.liaotianxyy"));
        appPacks.add(new AppPack("母婴护理大全", "com.jieanda.muyinghldq"));
        appPacks.add(new AppPack("自选壁纸", "com.jieanda.bizhika"));
        appPacks.add(new AppPack("安达录音机", "com.xiaoqiaoluyinji"));
        appPacks.add(new AppPack("记忆拼图", "com.jiyipintu"));
        appPacks.add(new AppPack("安达测距", "com.cejuyi"));
        appPacks.add(new AppPack("指南针", "com.nantaihang"));
        appPacks.add(new AppPack("翻译官", "com.fanyiguan"));
        appPacks.add(new AppPack("开平-有声听书", "com.jieanda.yutingshucheng"));
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
        aNumber.setText("0");
        bNumber.setText("200");
        showTime.setText("6");
        Log.e("getOperatorName", Utils.getOperatorName(this) + "            " + android.os.Build.MODEL + "          " + android.os.Build.MANUFACTURER);
        jumpMain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main2Activity.jumpHere(MainActivity.this);
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStart) {
                    start.setText("停止");
                    presenter.stopOrStart(isStart);
                    isStart = !isStart;
                } else {
                    start.setText("开始");
                    presenter.stopOrStart(isStart);
                    isStart = !isStart;
                    return;
                }

                String ua = "";
                try {
                    ua = Utils.changeURLEncoding(Utils.getUserAgent(MainActivity.this));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                int n = 1;
                String numberstr = number.getText().toString().trim();
                if (!TextUtils.isEmpty(numberstr)) {
                    n = Integer.parseInt(numberstr);
                }
                for (int j = 0; j < appPacks.size(); j++) {
                    for (int i = 0; i < n; i++) {
                        ipadressstr = Utils.getIP(MainActivity.this);
                        ipAddress.setText(ipadressstr);
                        final String finalUa = ua;
                        final int finalJ = j;
                        new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                try {

                                    Thread.sleep(5000);
                                    presenter.requestAdvertisement(appPacks.get(finalJ).getAppPack(), Utils.changeURLEncoding(appPacks.get(finalJ).getAppName()), finalUa, "1.1.0", ipadressstr, " MI 8 SE", "Xiaomi", Utils.getIMEI(MainActivity.this), 720, 1280);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();

                    }
                }
            }
        });
    }

    @Override
    public void getShowText(String context, boolean isPic) {
        contexturl = context;
        if (isPic == true) {
            showPic(top);
        } else {
            showWeb(top);
        }
    }

    @Override
    public void addResNumber(int number) {
        resNumber = resNumber + number;
        all.setText(resNumber + "");
    }

    @Override
    public void addSuccessNumber(int number) {
        successNum = successNum + number;
        successNumber.setText(successNum + "");
    }

    //向下弹出
    public void showPic(View view) {
        if (popupWindow != null && popupWindow.isShowing()) return;
        popupWindow = new CommonPopupWindow.Builder(this).setView(R.layout.pic_layout).setWidthAndHeight(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).setAnimationStyle(R.style.AnimDown).setViewOnclickListener(this).setOutsideTouchable(true).create();
        popupWindow.showAsDropDown(view);
    }

    //向下弹出
    public void showWeb(View view) {
        if (popupWindow != null && popupWindow.isShowing()) return;
        popupWindow = new CommonPopupWindow.Builder(this).setView(R.layout.web_layout).setWidthAndHeight(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).setAnimationStyle(R.style.AnimDown).setViewOnclickListener(this).setOutsideTouchable(true).create();
        popupWindow.showAsDropDown(view);
    }

    @Override
    public void getChildView(View view, int layoutResId) {
        switch (layoutResId) {
            case R.layout.pic_layout:
                ImageView pic = view.findViewById(R.id.show_context);
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.error(R.mipmap.jugao);//异常时候显示的图片
                requestOptions.placeholder(R.mipmap.jugao);//加载成功前显示的图片
                requestOptions.fallback(R.mipmap.jugao); //url为空的时候,显示的图片
                requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE); //不缓存
                Glide.with(App.mContext).load(contexturl).apply(requestOptions).into(pic);
                view.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
                break;
            case R.layout.web_layout:
                WebView webView = view.findViewById(R.id.show_context);
                WebSettings settings = webView.getSettings();
                settings.setJavaScriptEnabled(true);
                settings.setDomStorageEnabled(true);
                settings.setUseWideViewPort(true);
                settings.setLoadWithOverviewMode(true);
                webView.setWebViewClient(new WebViewClient());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
                } else {
                    settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
                }
                webView.loadData(contexturl, "text/html;charset=utf-8", "utf-8");
                view.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
                break;
        }
    }
}
