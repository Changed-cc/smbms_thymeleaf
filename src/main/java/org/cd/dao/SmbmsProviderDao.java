package org.cd.dao;

import org.cd.entity.SmbmsProvider;

import java.util.List;

public interface SmbmsProviderDao {
    public List<SmbmsProvider> showProviderList(String name);
}
