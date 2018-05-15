package cn.jyuyang.service.serviceimpl;

import cn.jyuyang.entity.TProduct;
import cn.jyuyang.entity.TProductExample;
import cn.jyuyang.mapper.TProductMapper;
import cn.jyuyang.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private TProductMapper productMapper;

    @Override
    public PageInfo<TProduct> findByPageNo(Integer pageNo) {

        PageHelper.startPage(pageNo,10);

        TProductExample productExample = new TProductExample();
        List<TProduct> tProductList = productMapper.selectByExample(productExample);

        return new PageInfo<>(tProductList);
    }

    @Override
    public void saveProduct(TProduct product) {
        productMapper.insertSelective(product);
    }

    @Override
    public TProduct findById(Integer id) {

        TProduct product = productMapper.selectByPrimaryKey(id);
        return product;
    }

}
