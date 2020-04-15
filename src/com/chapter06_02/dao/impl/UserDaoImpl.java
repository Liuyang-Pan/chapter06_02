package com.chapter06_02.dao.impl;

import com.chapter06_02.dao.UserDao;
import com.chapter06_02.domain.Users;
import com.chapter06_02.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Properties;

/**
 * UserDao实现类
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    /**
     * 得到SqlSession
     */
    SqlSession sqlSession = MyBatisUtils.getSqlSession();

    /**
     * 模糊查询实现
     *
     * @param field 列名
     * @param value 值
     * @return 查询到的数据
     */
    @Override
    public List<Users> listUsersByCondition(String field, String value) {
        Properties properties = new Properties();
        properties.setProperty("field", field);
        properties.setProperty("value", value);
        List<Users> users = sqlSession.selectList("com.chapter06_02.mapper.UsersMapper.listUsers", properties);
        sqlSession.close();
        return users;
    }

    /**
     * 登录方法实现
     *
     * @param name 用户名
     * @param pwd  密码
     * @return true：成功 false：失败
     */
    @Override
    public boolean doLogin(String name, String pwd) {
        Users users = new Users();
        users.setLoginId(name);
        users.setLoginPwd(pwd);
        int rows = sqlSession.selectOne("com.chapter06_02.mapper.UsersMapper.doLogin", users);
        sqlSession.close();
        return rows > 0 ? true : false;
    }

    /**
     * 更新操作实现
     *
     * @param field    需要修改的字段
     * @param value    修改后的值
     * @param loginId  用户登录的ID
     * @param loginPwd 用户登录的密码
     * @return true：成功 false：失败
     */
    @Override
    public boolean doUpdate(String field, String value, String loginId, String loginPwd) {
        Properties properties = new Properties();
        properties.setProperty("field", field);
        properties.setProperty("value", value);
        properties.setProperty("loginId", loginId);
        properties.setProperty("loginPwd", loginPwd);
        int rows = sqlSession.update("com.chapter06_02.mapper.UsersMapper.updateUsers", properties);
        sqlSession.commit();
        sqlSession.close();
        return rows > 0 ? true : false;
    }

    @Override
    public boolean doRegister(String name, String onePassword, String twoPassword) {
        Users users = new Users();
        users.setLoginId(name);
        users.setLoginPwd(twoPassword);
        int rows = sqlSession.insert("com.chapter06_02.mapper.UsersMapper.doRegister", users);
        sqlSession.commit();    //插入操作需要将事务提交上去才能写入到数据库中
        sqlSession.close();
        return rows > 0 ? true : false;
    }
}
