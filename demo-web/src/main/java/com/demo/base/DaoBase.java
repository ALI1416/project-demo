package com.demo.base;

import lombok.extern.slf4j.Slf4j;

/**
 * <h1>Dao层基类</h1>
 *
 * <p>
 * createDate 2020/11/11 11:11:11
 * </p>
 *
 * @author ALI[ali-k@foxmail.com]
 * @since 1.0.0
 **/
@Slf4j
public class DaoBase {

    /**
     * 尝试执行(无事务)：必须无异常
     *
     * @param function 函数
     * @return 是否成功
     */
    public static boolean tryAnyNoTransaction(Runnable function) {
        try {
            function.run();
            return true;
        } catch (Exception e) {
            log.error("tryAnyNoTransaction", e);
            return false;
        }
    }

}
