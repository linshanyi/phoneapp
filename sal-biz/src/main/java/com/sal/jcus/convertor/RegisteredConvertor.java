package com.sal.jcus.convertor;

import com.sal.dto.res.MessageDTO;
import com.sal.jcus.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RegisteredConvertor {
    RegisteredConvertor INSTANCE= Mappers.getMapper(RegisteredConvertor.class);
    User userResByUser(MessageDTO messageDTO);
}
