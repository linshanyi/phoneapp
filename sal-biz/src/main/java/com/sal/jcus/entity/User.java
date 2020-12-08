package com.sal.jcus.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {
    private static final Long serialVersionUID=1L;
    /**
     * 用户ID
     */
    private String UserId;
    /**
     * 用户手机号码
     */
    private String phone;

    /**
     * 密码
     */
    private String password;
    /**
     * 创建日期
     */
    private Date creatTime;
}
