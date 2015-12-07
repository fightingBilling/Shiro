package com.somnus.module.maintenance;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.somnus.module.maintenance.model.LogOptMapping;
import com.somnus.module.maintenance.model.SetOptLog;
import com.somnus.module.maintenance.service.OptLogService;
import com.somnus.support.util.IpUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AuditLogInterceptor extends HandlerInterceptorAdapter {

    private static final String AUDITLOG_STARTTIME = "auditLog_startTime";
    private static final String AUDITLOG_USER = "auditLog_user";
    
    private LogOptMapping logMapping;

    private OptLogService optLogService;

    protected transient Logger auditLog = LoggerFactory.getLogger("auditLog");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute(AUDITLOG_STARTTIME,startTime);
        request.setAttribute(AUDITLOG_USER,getCurrentUser());
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
        //执行时间
        long startTime =  findLongAttribute(request, AUDITLOG_STARTTIME);
        long endTime = System.currentTimeMillis();
        //记录审计日志
        recordOptLog(request,startTime,endTime);
    }

    /**
     * 记录审计日志
     *
     * @param request
     * @param startTime
     * @param endTime
     */
    private void recordOptLog(HttpServletRequest request,long startTime,long endTime){

        try{
            String userName = getCurrentUser();
            if(StringUtils.isEmpty(userName)){
                userName=(String)request.getAttribute(AUDITLOG_USER);
            }
            if(StringUtils.isEmpty(userName)){
                return ;
            }
            //从地址栏获取操作代码
            String logkey = getQueryParameter("opt",request);
            if(StringUtils.isNotEmpty(logkey)){
                //区分进入菜单操作代码与菜单页面查询操作代码
                logkey=logkey+"!";
            }
            //获取操作代码
            if(logkey.isEmpty()){
                logkey = request.getParameter("opt");
            }
            if(logkey == null){
                return ;
            }
            String logDesc = logMapping.getLogDesc(logkey);
            if(StringUtils.isEmpty(logDesc)){
                return;
            }
            String logType="0";
            //解析日志类型和日志描述
            String arrys[] = logDesc.split(":") ;
            if(arrys != null&&arrys.length >= 0){
              logType = arrys[0];
              logDesc = arrys[1];
            }

            logDesc = userName+ "于" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(startTime)) + " " + logDesc + "，耗时" + (endTime - startTime)/1000.0 + "秒";

            String optIp = IpUtil.getIpAddr(request);

            //记录文件审计日志
            auditLog.info("[{}][{}]{}",new Object[]{optIp,logType,logDesc});

            //记录数据库审计日志
            SetOptLog optLog = new SetOptLog();
            optLog.setOptUserName(userName);
            optLog.setOptIp(optIp);
            optLog.setOptAddress(IpUtil.getIpInfo(optIp));
            optLog.setLogType(logType);
            optLog.setOptName("none");
            optLog.setLogDesc(logDesc);
            optLog.setOptDate(new Date());
            optLog.setStatus("1");
            optLog.setLastUpdator("system");
            optLog.setLastUpdateTime(new Date());
            optLogService.create(optLog);
        } catch (Throwable ex){
            auditLog.error("记录审计日志出错：",ex);
        }

    }

    private String getQueryParameter(String name,HttpServletRequest request){
        String str = request.getQueryString();
        if(StringUtils.isNotEmpty(str)){
            String[] arrys = str.split("&");
            if(arrys != null&&arrys.length>0){
                for(int i=0;i<arrys.length;i++){
                    String s = arrys[i];
                    String valus[] = s.split("=");
                    if(name.equals(valus[0])){
                        return valus[1];
                    }
                }
            }
        }
        return "";
    }

    private Long findLongAttribute(HttpServletRequest request,String name){
          Long value = 0L;
          if(request.getAttribute(AUDITLOG_STARTTIME) == null){
              auditLog.error("记录审计日志开始时间错误,获取不到开始时间");
              return 0L;
          } else{
              try{
                  value = (Long)request.getAttribute(AUDITLOG_STARTTIME);
              } catch (Throwable ex) {
                  auditLog.error("记录审计日志开始时间错误：",ex);
              }
          }
        return value;
    }

    private String getCurrentUser(){
        Subject curUser = SecurityUtils.getSubject();
        if(curUser == null||curUser.getPrincipal() == null){
            return "";
        }
        return ShiroDbRealm.ShiroUser.class.cast(SecurityUtils.getSubject().getPrincipal()).getUserName();
    }
   

    public void setLogMapping(LogOptMapping logMapping) {
        this.logMapping = logMapping;
    }


    public void setOptLogService(OptLogService optLogService) {
        this.optLogService = optLogService;
    }
}
