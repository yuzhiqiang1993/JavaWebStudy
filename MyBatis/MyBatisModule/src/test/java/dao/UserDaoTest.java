package dao;

import com.xeon.dao.UserDaoMapper;
import com.xeon.pojo.User;
import com.xeon.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void testUser() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);
        List<User> users = mapper.getUsers();

        users.forEach(it -> {
            System.out.println("it = " + it.toString());
        });
    }


}
