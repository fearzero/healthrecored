package com.fear.healthrecord.service;

import java.util.Map;

public interface SystemUserService {
    int registeruser(Map<String,Object> map);
    Map<String,Object> loginuser(Map<String,Object> map);

}
