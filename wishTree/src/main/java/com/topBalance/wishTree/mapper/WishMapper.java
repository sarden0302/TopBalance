package com.topBalance.wishTree.mapper;

import com.topBalance.wishTree.dto.WishTree;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // sql 에 작성한 id를 가져와서 자바에서 사용하겠다는 설정 표기
public interface WishMapper {
    // xml 파일에 id 값 설정한 기능 목록 조회

    // 모든 유저 목록 조회
    List<WishTree> getSevenWish();

    String selectWish(String userWish);
}