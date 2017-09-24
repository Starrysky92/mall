package com.qianfeng.dao;

import com.qianfeng.bean.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/9/20 0020.
 */
@Repository
@Mapper
public interface MemberDao {
    Member findMember(Member member);
}
