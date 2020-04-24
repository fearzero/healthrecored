package com.fear.healthrecord.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Mapper
@Repository
public interface SystemUserMapper {
    Map<String,Object> selectSysUserInfo(Map<String,Object> map);
    Map<String,Object> selectPWD(Map<String,Object> map);
    int updatePWD(Map<String,Object> map);
    int updateSysUserInfo(Map<String,Object> map);
    int insertLogs(Map<String,Object> map);
    List<Map<String,Object>> selectLogs(Map<String,Object> map);

}
