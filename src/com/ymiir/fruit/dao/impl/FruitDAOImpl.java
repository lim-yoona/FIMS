package com.ymiir.fruit.dao.impl;

import com.ymiir.fruit.dao.FruitDAO;
import com.ymiir.fruit.pojo.Fruit;
import com.ymiir.myssm.basedao.BaseDAO;

import java.util.List;

public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
    public List<Fruit> getFruitList(Integer PageNum){

        return super.executeQuery("select * from t_fruit limit ?,5",(PageNum-1)*5);
    }
    public Fruit getFruitById(Integer  fid){return super.load("select * from t_fruit where fid=?",fid);}

    public void updateFruit(Fruit fruit){
        String sql = "update t_fruit set fname = ?, price = ?, fcount = ?, remark = ? where fid = ?";
        super.executeUpdate(sql,fruit.getFname(),fruit.getPrice(),fruit.getFcount(),fruit.getRemark(),fruit.getFid());
    }
    public void deleteFruit(Integer fid){
        super.executeUpdate("delete from t_fruit where fid = ?",fid);
    }
    public void addFruit(Fruit fruit){
        String sql = "insert into t_fruit  (fid,fname,price,fcount,remark) VALUES (0,?,?,?,?)";
        super.executeUpdate(sql,fruit.getFname(),fruit.getPrice(),fruit.getFcount(),fruit.getRemark());
    }

    public int getCount(){
        return Integer.parseInt(super.executeComplexQuery("select count(*) from t_fruit")[0].toString());
    }
    public List<Fruit> getFruitByName(String name){
        return super.executeQuery("select * from t_fruit where fname=?",name);
    }
}
