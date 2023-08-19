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

@WebServlet("/update.do")
public class UpdateServlet extends ViewBaseServlet {
    private static FruitDAO fruitdao = new FruitDAOImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码,防止中文乱码
        req.setCharacterEncoding("utf-8");
        // 首先拿到数据
        String fidStr = req.getParameter("fid");
        Integer fid = Integer.parseInt(fidStr);
        String fname = req.getParameter("fname");
        String fprice = req.getParameter("price");
        Integer price = Integer.parseInt(fprice);
        String fcount = req.getParameter("fcount");
        Integer count = Integer.parseInt(fcount);
        String remark = req.getParameter("remark");
        // 修改数据库
        fruitdao.updateFruit(new Fruit(fid,fname,price,count,remark));
        // 返回页面
        // 因为index.html是从session中取数据，如果用这个方法，由于session中的数据并未更新，因此数据还是原来的
//        super.processTemplate("index",req,resp);
        // 客户端重定向，再次发一次请求，防止数据不能更新
        resp.sendRedirect("fruitlist");
    }
}
