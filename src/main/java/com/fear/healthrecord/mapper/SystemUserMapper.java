package com.fear.healthrecord.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface SystemUserMapper {
    int registeruser(Map<String,Object> map);
    Map<String,Object> loginuser(Map<String,Object> map);
}
