/**
 * Copyright (c) 2018 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.common.redis;

/**
 * @author Mr.star 26011687@qq.com
 * @since 1.0.0
 */
public class RedisKeys {
    /**
     * 系统参数Key
     */
    public static String getSysParamsKey(){
        return "sys:params";
    }

    /**
     * 验证码Key
     */
    public static String getCaptchaKey(String uuid){
        return "sys:captcha:" + uuid;
    }

    /**
     * 登录用户Key
     */
    public static String getSecurityUserKey(Long id){
        return "sys:security:user:" + id;
    }

    /**
     * 系统日志Key
     */
    public static String getSysLogKey(){
        return "sys:log";
    }

    /**
     * 系统资源Key
     */
    public static String getSysResourceKey(){
        return  "sys:resource";
    }

    /**
     * 用户菜单导航Key
     */
    public static String getUserMenuNavKey(Long userId){
        return "sys:user:nav:" + userId;
    }

    /**
     * 用户权限标识Key
     */
    public static String getUserPermissionsKey(Long userId){
        return "sys:user:permissions:" + userId;
    }
    /**
     *  key: mobile
     *  value: smsCode
     *  过期时间5分钟
     */
    public final static String SMS_CODE = "sms_code:";

    /**
     *  key: userId
     *  value: userId
     *  过期时间5分钟
     */
    public final static String LOGIN_IP = "login_ip:";

    /**
     *  key: userId
     *  value: List<String>
     */
    public final static String GPT_KEY = "gpt_key";
    /**
     * 重复提交锁
     */
    public final static String SUBMIT_FORM = "submit_form:";
}
