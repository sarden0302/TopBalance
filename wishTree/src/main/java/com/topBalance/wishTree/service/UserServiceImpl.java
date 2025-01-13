package com.topBalance.wishTree.service;

import com.topBalance.wishTree.dto.User;
import com.topBalance.wishTree.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    // 테스트용 함수 전체 정보 가져오기
    @Override
    public List<Map<String, Object>> getAllUsers() {
        List<User> userList = userMapper.getAllUsers();
        return userList.stream().map(user -> {
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("userId", user.getUserId());
            return userMap;
        }).collect(Collectors.toList());
    }


    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public String findByPassword(String userId, String userPhone) {
        return userMapper.findByPassword(userId,userPhone);
    }

    @Override
    public String findById(String userName, String userPhone,Date userBirthdate) {
        return userMapper.findById(userName, userPhone, userBirthdate);
    }

    @Override
    public User login(String userId, String userPassword) {
        return userMapper.login(userId, userPassword);
    }

    @Override
    public User findUserById(String userId) {
        return userMapper.findUserById(userId);
    }

    @Override
    public boolean checkUsers(String userId) {
        boolean duplicated = userMapper.checkUsers(userId) > 0;
        System.out.println("중복확인 : " + duplicated);
        return duplicated;
    }
}
