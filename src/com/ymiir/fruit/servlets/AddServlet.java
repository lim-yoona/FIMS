package com.ymiir.fruit.servlets;

import com.ymiir.fruit.dao.FruitDAO;
import com.ymiir.fruit.dao.impl.FruitDAOImpl;
import com.ymiir.fruit.pojo.Fruit;
import com.ymiir.myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add.do")
public class AddServlet extends ViewBaseServlet {
    private static FruitDAO fruitdao = new FruitDAOImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 拿到数据
        String fname = req.getParameter("fname");
        String fprice = req.getParameter("price");
        Integer price = Integer.parseInt(fprice);
        String fcount = req.getParameter("fcount");
        Integer count = Integer.parseInt(fcount);
        String remark = req.getParameter("remark");
        // 存入数据库
        fruitdao.addFruit(new Fruit(0,fname,price,count,remark));
        // 刷新页面
        resp.sendRedirect("fruitlist");
    }
}
