package cn.jyuyang.mapper;

import cn.jyuyang.entity.Product;
import cn.jyuyang.entity.ProductType;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface ProductMapper {
    Product findById(Integer id);

    List<Product> findAllWithType();

    void delById(Integer id);

    void update(Product product);

    List<Product> findAllWithTypeAndParam(Map<String, Object> maplist);
}
