package com.demo.controller;

import com.demo.entity.po.LoginLog;
import com.demo.service.LoginLogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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

}
