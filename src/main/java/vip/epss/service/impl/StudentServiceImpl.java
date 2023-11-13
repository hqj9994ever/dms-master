package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import vip.epss.dao.IllegalRecordMapper;
import vip.epss.dao.StudentMapper;
import vip.epss.domain.IllegalRecordExample;
import vip.epss.domain.Student;
import vip.epss.domain.StudentExample;
import vip.epss.domain.StudentPass;
import vip.epss.service.StudentService;
import vip.epss.utils.MessageAndData;

import java.util.List;

@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private IllegalRecordMapper illegalRecordMapper;

    @Override
    public MessageAndData RegNewStudent(Student student) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andBedNumEqualTo(student.getBedNum());
        criteria.andRoomNoEqualTo(student.getRoomNo());
        //先查下该房间的该床是否已经有人
        List<Student>  list = studentMapper.selectByExample(studentExample);
        if(CollectionUtils.isEmpty(list)){
           boolean status =  studentMapper.insertSelective(student)>0;
           if(status){
               return MessageAndData.success().setMessage("新增成功");
           }else{
               return MessageAndData.error().setMessage("新增失败");
           }
        }
        return MessageAndData.error().setMessage(student.getRoomNo()+"宿舍"+student.getBedNum()+"床已有人");
    }

    @Override
    public Student LoginCheck(Student student) {
        Student newStudent = studentMapper.selectByLogin(student);
        if(newStudent!=null && student.getPassword().equals(newStudent.getPassword())){
            //账号和密码都匹配
            return newStudent;
        }
        return null;
    }

    @Override
    public boolean UpdatePassword(Student newStudent) {
        Student student = studentMapper.selectByPrimaryKey(newStudent.getStuId());
        if(student.getPassword().equals(newStudent.getPassword())){
            System.out.println("与原密码相同");
            return false;
        }else{
            studentMapper.updateByPrimaryKeySelective(newStudent);
            System.out.println("更改密码成功");
            return true;
        }
    }

    @Override
    public boolean UpdatePhoneNumber(Student newStudent) {
        studentMapper.updateByPrimaryKeySelective(newStudent);
        return true;
    }


    @Override
    public MessageAndData optEitStudent(Student student) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andBedNumEqualTo(student.getBedNum());
        criteria.andRoomNoEqualTo(student.getRoomNo());
        //先查下该房间的该床是否已经有人
        List<Student>  list = studentMapper.selectByExample(studentExample);
        if(CollectionUtils.isEmpty(list)){
            boolean status =  studentMapper.updateByPrimaryKeySelective(student)>0;
            if(status){
                return MessageAndData.success().setMessage("修改成功");
            }else{
                return MessageAndData.error().setMessage("修改失败");
            }
        }
        //有人占用，看下这个人是否为自己
        Student exitis = list.get(0);
        if(exitis.getStuId().intValue() == student.getStuId().intValue()){
            boolean status =  studentMapper.updateByPrimaryKeySelective(student)>0;
            if(status){
                return MessageAndData.success().setMessage("修改成功");
            }else{
                return MessageAndData.error().setMessage("修改失败");
            }
        }
        return MessageAndData.error().setMessage(student.getRoomNo()+"宿舍"+student.getBedNum()+"床已有人");
    }

    @Override
    public boolean DeleteOne(Integer stu_id) {
        //先删违纪记录中的学生信息，再删主表中的学生信息
        IllegalRecordExample illegalRecordExample = new IllegalRecordExample();
        IllegalRecordExample.Criteria criteria = illegalRecordExample.createCriteria();
        criteria.andStuIdEqualTo(stu_id);
        illegalRecordMapper.deleteByExample(illegalRecordExample);
        int i = studentMapper.deleteByPrimaryKey(stu_id);
        if(i > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Student> SelectAll() {
        return studentMapper.selectByExample(null);
    }

    @Override
    public boolean updMypassword(StudentPass studentPass) {
        Student student = studentMapper.selectByPrimaryKey(studentPass.getStuId());
        if(!student.getPassword().equals(studentPass.getOldPass())){
            return false;
        }else{
            Student passStudent = new Student();
            passStudent.setStuId(studentPass.getStuId());
            passStudent.setPassword(studentPass.getNewPass());
            studentMapper.updateByPrimaryKeySelective(passStudent);
            System.out.println("更改密码成功");
            return true;
        }
    }

    @Override
    public List<Integer> selectRoomAll() {
        return studentMapper.findRoomAll();
    }


    @Override
    public List<String> selectClasssesAll() {
        return studentMapper.findClasssesAll();
    }



}
