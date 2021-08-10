package com.yzq.Integral_process_server.server;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.yzq.Integral_process_server.server.bean.User;
import com.yzq.Integral_process_server.server.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class TestDB_Utils {
    public static void main(String[] args) {

        DruidPooledConnection connection = null;
        try {
            connection = DruidUtils.druidDataSource.getConnection();

            String sql = "select * from account";


            QueryRunner queryRunner = new QueryRunner();

            List<User> userList = queryRunner.query(connection, sql, new BeanListHandler<>(User.class));


            userList.forEach(it -> {
                System.out.println("it = " + it);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
