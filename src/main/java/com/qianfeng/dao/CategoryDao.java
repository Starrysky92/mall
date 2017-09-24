package com.qianfeng.dao;

import com.qianfeng.beans.Category;
import com.qianfeng.beans.Category2;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/28 0028.
 */
@Repository
public interface CategoryDao {
   // @Cacheable(value = "findAllCetegory")
    List<Category> findAllCetegory();
    List<Category> findAllCategory2();
  //  @CacheEvict(value = "findAllCetegory",allEntries = true)
    void addcategory(Category category);
    void delcategory(ArrayList<Integer> ids);
    void updatecategory(Category category);
    List<Category2> findAllCategoryForProtal();
}
