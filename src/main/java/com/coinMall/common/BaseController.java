package com.coinMall.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;

/** 
 * controller基类
 * @author jiangjiayi
 * @date 2018年10月16日
 */
public class BaseController {

	protected ThreadLocal<HttpServletRequest> requestThreadLocal = new ThreadLocal<>();
    protected ThreadLocal<HttpServletResponse> responseThreadLocal = new ThreadLocal<>();
	
    /**
     * 动态注入request和response对象，每次请求，在调用目标controller方法前都会调用该方法，
     * 同时也解决了如果在controller方法（void方法）中没有动态注入response对象，spring mvc会寻找默认的ModelAndView的错误
     **/
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
        requestThreadLocal.set(request);
        responseThreadLocal.set(response);
    }
    
    /**
     * 获取request属性值
     * @param request
     * @param attributeName
     * @param clazz
     * @return
     */
    protected <T> T getRequestAttribute(HttpServletRequest request,String attributeName,Class<T> clazz){
    	return (T) request.getAttribute(attributeName);
    }
    
    /**
     * 获取用户的ip地址
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request){
        String ip=request.getHeader("x-forwarded-for");
        if(ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
            ip=request.getHeader("Proxy-Client-IP");
        }
        if(ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
            ip=request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
            ip=request.getRemoteAddr();
        }
        return filterIp(ip);
    }
    
    private static String filterIp(String ip) {
        if (ip != null) {
            String[] data = ip.split(",");
            for (int i=0; i<data.length; i++) {
                if (!"unknown".equalsIgnoreCase(data[i].replaceAll("\\s*", ""))) {
                    ip = data[i].replaceAll("\\s*", "");   //去除首尾空格
                    break;
                }
            }
        }
        return ip;
    }
}
