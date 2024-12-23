package com.topBalance.wishTree.mapper;

import com.topBalance.wishTree.dto.Bamboo;
import com.topBalance.wishTree.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BambooChattingMapper {
    List<Bamboo> getAllBamboos();
}
