package vip.epss.service;

import vip.epss.domain.Callboard;

import java.util.List;

public interface CallBoardService {
    //发布公告(限管理员)
    public boolean CallBoardRelease(Callboard callBoard);
    //按照时间查询公告
    public List<Callboard> CallBoardQueryByDate(String date);
    //按照时间区间查询公告
    public List<Callboard> CallBoardQueryByDateInterval(String begin, String end);
    //查询所有公告
    public List<Callboard> SelectAll();
    //删除公告(限管理员)
    boolean CallBoardDelRelease(Callboard callBoard);
}
