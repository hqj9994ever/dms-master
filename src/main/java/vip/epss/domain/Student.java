package vip.epss.domain;

/**
 *学生
 */
public class Student {
    //主键id
    private Integer stuId;
    //宿舍号
    private Integer roomNo;
    //学生姓名
    private String name;
    //学生性别 男 true 女 false
    private Boolean gender;
    //手机号码
    private String phoneNum;
    //学生头像 使用base64存储到数据库中
    private String headImage;
    //床号
    private String bedNum;
    //学号 规则 20210201364 （年份4位+（1~300，不重复）3位+随机4位）
    private String username;
    //密码
    private String password;
    //班级
    private String stuClass;

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getBedNum() {
        return bedNum;
    }

    public void setBedNum(String bedNum) {
        this.bedNum = bedNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}