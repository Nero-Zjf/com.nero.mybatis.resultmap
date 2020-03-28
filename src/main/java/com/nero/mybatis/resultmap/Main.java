package com.nero.mybatis.resultmap;

import com.nero.mybatis.resultmap.domain.User;
import com.nero.mybatis.resultmap.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            //-------------------------使用 XML 构建 SqlSessionFactory-------------------------
            // 读取配置文件 mybatis-config.xml
            InputStream config = Resources
                    .getResourceAsStream("mybatis-config.xml");
            // 根据配置文件构建SqlSessionFactory
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder()
                    .build(config);
            //--------------------------------------------------------

            // 通过 SqlSessionFactory 创建 SqlSession
            SqlSession ss = ssf.openSession();
            // SqlSession执行映射文件中定义的SQL，并返回映射结果

            //获取UserMapper接口
            UserMapper userMapper = ss.getMapper(UserMapper.class);

            // 查询所有用户 Map方式
            System.out.println("查询所有用户 Map方式");
            List<Map<String, Object>> userMapList = userMapper.getAllUser();
            for (Map<String, Object> userMap : userMapList) {
                System.out.println(userMap);
            }

            // 查询所有用户 resultMap方式
            System.out.println("查询所有用户 resultMap方式");
            List<User> userList = userMapper.getAllUser2();
            for (User user :
                    userList) {
                System.out.println(user);
            }

            // 查询所有用户 自动映射方式
            System.out.println("查询所有用户 自动映射方式");
            List<User> userList3 = userMapper.getAllUser3();
            for (User user :
                    userList3) {
                System.out.println(user);
            }

            // 提交事务
            ss.commit();
            // 关闭 SqlSession
            ss.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
