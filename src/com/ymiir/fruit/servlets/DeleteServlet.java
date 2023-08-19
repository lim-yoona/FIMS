package com.ymiir.fruit.servlets;

import com.ymiir.fruit.dao.FruitDAO;
import com.ymiir.fruit.dao.impl.FruitDAOImpl;
import com.ymiir.myssm.myspringmvc.ViewBaseServlet;
import com.ymiir.myssm.utils.StringJudge;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/del.do")
public class DeleteServlet extends ViewBaseServlet {
    private static FruitDAO fruitdao = new FruitDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 取得参数
        String fidStr = req.getParameter("fid");
        // 数据库删除
        if(StringJudge.StringIsNotEmpty(fidStr)){
            Integer fid = Integer.parseInt(fidStr);
            fruitdao.deleteFruit(fid);
        }
        resp.sendRedirect("fruitlist");
    }
}
