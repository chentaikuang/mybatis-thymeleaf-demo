package com.example.demo.service;

import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.dao.UserInfoDao;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@Service(value = "userInfoService")
public class UserInfoService {

    @Resource
    private UserInfoDao userInfoMapper;

    public UserInfo getById(int id){
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(Integer.valueOf(id));
        return userInfo;
    }

    public UserInfo changeAgeById(UserInfo userInfo) throws Exception {
        int no = userInfoMapper.updateByPrimaryKey(userInfo);
        if (no == 0){
            throw new Exception("change age by id fail ,id : "+userInfo.getId());
        }
        return  getById(userInfo.getId());
    }

    public List<UserInfo> getAll() {
        List<UserInfo> users = userInfoMapper.getUsers();
        return  users;
    }

    public boolean addUser() {
        UserInfo user = new UserInfo();
        user.setAge(RandomUtils.nextInt(1,100));
        user.setRemark(RandomStringUtils.randomAlphanumeric(8));
        user.setName(RandomStringUtils.randomAlphanumeric(10));
        int no = userInfoMapper.insertSelective(user);
        return no>0;
    }
}
