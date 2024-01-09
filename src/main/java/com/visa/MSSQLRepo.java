package com.visa;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class MSSQLRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getUsers() {

        SqlRowSet rs = jdbcTemplate.queryForRowSet("SELECT [Id]\r\n" + //
                "      ,[Name]\r\n" + //
                "      ,[Date]\r\n" + //
                "  FROM [dbo].[TestTable]");
        List<User> users = new LinkedList<>();

        while (rs.next()) {
            User u = new User();
            u.setId(rs.getString("Id"));
            u.setName(rs.getString("Name"));
            u.setDate(rs.getString("Date"));
            users.add(u);
        }

        return users;
    }
}
