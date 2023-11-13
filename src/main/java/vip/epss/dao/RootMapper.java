package vip.epss.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.epss.domain.Root;
import vip.epss.domain.RootExample;

public interface RootMapper {
    long countByExample(RootExample example);

    int deleteByExample(RootExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Root record);

    int insertSelective(Root record);

    List<Root> selectByExample(RootExample example);

    Root selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Root record, @Param("example") RootExample example);

    int updateByExample(@Param("record") Root record, @Param("example") RootExample example);

    int updateByPrimaryKeySelective(Root record);

    int updateByPrimaryKey(Root record);

    Root selectByLogin(Root root);
}