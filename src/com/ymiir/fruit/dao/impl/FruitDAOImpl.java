package com.ymiir.fruit.dao.impl;

import com.ymiir.fruit.dao.FruitDAO;
import com.ymiir.fruit.pojo.Fruit;
import com.ymiir.myssm.basedao.BaseDAO;

import java.util.List;

public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
    public List<Fruit> getFruitList(){
        return super.executeQuery("select * from t_fruit");
    }
}
