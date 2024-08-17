package com.demo.controller;

import cn.z.ip2region.Ip2Region;
import cn.z.phone2region.Phone2Region;
import com.demo.entity.po.LoginLog;
import com.demo.service.LoginLogService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>首页</h1>
 *
 * <p>
 * createDate 2021/09/10 14:37:57
 * </p>
 *
 * @author ALI[ali-k@foxmail.com]
 * @since 1.0.0
 **/
@RestController
@AllArgsConstructor
@Slf4j
public class IndexController implements ErrorController {

    private final LoginLogService loginLogService;

    /**
     * 页面找不到
     */
    @RequestMapping("error")
    @ResponseStatus(HttpStatus.OK)
    public LoginLog error(HttpServletRequest request) {
        LoginLog loginLog = loginLogService.insert(request);
        log.info(loginLog.toString());
        return loginLog;
    }

    /**
     * ip2region
     */
    @RequestMapping("ip2region/{ip}")
    public cn.z.ip2region.Region ip2region(@PathVariable String ip) {
        cn.z.ip2region.Region region = Ip2Region.parse(ip);
        log.info(region.toString());
        return region;
    }

    /**
     * phone2region
     */
    @RequestMapping("phone2region/{phone}")
    public cn.z.phone2region.Region phone2region(@PathVariable String phone) {
        cn.z.phone2region.Region region = Phone2Region.parse(phone);
        log.info(region.toString());
        return region;
    }

}
