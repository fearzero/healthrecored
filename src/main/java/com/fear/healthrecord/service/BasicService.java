package com.fear.healthrecord.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface BasicService {
    public int insertuser(Map<String,Object> map);
}
