package cn.itcast.dao;

import cn.itcast.Utils.DButils;
import cn.itcast.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

public class Daoimp implements Dao{
    @Override

    public List<User> findAll()  {
        JdbcTemplate template = new JdbcTemplate(DButils.getDataSource());
        String sql = "select * from userinfo";
        List<User> userList = template.query(sql,new BeanPropertyRowMapper<User>(User.class));
        return userList;

    }

    @Override
    public User Login(User user) {
        JdbcTemplate template = new JdbcTemplate(DButils.getDataSource());
        String sql = "select * from userinfo where name = ? and password = ?";
        System.out.printf(user.getName()+user.getPassword());

        User user1= null;
        try {
            user1 = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),user.getName(),user.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user1;
    }

    @Override
    public void addUser(User user) {
        JdbcTemplate template = new JdbcTemplate(DButils.getDataSource());
        System.out.printf(user.toString());
        String sql ="insert into userinfo(name,gender,age,qq,email,address) values(?,?,?,?,?,?)";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getQq(),user.getEmail(),user.getAddress());
    }

    @Override
    public void update(User user) {
        JdbcTemplate template = new JdbcTemplate(DButils.getDataSource());

        String sql ="update userinfo set name=?,gender=?,age=?,qq=?,email=?,address=? where id =?";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getQq(),user.getEmail(),user.getAddress(),user.getId());

    }

    @Override
    public User findUser(User user) {
        String sql = "select * from userinfo where id=?";
        JdbcTemplate template = new JdbcTemplate(DButils.getDataSource());
        User user1  = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),user.getId());
        return user1;
    }

    @Override
    public void deleteUser(String id) {
        String sql = "delete from userinfo where id=?";
        JdbcTemplate template = new JdbcTemplate(DButils.getDataSource());
        template.update(sql,id);
    }

    @Override
    public int findcount(Map<String, String[]> condition) {
        String sql = "select count(*) from userinfo WHERE 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> set  = condition.keySet();
        List<Object> list = new ArrayList<Object>();
        for(String key:set){
            if(key.equals("currentpage")||key.equals("rows")){
                continue;
            }
            String value = condition.get(key)[0];
            if(value!=null&&!value.equals("")){
                sb.append(" and "+key+" like ? ");
                list.add("%"+value+"%");

            }

        }
        System.out.println(sb.toString());
        JdbcTemplate template = new JdbcTemplate(DButils.getDataSource());
//        System.out.println(Arrays.toString(list.toArray()));
        return template.queryForObject(sb.toString(),Integer.class,list.toArray());
    }

    @Override
    public List<User> findUserList(int pageindex, int pagesize, Map<String, String[]> condition) {
        String sql = "select * from userinfo where 1 = 1 ";
        JdbcTemplate template = new JdbcTemplate(DButils.getDataSource());
        StringBuilder sb = new StringBuilder(sql);
        Set<String> set  = condition.keySet();
        List<Object> list = new ArrayList<Object>();
        for(String key:set) {
            if (key.equals("currentpage") || key.equals("rows")) {
                continue;
            }
            String value = condition.get(key)[0];
            if (value != null && !value.equals("")) {
                sb.append(" and " + key + " like ? ");
                list.add("%" + value + "%");
            }
        }
        sb.append("order by id offset("+(pageindex-1)*pagesize+") rows fetch next "+pagesize+" rows only");
        System.out.println(sb.toString());
        System.out.println(list.toString());
        List<User>  userList = template.query(sb.toString(),new BeanPropertyRowMapper<User>(User.class),list.toArray());

       return userList;
    }
}

