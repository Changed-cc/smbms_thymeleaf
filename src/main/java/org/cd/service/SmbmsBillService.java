package org.cd.service;

import com.github.pagehelper.PageInfo;
import org.cd.entity.SmbmsBill;

import java.util.List;

public interface SmbmsBillService {
    /**
     *
     * @param name
     * @param pageNum
     * @return
     */
    public PageInfo<SmbmsBill> showSmbmsBills(String name, int pageNum);
}
