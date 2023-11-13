package vip.epss.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.epss.domain.HistScore;
import vip.epss.domain.HistScoreExample;

public interface HistScoreMapper {
    long countByExample(HistScoreExample example);

    int deleteByExample(HistScoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HistScore record);

    int insertSelective(HistScore record);

    List<HistScore> selectByExample(HistScoreExample example);

    HistScore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HistScore record, @Param("example") HistScoreExample example);

    int updateByExample(@Param("record") HistScore record, @Param("example") HistScoreExample example);

    int updateByPrimaryKeySelective(HistScore record);

    int updateByPrimaryKey(HistScore record);

    List<HistScore> selectByExampleGroupBy(HistScoreExample example);
}