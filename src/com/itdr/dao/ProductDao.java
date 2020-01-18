package com.itdr.dao;

import com.itdr.pojo.Product;
import com.itdr.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDao {

    public List<Product> selectAll(){
        QueryRunner qr = new QueryRunner(C3P0Util.com());
        List<Product> query = null;
        String sql = "SELECT id,pname,price,pnum,type,create_time,update_time FROM product";
        try {
             query = qr.query(sql, new BeanListHandler<Product>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public Product seltctByid(int i) {
        QueryRunner qr = new QueryRunner(C3P0Util.com());
        Product query = null;
        String sql = "SELECT id,pname,price,pnum,type,create_time,update_time FROM product WHERE id=?";
        try {
            query = qr.query(sql, new BeanHandler<Product>(Product.class),i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public int updeteByid(int i) {
        QueryRunner qr = new QueryRunner(C3P0Util.com());
        int m = 0;
        String sql = "UPDATE product SET type=1 WHERE id=?";
        try {
            m = qr.update(sql,i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    public List<Product> selectName(String name) {
        QueryRunner qr = new QueryRunner(C3P0Util.com());
        List<Product> li = null;
        String sql = "SELECT id,pname,price,pnum,type,create_time,update_time FROM product WHERE pname LIKE ?";
        try {
            li = qr.query(sql, new BeanListHandler<Product>(Product.class),name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
}
