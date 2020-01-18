package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Product;

public interface ProductService {
    ResponseCode getAllProduct();

    ResponseCode toType(String id);

    ResponseCode<Product> selectName(String name);
}
