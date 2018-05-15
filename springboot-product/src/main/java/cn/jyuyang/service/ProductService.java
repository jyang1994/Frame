package cn.jyuyang.service;

import cn.jyuyang.entity.TProduct;
import com.github.pagehelper.PageInfo;

public interface ProductService {

    PageInfo<TProduct> findByPageNo(Integer pageNo);

    void saveProduct(TProduct product);

    TProduct findById(Integer id);
}
