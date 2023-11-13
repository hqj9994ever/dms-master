package vip.epss.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.epss.domain.LatestScore;
import vip.epss.domain.LatestScoreExample;

public interface LatestScoreMapper {
    long countByExample(LatestScoreExample example);

    int deleteByExample(LatestScoreExample example);

    int deleteByPrimaryKey(Integer roomId);

    int insert(LatestScore record);

    int insertSelective(LatestScore record);

    List<LatestScore> selectByExample(LatestScoreExample example);

    LatestScore selectByPrimaryKey(Integer roomId);

    int updateByExampleSelective(@Param("record") LatestScore record, @Param("example") LatestScoreExample example);

    int updateByExample(@Param("record") LatestScore record, @Param("example") LatestScoreExample example);

    int updateByPrimaryKeySelective(LatestScore record);

    int updateByPrimaryKey(LatestScore record);
}