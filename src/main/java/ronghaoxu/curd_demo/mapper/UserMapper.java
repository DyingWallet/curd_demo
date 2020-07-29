package ronghaoxu.curd_demo.mapper;

import ronghaoxu.curd_demo.pojo.User;

import java.util.List;

public interface UserMapper {

    //查询
    User queryById(String id);
    List<User> queryAll();
    //更改密码
    boolean changePassword(User user);
    //更改用户账号状态
    boolean changeState(User user);
    //新增用户
    boolean insertUser(User user);
    //删除用户
    boolean deleteUser(String id);
}
