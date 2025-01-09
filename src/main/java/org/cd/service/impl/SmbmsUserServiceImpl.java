package org.cd.service.impl;

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
    public List<SmbmsUser> showList() {
        List<SmbmsUser> list = smbmsUserDao.showUserList();
        if(list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
