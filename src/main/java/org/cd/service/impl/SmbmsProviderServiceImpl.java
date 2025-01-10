package org.cd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.cd.dao.SmbmsProviderDao;
import org.cd.entity.SmbmsProvider;
import org.cd.entity.SmbmsUser;
import org.cd.service.SmbmsProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SmbmsProviderServiceImpl implements SmbmsProviderService {
    @Autowired
    private SmbmsProviderDao smbmsProviderDao;
    //查询所有供应商
    @Override
    public PageInfo<SmbmsProvider> showProviderList(String name,int pageNum) {
        //设置当前页，页面容量
        PageHelper.startPage(pageNum,5);
        List<SmbmsProvider> list = smbmsProviderDao.showProviderList(name);
        //将数据放在PageInfo
        PageInfo<SmbmsProvider> pageInfo = new PageInfo<>(list);
        if(pageInfo.getList().size()>0){
            System.out.println(list);
            return pageInfo;
        }else{
            System.out.println("获取列表失败");
            return null;
        }
    }
}
