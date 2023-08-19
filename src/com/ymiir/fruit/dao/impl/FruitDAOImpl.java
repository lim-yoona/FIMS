package com.ymiir.fruit.dao.impl;

import com.ymiir.fruit.dao.FruitDAO;
import com.ymiir.fruit.pojo.Fruit;
import com.ymiir.myssm.basedao.BaseDAO;

import java.util.List;

public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
    public List<Fruit> getFruitList(){
        return super.executeQuery("select * from t_fruit");
    }
    public Fruit getFruitById(Integer  fid){return super.load("select * from t_fruit where fid=?",fid);}

    public void updateFruit(Fruit fruit){
        String sql = "update t_fruit set fname = ?, price = ?, fcount = ?, remark = ? where fid = ?";
        super.executeUpdate(sql,fruit.getFname(),fruit.getPrice(),fruit.getFcount(),fruit.getRemark(),fruit.getFid());
    }
}
