package com.topBalance.wishTree.service;

import com.topBalance.wishTree.dto.User;
import com.topBalance.wishTree.dto.WishTree;

public interface WishTreeService {

    void insertWish(WishTree wishTree);

    User getWishTree(User logInUser);
}