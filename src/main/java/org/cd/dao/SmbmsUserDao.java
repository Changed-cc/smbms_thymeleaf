package org.cd.dao;

import org.cd.entity.SmbmsUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmbmsUserDao {
    /**
     *通过用户名查询用户信息
     * @param name
     * @return
     */
    public SmbmsUser getUserByName(String name);

    /**
     * 查询所有用户信息并模糊查询
     * @return
     */
    public List<SmbmsUser> showUserList(String name);
}
