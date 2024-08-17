package com.demo.entity.po;

import cn.z.ip2region.Region;
import cn.z.tool.useragent.UserAgent;
import com.demo.base.MongoEntityBase;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * <h1>登录日志</h1>
 *
 * <p>
 * createDate 2023/10/28 16:04:42
 * </p>
 *
 * @author ALI[ali-k@foxmail.com]
 * @since 1.0.0
 **/
@Getter
@Setter
@Document(collection = "login_log")
public class LoginLog extends MongoEntityBase {

    /**
     * URI
     */
    private String uri;
    /**
     * Method
     */
    private String method;
    /**
     * IP地址
     */
    private String ip;
    /**
     * IP地址详情
     */
    private Region ipInfo;
    /**
     * UserAgent
     */
    private String userAgent;
    /**
     * UserAgent详情
     */
    private UserAgent userAgentInfo;

}
