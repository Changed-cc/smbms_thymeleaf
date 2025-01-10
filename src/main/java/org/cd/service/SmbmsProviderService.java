package org.cd.service;

import com.github.pagehelper.PageInfo;
import org.cd.entity.SmbmsProvider;

import java.util.List;

public interface SmbmsProviderService {
    /**
     *
     * @param name
     * @param pageNum
     * @return
     */
    public PageInfo<SmbmsProvider> showProviderList(String name, int pageNum);
}
