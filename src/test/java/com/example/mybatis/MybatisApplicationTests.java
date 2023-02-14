package com.example.mybatis;

import com.example.mybatis.mapper.UserMapper;
import com.example.mybatis.user.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisApplicationTests {

    @Resource
    private UserMapper userMapper;
    @Test
    void contextLoads() {
    }

    @Test
    void testSelectList(){
        List<User> users =userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    @Test
    public void testInsert(){

        User user = new User();
        user.setName("Helen");
        user.setAge(18);
        //不设置email属性，则生成的动态sql中不包括email字段

        int result = userMapper.insert(user);
        System.out.println("影响的行数：" + result); //影响的行数
        System.out.println("id：" + user.getId()); //id自动回填
    }
}
