package cn.jyuyang.service;

import cn.jyuyang.entity.Product;
import cn.jyuyang.entity.ProductType;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface ProductService {
    /**
     * 根据ID找到对应的商品信息
     * @param id
     * @return商品对象
     */
    Product findById(Integer id);

    PageInfo<Product> findAllWithType(Integer pageNo);

    List<ProductType> findAllProductType();

    void delFindById(Integer id);

    void update(Product product);

    /**
     * 根据搜索条件进行动态查询
     * @param maplist
     * @return
     */
    PageInfo<Product> findAllProductTypeAndParam(Integer pageNo,Map<String, Object> maplist);
}
