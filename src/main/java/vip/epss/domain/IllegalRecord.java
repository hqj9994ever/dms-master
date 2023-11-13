package vip.epss.domain;

/**
 * 缺勤记录
 */
public class IllegalRecord {
    private Integer id;
    //缺勤时间
    private String date;
    //管理员记录人id
    private Integer adminiId;
    //缺勤原因
    private String remark;
    //缺勤学生主键id
    private Integer stuId;

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

    public Integer getAdminiId() {
        return adminiId;
    }

    public void setAdminiId(Integer adminiId) {
        this.adminiId = adminiId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }
}