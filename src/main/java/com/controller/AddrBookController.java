package com.controller;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.dao.AddrBook;
import com.dao.IAddrBookDao;
/**
 * Created by bogehu on 16/6/14.
 */
public class AddrBookController extends MultiActionController {
    private IAddrBookDao addrBookDao;
    public void setAddrBookDao(IAddrBookDao addrBookDao) {
        this.addrBookDao = addrBookDao;
    }
    public ModelAndView insertAndUpdate(HttpServletRequest request,HttpServletResponse response){
        AddrBook addrBook = new AddrBook();
        addrBook.setName(request.getParameter("name"));
        addrBook.setCompany(request.getParameter("company"));
        addrBook.setJob(request.getParameter("job"));
        addrBook.setTel(request.getParameter("tel"));
        addrBook.setMobile(request.getParameter("mobile"));
        addrBook.setMail(request.getParameter("mail"));
        addrBook.setFax(request.getParameter("fax"));
        addrBook.setId(Integer.valueOf(request.getParameter("id")));
        if(addrBook.getId()==0){
            addrBookDao.insert(addrBook);
        }else{
            addrBookDao.update(addrBook);
        }
        return findByAll(request, response);
    }
    public ModelAndView update(HttpServletRequest request,HttpServletResponse response){
        return null;
    }
    public ModelAndView delete(HttpServletRequest request,HttpServletResponse response){
        Integer id = Integer.valueOf(request.getParameter("id"));
        addrBookDao.delete(id);
        return findByAll(request, response);
    }
    public ModelAndView findByAll(HttpServletRequest request,HttpServletResponse response){
        List<Map> list = addrBookDao.findByAll();
        return new ModelAndView("show","list",list);
    }
    public ModelAndView findById(HttpServletRequest request,HttpServletResponse response){
        Integer id = Integer.valueOf(request.getParameter("id"));
        AddrBook addrBook = addrBookDao.findById(id);
        return new ModelAndView("insertAndUpdate","addrBook",addrBook);
    }
}
