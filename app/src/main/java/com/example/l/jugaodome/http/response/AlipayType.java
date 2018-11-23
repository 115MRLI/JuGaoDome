//package com.example.l.jugaodome.http.response;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import ta.hai.model.http.api.MoFangApi;
//import ta.hai.model.http.api.ServiceGenerator;
//import ta.hai.utils.OperationUtils;
//
//public class AlipayType {
//    private MoFangApi api;
//
//    /**
//     * 构造方法实例化网络请求接口
//     */
//    public AlipayType() {
////        ServiceGenerator.changeApiBaseUrl("http://gw.mofangtour.com/");//测试环境
//        ServiceGenerator.changeApiBaseUrl("http://www.mofangtour.com/");//生产环境
//        api = ServiceGenerator.createServiceFrom(MoFangApi.class);
//    }
//
//    /**
//     * 支付宝支付
//     *
//     * @param temp_order_no 临时订单号
//     * @param total_amount  泰铢金额
//     * @param auth_code     支付码
//     * @param callback      回调监听
//     * @param <T>           泛型
//     */
//    @Deprecated
//    public <T> void alipayType(String temp_order_no, String total_amount, String auth_code, String remark, String revoke, String discount_price, String coupon, Callback<T> callback) {
//        String lang = "";
//        //根据系统语言来选择语言包
//        String language = OperationUtils.getLanguage();
//        switch (language) {
//            case "US":
//                lang = "en_us";
//                break;
//            case "TH":
//                lang = "vi";
//                break;
//            default:
//                lang = "zh_cn";
//                break;
//        }
//        Call<T> call = (Call<T>) api.alipayType(lang, temp_order_no, total_amount, auth_code, remark, revoke, discount_price, coupon);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 微信支付
//     *
//     * @param temp_order_no 临时订单号
//     * @param total_amount  泰铢金额
//     * @param auth_code     支付码
//     * @param callback      回调监听
//     * @param <T>           泛型
//     */
//    @Deprecated
//    public <T> void wechatPayType(String temp_order_no, String total_amount, String auth_code, String remark, String revoke, String discount_price, String coupon, Callback<T> callback) {
//        String lang = "";
//        //根据系统语言来选择语言包
//        String language = OperationUtils.getLanguage();
//        switch (language) {
//            case "US":
//                lang = "en_us";
//                break;
//            case "TH":
//                lang = "vi";
//                break;
//            default:
//                lang = "zh_cn";
//                break;
//        }
//        Call<T> call = (Call<T>) api.wechatPayType(lang, temp_order_no, total_amount, auth_code, remark, revoke, discount_price, coupon);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 本地化微信支付
//     *
//     * @param temp_order_no  订单号
//     * @param total_amount   应支付泰铢金额
//     * @param auth_code      顾客条形码号码
//     * @param revoke         抹零金额
//     * @param discount_price 自定义打折金额
//     * @param cost           代金券面额
//     * @param desk_sn        桌号
//     * @param callback
//     * @param <T>
//     */
//    public <T> void wechatType(String temp_order_no, String total_amount, String auth_code, String revoke, String discount_price, String cost, int desk_sn, Callback<T> callback) {
//        String lang = "";
//        //根据系统语言来选择语言包
//        String language = OperationUtils.getLanguage();
//        switch (language) {
//            case "US":
//                lang = "en_us";
//                break;
//            case "TH":
//                lang = "vi";
//                break;
//            default:
//                lang = "zh_cn";
//                break;
//        }
//        Call<T> call = (Call<T>) api.wechatType(lang, temp_order_no, total_amount, auth_code, revoke, discount_price, cost, OperationUtils.getPartnerId(), desk_sn, OperationUtils.getName());
//        call.enqueue(callback);
//    }
//
//    /**
//     * 本地化微信支付
//     *
//     * @param temp_order_no  订单号
//     * @param total_amount   应支付泰铢金额
//     * @param auth_code      顾客条形码号码
//     * @param revoke         抹零金额
//     * @param discount_price 自定义打折金额
//     * @param cost           代金券面额
//     * @param desk_sn        桌号
//     * @param callback
//     * @param <T>
//     */
//    public <T> void alipayType(String temp_order_no, String total_amount, String auth_code, String revoke, String discount_price, String cost, int desk_sn, Callback<T> callback) {
//        String lang = "";
//        //根据系统语言来选择语言包
//        String language = OperationUtils.getLanguage();
//        switch (language) {
//            case "US":
//                lang = "en_us";
//                break;
//            case "TH":
//                lang = "vi";
//                break;
//            default:
//                lang = "zh_cn";
//                break;
//        }
//        Call<T> call = (Call<T>) api.alipayType(lang, temp_order_no, total_amount, auth_code, revoke, discount_price, cost, OperationUtils.getPartnerId(), desk_sn, OperationUtils.getName());
//        call.enqueue(callback);
//    }
//}
