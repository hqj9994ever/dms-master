package vip.epss.domain;
/**
 * 电费缴纳
 */
public class ElectRate {
    //宿舍号
    private Integer roomId;
    //剩余余额
    private double roomEndPay;
    //本次充值
    private double remain;
    //充值日期
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public double getRoomEndPay() {
        return roomEndPay;
    }

    public void setRoomEndPay(double roomEndPay) {
        this.roomEndPay = roomEndPay;
    }

    public double getRemain() {
        return remain;
    }

    public void setRemain(double remain) {
        this.remain = remain;
    }
}