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
        List<WishTree> wishTreeList = wishTreeMapper.getAllWishTree();

        if (wishTreeMapper.ifWishTreeExists(wishTree.getUserId()) != null){
            wishTreeMapper.updatingWishTree(wishTree.getUserId(), wishTree.getUserWish());
            return;
        }

        if (wishTreeList.size() == 10) {
            wishTreeMapper.deleteRecentWishTree();
        }

        wishTreeMapper.insertWish(wishTree);
    }

    @Override
    public User getWishTree(User logInUser) {
        return logInUser;
    }
}