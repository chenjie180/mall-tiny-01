package cn.com.sparknet.malltiny01.controller;

import cn.com.sparknet.malltiny01.common.api.CommonPage;
import cn.com.sparknet.malltiny01.common.api.CommonResult;
import cn.com.sparknet.malltiny01.mbg.model.PmsBrand;
import cn.com.sparknet.malltiny01.service.PmsBrandService;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-06-14 9:12
 */
@Controller
@RequestMapping("/brand")
@Api(tags = "PmsBrandController", description = "商品品牌管理")
public class PmsBrandController {
   @Autowired
    private PmsBrandService pmsBrandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);
    @ApiOperation(value = "创建一个品牌")
    @ResponseBody
    @RequestMapping(value = "/createBrand",method = RequestMethod.POST)
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand){
        CommonResult commonResult;
        int result= pmsBrandService.createBrand(pmsBrand);
        if(result>0){
            commonResult=   CommonResult.success(pmsBrand);
        }else{
            commonResult= CommonResult.failed("操作失败");
        }
        return  commonResult;
    }

    @ApiOperation(value = "删除一个品牌")
    @ResponseBody
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public CommonResult createBrand(@PathVariable("id") long id){
        CommonResult commonResult;
        int result = pmsBrandService.deleteByPrimaryKey(id);
        if(result>0){
            commonResult=   CommonResult.success(id);
        }else{
            commonResult= CommonResult.failed("操作失败");
        }
        return  commonResult;
    }
    @PreAuthorize("hasAuthority('pms:brand:read')")
    @ApiOperation(value = "查询所有品牌")
    @ResponseBody
    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    public CommonResult listAll(){
        CommonResult commonResult;
        List<PmsBrand>  brandList=pmsBrandService.selectByExample();
        if(brandList!=null){
            commonResult=   CommonResult.success(brandList);
        }else{
            commonResult= CommonResult.failed("操作失败");
        }
        return  commonResult;
    }

    @ApiOperation(value = "查询一个品牌")
    @ResponseBody
    @RequestMapping(value = "/selectByPrimaryKey/{id}",method = RequestMethod.GET)
    public CommonResult selectByPrimaryKey(@PathVariable("id") long id){
        CommonResult commonResult;
        PmsBrand pmsBrand = pmsBrandService.selectByPrimaryKey(id);
        if(pmsBrand!=null){
            commonResult=   CommonResult.success(pmsBrand);
        }else{
            commonResult= CommonResult.failed("操作失败");
        }
        return  commonResult;
    }

    @ApiOperation(value = "分页查询品牌")
    @ResponseBody
    @RequestMapping(value = "/selectPageByExample",method = RequestMethod.GET)
    public CommonResult selectPageByExample(
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        CommonResult commonResult;
        List<PmsBrand>  brandList= pmsBrandService.selectPageByExample(pageNum,pageSize);
        if(brandList!=null){
            commonResult=   CommonResult.success(CommonPage.restPage(brandList));
        }else{
            commonResult= CommonResult.failed("操作失败");
        }
        return  commonResult;
    }

    @ApiOperation(value = "修改品牌通过主键")
    @ResponseBody
    @RequestMapping(value = "/updateByPrimaryKey/{id}",method = RequestMethod.GET)
    public CommonResult updateByPrimaryKey(
            @PathVariable("id") long id,@RequestBody PmsBrand pmsBrand){
        LOGGER.debug("id"+"sssss");
        CommonResult commonResult;
        int i = pmsBrandService.updateByPrimaryKey(id, pmsBrand);
        if(i>0){
            commonResult=   CommonResult.success(pmsBrand);
        }else{
            commonResult= CommonResult.failed("操作失败");
        }
        return  commonResult;
    }

}
