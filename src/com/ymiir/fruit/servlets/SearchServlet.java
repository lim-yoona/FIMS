package com.ymiir.fruit.servlets;

import com.ymiir.fruit.dao.FruitDAO;
import com.ymiir.fruit.dao.impl.FruitDAOImpl;
import com.ymiir.fruit.pojo.Fruit;
import com.ymiir.myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/search.do")
public class SearchServlet extends ViewBaseServlet {
    private static FruitDAO fruitdao = new FruitDAOImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 获得数据
        String key = req.getParameter("keyword");
        // 查询
        List<Fruit> searchList = fruitdao.getFruitByName(key);
        HttpSession session = req.getSession();
        session.setAttribute("fruitList",searchList);
        // 处理模板，将数据显示到页面上
        super.processTemplate("index",req,resp);
    }
}
