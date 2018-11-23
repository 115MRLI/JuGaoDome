//package com.example.l.jugaodome.http.response;
//
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import ta.hai.model.http.api.MoFangApi;
//import ta.hai.model.http.api.ServiceGenerator;
//import ta.hai.utils.OperationUtils;
//
///**
// * 海獭收银台的网络请求
// */
//public class HaiTaModel {
//    private MoFangApi api;
//
//    /**
//     * 构造方法实例化网络请求接口
//     */
////    public HaiTaModel() {
//        ServiceGenerator.changeApiBaseUrl("http://mftour.mofangtour.com/");//测试环境
//        ServiceGenerator.changeApiBaseUrl("http://api.mofangtour.com/");//生产环境
//        api = ServiceGenerator.createServiceFrom(MoFangApi.class);
//    }
//
//    /**
//     * 用户登录
//     *
//     * @param userName 账号
//     * @param userPwd  密码
//     * @param callback 回调监听
//     * @param <T>      泛型
//     */
//    public <T> void userRegister(String userName, String userPwd, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.userRegister(lang, userName, userPwd);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 获取桌台信息
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      秘钥
//     * @param callback   回调监听
//     * @param <T>        泛型
//     */
//    @Deprecated
//    public <T> void getTable(int partner_id, int user_id, String token, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getTable(lang, partner_id, user_id, token);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 按房间请求桌子
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param room_id    房间ID
//     * @param callback   回调监听
//     * @param <T>        泛型
//     */
//    @Deprecated
//    public <T> void getDesk(int partner_id, int user_id, String token, int room_id, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getDesk(lang, partner_id, user_id, token, room_id);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 请求未结账桌台信息
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param desk_sn    房间ID
//     * @param callback   回调监听
//     * @param <T>        泛型
//     */
//    @Deprecated
//    public <T> void getDeskState(int partner_id, int user_id, String token, int desk_sn, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getDeskState(lang, partner_id, user_id, token, desk_sn);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 获取菜单，全部菜，菜分类
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      秘钥
//     * @param callback   回调监听
//     * @param <T>        泛型
//     */
//    @Deprecated
//    public <T> void getFoodMenu(int partner_id, int user_id, String token, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getFoodMenu(lang, partner_id, user_id, token);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 下单
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      秘钥
//     * @param desk_sn    桌号
//     * @param remark     备注
//     * @param idList     食物
//     * @param callback   回调监听
//     * @param <T>        泛型
//     */
//    @Deprecated
//    public <T> void getPlaceAnOrder(int partner_id, int user_id, String token, int desk_sn, String remark, String idList, String source, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getPlaceAnOrder(lang, partner_id, user_id, token, desk_sn, remark, idList, source);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 退菜
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      秘钥
//     * @param id         菜品ID
//     * @param callback   回调监听
//     * @param <T>        泛型
//     */
//    @Deprecated
//    public <T> void getRetreatFood(int partner_id, int user_id, String token, int id, int num, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getRetreatFood(lang, partner_id, user_id, token, id, num);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 撤单
//     * getWithdrawAnOffer
//     *
//     * @param partner_id    商户ID
//     * @param user_id       用户ID
//     * @param token         秘钥
//     * @param temp_order_no 临时订单号
//     * @param callback      回调监听
//     * @param <T>           泛型
//     */
//    @Deprecated
//    public <T> void getRevocation(int partner_id, int user_id, String token, String temp_order_no, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getRevocation(lang, partner_id, user_id, token, temp_order_no);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 加菜
//     *
//     * @param user_id       用户ID
//     * @param token         秘钥
//     * @param temp_order_no 临时订单号
//     * @param idList        食物
//     * @param callback      回调监听
//     * @param <T>           泛型
//     */
//    @Deprecated
//    public <T> void getAddFood(int user_id, String token, String temp_order_no, String idList, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getAddFood(lang, user_id, token, temp_order_no, idList);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 订单查询
//     * getOrderPaging
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param mark       day ： 今天 week： 最近7天   month：最近30天
//     * @param callback   回调监听
//     * @param <T>        泛型
//     */
//    @Deprecated
//    public <T> void getOrderSelect(int partner_id, int user_id, String token, String mark, int type, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getOrderSelect(lang, partner_id, user_id, token, mark, type);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 按时间范围检索订单
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param start_time 开始时间
//     * @param end_time   结束时间
//     * @param callback   回调监听
//     * @param <T>        泛型
//     */
//    @Deprecated
//    public <T> void getOrderSelect(int partner_id, int user_id, String token, String start_time, String end_time, int type, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getOrderSelect(lang, partner_id, user_id, token, start_time, end_time, type);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 查询订单详情
//     *
//     * @param user_id       用户ID
//     * @param token         口令
//     * @param temp_order_no 订单号
//     * @param callback      回调监听
//     * @param <T>           泛型
//     */
//    public <T> void getOrderDetails(int user_id, String token, String temp_order_no, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getOrderDetails(lang, user_id, token, temp_order_no);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 修改菜品库存
//     *
//     * @param user_id  用户ID
//     * @param token    口令
//     * @param food_id  菜品id
//     * @param number   修改的库存
//     * @param callback 回调监听
//     * @param <T>      泛型
//     */
//    public <T> void getModification(int user_id, String token, int food_id, String number, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getModification(lang, user_id, token, food_id, number);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 打印订单详情
//     *
//     * @param user_id       用户ID
//     * @param token         口令
//     * @param temp_order_no 订单详情
//     * @param callback      回调监听
//     * @param <T>           泛型
//     */
//    public <T> void getPrintOrderDetails(int user_id, String token, String temp_order_no, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getPrintOrderDetails(lang, user_id, token, temp_order_no);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 验证代金券
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param coupon_id  代金券码
//     * @param callback   回调监听
//     * @param <T>        泛型
//     */
//    public <T> void getVerification(int partner_id, int user_id, String token, String coupon_id, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getVerification(lang, partner_id, user_id, token, coupon_id);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 现金结账接口
//     *
//     * @param user_id        用户ID
//     * @param token          口令
//     * @param temp_order_no  订单详情
//     * @param cost           代金券面额
//     * @param discount_price 打折的金额
//     * @param callback       回调监听
//     * @param <T>            泛型
//     */
//    @Deprecated
//    public <T> void getPayMoney(int user_id, String token, String temp_order_no, String cost, String discount_price, String remark, String revoke, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getPayMoney(lang, user_id, token, temp_order_no, cost, discount_price, remark, revoke);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 交班
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param callback   回调监听
//     * @param <T>        泛型
//     */
//    public <T> void getChangeShifts(int partner_id, int user_id, String token, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getChangeShifts(lang, partner_id, user_id, token);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 根据时间范围查询订单汇总打印接口
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param mark       日期，day           今天；week         最近7天；money      本月；custom       自定义时间范围
//     * @param start_time 开始时间
//     * @param end_time   结束时间
//     * @param callback   回调监听
//     * @param <T>        泛型
//     * @return
//     */
//    public <T> void printAll(int partner_id, int user_id, String token, String mark, String start_time, String end_time, int type, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.printAll(lang, partner_id, user_id, token, mark, start_time, end_time, type);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 换桌接口
//     *
//     * @param partner_id  商户ID
//     * @param user_id     用户ID
//     * @param token       口令
//     * @param desk_sn     更换的的桌子
//     * @param new_desk_sn 要更换的桌子
//     * @param callback    回调监听
//     * @param <T>         泛型
//     * @return
//     */
//    @Deprecated
//    public <T> void changeTable(int partner_id, int user_id, String token, int desk_sn, int new_desk_sn, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.changeTable(lang, partner_id, user_id, token, desk_sn, new_desk_sn);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 获取店铺广告
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param callback   回调监听
//     * @param <T>        泛型
//     */
//    public <T> void getAdvBean(int partner_id, int user_id, String token, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getAdvBean(lang, partner_id, user_id, token);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 后厨打印
//     *
//     * @param user_id       用户ID
//     * @param token         口令
//     * @param temp_order_no 订单号
//     * @param callback      回调监听
//     * @param <T>           泛型
//     */
//    public <T> void cookePrint(int user_id, String token, String temp_order_no, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.cookePrint(lang, user_id, token, temp_order_no);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 前台打印
//     *
//     * @param user_id       用户ID
//     * @param token         口令
//     * @param temp_order_no 订单号
//     * @param callback      回调监听
//     * @param <T>           泛型
//     */
//    public <T> void deskPrint(int user_id, String token, String temp_order_no, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.deskPrint(lang, user_id, token, temp_order_no);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 团购劵验证
//     *
//     * @param user_id
//     * @param token
//     * @param partner_id
//     * @param coupon_id
//     * @param callback
//     * @param <T>
//     */
//    public <T> void getCoupon(int user_id, String token, int partner_id, String coupon_id, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getCoupon(lang, user_id, token, partner_id, coupon_id);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 团购套餐下单接口
//     *
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param partner_id 商户ID
//     * @param desk_sn    桌台号
//     * @param pp_id      团购号
//     * @param order_id   订单ID
//     * @return
//     */
//    public <T> void getCouponOeder(int user_id, String token, int partner_id, int desk_sn, int pp_id, int order_id, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getCouponOeder(lang, user_id, token, partner_id, desk_sn, pp_id, order_id);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 查询会员列表
//     *
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param partner_id 项目ID
//     * @return
//     */
//    public <T> void getMembers(int user_id, String token, int partner_id, int current_page, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getMembers(lang, user_id, token, partner_id, current_page);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 新增会员
//     *
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param partner_id 项目ID
//     * @param mobile     手机号
//     * @param name       姓名
//     * @param sex        性别
//     * @param birthday   生日
//     * @param email      邮箱
//     * @return
//     */
//    public <T> void addMenber(int user_id, String token, int partner_id, String mobile, String name, int sex, String birthday, String email, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.addMenber(lang, user_id, token, partner_id, mobile, name, sex, birthday, email);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 会员详情
//     *
//     * @param user_id   用户ID
//     * @param token     口令
//     * @param member_id 会员id
//     * @return
//     */
//    public <T> void getMemberDetails(int user_id, String token, int member_id, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getMemberDetails(lang, user_id, token, member_id);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 修改会员资料
//     *
//     * @param user_id   用户ID
//     * @param token     口令
//     * @param mobile    手机号
//     * @param name      姓名
//     * @param sex       性别
//     * @param birthday  生日
//     * @param email     邮箱
//     * @param member_id 会员ID
//     * @return
//     */
//    public <T> void updateMenber(int user_id, String token, String mobile, String name, int sex, String birthday, String email, int member_id, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.updateMenber(lang, user_id, token, mobile, name, sex, birthday, email, member_id);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 会员冻结
//     *
//     * @param user_id   用户ID
//     * @param token     口令
//     * @param member_id 会员id
//     * @return
//     */
//    public <T> void freezeMember(int user_id, String token, int member_id, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.freezeMember(lang, user_id, token, member_id);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 会员解冻
//     *
//     * @param user_id   用户ID
//     * @param token     口令
//     * @param member_id 会员id
//     * @return
//     */
//    public <T> void unfreezeMember(int user_id, String token, int member_id, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.unfreezeMember(lang, user_id, token, member_id);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 会员充值
//     *
//     * @param user_id   用户ID
//     * @param token     口令
//     * @param member_id 会员id
//     * @param amount    储值金额
//     * @return
//     */
//    public <T> void rechargeMember(int user_id, String token, int member_id, String amount, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.rechargeMember(lang, user_id, token, member_id, amount);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 获取会员充值记录
//     *
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param partner_id 项目ID
//     * @return
//     */
//    public <T> void getRechargeList(int user_id, String token, int partner_id, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getRechargeList(lang, user_id, token, partner_id);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 会员搜索
//     *
//     * @param user_id 用户ID
//     * @param token   口令
//     * @param mobile  联系方式
//     * @return
//     */
//    public <T> void searchMemberDetails(int user_id, String token, String mobile, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.searchMemberDetails(lang, user_id, token, mobile);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 会员退款
//     *
//     * @param user_id   用户ID
//     * @param token     口令
//     * @param member_id 会员id
//     * @return
//     */
//    public <T> void refundMember(int user_id, String token, int member_id, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.refundMember(lang, user_id, token, member_id);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 加载本地菜品分类
//     *
//     * @return
//     */
//    public <T> void getFoodClassify( Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getFoodClassify(lang, OperationUtils.getId(), OperationUtils.getToken(), OperationUtils.getPartnerId());
//        call.enqueue(callback);
//    }
//
//    /**
//     * 分页模式加载菜品，套餐
//     *
//     * @param current_page 页码
//     * @return
//     */
//    public <T> void getFoods(int current_page, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getFoods(lang, OperationUtils.getId(), OperationUtils.getToken(), OperationUtils.getPartnerId(), current_page);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 下单接口以作修改本地数据
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param desk_sn    桌号
//     * @param remark     备注
//     * @param idList     菜品集合
//     * @param source     下单人
//     * @return
//     */
//    @Deprecated
//    public <T> void getPlaceOrder(int partner_id, int user_id, String token, int desk_sn, String remark, String idList, String source, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getPlaceOrder(lang, partner_id, user_id, token, desk_sn, remark, idList, source);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 加菜接口以作修改本地数据
//     *
//     * @param user_id       用户ID
//     * @param token         口令
//     * @param temp_order_no 菜单临时订单号
//     * @param idList        菜品集合
//     * @return
//     */
//    @Deprecated
//    public <T> void addPlaceOder(int user_id, String token, String temp_order_no, String idList, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.addPlaceOder(lang, user_id, token, temp_order_no, idList);
//        call.enqueue(callback);
//    }
//    // 分页加载新接口
//
//    /**
//     * 获取店铺房间信息
//     *
//     * @return
//     */
//    public <T> void getCookRoon( Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getCookRoon(lang, OperationUtils.getId(), OperationUtils.getToken(), OperationUtils.getPartnerId());
//        call.enqueue(callback);
//    }
//
//    /**
//     * 分页获取房间内的桌位
//     *
//     * @param user_id      用户ID
//     * @param token        口令
//     * @param partner_id   项目ID
//     * @param room_id      房间ID
//     * @param current_page 页码
//     * @return
//     */
//    @Deprecated
//    public <T> void getCookTable(int user_id, String token, int partner_id, int room_id, int current_page, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getCookTable(lang, user_id, token, partner_id, room_id, current_page);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 退菜 修改本地库存
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param id         菜品ID
//     * @param num        要退菜的数量
//     * @return
//     */
//    public <T> void getReturnDishes(int partner_id, int user_id, String token, int id, int num, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getReturnDishes(lang, partner_id, user_id, token, id, num);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 撤单
//     *
//     * @param partner_id    商户ID
//     * @param user_id       用户ID
//     * @param token         秘钥
//     * @param temp_order_no 临时订单号
//     * @param callback      回调监听
//     * @param <T>           泛型
//     */
//    public <T> void getWithdrawAnOffer(int partner_id, int user_id, String token, String temp_order_no, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getWithdrawAnOffer(lang, partner_id, user_id, token, temp_order_no);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 订单查询 分页查询
//     *
//     * @param partner_id   商户ID
//     * @param user_id      用户ID
//     * @param token        口令
//     * @param mark         day ： 今天 week： 最近7天   month：最近30天
//     * @param current_page 页码
//     * @param callback
//     * @param <T>
//     */
//    public <T> void getOrderPaging(int partner_id, int user_id, String token, String mark, long start_time, long end_time, int type, int current_page, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getOrderPaging(lang, partner_id, user_id, token, mark, start_time, end_time, type, current_page);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 分页获取房间内的桌位（存在本地表）
//     *
//     * @param user_id      用户ID
//     * @param token        口令
//     * @param partner_id   项目ID
//     * @param current_page 页码
//     * @return
//     */
//    public <T> void getShopTable( int current_page, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.getShopTable(lang, OperationUtils.getId(), OperationUtils.getToken(), OperationUtils.getPartnerId(), current_page);
//        call.enqueue(callback);
//    }
//
//    //本地同步
//    public <T> void syncDta(String orders, Callback<T> callback) {
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
//        Call<T> call = (Call<T>) api.syncDta(lang, OperationUtils.getId(), OperationUtils.getToken(), OperationUtils.getPartnerId(), OperationUtils.getShopeNmae(), orders);
//        call.enqueue(callback);
//    }
//}
