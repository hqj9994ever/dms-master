package vip.epss.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vip.epss.domain.Callboard;
import vip.epss.service.CallBoardService;
import vip.epss.utils.MessageAndData;

import java.util.List;

@Controller
@RequestMapping(value = "/callboard")
public class CallBoardController {

    @Autowired
    private CallBoardService callBoardService;

    //发布公告(限管理员)
    @ResponseBody
    @RequestMapping(value = "/optAdd", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    public MessageAndData optAdd(@RequestBody Callboard callBoard){
        boolean b = callBoardService.CallBoardRelease(callBoard);
        if(b){
            return MessageAndData.success().setMessage("发布成功");
        }else{
            return MessageAndData.error().setMessage("发布失败");
        }
    }

    //按时间点查询公告
    @ResponseBody
    @RequestMapping(value = "/optTime/{date}",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    public MessageAndData getCallBoardWithTime(@PathVariable(value = "date") String date){
        List<Callboard> callboards = callBoardService.CallBoardQueryByDate(date);
        if(callboards.size() > 0){
            return MessageAndData.success().add("callboards", callboards);
        }else{
            return MessageAndData.error().setMessage("没有匹配结果");
        }
    }

    //在某一时间段内查询
    @ResponseBody
    @RequestMapping(value = "/optTimes/{begin}/{end}",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    public MessageAndData getCallBoardWithTimeInterval(@PathVariable(value = "begin") String begin, @PathVariable(value="end") String end){
        List<Callboard> callboards = callBoardService.CallBoardQueryByDateInterval(begin,end);
        if(callboards.size() > 0){
            return MessageAndData.success().add("callboards", callboards);
        }else{
            return MessageAndData.error().setMessage("没有匹配结果");
        }
    }

    //展示所有公告
    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    public MessageAndData list(){
        List<Callboard> callboards = callBoardService.SelectAll();
        return MessageAndData.success().add("callboards", callboards);
    }

    //删除公告(限管理员)
    @ResponseBody
    @RequestMapping(value = "/optDel", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    public MessageAndData optDel(@RequestBody Callboard callBoard){
        boolean b = callBoardService.CallBoardDelRelease(callBoard);
        if(b){
            return MessageAndData.success().setMessage("删除成功");
        }else{
            return MessageAndData.error().setMessage("删除失败");
        }
    }

}
