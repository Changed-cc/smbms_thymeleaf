package org.cd.web;

import com.github.pagehelper.PageInfo;
import org.cd.entity.SmbmsProvider;
import org.cd.service.SmbmsProviderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/provider")
public class ProviderController {
    @Resource
    private SmbmsProviderService smbmsProviderService;
    //查询供应商
    @RequestMapping("/showProviderList")
    public String showProviderList(Model model, String pname,@RequestParam(defaultValue = "1") int pageNum) {
        System.out.println("进入供应商查询界面");
        PageInfo<SmbmsProvider> pageInfo = smbmsProviderService.showProviderList(pname,pageNum);
        if (pageInfo.getList().size() > 0) {
            //存储list
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("pname", pname);
            return "providerList";
        }else{
            return "error";
        }
    }
}
