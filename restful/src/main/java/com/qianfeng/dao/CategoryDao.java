package com.qianfeng.dao;

import com.qianfeng.beans.Category2;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/28 0028.
 */
@Repository
@Mapper
public interface CategoryDao {
    @Cacheable(value = "findAllCategoryForProtal")
    List<Category2> findAllCategoryForProtal();
}
