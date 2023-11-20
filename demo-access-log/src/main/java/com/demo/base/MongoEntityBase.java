package com.demo.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

/**
 * <h1>MongoDB实体层基类</h1>
 *
 * <p>
 * createDate 2021/11/18 13:32:47
 * </p>
 *
 * @author ALI[ali-k@foxmail.com]
 * @since 1.0.0
 **/
@Getter
@Setter
public class MongoEntityBase extends ToStringBase {

    /* ==================== po ==================== */
    /**
     * id
     */
    @Id
    private Long id;
    /**
     * 创建时间
     */
    private Timestamp createTime;

}
