package com.topBalance.wishTree.mapper;

import com.topBalance.wishTree.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // sql 에 작성한 id를 가져와서 자바에서 사용하겠다는 설정 표기
// MyBatis 매퍼 인터페이스로 지정. SQL매퍼 XML파일에서 작성된 쿼리와 이 인터페이스의 메서드 연결
// XML에서 정의한 SQL쿼리를 JAVA메서드로 호출가능
// 매퍼 XML 파일에서 정의된 SQL문을 사용해서 DB와 상호작용
public interface RankingMapper {
    // xml 파일에 id 값 설정한 기능 목록 조회

    // 모든 유저 목록 조회
    List<User> getTenRank();

    int selectRank(int total_score);
}


