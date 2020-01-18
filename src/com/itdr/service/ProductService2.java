package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.ProductDao;
import com.itdr.pojo.Product;

import java.util.List;

public class ProductService2 implements ProductService{

    private ProductDao productDao = new ProductDao();

    @Override
    public ResponseCode getAllProduct() {
        List<Product> products = productDao.selectAll();
        return ResponseCode.toSuccess(products);
    }

    // 商品下架
    @Override
    public ResponseCode toType(String id) {
        if (id == null || "".equals(id)){
            return ResponseCode.toDefeated("非法参数");
        }

        int i = Integer.parseInt(id);
        Product p = productDao.seltctByid(i);
        if (p == null){
            return ResponseCode.toDefeated("商品不存在");
        }

        int i2 = productDao.updeteByid(i);
        if (i2 < 0){
            return ResponseCode.toDefeated("商品下架失败");
        }
        return ResponseCode.toSuccess(i2);
    }

    @Override
    public ResponseCode<Product> selectName(String name) {
        if (name == null || "".equals(name)){
            return ResponseCode.toDefeated("非法参数");
        }
        String sql = "%"+name+"%";
        List<Product> p = productDao.selectName(sql);
        if (p == null){
            return ResponseCode.toDefeated("没有找到物品");
        }
        return ResponseCode.toSuccess(p);
    }
}
