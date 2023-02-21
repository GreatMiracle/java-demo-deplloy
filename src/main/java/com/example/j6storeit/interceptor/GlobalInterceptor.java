package com.example.j6storeit.interceptor;

import com.example.j6storeit.entity.Category;
import com.example.j6storeit.service.CategoryService;
import com.example.j6storeit.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class GlobalInterceptor implements HandlerInterceptor {
    @Autowired
    CategoryService categoryService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        request.setAttribute("cates",categoryService.findAll());
    }
}
