package vip.epss.service;

import vip.epss.domain.IllegalRecord;
import vip.epss.domain.IllegalRecordResult;

import java.util.List;

public interface IllegalRecordService {
    //新增一条违规记录(限管理员)
    public boolean IllegalRecordAdd(IllegalRecord illegalRecord);
    //删除一条违规记录(限管理员)
    public boolean IllegalRecordDeleteById(Integer id);
    //根据学生学号查询违规记录
    public List<IllegalRecord> IllegalRecordQueryBySid(Integer stuId);
    //根据日期查询违规记录
    public List<IllegalRecord> IllegalRecordQueryByDate(String date);
    //查询所有违规记录
    public List<IllegalRecordResult> SelectAll(IllegalRecord illegalRecord);

    boolean IllegalRecordEdit(IllegalRecord illegalRecord);
}
