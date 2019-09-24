package com.lisong.ssm.blog.interceptor;


/**
 * @author liuyanzhao
 */
@org.springframework.stereotype.Component
public class SecurityInterceptor extends org.springframework.web.servlet.handler.HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object o) throws java.io.IOException {
        //这里可以根据session的用户来判断角色的权限，根据权限来转发不同的页面
        if(request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, org.springframework.web.servlet.ModelAndView modelAndView)  {

    }

    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, Exception e)  {

    }
}

