package com.ruhaly.androidsdk.baseapi;

/**
 * Created by hlr on 2015/9/17.
 */
public class Urls {


    /***
     * 本地环境
     ***/
//    public static final String urls = "http://192.168.1.154:8090";
//    public static final String loginurl =
//            "http://192.168.1.154:8090/Egj-CSM-public/appUser";// 小龙
//    public static final String qcode = "http://192.168.1.154:8090";
//    public static final String yizhuanyuan_info =
//            "http://192.168.1.154:8090/Egj-CSM-public/egjHelper";
//    public static final String togoHelp =
//            "http://192.168.1.154:8090/Egj-CSM-public/appUser";
//    public static final String downLoadPic =
//            "http://192.168.1.154:8090/Egj-CSM-public/egjHelper";
//    public static final String needurl =
//            "http://192.168.1.154:8090/Egj-CSM-public/appDemandController";
//    public static final String chaturl = "http://192.168.1.154:8090/Egj-IM";
//    public static final String orderurl =
//            "http://192.168.1.154:8090/Egj-CSM-public/appDemandController";
//    public static final String checkAppVersion =
//            "http://192.168.1.154:8090/Egj-CSM-public/appDownloadController";
    /***
     *
     * 221
     *
     * ****/
//	 public static final String urls = "http://192.168.1.221:8090";
//	 public static final String loginurl =
//	 "http://192.168.1.221:8090/csm-public/appUser";// 小龙
//	 public static final String yizhuanyuan_info =
//	 "http://192.168.1.221:8090/csm-public/egjHelper";
//	 public static final String togoHelp =
//	 "http://192.168.1.221:8090/csm-public/appUser";
//	 public static final String downLoadPic =
//	 "http://192.168.1.221:8090/csm-public/egjHelper";
//	 public static final String needurl =
//	 "http://192.168.1.221:8090/csm-public/appDemandController";
//	 public static final String chaturl = "http://192.168.1.221:8090/Egj-IM";
//	 public static final String orderurl =
//	 "http://192.168.1.221:8090/csm-public/appDemandController";
//	 public static final String checkAppVersion =
//	 "http://192.168.1.221:8090/csm-public/appDownloadController";
    /**
     * 211
     **/
    public static final String urls = "http://stage-im.eachonline.com:90";
    public static final String loginurl =
            "http://stage-www.eachonline.com:90/appUser";// 小龙
    public static final String yizhuanyuan_info =
            "http://stage-www.eachonline.com:90/egjHelper";
    public static final String togoHelp =
            "http://stage-www.eachonline.com:90/appUser";
    public static final String downLoadPic =
            "http://stage-www.eachonline.com:90/egjHelper";
    public static final String needurl =
            "http://stage-www.eachonline.com:90/appDemandController";
    public static final String chaturl = "http://stage-im.eachonline.com:90";
    public static final String orderurl =
            "http://stage-www.eachonline.com:90/appDemandController";
    public static final String checkAppVersion =
            "http://stage-www.eachonline.com:90/appDownloadController";
    //    线上
//    public static final String urls = "http://im.eachonline.com";
//    public static final String loginurl = "http://www.eachonline.com/appUser";// 小龙
//    public static final String yizhuanyuan_info = "http://www.eachonline.com/egjHelper";
//    public static final String togoHelp = "http://www.eachonline.com/appUser";
//    public static final String downLoadPic = "http://www.eachonline.com/egjHelper";
//    public static final String needurl = "http://www.eachonline.com/appDemandController";
//    public static final String chaturl = "http://im.eachonline.com";
//    public static final String orderurl = "http://www.eachonline.com/appDemandController";
//    public static final String checkAppVersion = "http://www.eachonline.com/appDownloadController";
    // 登录
    public static final String mlogins = loginurl + "/login.shtml";
    // 验证码
    public static final String myanzheng = loginurl + "/getCerCode.shtml";
    // 验证
    public static final String yanzheng = loginurl + "/validatePhone.shtml";
    // 重置密码
    public static final String resetpwd = loginurl + "/resetPwd.shtml";
    // 注册
    public static final String regist = loginurl + "/reg.shtml";
    // 修改用户名
    public static final String CHANGE_USER_NAME = loginurl
            + "/reSetUsername.shtml";
    // 修改密码
    public static final String CHANGE_PWD = loginurl + "/reSetPassword.shtml";
    // 判断验证码手机号
    public static final String GET_CERCODE = loginurl + "/validatePhone.shtml";
    // 修改绑定手机号码
    public static final String CHANG_BD_PHONENUM = loginurl
            + "/reSetPhone.shtml";
    // 逸专员查询资料
    public static final String YZY_INFO = yizhuanyuan_info + "/getInfo.shtml";
    // 获取地区信息
    public static final String getArea = togoHelp + "/getCityList.shtml";
    // 单张图片上传
    public static final String forHelp_dowloadPic = downLoadPic
            + "/insertEgjPics.shtml";
    // 上传专员资料
    public static final String forhelp_submit = downLoadPic
            + "/insertEgj.shtml";
    // 获取身份信息
    public static final String getUserInfo = togoHelp
            + "/getUserInfoById.shtml";
    // 发布需求
    public static final String fabuNeed = needurl + "/releaseRequirement.shtml";
    // 订单列表
    public static final String needList = orderurl + "/myOrder.shtml";
    public static final String needDetail = orderurl + "/myOrderDetails.shtml";
    public static final String changeNeedState = togoHelp
            + "/serviceClickStatus.shtml";
    public static final String complain = togoHelp + "/complain.shtml";
    // 获取token
    public static final String gettoken = chaturl + "/appToken";
    // 检查更新App
    public static final String goCheckApp = checkAppVersion
            + "/getDownload.shtml";
    // 获取用户信息
    public static final String getuserinfo = chaturl + "/getUserInfo";

}
