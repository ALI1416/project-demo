package com.demo.controller;

import com.demo.entity.po.LoginLog;
import com.demo.entity.pojo.Result;
import com.demo.service.LoginLogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <h1>首页</h1>
 *
 * <p>
 * createDate 2023/10/12 14:17:18
 * </p>
 *
 * @author ALI[ali-k@foxmail.com]
 * @since 1.0.0
 **/
@RestController
@AllArgsConstructor
@Slf4j
public class IndexController {

    private final HttpServletRequest request;
    private final LoginLogService loginLogService;

    /**
     * 首页
     */
    @GetMapping
    public Result<LoginLog> index() {
        LoginLog loginLog = loginLogService.insert(request);
        log.info(loginLog.toString());
        return Result.o(loginLog);
    }

}
