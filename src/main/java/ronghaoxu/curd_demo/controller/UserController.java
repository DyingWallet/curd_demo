package ronghaoxu.curd_demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.web.bind.annotation.*;
import ronghaoxu.curd_demo.pojo.User;
import ronghaoxu.curd_demo.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    @Resource
    private UserService service;

    private final String format = "application/json;charset=UTF-8";

    //增
    @PostMapping(value = "/signIn",produces = format)
    public boolean signIn(@RequestBody String userJson){
        return service.insertUser(JSON.parseObject(userJson,User.class));
    }

    //删
    @PostMapping(value = "/delUser",produces = format)
    public boolean delUser(@RequestBody String idJson){
        return service.delUser(JSON.parseObject(idJson,String.class));
    }

    //查
    @GetMapping("/queryById")
    public String queryById(@RequestParam(value = "id") String id){
        return JSON.toJSONString(service.queryById(id), SerializerFeature.WriteClassName);
    }

    @GetMapping("/queryAll")
    public String queryAll(){
        return JSON.toJSONString(service.queryAll(),SerializerFeature.WriteClassName);
    }

    //改密码
    @PostMapping(value = "/changePasswd",produces = format)
    public boolean changePasswd(@RequestBody String userJson){
        return service.changePasswd(JSON.parseObject(userJson,User.class));
    }

    //改用户状态
    @PostMapping(value = "/changeState",produces = format)
    public boolean changeState(@RequestBody String userJson){
        return service.changeState(JSON.parseObject(userJson,User.class));
    }
}
