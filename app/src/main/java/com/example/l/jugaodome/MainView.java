package com.example.l.jugaodome;

import com.example.l.jugaodome.base.BaseView;

public interface MainView extends BaseView {
    /**
     * 要展示的数据
     *
     * @param context 要展示内容
     * @param isPic   是否是图片
     */
    void getShowText(String context, boolean isPic);

    /**
     * 添加请求总次数
     *
     * @param number
     */
    void addResNumber(int number);

    /**
     * 添加请求成功次数
     *
     * @param number
     */
    void addSuccessNumber(int number);
}
