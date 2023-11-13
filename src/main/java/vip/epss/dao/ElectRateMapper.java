package vip.epss.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import vip.epss.domain.ElectRate;
import vip.epss.domain.ElectRateExample;

public interface ElectRateMapper {
    long countByExample(ElectRateExample example);

    int deleteByExample(ElectRateExample example);

    int deleteByPrimaryKey(Integer roomId);

    int insert(ElectRate record);

    int insertSelective(ElectRate record);

    List<ElectRate> selectByExample(ElectRateExample example);

    ElectRate selectByPrimaryKey(Integer roomId);

    int updateByExampleSelective(@Param("record") ElectRate record, @Param("example") ElectRateExample example);

    int updateByExample(@Param("record") ElectRate record, @Param("example") ElectRateExample example);

    int updateByPrimaryKeySelective(ElectRate record);

    int updateByPrimaryKey(ElectRate record);

    List<Map> findLastWeek(Integer roomId);

    List<Map> findLastThreeList(Integer roomId);
}