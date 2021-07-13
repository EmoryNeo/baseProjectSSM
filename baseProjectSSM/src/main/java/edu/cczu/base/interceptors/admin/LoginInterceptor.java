package edu.cczu.base.interceptors.admin;

import edu.cczu.base.domain.admin.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author iceorangeduxiaocheng@aliyun.com
 * @date 2021/7/13 19:04
 */

/**
 * 后台登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    /* 在请求处理之前进行处理 */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 登录拦截器
        String requestURI = request.getRequestURI();
        User admin = (User) request.getSession().getAttribute("admin");
        if(null == admin){
            /*
            System.out.println("被拦截的请求 =======> " + requestURI);
            String header = request.getHeader("X-Requested-With");
            */
            // 判断是否是Ajax请求
            /*
            if("XMLHttpRequest".equals(header)){
                System.out.println("testing....");
                // 表示是Ajax请求
                Map<String, String> map = new HashMap<>();
                map.put("type", "500");
                map.put("msg", "登录超时或未登录，请重新登录!");
                return false;
            }
            */

            // 表示未登录
//            String path = request.getContextPath();
            response.sendRedirect(request.getContextPath() + "/system/to_login.do");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
