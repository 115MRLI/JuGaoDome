package com.example.l.jugaodome.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.leefeng.promptlibrary.PromptDialog;
import ta.hai.R;

/**
 */
public abstract class BaseFragment extends Fragment {
    private final String TAG = getClass().getSimpleName();
    protected Context mContext;
    protected View rootView;
    protected Unbinder unbinder;
    private boolean isViewPrepared; // 标识fragment视图已经初始化完毕
    private boolean hasFetchData; // 标识已经触发过懒加载数据
    //弹窗
    private MaterialDialog.Builder mBuilder;
    private MaterialDialog mMaterialDialog;
    //进度条
    private PromptDialog promptDialog;
    private Handler handler = new Handler();
    @Override
    public void onAttach(Context mContext) {
        super.onAttach(mContext);
        Log.d(this.getClass() + "", getName() + "------>onAttach");
        if (mContext != null) {
            this.mContext = mContext;
        } else {
            this.mContext = getActivity();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(this.getClass() + "", getName() + "------>onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(this.getClass() + "", getName() + "------>onCreateView");
        if (rootView == null) {
            rootView = inflater.inflate(getLayout(), container, false);
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        unbinder = ButterKnife.bind(this, rootView);
        initView(inflater);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(this.getClass() + "", getName() + "------>onActivityCreated");
        initEvent();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(this.getClass() + "", getName() + "------>onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(this.getClass() + "", getName() + "------>onResume");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(this.getClass() + "", getName() + "------>onViewCreated");
        isViewPrepared = true;
        lazyFetchDataIfPrepared();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(this.getClass() + "", getName() + "------>onPause");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(this.getClass() + "", getName() + "------>onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(this.getClass() + "", getName() + "------>onDestroyView");
        // view被销毁后，将可以重新触发数据懒加载，因为在viewpager下，fragment不会再次新建并走onCreate的生命周期流程，将从onCreateView开始
        hasFetchData = false;
        isViewPrepared = false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(this.getClass() + "", getName() + "------>onDestroy");
        if (unbinder != null) unbinder.unbind();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(this.getClass() + "", getName() + "------>onDetach");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.v(TAG, getClass().getName() + "------>isVisibleToUser = " + isVisibleToUser);
        if (isVisibleToUser) {
            lazyFetchDataIfPrepared();
        }
    }

    private void lazyFetchDataIfPrepared() {
        // 用户可见fragment && 没有加载过数据 && 视图已经准备完毕
        if (getUserVisibleHint() && !hasFetchData && isViewPrepared) {
            hasFetchData = true;
            lazyFetchData();
        }

    }

    /**
     * 懒加载的方式获取数据，仅在满足fragment可见和视图已经准备好的时候调用一次
     */
    protected void lazyFetchData() {
        Log.v(TAG, getClass().getName() + "------>lazyFetchData");
    }

    public String getName() {
        return BaseFragment.class.getName();
    }

    protected abstract int getLayout();

    protected void initView(LayoutInflater inflater) {
    }


    protected void initEvent() {
    }

    /**
     * 展示弹窗
     *
     * @param content  展示主题内容
     * @param callback 监听
     */
    public void showDialog(String content, MaterialDialog.SingleButtonCallback callback) {
        if (!getActivity().isFinishing()) {
            mBuilder = new MaterialDialog.Builder(getActivity());
            mBuilder.title("提示");
            mBuilder.titleColor(Color.parseColor("#000000"));
            mBuilder.content(content);
            mBuilder.contentColor(Color.parseColor("#000000"));
            mBuilder.positiveText("确定");
            mBuilder.titleGravity(GravityEnum.CENTER);
            mBuilder.buttonsGravity(GravityEnum.START);
            mBuilder.negativeText("取消");
            mBuilder.cancelable(false);
            mMaterialDialog = mBuilder.build();
            mMaterialDialog.show();
            mBuilder.onAny(callback);
//                new MaterialDialog.SingleButtonCallback() {
//            @Override
//            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//                if (which == DialogAction.POSITIVE) {
//                    mMaterialDialog.dismiss();
//                } else if (which == DialogAction.NEGATIVE) {
//                    mMaterialDialog.dismiss();
//                }
//            }
//        });
        }
    }


    /**
     * 展示弹窗
     *
     * @param content  展示主题内容
     * @param callback 监听
     */
    public void showDialog(int content, MaterialDialog.SingleButtonCallback callback) {
        if (!getActivity().isFinishing()) {
            mBuilder = new MaterialDialog.Builder(getActivity());
            mBuilder.title(R.string.reminder_str);
            mBuilder.titleColor(Color.parseColor("#000000"));
            mBuilder.content(content);
            mBuilder.contentColor(Color.parseColor("#000000"));
            mBuilder.positiveText(R.string.sure);
            mBuilder.titleGravity(GravityEnum.CENTER);
            mBuilder.buttonsGravity(GravityEnum.START);
            mBuilder.negativeText(R.string.abolish_str);
            mBuilder.cancelable(false);
            mMaterialDialog = mBuilder.build();
            mMaterialDialog.show();
            mBuilder.onAny(callback);
//                new MaterialDialog.SingleButtonCallback() {
//            @Override
//            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//                if (which == DialogAction.POSITIVE) {
//                    mMaterialDialog.dismiss();
//                } else if (which == DialogAction.NEGATIVE) {
//                    mMaterialDialog.dismiss();
//                }
//            }
//        });
        }
    }

    /**
     * 展示进度条弹窗
     *
     * @param details 弹窗内容
     */
    public void progressBar(String details) {
        if (promptDialog != null) {
            promptDialog.showLoading(details);
        } else {
            dissProgressBar();
            promptDialog = new PromptDialog(getActivity());
            promptDialog.showLoading(details);
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //30秒未关闭弹窗自动关闭
                dissProgressBar();
            }
        }, 30000);
    }

    /**
     * 消失进度条
     */
    public void dissProgressBar() {
        if (promptDialog != null) {
            promptDialog.dismiss();
            promptDialog.onDetach();
        } else {
            promptDialog = new PromptDialog(getActivity());
            promptDialog.dismiss();
        }
    }

    /**
     * 进度条显示成功
     *
     * @param details
     */
    public void showSuccess(String details) {
        if (promptDialog == null) {
            promptDialog = new PromptDialog(getActivity());
        }
        promptDialog.showSuccess(details);
    }

    /**
     * 进度条显示失败
     *
     * @param details
     */
    public void showError(String details) {
        if (promptDialog == null) {
            promptDialog = new PromptDialog(getActivity());
        }
        promptDialog.showError(details);
    }

    /**
     * 将string文件的值转成string类型
     *
     * @param strings
     * @return
     */
    public String changeString(int strings) {
        return getResources().getString(strings);
    }

    /**
     * 进度条状态
     *
     * @return
     */
    public void getPromptDialog() {
         promptDialog = null;
    }
}
