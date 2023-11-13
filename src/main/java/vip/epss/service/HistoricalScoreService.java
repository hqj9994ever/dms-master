package vip.epss.service;

import vip.epss.domain.HistScore;

import java.util.List;

public interface HistoricalScoreService {
    //增加一条评分(限管理员)
    public Boolean HistoricalScoreAdd(HistScore hist_score);
    //查询一个宿舍的历史评分
    public List<HistScore> HistoricalScoreQuery(Integer room_id);
    //查询所有宿舍历史评分(限管理员)
    public List<HistScore> SelectAll();

    public Boolean historicalScoreDel(HistScore histScore);

    public void delhistoricalScore(HistScore histScore);
}
