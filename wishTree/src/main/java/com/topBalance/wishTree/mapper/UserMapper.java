package com.topBalance.wishTree.mapper;

import com.topBalance.wishTree.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getAllUsers();

    //회원가입 - 유저저장하기
    void insertUser(User user);

    //회원정보 - 수정
    void updateUser(User user);

    //비번찾기 - 아이디,핸드폰번호
    String findByPassword(String userId, String userPhone);

    //아이디찾기 - 이름 ,핸드폰번호 ,생년월일
    String findById(String userName, String userPhone, Date userBirthdate);

    //로그인 - 아이디, 비밀번호
    User login(String userId, String userPassword);

    //유저 아이디로 전체 정보 호출 - 유저 정보 불러오기시 필요
    User findUserById(String userId);
    // 회원가입시 중복 정보 확인용
    int checkUsers(String userId);
    // 게임 점수 업데이트용
    void updatingTotalScore(int totalScore, String userId);
}


