package vip.epss.domain;

/**
 * 公告
 */
public class Callboard {
    private Integer id;
    //发布日期
    private String date;
    //管理员id
    private Integer adminiId;
    //管理员发布内容
    private String content;
    //管理员姓名
    private String adminiName;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAdminiName() {
        return adminiName;
    }

    public void setAdminiName(String adminiName) {
        this.adminiName = adminiName;
    }
}