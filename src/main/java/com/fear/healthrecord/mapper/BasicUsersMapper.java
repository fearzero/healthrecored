package com.fear.healthrecord.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface BasicUsersMapper {
    int insertuser(Map<String,Object> map);
    List<Map<String,Object>> selectuser(Map<String,Object> map)
}
