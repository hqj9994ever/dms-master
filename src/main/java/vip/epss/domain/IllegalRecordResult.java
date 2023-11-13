package vip.epss.domain;

public class IllegalRecordResult {
    private Integer id;

    private String date;

    private String adminiName;

    private String remark;

    private String name;

    private Integer roomNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAdminiName() {
        return adminiName;
    }

    public void setAdminiName(String adminiName) {
        this.adminiName = adminiName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }
}