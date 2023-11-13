package vip.epss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vip.epss.domain.Callboard;
import vip.epss.domain.Student;
import vip.epss.domain.StudentPass;
import vip.epss.service.StudentService;
import vip.epss.utils.MessageAndData;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    //对学生进行注册(限管理员)
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    public MessageAndData regStudent(@RequestBody Student student){
        return  studentService.RegNewStudent(student);
//        boolean b = studentService.RegNewStudent(student);
//        if(b)
//        {
//            return MessageAndData.success().setMessage("注册成功");
//        }else{
//            return MessageAndData.error().setMessage("注册失败");
//        }
    }

    //对学生进行修改(限管理员)
    @ResponseBody
    @RequestMapping(value = "/optEit", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    public MessageAndData optEit(@RequestBody Student student){
        return studentService.optEitStudent(student);
//        boolean b = studentService.optEitStudent(student);
//        if(b)
//        {
//            return MessageAndData.success().setMessage("修改成功");
//        }else{
//            return MessageAndData.error().setMessage("修改失败");
//        }
    }

    //登录(限学生)
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    public MessageAndData loginStudent(@RequestBody Student student){
        Student nowStudent = studentService.LoginCheck(student);
        if(nowStudent!=null){
            //宿舍列表
            List<Integer> rooms = studentService.selectRoomAll();
            //登录验证成功
            return MessageAndData.success().setMessage("登录成功").add("student",nowStudent).add("rooms",rooms);
        }else{
            return MessageAndData.error().setMessage("学生学号或密码错误,登录失败");
        }
    }

    //重置密码(限管理员)
    @ResponseBody
    @RequestMapping(value = "/updpassword",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    public MessageAndData updPassword(@RequestBody Student student){
        boolean b = studentService.UpdatePassword(student);
        if(b){
            return MessageAndData.success().setMessage("更改密码成功");
        }else{
            return MessageAndData.error().setMessage("更改密码失败");
        }
    }

    //修改密码(限学生)
    @ResponseBody
    @RequestMapping(value = "/updMypassword",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    public MessageAndData updMypassword(@RequestBody StudentPass studentPass){
        boolean b = studentService.updMypassword(studentPass);
        if(b){
            return MessageAndData.success().setMessage("更改密码成功,请重新登录");
        }else{
            return MessageAndData.error().setMessage("更改密码失败");
        }
    }

    //更改个人信息
    @ResponseBody
    @RequestMapping(value = "/updUserInfo",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    public MessageAndData updUserInfo(@RequestBody Student student){
        boolean b = studentService.UpdatePhoneNumber(student);
        if(b){
            return MessageAndData.success().setMessage("更改个人信息成功");
        }else{
            return MessageAndData.error().setMessage("更改个人信息失败");
        }
    }

    //删除一名学生(限管理员)
    @ResponseBody
    @RequestMapping(value = "/delstudent", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    public MessageAndData delStudent(@RequestBody Student student){
        boolean b = studentService.DeleteOne(student.getStuId());
        if(b){
            return MessageAndData.success().setMessage("删除成功");
        }else{
            return MessageAndData.error().setMessage("删除失败");
        }
    }

    //列表
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    public MessageAndData list(){
        List<Student> students = studentService.SelectAll();
        return MessageAndData.success().setMessage("学生列表查成功").add("students", students);
    }

}
