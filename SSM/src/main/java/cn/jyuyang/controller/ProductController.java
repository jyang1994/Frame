package cn.jyuyang.controller;

import cn.jyuyang.entity.Product;


import cn.jyuyang.entity.ProductType;
import cn.jyuyang.exception.NotFountException;
import cn.jyuyang.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/{id:\\d+}")
    public String findById(@PathVariable Integer id, Model model){
        Product product = productService.findById(id);
        if(product==null){
            throw new NotFountException();
        }
        model.addAttribute("product",product);
        return "product/product";
    }

    @GetMapping
    public String findAllWithType(
                                    @RequestParam(defaultValue = "1",name="p",required = false) Integer pageNo,
                                    @RequestParam(required = false) String productName,
                                    @RequestParam(required = false) String place,
                                    @RequestParam(required = false) Float minPrice,
                                    @RequestParam(required = false) Float maxPrice,
                                    @RequestParam(required = false) Integer typeId,
                                               Model model){
        Map<String,Object> maplist = new HashMap<>();
        maplist.put("productName",productName);
        maplist.put("place",place);
        maplist.put("minPrice",minPrice);
        maplist.put("maxPrice",maxPrice);
        maplist.put("typeId",typeId);

        PageInfo<Product> productPageInfo = productService.findAllProductTypeAndParam(pageNo,maplist);
        List<ProductType> productTypeList = productService.findAllProductType();
        model.addAttribute("productPageInfo",productPageInfo);
        model.addAttribute("productTypeList",productTypeList);

        return "product/productlist";
    }

    @GetMapping("/new")
    public String findAllProductType(Model model){
        List<ProductType> productTypeList = productService.findAllProductType();

        model.addAttribute("productTypeList",productTypeList);
        return "product/new";
    }
    @PostMapping("new")
    public String findAllProductType(Product product, RedirectAttributes redirectAttributes) {
        System.out.println(product);
        redirectAttributes.addFlashAttribute("message","保存成功");
        return "redirect:/product";
    }

    @GetMapping("/{id:\\d+}/del")
    public String delById(@PathVariable Integer id ){
        System.out.println(id);
        productService.delFindById(id);
        return "redirect:/product";
    }
    @PostMapping("/{id:\\d+}/edit")
    public String edit(Product product,RedirectAttributes redirectAttributes){
        productService.update(product);
        redirectAttributes.addFlashAttribute("message","修改成功");
        return "redirect:/product";
    }
    @GetMapping("/{id:\\d+}/edit")
    public String edit(@PathVariable Integer id,Model model){
        Product product = productService.findById(id);
        List<ProductType> productTypeList = productService.findAllProductType();


        model.addAttribute("productTypeList",productTypeList);
        model.addAttribute("product",product);
        return "product/edit";
    }
}
