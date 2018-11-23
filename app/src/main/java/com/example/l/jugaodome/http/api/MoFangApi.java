//package com.example.l.jugaodome.http.api;
//
//import retrofit2.Call;
//import retrofit2.http.GET;
//import retrofit2.http.POST;
//import retrofit2.http.Query;
//import ta.hai.model.bean.AddFood;
//import ta.hai.model.bean.AddMember;
//import ta.hai.model.bean.AdvBean;
//import ta.hai.model.bean.ChangeShifts;
//import ta.hai.model.bean.CookRoom;
//import ta.hai.model.bean.CookeTable;
//import ta.hai.model.bean.Coupon;
//import ta.hai.model.bean.Desk;
//import ta.hai.model.bean.DeskState;
//import ta.hai.model.bean.FoodMenu;
//import ta.hai.model.bean.Member;
//import ta.hai.model.bean.MemberD;
//import ta.hai.model.bean.Modification;
//import ta.hai.model.bean.OrderDetails;
//import ta.hai.model.bean.OrderPaging;
//import ta.hai.model.bean.OrderSelect;
//import ta.hai.model.bean.PlaceAnOrder;
//import ta.hai.model.bean.PrintOrderDetails;
//import ta.hai.model.bean.RechargeBean;
//import ta.hai.model.bean.RetreatFood;
//import ta.hai.model.bean.ReturnDishes;
//import ta.hai.model.bean.Revocation;
//import ta.hai.model.bean.Table;
//import ta.hai.model.bean.User;
//import ta.hai.model.bean.Verification;
//import ta.hai.model.bean.WithdrawAnOffer;
//import ta.hai.model.dbbean.FoodClassifyJudge;
//import ta.hai.model.dbbean.FoodJude;
//import ta.hai.model.dbbean.PlaceOder;
//import ta.hai.model.dbbean.TableJude;
//
///**
// * 魔方请求数据api
// */
//public interface MoFangApi {
//    /**
//     * 登录接口
//     *
//     * @param userName 账号
//     * @param userPwd  密码
//     * @return
//     */
//    @POST("login")
//    Call<User> userRegister(@Query("lang") String lang, @Query("userName") String userName, @Query("userPwd") String userPwd);
//
//    /**
//     * 获取桌台信息
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      口令
//     * @return
//     */
//    @Deprecated
//    @POST("cashier/room")
//    Call<Table> getTable(@Query("lang") String lang, @Query("partner_id") int partner_id, @Query("user_id") int user_id, @Query("token") String token);
//    //http://mftour.admlmc.com/cashier/table?lang=zh_cn&partner_id=668&user_id=2&token=b74735ff0c50ac323ca85dd77c90436a237697fc&room_id=3
//
//    /**
//     * 按房间请求桌子
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param room_id    房间ID
//     * @return
//     */
//    @Deprecated
//    @POST("cashier/table")
//    Call<Desk> getDesk(@Query("lang") String lang, @Query("partner_id") int partner_id, @Query("user_id") int user_id, @Query("token") String token, @Query("room_id") int room_id);
//
//    /**
//     * 请求未结账桌台信息
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param desk_sn    房间ID
//     * @return
//     */
//    @Deprecated
//    @POST("cashier/paymoney_info")
//    Call<DeskState> getDeskState(@Query("lang") String lang, @Query("partner_id") int partner_id, @Query("user_id") int user_id, @Query("token") String token, @Query("desk_sn") int desk_sn);
//
//    /**
//     * 获取菜单，全部菜，菜分类
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      口令
//     * @return
//     */
//    @Deprecated
//    @POST("cashier/food_info")
//    Call<FoodMenu> getFoodMenu(@Query("lang") String lang, @Query("partner_id") int partner_id, @Query("user_id") int user_id, @Query("token") String token);
//
//    /**
//     * 下单接口
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param desk_sn    桌号
//     * @param remark     备注
//     * @param idList     菜品集合
//     * @return
//     */
//    @Deprecated
//    @POST("cashier/place_order")
//    Call<PlaceAnOrder> getPlaceAnOrder(@Query("lang") String lang, @Query("partner_id") int partner_id, @Query("user_id") int user_id, @Query("token") String token, @Query("desk_sn") int desk_sn, @Query("remark") String remark, @Query("foods") String idList, @Query("source") String source);
//
//    /**
//     * 退菜
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param id         菜品ID
//     * @param num        要退菜的数量
//     * @return
//     */
//    @Deprecated
//    @POST("cashier/refund")
//    Call<RetreatFood> getRetreatFood(@Query("lang") String lang, @Query("partner_id") int partner_id, @Query("user_id") int user_id, @Query("token") String token, @Query("id") int id, @Query("num") int num);
//
//    /**
//     * 撤单
//     *
//     * @param partner_id    商户ID
//     * @param user_id       用户ID
//     * @param token         口令
//     * @param temp_order_no 菜单临时订单号
//     * @return
//     */
//    @Deprecated
//    @POST("cashier/cancel_order")
//    Call<Revocation> getRevocation(@Query("lang") String lang, @Query("partner_id") int partner_id, @Query("user_id") int user_id, @Query("token") String token, @Query("temp_order_no") String temp_order_no);
//
//    /**
//     * 加菜
//     *
//     * @param user_id       用户ID
//     * @param token         口令
//     * @param temp_order_no 菜单临时订单号
//     * @param idList        菜品集合
//     * @return
//     */
//    @Deprecated
//    @POST("cashier/add_food")
//    Call<AddFood> getAddFood(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("temp_order_no") String temp_order_no, @Query("foods") String idList);
//
//    /**
//     * 订单查询
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param mark       day ： 今天 week： 最近7天   month：最近30天
//     * @param type       1团购2代金券4店内点餐6外卖7快餐0全部
//     * @return
//     */
//    @Deprecated
//    @POST("cashier/today_orders")
//    Call<OrderSelect> getOrderSelect(@Query("lang") String lang, @Query("partner_id") int partner_id, @Query("user_id") int user_id, @Query("token") String token, @Query("mark") String mark, @Query("type") int type);
//
//    /**
//     * 按时间范围查询订单
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param start_time 开始时间
//     * @param end_time   结束时间
//     * @return
//     */
//    @Deprecated
//    @POST("cashier/select_orders")
//    Call<OrderSelect> getOrderSelect(@Query("lang") String lang, @Query("partner_id") int partner_id, @Query("user_id") int user_id, @Query("token") String token, @Query("start_time") String start_time, @Query("end_time") String end_time, @Query("type") int type);
//
//    /**
//     * 查询订单详情
//     *
//     * @param user_id       用户ID
//     * @param token         口令
//     * @param temp_order_no 订单号
//     * @return
//     */
//    @POST("cashier/order_detail")
//    Call<OrderDetails> getOrderDetails(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("temp_order_no") String temp_order_no);
//
//    /**
//     * 修改菜品库存
//     *
//     * @param user_id 用户ID
//     * @param token   口令
//     * @param food_id 菜品id
//     * @param number  修改的库存
//     * @return
//     */
//    @POST("cashier/edit_stock")
//    Call<Modification> getModification(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("food_id") int food_id, @Query("number") String number);
//
//    /**
//     * 打印订单详情
//     *
//     * @param user_id       用户ID
//     * @param token         口令
//     * @param temp_order_no 订单详情
//     * @return
//     */
//    @POST("cashier/order_detail_printer")
//    Call<PrintOrderDetails> getPrintOrderDetails(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("temp_order_no") String temp_order_no);
//
//    /**
//     * 验证代金券
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param coupon_id  代金券码
//     * @return
//     */
//    @POST("cashier/check_coupon")
//    Call<Verification> getVerification(@Query("lang") String lang, @Query("partner_id") int partner_id, @Query("user_id") int user_id, @Query("token") String token, @Query("coupon_id") String coupon_id);
//
//    /**
//     * 现金结账接口
//     *
//     * @param user_id        用户ID
//     * @param token          口令
//     * @param temp_order_no  订单详情
//     * @param cost           代金券面额
//     * @param discount_price 打折的金额
//     * @param remark         抹零原因
//     * @param revoke         抹零金额
//     * @return
//     */
//    @POST("cashier/payment")
//    Call<Verification> getPayMoney(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("temp_order_no") String temp_order_no, @Query("cost") String cost, @Query("discount_price") String discount_price, @Query("remark") String remark, @Query("revoke") String revoke);
//
//    /**
//     * 交班
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      口令
//     * @return
//     */
//    @POST("cashier/shift")
//    Call<ChangeShifts> getChangeShifts(@Query("lang") String lang, @Query("partner_id") int partner_id, @Query("user_id") int user_id, @Query("token") String token);
//
//    /**
//     * 支付宝支付
//     *
//     * @param temp_order_no 临时订单号
//     * @param total_amount  泰铢金额
//     * @param auth_code     支付码
//     * @return
//     */
//    @GET("mobiletest/paycenter/f2fpay/barpay.php")
//    Call<AddFood> alipayType(@Query("lang") String lang, @Query("temp_order_no") String temp_order_no, @Query("total_amount") String total_amount, @Query("auth_code") String auth_code, @Query("remark") String remark, @Query("revoke") String revoke, @Query("discount_price") String discount_price, @Query("coupon") String coupon);
//
//    /**
//     * 微信支付
//     *
//     * @param lang          语言版本
//     * @param temp_order_no 临时单号
//     * @param total_amount  泰铢金额
//     * @param auth_code     支付码
//     * @return
//     */
//    @Deprecated
//    @GET("paycenter/wechatSdk/example/micropay.php")
//    Call<AddFood> wechatPayType(@Query("lang") String lang, @Query("temp_order_no") String temp_order_no, @Query("total_amount") String total_amount, @Query("auth_code") String auth_code, @Query("remark") String remark, @Query("revoke") String revoke, @Query("discount_price") String discount_price, @Query("coupon") String coupon);
//
//    /**
//     * 根据时间范围查询订单汇总打印接口
//     *
//     * @param lang       语言
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param mark       日期，day           今天；week         最近7天；money      本月；custom       自定义时间范围
//     * @param start_time 开始时间
//     * @param end_time   结束时间
//     * @return
//     */
//    @POST("cashier/print_orders")
//    Call<AddFood> printAll(@Query("lang") String lang, @Query("partner_id") int partner_id, @Query("user_id") int user_id, @Query("token") String token, @Query("mark") String mark, @Query("start_time") String start_time, @Query("end_time") String end_time, @Query("type") int type);
//
//    /**
//     * 换桌接口
//     *
//     * @param lang        语言
//     * @param partner_id  商户ID
//     * @param user_id     用户ID
//     * @param token       口令
//     * @param desk_sn     更换的的桌子
//     * @param new_desk_sn 要更换的桌子
//     * @return
//     */
//    @Deprecated
//    @POST("cashier/change_desk")
//    Call<AddFood> changeTable(@Query("lang") String lang, @Query("partner_id") int partner_id, @Query("user_id") int user_id, @Query("token") String token, @Query("desk_sn") int desk_sn, @Query("new_desk_sn") int new_desk_sn);
//
//    /**
//     * 获取店铺广告
//     *
//     * @param lang       语言
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      口令
//     * @return
//     */
//    @POST("cashier/advertisement")
//    Call<AdvBean> getAdvBean(@Query("lang") String lang, @Query("partner_id") int partner_id, @Query("user_id") int user_id, @Query("token") String token);
//
//    /**
//     * 后厨打印
//     *
//     * @param lang          语言
//     * @param user_id       用户ID
//     * @param token         口令
//     * @param temp_order_no 订单号
//     * @return
//     */
//
//    @POST("cashier/order_print")
//    Call<AddFood> cookePrint(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("temp_order_no") String temp_order_no);
//
//    /**
//     * 前台打印
//     *
//     * @param lang          语言
//     * @param user_id       用户ID
//     * @param token         口令
//     * @param temp_order_no 订单号
//     * @return
//     */
//    @POST("cashier/unpay_print")
//    Call<AddFood> deskPrint(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("temp_order_no") String temp_order_no);
//
//    /**
//     * 团购劵验证
//     *
//     * @param lang       语言
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param partner_id 商户ID
//     * @param coupon_id  团购套餐号码
//     * @return
//     */
//    @POST("cashier/check_group")
//    Call<Coupon> getCoupon(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("partner_id") int partner_id, @Query("coupon_id") String coupon_id);
//
//    /**
//     * 团购套餐下单接口
//     *
//     * @param lang       语言
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param partner_id 商户ID
//     * @param desk_sn    桌台号
//     * @param pp_id      团购号
//     * @param order_id   订单ID
//     * @return
//     */
//    @POST("cashier/group_order")
//    Call<PlaceAnOrder> getCouponOeder(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("partner_id") int partner_id, @Query("desk_sn") int desk_sn, @Query("pp_id") int pp_id, @Query("order_id") int order_id);
//
//    /**
//     * 查询会员列表
//     *
//     * @param lang       语言
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param partner_id 项目ID
//     * @return
//     */
//    @POST("cashier/member_list")
//    Call<Member> getMembers(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("partner_id") int partner_id, @Query("current_page") int current_page);
//
//    /**
//     * 新增会员
//     *
//     * @param lang       语言
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
//    @POST("cashier/add_member")
//    Call<AddMember> addMenber(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("partner_id") int partner_id, @Query("mobile") String mobile, @Query("name") String name, @Query("sex") int sex, @Query("birthday") String birthday, @Query("member_no") String email);
//
//    /**
//     * 会员详情
//     *
//     * @param lang      语言
//     * @param user_id   用户ID
//     * @param token     口令
//     * @param member_id 会员id
//     * @return
//     */
//    @POST("cashier/member_detail")
//    Call<MemberD> getMemberDetails(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("member_id") int member_id);
//
//    /**
//     * 修改会员资料
//     *
//     * @param lang      语言
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
//    @POST("cashier/edit_member")
//    Call<AddFood> updateMenber(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("mobile") String mobile, @Query("name") String name, @Query("sex") int sex, @Query("birthday") String birthday, @Query("email") String email, @Query("member_id") int member_id);
//
//    /**
//     * 会员冻结
//     *
//     * @param lang      语言
//     * @param user_id   用户ID
//     * @param token     口令
//     * @param member_id 会员id
//     * @return
//     */
//    @POST("cashier/frozen_member")
//    Call<AddFood> freezeMember(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("member_id") int member_id);
//
//    /**
//     * 会员解冻
//     *
//     * @param lang      语言
//     * @param user_id   用户ID
//     * @param token     口令
//     * @param member_id 会员id
//     * @return
//     */
//    @POST("cashier/thaw_member")
//    Call<AddFood> unfreezeMember(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("member_id") int member_id);
//
//    /**
//     * 会员充值
//     *
//     * @param lang      语言
//     * @param user_id   用户ID
//     * @param token     口令
//     * @param member_id 会员id
//     * @param amount    储值金额
//     * @return
//     */
//    @POST("cashier/recharge")
//    Call<AddFood> rechargeMember(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("member_id") int member_id, @Query("amount") String amount);
//
//    /**
//     * 获取会员充值记录
//     *
//     * @param lang       语言
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param partner_id 项目ID
//     * @return
//     */
//    @POST("cashier/recharge_record")
//    Call<RechargeBean> getRechargeList(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("partner_id") int partner_id);
//
//    /**
//     * 搜索会员
//     *
//     * @param lang    语言
//     * @param user_id 用户ID
//     * @param token   口令
//     * @param mobile  联系方式
//     * @return
//     */
//    @POST("cashier/search_member")
//    Call<MemberD> searchMemberDetails(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("mobile") String mobile);
//
//    /**
//     * 会员退款
//     *
//     * @param lang      语言
//     * @param user_id   用户ID
//     * @param token     口令
//     * @param member_id 会员id
//     * @return
//     */
//    @POST("cashier/member_refund")
//    Call<AddFood> refundMember(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("member_id") int member_id);
//
//
//    //新接口分页
//
//    /**
//     * 获取店铺房间信息
//     *
//     * @param lang       语言
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param partner_id 项目ID
//     * @return
//     */
//
//    @POST("cashier/area")
//    Call<CookRoom> getCookRoon(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("partner_id") int partner_id);
//
//    /**
//     * 分页获取房间内的桌位
//     *
//     * @param lang         语言
//     * @param user_id      用户ID
//     * @param token        口令
//     * @param partner_id   项目ID
//     * @param room_id      房间ID
//     * @param current_page 页码
//     * @return
//     */
//    @Deprecated
//    @POST("cashier/room_page")
//    Call<CookeTable> getCookTable(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("partner_id") int partner_id, @Query("room_id") int room_id, @Query("current_page") int current_page);
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
//    @POST("cashier/refund_stock")
//    Call<ReturnDishes> getReturnDishes(@Query("lang") String lang, @Query("partner_id") int partner_id, @Query("user_id") int user_id, @Query("token") String token, @Query("id") int id, @Query("num") int num);
//
//    /**
//     * 撤单接口修改本地库存
//     *
//     * @param partner_id    商户ID
//     * @param user_id       用户ID
//     * @param token         口令
//     * @param temp_order_no 菜单临时订单号
//     * @return
//     */
//    @POST("cashier/cancel_order_stock")
//    Call<WithdrawAnOffer> getWithdrawAnOffer(@Query("lang") String lang, @Query("partner_id") int partner_id, @Query("user_id") int user_id, @Query("token") String token, @Query("temp_order_no") String temp_order_no);
//
//    /**
//     * 按分页查询订单
//     *
//     * @param partner_id 商户ID
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param mark       day ： 今天 week： 最近7天   month：最近30天
//     * @param type       1团购2代金券4店内点餐6外卖7快餐0全部
//     * @return
//     */
//    @POST("cashier/orders_page")
//    Call<OrderPaging> getOrderPaging(@Query("lang") String lang, @Query("partner_id") int partner_id, @Query("user_id") int user_id, @Query("token") String token, @Query("mark") String mark, @Query("start_time") long start_time, @Query("end_time") long end_time, @Query("type") int type, @Query("current_page") int current_page);
//
//    //  本地数据接口
//
//    /**
//     * 加载本地菜品分类
//     *
//     * @param lang       语言
//     * @param user_id    用户ID
//     * @param token      口令
//     * @param partner_id 项目ID
//     * @return
//     */
//    @POST("cashier/food_cateinfo")
//    Call<FoodClassifyJudge> getFoodClassify(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("partner_id") int partner_id);
//
//    /**
//     * 分页模式加载菜品，套餐
//     *
//     * @param lang         语言
//     * @param user_id      用户ID
//     * @param token        口令
//     * @param partner_id   项目ID
//     * @param current_page 页码
//     * @return
//     */
//    @POST("cashier/food_info_page")
//    Call<FoodJude> getFoods(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("partner_id") int partner_id, @Query("current_page") int current_page);
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
//    @POST("cashier/place_order_stock")
//    Call<PlaceOder> getPlaceOrder(@Query("lang") String lang, @Query("partner_id") int partner_id, @Query("user_id") int user_id, @Query("token") String token, @Query("desk_sn") int desk_sn, @Query("remark") String remark, @Query("foods") String idList, @Query("source") String source);
//
//    /**
//     * 加菜接口以作修改本地数据
//     *
//     * @param lang          语言
//     * @param user_id       用户ID
//     * @param token         口令
//     * @param temp_order_no 菜单临时订单号
//     * @param idList        菜品集合
//     * @return
//     */
//    @Deprecated
//    @POST("cashier/add_food_stock")
//    Call<PlaceOder> addPlaceOder(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("temp_order_no") String temp_order_no, @Query("foods") String idList);
//
//    /**
//     * 本地存储数据桌位信息
//     *
//     * @param lang         语言
//     * @param user_id      用户ID
//     * @param token        口令
//     * @param partner_id
//     * @param current_page 页码
//     * @return
//     */
//    @POST("cashier/all_desk_page")
//    Call<TableJude> getShopTable(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("partner_id") int partner_id, @Query("current_page") int current_page);
//    //微信支付
//
//    /**
//     * 本地化微信支付
//     *
//     * @param lang           语言
//     * @param temp_order_no  订单号
//     * @param total_amount   应支付泰铢金额
//     * @param auth_code      顾客条形码号码
//     * @param revoke         抹零金额
//     * @param discount_price 自定义打折金额
//     * @param cost           代金券面额
//     * @param partner_id     项目ID
//     * @param desk_sn        桌号
//     * @param source         下单人
//     * @return
//     */
//    @GET("paycenter/wechatSdk/example/wechat_pay.php")
//    Call<AddFood> wechatType(@Query("lang") String lang, @Query("temp_order_no") String temp_order_no, @Query("total_amount") String total_amount, @Query("auth_code") String auth_code, @Query("revoke") String revoke, @Query("discount_price") String discount_price, @Query("cost") String cost, @Query("partner_id") int partner_id, @Query("desk_sn") int desk_sn, @Query("source") String source);
//
//    /**
//     * 本地化微信支付
//     *
//     * @param lang           语言
//     * @param temp_order_no  订单号
//     * @param total_amount   应支付泰铢金额
//     * @param auth_code      顾客条形码号码
//     * @param revoke         抹零金额
//     * @param discount_price 自定义打折金额
//     * @param cost           代金券面额
//     * @param partner_id     项目ID
//     * @param desk_sn        桌号
//     * @param source         下单人
//     * @return
//     */
//    @GET("mobiletest/paycenter/f2fpay/alipay_pay.php")
//    Call<AddFood> alipayType(@Query("lang") String lang, @Query("temp_order_no") String temp_order_no, @Query("total_amount") String total_amount, @Query("auth_code") String auth_code, @Query("revoke") String revoke, @Query("discount_price") String discount_price, @Query("cost") String cost, @Query("partner_id") int partner_id, @Query("desk_sn") int desk_sn, @Query("source") String source);
//
//    /**
//     * 同步数据
//     *
//     * @param lang       语言
//     * @param user_id    用户id
//     * @param token      口令
//     * @param partner_id 项目id
//     * @param orders     订单
//     * @param source     下单人
//     * @return
//     */
//    @POST("cashier/synchronization_order")
//    Call<AddFood> syncDta(@Query("lang") String lang, @Query("user_id") int user_id, @Query("token") String token, @Query("partner_id") int partner_id, @Query("source") String source, @Query("orders") String orders);
//}
