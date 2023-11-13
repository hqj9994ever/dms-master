package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.CallBoardMapper;
import vip.epss.domain.Callboard;
import vip.epss.domain.CallboardExample;
import vip.epss.service.CallBoardService;

import java.util.List;

@Service(value="callboardService")
public class CallBoardServiceImpl implements CallBoardService {

    @Autowired
    private CallBoardMapper callBoardMapper;

    @Override
    public boolean CallBoardRelease(Callboard callBoard) {
        if(callBoardMapper.insert(callBoard) > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Callboard> CallBoardQueryByDate(String date) {
        CallboardExample callboardExample = new CallboardExample();
        CallboardExample.Criteria criteria = callboardExample.createCriteria();
        criteria.andDateEqualTo(date);
        List<Callboard> callboards = callBoardMapper.selectByExample(callboardExample);
        return callboards;
    }

    @Override
    public List<Callboard> CallBoardQueryByDateInterval(String begin, String end) {
        CallboardExample callboardExample = new CallboardExample();
        CallboardExample.Criteria criteria = callboardExample.createCriteria();
        criteria.andDateBetween(begin,end);
        List<Callboard> callboards = callBoardMapper.selectByExample(callboardExample);
        return callboards;
    }

    @Override
    public List<Callboard> SelectAll() {
        List<Callboard> callboards = callBoardMapper.selectByExample(null);
        return callboards;
    }

    @Override
    public boolean CallBoardDelRelease(Callboard callBoard) {
        if(callBoardMapper.deleteByPrimaryKey(callBoard.getId()) > 0){
            return true;
        }else{
            return false;
        }
    }

}
