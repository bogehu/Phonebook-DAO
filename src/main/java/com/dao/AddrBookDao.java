package com.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;
import java.util.Map;

/**
 * Created by bogehu on 16/6/14.
 */
public class AddrBookDao extends JdbcDaoSupport implements IAddrBookDao {

    /*
     * IAddrBookDao#findByAll()
     */
    @Override
    public List<Map> findByAll() {
        List list = getJdbcTemplate().queryForList("SELECT * FROM persons");
        return list;
    }

    /*
     * IAddrBookDao#findById()
     */
    @Override
    public AddrBook findById(Integer id) {
        AddrBook addrBook = new AddrBook();
        List<Map<String, Object>> list = getJdbcTemplate().queryForList("SELECT * FROM persons WHERE id="+id);
        for (int i = 0; i < list.size(); i++) {
            Map map =  list.get(i);
            addrBook.setId(Integer.valueOf(map.get("id").toString()));
            addrBook.setName(map.get("name").toString());
            addrBook.setCompany(map.get("company").toString());
            addrBook.setJob(map.get("job").toString());
            addrBook.setTel(map.get("tel").toString());
            addrBook.setMobile(map.get("mobile").toString());
            addrBook.setFax(map.get("fax").toString());
            addrBook.setMail(map.get("mail").toString());
        }
        return addrBook;
    }

    /*
     * IAddrBookDao#insert()
     */
    @Override
    public void insert(AddrBook addrBook) {
        Object[] o = { addrBook.getName(), addrBook.getCompany(),
                addrBook.getJob(), addrBook.getTel(),
                addrBook.getMobile(), addrBook.getFax(), addrBook.getMail() };
        getJdbcTemplate().update(
                "INSERT INTO "
                        + "persons(name,company,job,tel,mobile,fax,mail) "
                        + "values (?,?,?,?,?,?,?)",o);
    }

    /*
     * IAddrBookDao#update()
     */
    @Override
    public void update(AddrBook addrBook) {
        Object[] o = { addrBook.getName(), addrBook.getCompany(),
                addrBook.getJob(), addrBook.getTel(), addrBook.getMobile(),
                addrBook.getFax(), addrBook.getMail(),addrBook.getId()};
        getJdbcTemplate().update("UPDATE persons SET name=?,company=?,job=?,tel=?,mobile=?,fax=?,mail=? WHERE id=?",o);
    }

    /*
     * IAddrBookDao#delete(java.lang.Integer)
     */
    @Override
    public void delete(Integer id) {
        getJdbcTemplate().update("DELETE FROM persons WHERE id="+id);
    }
}

