package com.topBalance.wishTree.mapper;

import com.topBalance.wishTree.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // xml 파일에 id 값 설정한 기능 목록 조회

    // 모든 유저 목록 조회
    //SELECT * FROM USERPROFILE
    List<User> getAllUsers();

    // 유저 저장하기
    void insertUser(User user);

    // 이메일로 이름 찾기
    String findByUsername(String email);

    // 이름과 성별로 이메일 찾기
    String findByEmail(String username, String gender);

    // 유저 아이디 번호 통해서 유저에 대한 정보 가져오기
    User getUser(int userId);
}