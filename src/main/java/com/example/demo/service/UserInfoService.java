package com.example.demo.service;

import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.dao.UserInfoDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
