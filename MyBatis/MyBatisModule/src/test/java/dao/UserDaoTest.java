package dao;

import com.xeon.dao.UserDaoMapper;
import com.xeon.pojo.User;
import com.xeon.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        User user = mapper.getUserById(1);

        System.out.println("user = " + user);
        sqlSession.close();

    }


    @Test
    public void addUser() {

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);

        User user = new User("1312", "e232", "212312", "12312");
        mapper.addUser(user);

        sqlSession.commit();

        sqlSession.close();

    }


    @Test
    public void updateUser() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);
        User user = new User("8888", "306400", "喻志强", "5109U24663", 3);

        mapper.updateUser(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);
        User user = new User();
        user.setId(3);
        mapper.deleteUser(user);
        sqlSession.commit();
        sqlSession.close();

    }
}