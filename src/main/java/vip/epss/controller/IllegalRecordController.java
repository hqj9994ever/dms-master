package vip.epss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vip.epss.domain.IllegalRecord;
import vip.epss.domain.IllegalRecordResult;
import vip.epss.service.IllegalRecordService;
import vip.epss.utils.MessageAndData;

import java.util.List;

@Controller
@RequestMapping(value = "/illegalRecord")
public class IllegalRecordController {

    @Autowired
    private IllegalRecordService illegalRecordService;

    //新增一条违纪记录(限管理员)
    @ResponseBody
    @RequestMapping(value = "/optAdd", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8"})
    public MessageAndData OptAdd(@RequestBody IllegalRecord illegalRecord)
    {
        //同一天只能有一次缺勤
        boolean b = illegalRecordService.IllegalRecordAdd(illegalRecord);
        if(b)
        {
            return MessageAndData.success().setMessage("新增成功");
        }else{
            return MessageAndData.error().setMessage("新增失败");
        }
    }

    //修改一条违纪记录(限管理员)
    @ResponseBody
    @RequestMapping(value = "/optEdit", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    public MessageAndData optEdit(@RequestBody IllegalRecord illegalRecord)
    {
        boolean b = illegalRecordService.IllegalRecordEdit(illegalRecord);
        if(b)
        {
            return MessageAndData.success().setMessage("修改成功");
        }else{
            return MessageAndData.error().setMessage("修改失败");
        }
    }

    //删除一条违纪记录(限管理员)
    @ResponseBody
    @RequestMapping(value = "/optDel/{stuId}", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    public MessageAndData OptDelete(@PathVariable(value = "stuId") Integer stuId)
    {
        boolean b = illegalRecordService.IllegalRecordDeleteById(stuId);
        if(b)
        {
            return MessageAndData.success().setMessage("删除成功");
        }else{
            return MessageAndData.error().setMessage("删除失败");
        }
    }

    //根据学生学号查询违纪记录
    @ResponseBody
    @RequestMapping(value = "optStuId/{stuId}",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    public MessageAndData OptQueryWithId(@PathVariable(value = "stuId") Integer stuId)
    {
        List<IllegalRecord> illegalRecords = illegalRecordService.IllegalRecordQueryBySid(stuId);
        return MessageAndData.success().add("illegalRecords",illegalRecords);
    }

    //根据日期查询违纪记录
    @ResponseBody
    @RequestMapping(value = "optTime/{date}",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    public MessageAndData OptQueryWithDate(@PathVariable(value = "date") String date)
    {
        List<IllegalRecord> illegalRecords = illegalRecordService.IllegalRecordQueryByDate(date);
        return MessageAndData.success().add("illegalRecords",illegalRecords);
    }

    //查询所有违纪记录,可查询日期或者学号
    @ResponseBody
    @RequestMapping(value = "/optAll",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    public MessageAndData OptQueryAll(@RequestBody IllegalRecord illegalRecord){
        List<IllegalRecordResult> illegalRecords = illegalRecordService.SelectAll(illegalRecord);
        return MessageAndData.success().add("illegalRecords",illegalRecords);
    }

}
