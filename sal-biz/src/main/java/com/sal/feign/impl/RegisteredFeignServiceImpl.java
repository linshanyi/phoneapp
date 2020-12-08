package com.sal.feign.impl;

import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nisbos.base.exception.BusinessException;
import com.nisbos.rpc.framework.common.entity.RPCResult;
import com.sal.dto.res.MessageDTO;
import com.sal.dto.res.UserNoDTO;
import com.sal.feign.RegisteredFeignService;
import com.sal.jcus.convertor.RegisteredConvertor;
import com.sal.jcus.entity.User;
import com.sal.jcus.service.RegisteredService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Date;
import java.util.UUID;

import static com.sal.feign.RegisteredFeignService.INTERFACE_NAME;
@Slf4j
@RequestMapping(value = INTERFACE_NAME)
@Transactional(rollbackFor = Exception.class)
public class RegisteredFeignServiceImpl implements RegisteredFeignService {
    @Autowired
    RegisteredService registeredService;
    User user;


    @Override
    public RPCResult<MessageDTO> registered(MessageDTO messageDTO) {
        User users=null;
        UserNoDTO userNoDTO=null;
        Date creatTime =new Date();
        boolean is=false;
        if (messageDTO.getPhone()!=null){
            String phone=messageDTO.getPhone();
            QueryWrapper<User> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("phone",phone);
            users=registeredService.getOne(queryWrapper);
        }
        if (users==null){
            User user= RegisteredConvertor.INSTANCE.userResByUser(messageDTO);
            String UserId= UUID.randomUUID().toString().replace("-","");
            user.setUserId(UserId);
            user.setCreatTime(creatTime);
            try {
                is =registeredService.save(user);
                userNoDTO=new UserNoDTO();
                userNoDTO.setUserNo(UserId);
            }catch (Exception e){
               log.warn("保存失败"+messageDTO,e);
               throw new BusinessException(HttpStatus.HTTP_INTERNAL_ERROR,"保存失败:"+userNoDTO,e);
            }
        }


        return null;
    }
}
