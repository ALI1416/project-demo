package com.demo.service;

import cn.z.clock.Clock;
import cn.z.id.Id;
import cn.z.ip2region.Ip2Region;
import cn.z.tool.useragent.UserAgent;
import com.demo.dao.mongo.LoginLogDao;
import com.demo.entity.po.LoginLog;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * <h1>登录日志</h1>
 *
 * <p>
 * createDate 2023/11/04 17:28:27
 * </p>
 *
 * @author ALI[ali-k@foxmail.com]
 * @since 1.0.0
 **/
@Service
@AllArgsConstructor
public class LoginLogService {

    private final LoginLogDao loginLogDao;

    /**
     * 插入
     *
     * @param request HttpServletRequest
     * @return LoginLog(失败返回null)
     */
    public LoginLog insert(HttpServletRequest request) {
        LoginLog loginLog = new LoginLog();
        loginLog.setId(Id.next());
        loginLog.setCreateTime(Clock.timestamp());
        String ip = request.getHeader("X-Real-IP");
        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        loginLog.setIp(ip);
        try {
            loginLog.setIpInfo(Ip2Region.parse(ip));
        } catch (Exception ignored) {
        }
        String userAgent = request.getHeader("User-Agent");
        if (userAgent != null) {
            loginLog.setUserAgent(userAgent);
            try {
                loginLog.setUserAgentInfo(UserAgent.parse(userAgent));
            } catch (Exception ignored) {
            }
        }
        long ok = loginLogDao.insert(loginLog);
        if (ok == 0) {
            return null;
        } else {
            return loginLog;
        }
    }

}
