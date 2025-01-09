package org.cd.web;

import org.cd.entity.SmbmsUser;
import org.cd.service.SmbmsUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class LoginController {
    //将业务层注入
    @Resource
    private SmbmsUserService smbmsUserService;
    //登录界面
    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session) {
        System.out.println(username+"==========");
        System.out.println(password+"==========");
        boolean login = smbmsUserService.login(username, password);
        System.out.println(login);
        if (login){
            System.out.println("111111");
            session.setAttribute("name", username);
            return "welcome";
        }else{
            System.out.println("00000");
            return "login";
        }
    }
    //查询全部用户界面
    @RequestMapping("/showList")
    public String showList(Model model,HttpSession session) {
        System.out.println("进入查询界面");
        List<SmbmsUser> list = smbmsUserService.showList();
        if (list.size() > 0){
            //存储list
            model.addAttribute("list", list);
            return "userList";
        }else{
            return "error";
        }
    }
}
