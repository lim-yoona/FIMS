package com.ymiir.fruit.dao;

import com.ymiir.fruit.pojo.Fruit;

import java.util.List;

public interface FruitDAO {
    // 获取指定页的数据
    List<Fruit> getFruitList(Integer PageNum);
//    根据fid获取特定的水果库存信息
    Fruit getFruitById(Integer fid);
    // 修改指定的库存记录
    void updateFruit(Fruit fruit);
    // 删除指定数据
    void deleteFruit(Integer fid);
    void addFruit(Fruit fruit);
    // 查询总记录条数
    int getCount();
}
