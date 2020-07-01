package cn.com.sparknet.malltiny01.service;

import cn.com.sparknet.malltiny01.mbg.model.PmsBrand;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-06-14 9:15
 */
public interface PmsBrandService {
    int createBrand(PmsBrand pmsBrand);

    int deleteByPrimaryKey(Long id);
    List<PmsBrand> selectByExample();
    PmsBrand selectByPrimaryKey(Long id);

    List<PmsBrand> selectPageByExample(Integer pageNum, Integer pageSize);
    int updateByPrimaryKey(long id ,PmsBrand record);

}
