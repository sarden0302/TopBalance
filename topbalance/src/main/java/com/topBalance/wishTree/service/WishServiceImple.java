package com.topBalance.wishTree.service;

import com.topBalance.wishTree.dto.WishTree;
import com.topBalance.wishTree.mapper.WishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WishServiceImple implements WishService {

    @Autowired
    private WishMapper wishMapper;

    @Override
    public List<Map<String, Object>> getSevenWish() {
        List<WishTree> wishList = wishMapper.getSevenWish();
        return wishList.stream().map( user -> {
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("userId", user.getUserId());
            userMap.put("userWish", user.getUserWish());
            userMap.put("wishDate", user.getWishDate());

            return userMap;
        }).collect(Collectors.toList());
    }

    @Override
    public String selectWish(String userWish) {
        return wishMapper.selectWish(userWish);

    }
}