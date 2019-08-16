package cn.itcast.service;

import cn.itcast.dao.Dao;
import cn.itcast.dao.Daoimp;
import cn.itcast.dao.PageBean;
import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

public class Serviceimp implements Service {

    private Dao dao = new Daoimp();
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User Login(User user) {
        return dao.Login(user);
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void update(User user) {
        dao.update(user);
    }

    @Override
    public User findUser(User user) {
        return dao.findUser(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.deleteUser(id);
    }

    @Override
    public PageBean<User> fingPageByUser(String _currentpage, String _rows, Map<String, String[]> condition) {
        PageBean<User> pageBean = new PageBean<User>();
        Dao  dao = new Daoimp();
        if(_rows==null){
            _rows="5";
        }
        if(_currentpage==null){
            _currentpage="1";
        }
        int currentpage = Integer.parseInt(_currentpage);
        int rows = Integer.parseInt(_rows);
        pageBean.setCurrentpage(currentpage);
        pageBean.setRows(rows);
        int count = dao.findcount(condition);
        pageBean.setTotalcount(count);
//        int start = (currentpage-1)*rows; //开始的索引
        //传入当前页面和查找记录的大小
        List<User> userList = dao.findUserList(currentpage,rows,condition);
        pageBean.setPagelist(userList);
        pageBean.setPagecount(count%rows==0?count/rows:(count/rows)+1);
        return pageBean;
    }
}
