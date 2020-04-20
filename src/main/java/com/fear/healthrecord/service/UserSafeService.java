package com.fear.healthrecord.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface UserSafeService {
    Map<String, Object> registeruser(Map<String,Object> map);
    Map<String,Object> loginuser(Map<String,Object> map , HttpServletResponse response);
    Map<String,Object> outline(HttpServletRequest request);

}
