package com.chapter06_02.dao;

import com.chapter06_02.domain.Users;

import java.util.List;

public interface UserDao {
    /**
     * 从Users表中查找列为field，值包含value的所有用户信息
     *
     * @param field 列名
     * @param value 值
     * @return 符合的结果
     */
    public List<Users> listUsersByCondition(String field, String value);

    /**
     * 用户登录方法
     *
     * @param name 用户名
     * @param pwd  密码
     * @return true 代表登录成功   false代表登录失败
     */
    public boolean doLogin(String name, String pwd);

    /**
     * 修改用户信息
     *
     * @param field    需要修改的字段
     * @param value    修改后的值
     * @param loginId  用户登录的ID
     * @param loginPwd 用户登录的密码
     * @return
     */
    public boolean doUpdate(String field, String value, String loginId, String loginPwd);

    /**
     * 注册方法
     *
     * @param name        用户名
     * @param onePassword 第一次输入密码
     * @param twoPassword 第二次输入密码
     * @return true为注册成功，false为注册失败
     */
    public boolean doRegister(String name, String onePassword, String twoPassword);
}
