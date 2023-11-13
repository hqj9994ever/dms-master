package vip.epss.service;

import vip.epss.domain.ElectRate;

import java.util.List;
import java.util.Map;

public interface ElectricChargeService {
    //宿舍充值电费
    public boolean ElectricChargePay(ElectRate electRate);
    //查询宿舍的电费余额
    public double ElectricChargeCheckBalance(Integer roomId);
    //查询所有宿舍的电费信息(限管理员)
    public List<ElectRate> SelectAll();
    //上周记录
    List<Map> selectLastWeek(Integer roomId);
    //最新三条记录
    List<Map> selectLastThreeList(Integer roomId);
}
