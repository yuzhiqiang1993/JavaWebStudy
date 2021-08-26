package dao;

import com.xeon.dao.UserDaoMapper;
import com.xeon.pojo.User;
import com.xeon.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

public class UserDaoTest {
    @Test
    public void getUserList() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);
        List<User> users = mapper.getUsers();

        users.forEach(it -> {
            System.out.println("it = " + it.toString());
        });


        sqlSession.close();
    }


    @Test
    public void testGetUser() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);


        final User user = new User();
        user.setGid("5109U24613");

        User userResult = mapper.getUser(user);

        System.out.println("user = " + userResult);
        sqlSession.close();



        /*测试缓存*/
        user.setId(1);
        final SqlSession sqlSession1 = MyBatisUtil.getSqlSession();

        final UserDaoMapper mapper1 = sqlSession1.getMapper(UserDaoMapper.class);

        final User userById = mapper1.getUser(user);

        System.out.println("userById = " + userById);

        sqlSession1.close();

    }


    @Test
    public void addUser() {

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);

        User user = new User("1312", "e232", "212312", String.valueOf(new Random(1).nextInt(9999)));
        mapper.addUser(user);

        sqlSession.commit();

        sqlSession.close();

    }


    @Test
    public void updateUser() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);
        User user = new User("8888", "306400", "喻志强111", "5109U24663", 6);

        mapper.updateUser(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);
        User user = new User();
        user.setId(3);
        mapper.deleteUser(user);
        sqlSession.commit();
        sqlSession.close();

    }


    @Test
    public void getUserBySearch() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);

        List<User> users = mapper.getUsersLike("%x%");
        System.out.println("users = " + users);

        sqlSession.close();

    }

    @Test
    public void getUserByName() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);

        final User user = mapper.getUserByName("xeon");

        System.out.println("user = " + user);

        sqlSession.close();

    }
}
