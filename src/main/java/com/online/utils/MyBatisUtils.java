package com.online.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by panlu02 on 2017/5/2.
 */
public class MyBatisUtils {
    private static SqlSessionFactory sessionFactory;

    public static SqlSession getSession() throws IOException {
        String resource = "/MyBatisConfig.xml";
        InputStream is;
        if (sessionFactory == null) {
            is = Resources.getResourceAsStream(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(is);
        }

        return sessionFactory.openSession();
    }
}
