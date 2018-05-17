package cn.jyuyang.controller;

import cn.jyuyang.entity.Product;
import cn.jyuyang.service.ProductService;
import cn.jyuyang.util.ResponseBean;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseBean home(
            @RequestParam(defaultValue = "1",required = false,name = "p")Integer pageNo){
        System.out.println(pageNo+"---------------ppp");
        PageInfo<Product> pageInfo = productService.selectByPageNo(pageNo);
        return ResponseBean.success(pageInfo);
    }
    @PostMapping("/new")
    public ResponseBean newProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return ResponseBean.success();
    }

    @DeleteMapping("/{id}")
    public ResponseBean delProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return  ResponseBean.success();
    }

    @PutMapping("/{id}")
    public ResponseBean updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return ResponseBean.success();
    }

    @GetMapping("/{id}")
    public ResponseBean getProduct(@PathVariable Integer id){
       Product product = productService.findById(id);
       return ResponseBean.success(product);
    }
}
