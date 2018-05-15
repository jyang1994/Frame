package cn.jyuyang.controller;

import cn.jyuyang.entity.TProduct;
import cn.jyuyang.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String home(
            @RequestParam(name = "p",defaultValue = "1",required = false)  Integer pageNo,
                    Model model) {
        PageInfo<TProduct> pageInfo = productService.findByPageNo(pageNo);
        model.addAttribute("page",pageInfo);
        return "product/home";
    }

    @GetMapping("/new")
    public String newProduct() {
        return "product/new";
    }
/*
    @PostMapping("/new")
    public String newProduct(@Valid  TProduct product, BindingResult result){
        System.out.println("-------------------------------------");
        productService.saveProduct(product);
        return "redirect:/product";
    }*/

    @PostMapping("/new")
    public String newProduct(TProduct product){

        productService.saveProduct(product);
        return "redirect:/product";
    }


    @GetMapping("/{id:\\d+}/show")
    public String show(@PathVariable Integer id,Model model){
        TProduct product = productService.findById(id);
        model.addAttribute("product",product);
        return "product/show";
    }
}
