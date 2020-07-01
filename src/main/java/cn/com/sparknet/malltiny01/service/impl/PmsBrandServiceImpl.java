package cn.com.sparknet.malltiny01.service.impl;

import cn.com.sparknet.malltiny01.mbg.mapper.PmsBrandMapper;
import cn.com.sparknet.malltiny01.mbg.model.PmsBrand;
import cn.com.sparknet.malltiny01.mbg.model.PmsBrandExample;
import cn.com.sparknet.malltiny01.service.PmsBrandService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-06-14 9:16
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {
   @Autowired
    private PmsBrandMapper pmsBrandMapper;
    @Override
    public int createBrand(PmsBrand pmsBrand) {
        int result=pmsBrandMapper.insert(pmsBrand);
        return result;
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        int result=pmsBrandMapper.deleteByPrimaryKey(id);
        return  result;
    }

    @Override
    public List<PmsBrand> selectByExample() {
        PmsBrandExample pmsBrandExample=new PmsBrandExample();
       return pmsBrandMapper.selectByExample(pmsBrandExample);
    }

    @Override
    public PmsBrand selectByPrimaryKey(Long id) {
        return pmsBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> selectPageByExample(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int updateByPrimaryKey(long id, PmsBrand record) {
        record.setId(id);
        return pmsBrandMapper.updateByPrimaryKey(record);
//        return pmsBrandMapper.updateByPrimaryKeySelective(record);
    }
}
