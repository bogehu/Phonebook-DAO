package com.dao;

import java.util.List;
import java.util.Map;

/**
* Created by bogehu on 16/6/14.
*/
public interface IAddrBookDao {
 public void insert(AddrBook addrBook);
 public void update(AddrBook addrBook);
 public void delete(Integer id);
 public List<Map> findByAll();
 public AddrBook findById(Integer id);
}
