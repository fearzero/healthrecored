package com.fear.healthrecord.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface SystemUserService {
    Map<String,Object> selectSysUserInfo(HttpServletRequest request);
    Map<String,Object> updatePWD(HttpServletRequest request ,Map<String,Object> map);
    Map<String,Object> updateSysUserInfo(HttpServletRequest request ,Map<String,Object> map);
    Map<String,Object> selectLogs(HttpServletRequest request ,Map<String,Object> map);
}
