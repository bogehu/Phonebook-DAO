<%@ page language="java" contentType="text/html" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Spring MVC通讯录</title>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312"><style type="text/css">

body {
    margin-left: 0px;
    margin-top: 0px;
    margin-right: 0px;
    margin-bottom: 0px;
}
.td1 {
    font-size: 9pt;
    line-height: 24px;
    font-weight: bold;
    color: #000000;
    background-color: #dae8f1;
}
.td2 {
    font-size: 9pt;
    font-style: normal;
    line-height: 24px;
    background-color: #f9fdff;
    border-bottom-width: 1px;
    border-bottom-style: solid;
    border-bottom-color: #CCCCCC;
    font-weight: normal;
}
a:link {
    color: #0000FF;
    text-decoration: none;
}
a:visited {
    text-decoration: none;
    color: #0000FF;
}
a:hover {
    text-decoration: none;
    color: #0000FF;
}
a:active {
    text-decoration: none;
    color: #0000FF;
}
  </style>
  </head>

  <body>

    <table width="778" align="center" cellspacing="0" bgcolor="#f9fdff">
        <tr>
            <td height="147" background="images/top.gif" colspan="9"></td>
        </tr>
        <tr>
            <td height="33" background="images/title.gif" colspan="9"></td>
        </tr>


        <tr><td align="center" colspan="9">
        <table width="90%" cellspacing="0">
        <tr>
            <td height="3" colspan="9" bgcolor="#e0e9f0"></td>
        </tr>
        <tr>
            <td height="1" colspan="9"></td>
        </tr>
        <tr>
            <td height="24" colspan="9" align="right" bgcolor="#f0f5fb"><a href="insertAndUpdate.jsp"><img src="images/add.jpg" border="0"/></a></td>
        </tr>
        <tr>
            <td height="2" colspan="9"></td>
        </tr>
        <tr>
            <td height="24" align="center" class="td1">姓名</td>
            <td height="24" align="center" class="td1">工作单位</td>
            <td height="24" align="center" class="td1">职位</td>
            <td height="24" align="center" class="td1">办公电话</td>
            <td height="24" align="center" class="td1">移动电话</td>
            <td height="24" align="center" class="td1">传真</td>
            <td height="24" align="center" class="td1">电子邮件</td>
            <td height="24" colspan="2" align="center" class="td1">操作</td>
        </tr>
        <c:forEach items="${list}" var="item" varStatus="i">
            <tr>
                <td height="24" align="center" class="td2">${item.name}</td>
                <td height="24" align="center" class="td2">${item.company}</td>
                <td height="24" align="center" class="td2">${item.job}</td>
                <td height="24" align="center" class="td2">${item.tel}</td>
                <td height="24" align="center" class="td2">${item.mobile}</td>
                <td height="24" align="center" class="td2">${item.fax}</td>
                <td height="24" align="center" class="td2">${item.mail}</td>
                <td height="24" align="center" class="td2"><a href="addrBook.html?method=findById&id=${item.id}">修改</a></td>
                <td height="24" align="center" class="td2"><a href="addrBook.html?method=delete&id=${item.id}">删除</a></td>
            </tr>
        </c:forEach>
        </table>
        </td></tr>
        <tr>
            <td height="111" background="images/bottom.gif" colspan="9"></td>
        </tr>
  </table>
  </body>
</html>