package cn.com.sparknet.malltiny01.controller;

import cn.com.sparknet.malltiny01.common.api.CommonResult;
import cn.com.sparknet.malltiny01.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shkstart
 * @create 2020-06-14 17:32
 */
@Controller
@Api(tags = "UmsMemberController", description = "验证码管理")
public class UmsMemberController {
    @Autowired
    private UmsMemberService umsMemberService;

    @ApiOperation(value ="生成验证码" )
    @RequestMapping(value = "/generateAuthCode",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult generateAuthCode(@RequestParam String telephone){
       return umsMemberService.generateAuthCode(telephone);
    }

    @ApiOperation(value ="校验验证码" )
    @RequestMapping(value = "/verifyAuthCode",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult verifyAuthCode(@RequestParam String telephone,@RequestParam String code){
        return umsMemberService.verifyAuthCode(telephone,code);
    }
}
