package org.cd.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.cd.entity.SmbmsUser;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface SmbmsUserService {
    /**
     *
     * @param name
     * @param password
     * @return
     */
    public boolean login(String name, String password);

    /**
     * 查询所有用户并支持模糊查询
     * 一个页面显示几条数据
     * @return
     */
    public PageInfo<SmbmsUser> showList(String name, int pageNum);

    public SmbmsUser viewUser(int id);
}
