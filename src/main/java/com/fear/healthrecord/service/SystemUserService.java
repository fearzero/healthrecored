package com.fear.healthrecord.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface SystemUserService {
    Map<String,Object> selectSysUserInfo(HttpServletRequest request);
    Map<String,Object> whoOnline(HttpServletRequest request);
}
