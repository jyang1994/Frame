package cn.jyuyang.service;

import cn.jyuyang.entity.Product;
import cn.jyuyang.entity.ProductExample;
import cn.jyuyang.mapper.ProductMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public PageInfo<Product> selectByPageNo(Integer pageNo) {
        PageHelper.startPage(pageNo,10);

        ProductExample productExample = new ProductExample();
        productExample.setOrderByClause("id asc");

        List<Product> lists = productMapper.selectByExample(productExample);

        return new PageInfo<>(lists);

    }

    public void saveProduct(Product product) {
        productMapper.insertSelective(product);
    }

    public void deleteProduct(Integer id) {
        productMapper.deleteByPrimaryKey(id);
    }

    public void updateProduct(Product product) {
        productMapper.updateByPrimaryKeySelective(product);
    }

    public Product findById(Integer id) {
        Product product = productMapper.selectByPrimaryKey(id);
        return product;
    }
}
