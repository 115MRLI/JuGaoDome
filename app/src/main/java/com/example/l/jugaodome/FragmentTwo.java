package com.example.l.jugaodome;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.l.jugaodome.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FragmentTwo extends BaseFragment  implements AbsListView.OnScrollListener {
    @BindView(R.id.main_srl)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.main_lv)
    ListView lv;
    private ArrayAdapter adapter;
    private List<String> list;
    @Override
    protected int getLayout() {
        return R.layout.fragment_layout;
    }

    @Override
    protected void initView(LayoutInflater inflater) {
        super.initView(inflater);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        list = new ArrayList<>();
//        list.addAll(Arrays.asList("Java", "php", "C++", "C#", "IOS", "html", "C", "J2ee", "j2se", "VB", ".net", "Http", "tcp", "udp", "www"));

        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, list);
        lv.setAdapter(adapter);

        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new LoadDataThread().start();
            }
        });
    }
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0x101:
                    if (swipeRefreshLayout.isRefreshing()) {
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);//设置不刷新
                    }
                    break;
            }
        }
    };
    private int visibleLastIndex;//用来可显示的最后一条数据的索引

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (adapter.getCount() == visibleLastIndex && scrollState == SCROLL_STATE_IDLE) {
            new LoadDataThread().start();
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        visibleLastIndex = firstVisibleItem + visibleItemCount - 1;//减去最后一个加载中那条
    }


    /**
     * 模拟加载数据的线程
     */
    class LoadDataThread extends Thread {
        @Override
        public void run() {
            initData();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.sendEmptyMessage(0x101);//通过handler发送一个更新数据的标记
        }

        private void initData() {
//            list.addAll(Arrays.asList("Json", "XML", "UDP", "http"));
        }
    }
}
