package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.LatestScoreMapper;
import vip.epss.domain.LatestScore;
import vip.epss.service.LatestScoreService;

import java.util.List;

@Service(value = "latestscoreService")
public class LatestScoreServiceImpl implements LatestScoreService {

    @Autowired
    private LatestScoreMapper latest_scoreMapper;

    @Override
    public boolean LatestScoreAdd(LatestScore latest_score) {
        //如果表中不存在该寝室，则增加一条记录
        if(latest_scoreMapper.selectByPrimaryKey(latest_score.getRoomId())!=null){
            return false;
        }else{
            latest_scoreMapper.insert(latest_score);
            return true;
        }

    }

    @Override
    public boolean LatestScoreUpdate(LatestScore latest_score) {
        //如果表中已存在该寝室，则更改其评分
        if(latest_scoreMapper.selectByPrimaryKey(latest_score.getRoomId())==null){
            return false;
        }else{
            latest_scoreMapper.updateByPrimaryKey(latest_score);
            return true;
        }
    }

    @Override
    public double LatestScoreQuery(Integer room_id) {
        LatestScore latest_score = latest_scoreMapper.selectByPrimaryKey(room_id);
        return latest_score.getScore();
    }

    @Override
    public List<LatestScore> SelectAll() {
        List<LatestScore> latest_scores = latest_scoreMapper.selectByExample(null);
        return latest_scores;
    }

}
