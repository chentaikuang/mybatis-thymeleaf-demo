package com.example.demo.controller;

import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    UserInfoService userInfoService;

    /**
     * http://localhost:8888/test/getById?id=1
     * @param id
     * @return
     */
    @RequestMapping("/getById")
    public UserInfo getById(int id) {
        UserInfo user = userInfoService.getById(id);
        if (user == null) {
            user = new UserInfo();
            user.setName("xiao chen");
            user.setId(id);
            user.setAge(8);
            user.setRemark("no found by id["+id+"]");
        }
        return user;
    }

    /**
     * http://localhost:8888/test/changeAgeById?id=1&age=10
     * @param id
     * @param age
     * @return
     * @throws Exception
     */
    @RequestMapping("/changeAgeById")
    public UserInfo changeAgeById(int id,int age) throws Exception {
        UserInfo user = userInfoService.getById(id);
        if (user == null){
            throw new Exception("no found user by id,id : " + id);
        }
        user.setAge(age);
        return userInfoService.changeAgeById(user);
    }

    /**
     * http://localhost:8888/test/addUser
     * @return
     * @throws Exception
     */
    @RequestMapping("/addUser")
    public boolean addUser() throws Exception {
        boolean flag = userInfoService.addUser();
        if (!flag){
            throw new Exception("Create User Fail");
        }
        return flag;
    }

}