package vip.epss.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vip.epss.domain.ElectRate;
import vip.epss.service.ElectricChargeService;
import vip.epss.utils.MessageAndData;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/electric")
public class ElectricController {

    @Autowired
    private ElectricChargeService electricChargeService;

    //充值电费(更新操作)(限学生)
    @ResponseBody
    @RequestMapping(value = "/optAdd", method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    public MessageAndData Pay(@RequestBody ElectRate electRate){
        boolean b = electricChargeService.ElectricChargePay(electRate);
        if(b)
        {
            return MessageAndData.success().setMessage("充值成功");
        }else{
            return MessageAndData.error().setMessage("充值失败");
        }
    }

    //查询电费余额
    @ResponseBody
    @RequestMapping(value = "/optFind/{roomId}", method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    public MessageAndData CheckRemain(@PathVariable("roomId") Integer roomId){
        double remain = electricChargeService.ElectricChargeCheckBalance(roomId);
        return MessageAndData.success().setMessage("查询成功").add("allRemain",remain);
    }

    //查询宿舍上周数据统计
    @ResponseBody
    @RequestMapping(value = "/lastWeek/{roomId}",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    public MessageAndData lastWeek(@PathVariable("roomId") Integer roomId){
        List<Map> electRates = electricChargeService.selectLastWeek(roomId);
        return MessageAndData.success().add("electRates", electRates);
    }

    //查询宿舍最近3条数据
    @ResponseBody
    @RequestMapping(value = "/lastThreeList/{roomId}",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    public MessageAndData lastThreeList(@PathVariable("roomId") Integer roomId){
        List<Map> electRates = electricChargeService.selectLastThreeList(roomId);
        return MessageAndData.success().add("electRates", electRates);
    }
}

