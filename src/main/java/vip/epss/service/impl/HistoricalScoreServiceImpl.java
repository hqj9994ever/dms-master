package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.HistScoreMapper;
import vip.epss.domain.HistScore;
import vip.epss.domain.HistScoreExample;
import vip.epss.service.HistoricalScoreService;

import java.util.List;

@Service(value="historicalscoreService")
public class HistoricalScoreServiceImpl implements HistoricalScoreService {

    @Autowired
    private HistScoreMapper histScoreMapper;

    @Override
    public Boolean HistoricalScoreAdd(HistScore hist_score) {
        return  histScoreMapper.insert(hist_score)>0;
    }

    @Override
    public List<HistScore> HistoricalScoreQuery(Integer roomId) {
        HistScoreExample hist_scoreExample = new HistScoreExample();
        HistScoreExample.Criteria criteria = hist_scoreExample.createCriteria();
        criteria.andRoomIdEqualTo(roomId);
        List<HistScore> histScores = histScoreMapper.selectByExample(hist_scoreExample);
        return histScores;
    }

    @Override
    public List<HistScore> SelectAll() {
        List<HistScore> histScores = histScoreMapper.selectByExampleGroupBy(null);
        return histScores;
    }

    @Override
    public Boolean historicalScoreDel(HistScore histScore) {
        return histScoreMapper.deleteByPrimaryKey(histScore.getId())>0;
    }

    @Override
    public void delhistoricalScore(HistScore histScore) {
        HistScoreExample histScoreExample = new HistScoreExample();
        HistScoreExample.Criteria criteria = histScoreExample.createCriteria();
        criteria.andDateLike(histScore.getDate());
        criteria.andRoomIdEqualTo(histScore.getRoomId());
        histScoreMapper.deleteByExample(histScoreExample);
    }
}
