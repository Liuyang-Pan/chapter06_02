package com.chapter06_02.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtilsForDBmybatis {
    static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config1.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到SqlSession
     *
     * @return SqlSession对象
     */
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
