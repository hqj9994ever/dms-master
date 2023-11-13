package vip.epss.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vip.epss.domain.HistScore;
import vip.epss.domain.LatestScore;
import vip.epss.service.HistoricalScoreService;
import vip.epss.service.LatestScoreService;
import vip.epss.utils.MessageAndData;

import java.util.List;

@Controller
@RequestMapping(value = "/score")
public class ScoreController {

    @Autowired
    private HistoricalScoreService historicalScoreService;

    //评分(限管理员)
    @ResponseBody
    @RequestMapping(value = "/optAdd", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    public MessageAndData optAdd( @RequestBody HistScore histScore){
        //如果该寝室当天未评过分，则评分
        //如果该寝室已评过分，则更新最新评分
        //更正为：不管是否评分，先删除当天评分，再新增一条
        historicalScoreService.delhistoricalScore(histScore);
        boolean status = historicalScoreService.HistoricalScoreAdd(histScore);
        if(status){
            return MessageAndData.success().setMessage("评分成功");
        }else {
            return MessageAndData.error().setMessage("评分失败");
        }
    }

//    //删除一条评分(限管理员)
//    @ResponseBody
//    @RequestMapping(value = "/optDel", method = RequestMethod.POST, produces = {
//            "application/json; charset=utf-8" })
//    public MessageAndData OptDelete( @RequestBody HistScore histScore)
//    {
//        boolean b = historicalScoreService.historicalScoreDel(histScore);
//        if(b){
//            return MessageAndData.success().setMessage("删除成功");
//        }else{
//            return MessageAndData.error().setMessage("删除失败");
//        }
//    }

    //根据宿舍号查询历史评分
    @ResponseBody
    @RequestMapping(value = "/queryhis/{roomId}", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    public MessageAndData QueryHisById(@PathVariable(value = "roomId") Integer roomId){
        List<HistScore> histScores = historicalScoreService.HistoricalScoreQuery(roomId);
        return MessageAndData.success().add("histScores",histScores);
    }

    //展示所有宿舍的当天的分数(限管理员)
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    public MessageAndData list(){
        List<HistScore> histScores = historicalScoreService.SelectAll();
        return MessageAndData.success().add("histScores",histScores);
    }

}
