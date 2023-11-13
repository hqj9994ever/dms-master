package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.ElectRateMapper;
import vip.epss.domain.ElectRate;
import vip.epss.service.ElectricChargeService;

import java.util.List;
import java.util.Map;

@Service(value = "electricchargeService")
public class ElectricChargeServiceImpl implements ElectricChargeService {

    @Autowired
    private ElectRateMapper electRateMapper;

    @Override
    public boolean ElectricChargePay(ElectRate electRate) {
        if(electRate.getRemain()<=0){
            return false;
        }else{
            ElectRate oldElectRate = electRateMapper.selectByPrimaryKey(electRate.getRoomId());
            if(oldElectRate==null){
                oldElectRate = new ElectRate();
            }
            //获取最新一次余额
            double oldRemain = oldElectRate.getRoomEndPay();
            //将余额和充入的金额作为最新的余额
            electRate.setRoomEndPay(oldRemain+electRate.getRemain());
            return electRateMapper.insertSelective(electRate)>0;
        }
    }

    @Override
    public double ElectricChargeCheckBalance(Integer roomId) {
        ElectRate electRate = electRateMapper.selectByPrimaryKey(roomId);
        if(electRate == null){
            electRate = new ElectRate();
        }
        return electRate.getRoomEndPay();
    }

    @Override
    public List<ElectRate> SelectAll() {
        List<ElectRate> electRates = electRateMapper.selectByExample(null);
        return electRates;
    }

    @Override
    public List<Map> selectLastWeek(Integer roomId) {
        return electRateMapper.findLastWeek(roomId);
    }

    @Override
    public List<Map> selectLastThreeList(Integer roomId) {
        return electRateMapper.findLastThreeList(roomId);
    }
}
