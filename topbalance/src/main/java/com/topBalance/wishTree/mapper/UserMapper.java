package com.topBalance.wishTree.mapper;

import com.topBalance.wishTree.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;


import java.util.List;

@Mapper
public interface UserMapper {
    /*
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
    User getUser(int userId);*/
    List<User> getAllUsers();

    //유저저장하기
    void insertUser(User user);

    //id 분실시 유저이름과,전화번호/ /이름과 생년월일 성별을 통한 아이디찾기 뒤에서 4자리 가리기
    //String findById(String userName, String userPhone);
    //pw 분실시 id와 이름, 전화번호/ /id와 이름 생년월일 성별을 통한 비밀번호찾기
    //String findByPassword(String userName, String userPhone);
    //회원정보 수정
    void updateUser(User user);
    //비번찾기 - 아이디,핸드폰번호

    String findByPassword(String userId, String userPhone);

    String findById(String userName, String userPhone, Date userBirthdate);

    User login(String userId, String userPassword);

    User findUserById(String userId);

    void updatingTotalScore(int totalScore, String userId);

    User findUserByIdUser(String userId);

}