package com.demo.dao.mongo;

import com.demo.base.DaoBase;
import com.demo.entity.po.LoginLog;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * <h1>登录日志</h1>
 *
 * <p>
 * createDate 2023/10/28 16:19:58
 * </p>
 *
 * @author ALI[ali-k@foxmail.com]
 * @since 1.0.0
 **/
@Service
@AllArgsConstructor
public class LoginLogDao extends DaoBase {

    private final MongoTemplate mongoTemplate;

    /**
     * 插入
     *
     * @param loginLog LoginLog
     * @return ok:id,e:0
     */
    public long insert(LoginLog loginLog) {
        if (tryAnyNoTransaction(() -> mongoTemplate.insert(loginLog))) {
            return loginLog.getId();
        } else {
            return 0L;
        }
    }

}
