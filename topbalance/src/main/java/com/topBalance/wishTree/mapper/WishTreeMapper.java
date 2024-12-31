package com.topBalance.wishTree.mapper;

import com.topBalance.wishTree.dto.WishTree;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WishTreeMapper {

    //소원 한줄 입력받기
    void insertWish(WishTree wishTree);

    List<WishTree> getAllWishTree();

    void deleteRecentWishTree();

    WishTree ifWishTreeExists(String userId);

    void updatingWishTree(String userId, String userWish);
}
