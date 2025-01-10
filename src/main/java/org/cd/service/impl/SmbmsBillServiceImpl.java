package org.cd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.cd.dao.SmbmsBillDao;
import org.cd.entity.SmbmsBill;
import org.cd.entity.SmbmsProvider;
import org.cd.service.SmbmsBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmbmsBillServiceImpl implements SmbmsBillService {
    @Autowired
    private SmbmsBillDao smbmsBillDao;
    @Override
    public PageInfo<SmbmsBill> showSmbmsBills(String name,int pageNum) {
        //设置当前页，页面容量
        PageHelper.startPage(pageNum,5);
        List<SmbmsBill> list = smbmsBillDao.showSmbmsBills();
        //将数据放在PageInfo
        PageInfo<SmbmsBill> pageInfo = new PageInfo<>(list);
        if(pageInfo.getList().size()>0){
            System.out.println(list);
            return pageInfo;
        }else{
            System.out.println("获取列表失败");
            return null;
        }
    }
}
