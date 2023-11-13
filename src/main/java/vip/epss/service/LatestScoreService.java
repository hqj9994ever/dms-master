package vip.epss.service;

import vip.epss.domain.LatestScore;

import java.util.List;

public interface LatestScoreService {
    //增加一条评分(限管理员)
    public boolean LatestScoreAdd(LatestScore latest_score);
    //修改评分(限管理员)
    public boolean LatestScoreUpdate(LatestScore latest_score);
    //查询一个宿舍的当前评分
    public double LatestScoreQuery(Integer room_id);
    //查询所有宿舍的当前评分
    public List<LatestScore> SelectAll();
}
