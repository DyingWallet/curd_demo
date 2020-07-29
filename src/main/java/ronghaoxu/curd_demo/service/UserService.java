package ronghaoxu.curd_demo.service;

import org.springframework.stereotype.Service;
import ronghaoxu.curd_demo.mapper.UserMapper;
import ronghaoxu.curd_demo.pojo.User;
import ronghaoxu.curd_demo.utils.TimeHandler;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Service
public class UserService {
    @Resource
    UserMapper mapper;

    public boolean insertUser(User user) {
        Timestamp stamp = TimeHandler.currentTimestamp();
        user.setCreate_time(stamp);
        user.setUpdate_time(stamp);
        return mapper.insertUser(user);
    }

    public boolean delUser(String id) {
        return mapper.deleteUser(id);
    }

    public Object queryById(String id) {
        return mapper.queryById(id);
    }

    public boolean changePasswd(User user) {
        user.setUpdate_time(TimeHandler.currentTimestamp());
        return mapper.changePassword(user);
    }

    public boolean changeState(User user) {
        user.setUpdate_time(TimeHandler.currentTimestamp());
        return mapper.changeState(user);
    }

    public List<User> queryAll() {

        return mapper.queryAll();
    }
}
