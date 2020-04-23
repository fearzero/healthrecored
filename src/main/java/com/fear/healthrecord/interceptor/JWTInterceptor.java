package com.fear.healthrecord.interceptor;

import com.fear.healthrecord.myunitls.JWTUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * @Auther: ARong
 * @Date: 2019/1/19 14:37
 * @Description: JWT token 管理后台的拦截校验器
 */
@Component
public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 允许跨域
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods","*");
        // 允许自定义请求头token(允许head跨域)
         response.setHeader("Access-Control-Allow-Headers", "*");

        //后台管理页面产生的token
        String token = request.getHeader("Authorization");
        //判断是否过期
        Optional.ofNullable(token)
                .map(n -> {
                    try {
                        return JWTUtils.parseJWT(n);
                    } catch (Exception e) {
                        throw new RuntimeException("token不存在");
                    }
                });

        return true;
    }

}

