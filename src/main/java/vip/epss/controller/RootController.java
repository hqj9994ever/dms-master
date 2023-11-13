package vip.epss.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vip.epss.domain.Root;
import vip.epss.service.RootService;
import vip.epss.service.StudentService;
import vip.epss.utils.MessageAndData;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/root")
public class RootController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private RootService rootService;

    //登录(限管理员)
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    public MessageAndData loginRoot(@RequestBody Root root){
        Root nowRoot = rootService.LoginCheck(root);
        if(nowRoot!=null){
            //宿舍列表
            List<Integer> rooms = studentService.selectRoomAll();

            //班级列表
            List<String> classses = studentService.selectClasssesAll();
            //登录验证成功,返回管理员id
            return MessageAndData.success().setMessage("登录成功").add("root",nowRoot).add("rooms",rooms).add("classses",classses);
        }else{
            return MessageAndData.error().setMessage("管理员编号或密码错误,登录失败");
        }
    }


}
