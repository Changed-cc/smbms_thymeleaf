package org.cd.web;

import com.github.pagehelper.PageInfo;
import org.cd.entity.SmbmsBill;
import org.cd.entity.SmbmsUser;
import org.cd.service.SmbmsBillService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/bill")
public class BillController {
    @Resource
    private SmbmsBillService smbmsBillService;
    @RequestMapping("/billList")
    public String billList(Model model,String bname,@RequestParam(defaultValue = "1") int pageNum) {
        System.out.println("进入订单查询界面");
        PageInfo<SmbmsBill> pageInfo = smbmsBillService.showSmbmsBills(bname,pageNum);
        if (pageInfo.getList().size() > 0) {
            //存储list
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("bname", bname);
            return "billList";
        }else{
            return "error";
        }
    }
}
