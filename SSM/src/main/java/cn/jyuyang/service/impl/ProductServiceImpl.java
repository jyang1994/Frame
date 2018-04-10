package cn.jyuyang.service.impl;

import cn.jyuyang.entity.Product;
import cn.jyuyang.entity.ProductType;
import cn.jyuyang.mapper.ProductMapper;
import cn.jyuyang.mapper.ProductTypeMapper;
import cn.jyuyang.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductTypeMapper productTypeMapper;
    /**
     * 根据ID找到对应的商品信息
     *
     * @param id
     * @return商品对象
     */
    @Override
    public Product findById(Integer id) {
        return productMapper.findById(id);
    }

    @Override
    public PageInfo<Product> findAllWithType(Integer pageNo) {
        PageHelper.startPage(pageNo,15);
        List<Product> productList = productMapper.findAllWithType();
        return new PageInfo<>(productList);
    }

    @Override
    public List<ProductType> findAllProductType() {
        return productTypeMapper.findAllProductType();
    }

    @Override
    public void delFindById(Integer id) {
        productMapper.delById(id);
    }

    @Override
    public void update(Product product) {
        productMapper.update(product);
    }
}
