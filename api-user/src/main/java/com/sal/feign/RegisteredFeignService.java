package com.sal.feign;

import com.nisbos.rpc.framework.common.entity.RPCResult;
import com.sal.dto.res.MessageDTO;
import io.swagger.annotations.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Api(tags = "对外接口")
@FeignClient(name = "sabedoria", path = "INTERFACE_NAME", contextId = "salID")
public interface RegisteredFeignService {
    String INTERFACE_NAME="feign/sabedoria";
    /**
     * 用户注册
     */
    @ApiOperation(value =  "用户注册" )
    @PostMapping(value = "registered", produces = {"application/json"})
    @ApiResponses(value = {@ApiResponse(code=200,message="操作是否成功，200：成功 否则失败")})
    RPCResult<MessageDTO> registered (@ApiParam(value = "用户信息", required = true) @Validated @RequestBody MessageDTO messageDTO);


}
