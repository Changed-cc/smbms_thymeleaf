package org.cd.service;

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
     * 查询所有用户
     * @return
     */
    public List<SmbmsUser> showList();
}
