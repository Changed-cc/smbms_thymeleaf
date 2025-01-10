package org.cd.web;

import com.github.pagehelper.PageInfo;
import org.cd.entity.SmbmsProvider;
import org.cd.entity.SmbmsUser;
import org.cd.service.SmbmsProviderService;
import org.cd.service.SmbmsUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
            return "error";
        }
    }
    //查询全部用户界面
    @RequestMapping("/showList")
    public String showList(Model model, String uname, @RequestParam(defaultValue = "1") int pageNum) {
        System.out.println("进入用户查询界面");
        PageInfo<SmbmsUser> pageInfo = smbmsUserService.showList(uname,pageNum);
        if (pageInfo.getList().size()>0){
            //存储pageInfo
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("uname", uname);
            System.out.println(pageInfo.getList());
            return "userList";
        }else{
            return "error";
        }
    }
}
