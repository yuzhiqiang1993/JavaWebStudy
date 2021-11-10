package com.xeon.springboot_mp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xeon.springboot_mp.dao.User;
import com.xeon.springboot_mp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class SpringbootMpApplicationTests {


    @Autowired
    UserService userService;


    @Test
    void contextLoads() {
    }

    @Test
    void getUserList() {
        final List<User> list = userService.list(null);
        System.out.println("list = " + list);
    }


    @Test
    public void batchInsert() {
        final List<User> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setName(getRandomString(5));
            user.setAge(new Random().nextInt(100));

            if (i % 2 == 0) {
                user.setGender("女");
            } else {
                user.setGender("男");
            }

            users.add(user);
        }

        final boolean save = userService.saveBatch(users);
        System.out.println("save = " + save);

    }

    @Test
    public void testInsert() {
        final User user = new User();

        user.setName(getRandomString(3));
        user.setAge(new Random().nextInt(30));
        user.setGender("男");

        final boolean save = userService.save(user);

        System.out.println("插入数据===》save = " + save);
    }


    @Test
    void updateUser() {
        final User user = new User();
        user.setName("uodateName");

        user.setId(205L);
        user.setGender("男");
        user.setAge(20);
        final boolean b = userService.updateById(user);

        System.out.println("更新user = " + b);
    }

    @Test
    public void testPage() {

        final Page<User> userPage = new Page<>();
        /*查询的时候会减1  传1就是从0开始查*/
        userPage.setCurrent(1);
        userPage.setSize(5);

        /*配置查询条件*/
        final QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("enable", 1);
        final Page<User> page = userService.page(userPage, userQueryWrapper);

        System.out.println("page.getRecords() = " + page.getRecords());
        System.out.println("page.getTotal() = " + page.getTotal());


    }


    /**
     * 随机字符串
     *
     * @param length
     * @return
     */
    public String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();


    }


}
