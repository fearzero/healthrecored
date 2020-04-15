package com.fear.healthrecord.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;
@Mapper
@Repository
public interface UserIdCreateMapper {
    Map<String,Object> selectUserId();
    int insertUserId(Map<String,Object> map);
    int upadteUserId(Map<String,Object> map);
}
