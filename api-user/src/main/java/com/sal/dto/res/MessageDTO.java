package com.sal.dto.res;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class MessageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "名", name = "firstname", required = true)
    private String firstname;

    @ApiModelProperty(value = "姓",name = "lastname",required = true)
    private String lastname;

    /**
     * 根据规则自动生成的登陆ID
     */
    @ApiModelProperty(value = "登陆ID", name = "loginID")
    private String loginID;


    /**
     * 电话号码
     */
    @ApiModelProperty(value = "电话号码", name = "phone", required = true)
    private String phone;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱", name = "email", required = true)
    private String email;
    /**
     * 用户密码
     */
    @ApiModelProperty(value = "密码", name = "password", required = true)
    private String password;

    /**
     * 用户性别
     */
    @ApiModelProperty(value = "性别", name = "sex", required = true)
    private String sex;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄", name = "age", required = true)
    private int age;

    /**
     * 国家
     */
    @ApiModelProperty(value = "国家", name = "country", required = true)
    private int country;

    /**
     * 出生日期
     */
    @ApiModelProperty(value = "出生日期", name = "birthday")
    private Date birthday;

    /**
     * 用户ID
     */
    private String UserId;

    @ApiModelProperty(value = "创建时间", name = "creatTime")
    private Date creatTime;



}
