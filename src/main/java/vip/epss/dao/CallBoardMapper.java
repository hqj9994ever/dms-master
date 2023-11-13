package vip.epss.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.epss.domain.Callboard;
import vip.epss.domain.CallboardExample;

public interface CallBoardMapper {
    long countByExample(CallboardExample example);

    int deleteByExample(CallboardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Callboard record);

    int insertSelective(Callboard record);

    List<Callboard> selectByExample(CallboardExample example);

    Callboard selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Callboard record, @Param("example") CallboardExample example);

    int updateByExample(@Param("record") Callboard record, @Param("example") CallboardExample example);

    int updateByPrimaryKeySelective(Callboard record);

    int updateByPrimaryKey(Callboard record);
}