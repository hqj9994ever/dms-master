package vip.epss.service;

import vip.epss.domain.Student;
import vip.epss.domain.StudentPass;
import vip.epss.utils.MessageAndData;

import java.util.List;

public interface StudentService {
    //学生注册(限管理员)
    public MessageAndData RegNewStudent(Student student);
    //学生登录
    public Student LoginCheck(Student student);
    //更改密码
    public boolean UpdatePassword(Student student);
    //更改电话号码
    public boolean UpdatePhoneNumber(Student student);
    //更改宿舍号和床号(限管理员)
    MessageAndData optEitStudent(Student student);
    //删除学生信息(限管理员)
    public boolean DeleteOne(Integer stu_id);
    //列表
    public List<Student> SelectAll();

    public boolean updMypassword(StudentPass studentPass);

    public List<Integer> selectRoomAll();

    public List<String> selectClasssesAll();
}
