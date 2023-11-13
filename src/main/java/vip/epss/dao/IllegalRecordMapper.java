package vip.epss.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.epss.domain.IllegalRecord;
import vip.epss.domain.IllegalRecordExample;
import vip.epss.domain.IllegalRecordResult;

public interface IllegalRecordMapper {
    long countByExample(IllegalRecordExample example);

    int deleteByExample(IllegalRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IllegalRecord record);

    int insertSelective(IllegalRecord record);

    List<IllegalRecord> selectByExample(IllegalRecordExample example);

    IllegalRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IllegalRecord record, @Param("example") IllegalRecordExample example);

    int updateByExample(@Param("record") IllegalRecord record, @Param("example") IllegalRecordExample example);

    int updateByPrimaryKeySelective(IllegalRecord record);

    int updateByPrimaryKey(IllegalRecord record);

    List<IllegalRecordResult> selectByResultExample(IllegalRecord record);
}