package org.cd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.cd.dao.SmbmsUserDao;
import org.cd.entity.SmbmsUser;
import org.cd.service.SmbmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmbmsUserServiceImpl implements SmbmsUserService {
    @Autowired
    private SmbmsUserDao smbmsUserDao;
    //登录
    @Override
    public boolean login (String name, String password) {
       SmbmsUser user = smbmsUserDao.getUserByName(name);
       if(user != null){
           if (user.getUserPassword().equals(password)) {
               return true;
           }else{
               return false;
           }
       }
       return false;
    }
    //查询所有用户
    @Override
    public PageInfo<SmbmsUser> showList(String name,int pageNum) {
        //设置当前页，页面容量
        PageHelper.startPage(pageNum,5);
        SmbmsUser smbmsUser = new SmbmsUser();
        smbmsUser.setUsername(name);
        List<SmbmsUser> list = smbmsUserDao.showUserList(smbmsUser);
        //将数据放在PageInfo
        PageInfo<SmbmsUser> pageInfo = new PageInfo<>(list);
        if(pageInfo.getList().size()>0){
            return pageInfo;
        }else{
            return null;
        }
    }
    @Override
    public SmbmsUser viewUser(int id) {
        SmbmsUser smbmsUser = new SmbmsUser();
        smbmsUser.setId(id);
        List<SmbmsUser> list = smbmsUserDao.showUserList(smbmsUser);
        if(list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }
}
