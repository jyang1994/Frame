package cn.jyuyang.mapper;

import cn.jyuyang.entity.Product;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductMapper {
    Product findById(Integer id);

    List<Product> findAllWithType();

    void delById(Integer id);

    void update(Product product);
}
