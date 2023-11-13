package vip.epss.domain;

/**
 * 修改密码的新旧密码
 */
public class StudentPass {
    //学生id
    private Integer stuId;
    //旧密码
    private String oldPass;
    //新密码
    private String newPass;
//    //确认密码
//    private String verifyPass;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

//    public String getVerifyPass(){return verifyPass;}
//
//    public void setVerifyPass(String verifyPass){ this.verifyPass = verifyPass;}
}