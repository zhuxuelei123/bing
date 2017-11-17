package com.bing.sso.mapper.test;

import com.bing.sso.pojo.test.BbsUser;
import com.bing.sso.pojo.test.BbsUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsUserMapper {
    int countByExample(BbsUserExample example);

    int deleteByExample(BbsUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(BbsUser record);

    int insertSelective(BbsUser record);

    List<BbsUser> selectByExample(BbsUserExample example);

    BbsUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") BbsUser record, @Param("example") BbsUserExample example);

    int updateByExample(@Param("record") BbsUser record, @Param("example") BbsUserExample example);

    int updateByPrimaryKeySelective(BbsUser record);

    int updateByPrimaryKey(BbsUser record);
}