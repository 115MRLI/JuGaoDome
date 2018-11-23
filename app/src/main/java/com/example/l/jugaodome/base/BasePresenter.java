package com.example.l.jugaodome.base;

/**
 */
public interface BasePresenter<V extends BaseView> {

    void attachView(V baseView);

    void detachView();
}
