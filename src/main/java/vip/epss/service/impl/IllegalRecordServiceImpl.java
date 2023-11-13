package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import vip.epss.dao.IllegalRecordMapper;
import vip.epss.domain.IllegalRecord;
import vip.epss.domain.IllegalRecordExample;
import vip.epss.domain.IllegalRecordResult;
import vip.epss.service.IllegalRecordService;

import java.util.List;

@Service(value = "illegalrecordService")
public class IllegalRecordServiceImpl implements IllegalRecordService {

    @Autowired
    private IllegalRecordMapper illegalRecordMapper;

    @Override
    public boolean IllegalRecordAdd(IllegalRecord illegalRecord) {
        IllegalRecordExample illegalRecordExample = new IllegalRecordExample();
        IllegalRecordExample.Criteria criteria = illegalRecordExample.createCriteria();
        criteria.andStuIdEqualTo(illegalRecord.getStuId());
        criteria.andDateEqualTo(illegalRecord.getDate());
        //先删除当天已经存在的记录再新增
        illegalRecordMapper.deleteByExample(illegalRecordExample);
        return illegalRecordMapper.insertSelective(illegalRecord) > 0;
    }

    @Override
    public boolean IllegalRecordDeleteById(Integer id) {
        return illegalRecordMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public List<IllegalRecord> IllegalRecordQueryBySid(Integer stuId) {
        IllegalRecordExample illegalRecordExample = new IllegalRecordExample();
        IllegalRecordExample.Criteria criteria = illegalRecordExample.createCriteria();
        criteria.andStuIdEqualTo(stuId);
        List<IllegalRecord> illegalRecords = illegalRecordMapper.selectByExample(illegalRecordExample);
        return illegalRecords;
    }

    @Override
    public List<IllegalRecord> IllegalRecordQueryByDate(String date) {
        IllegalRecordExample illegalRecordExample = new IllegalRecordExample();
        IllegalRecordExample.Criteria criteria = illegalRecordExample.createCriteria();
        criteria.andDateEqualTo(date);
        List<IllegalRecord> illegalRecords = illegalRecordMapper.selectByExample(illegalRecordExample);
        return illegalRecords;
    }

    @Override
    public List<IllegalRecordResult> SelectAll(IllegalRecord illegalRecord) {
        List<IllegalRecordResult> illegalRecords = illegalRecordMapper.selectByResultExample(illegalRecord);
        return illegalRecords;
    }

    @Override
    public boolean IllegalRecordEdit(IllegalRecord illegalRecord) {
        return illegalRecordMapper.updateByPrimaryKeySelective(illegalRecord)>0;
    }
}
