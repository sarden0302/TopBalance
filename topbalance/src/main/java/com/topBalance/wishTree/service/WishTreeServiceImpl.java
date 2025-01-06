package com.topBalance.wishTree.service;

import com.topBalance.wishTree.dto.Bamboo;
import com.topBalance.wishTree.dto.User;
import com.topBalance.wishTree.dto.WishTree;
import com.topBalance.wishTree.mapper.WishTreeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishTreeServiceImpl implements WishTreeService{

    @Autowired
    private WishTreeMapper wishTreeMapper;

    @Override
    public void insertWish(WishTree wishTree) {
        // 만약 현재 유저가 작성한 wishtree 가 DB에 존재한다면 기존에 작성한 DB를 UPDATE
        if (wishTreeMapper.ifWishTreeExists(wishTree.getUserId()) != null){
            wishTreeMapper.updatingWishTree(wishTree.getUserId(), wishTree.getUserWish());  // 해당 DB를 UPDATE
            return;
        }

        // wishtree를 작성한 유저가 10명인지 확인하기 위해서 list로 전체 데이터를 받는다.
        List<WishTree> wishTreeList = wishTreeMapper.getAllWishTree();

        if (wishTreeList.size() == 10) {
            wishTreeMapper.deleteRecentWishTree(); // 가장 처음에 작성한 wishTree 정보 삭제
        }

        wishTreeMapper.insertWish(wishTree); // 새로운 데이터 INSERT
    }

    @Override
    public User getWishTree(User logInUser) {
        return logInUser;
    }
}