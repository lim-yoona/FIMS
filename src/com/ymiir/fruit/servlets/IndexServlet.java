package com.ymiir.fruit.servlets;

import com.ymiir.fruit.dao.FruitDAO;
import com.ymiir.fruit.dao.impl.FruitDAOImpl;
import com.ymiir.fruit.pojo.Fruit;
import com.ymiir.myssm.myspringmvc.ViewBaseServlet;
import com.ymiir.myssm.utils.StringJudge;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


// servlet从3.0开始支持注解方式的注册
//@WebServlet("/fruitList")
public class IndexServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 默认为第一页
        Integer PageNum = 1;
        // 取得pagenum
        String pn = req.getParameter("PageNum");
        if(StringJudge.StringIsNotEmpty(pn)){
            PageNum = Integer.parseInt(pn);
        }
        // 将页码保存到session作用域
        HttpSession session = req.getSession();
        session.setAttribute("PageNum",PageNum);

        FruitDAO fruitdao = new FruitDAOImpl();
        int fruitCount = fruitdao.getCount();
        session.setAttribute("totalCount",fruitCount);
        // 检索数据库得到水果列表
        List<Fruit> fruitlist = fruitdao.getFruitList(PageNum);
        // 保存到session作用域
        session.setAttribute("fruitList",fruitlist);

        // 处理模板，将数据显示到页面上
        super.processTemplate("index",req,resp);
    }
}
