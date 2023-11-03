package com.example.softwareecommers.web;

import com.example.softwareecommers.services.Impl.ProductServiceImpl;
import com.example.softwareecommers.services.Impl.UserServiceImpl;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController extends BaseController{
    private final ProductServiceImpl productService;
    private final UserServiceImpl userServiceImpl;



    public ProductController(ProductServiceImpl productService, UserServiceImpl userServiceImpl) {
        this.productService = productService;
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping()
    public ModelAndView getProducts(){
        return super.view("products");
    }

    @GetMapping("/games")
    public ModelAndView listGames(Model model){
        model.addAttribute("gamesCatalog",productService.getProductsGames());
        return super.view("games");
    }

    @GetMapping("/software")
    public ModelAndView listSoftware(Model model){
        model.addAttribute("softwareCatalog",productService.getProductsSoftware());
        return super.view("software");
    }

    @GetMapping("/subscriptions")
    public ModelAndView listSubscriptions(Model model){
        model.addAttribute("subscriptionCatalog",productService.getProductsSubscriptions());
        return super.view("subscriptions");
    }

    @GetMapping("/{id}")
    public ModelAndView getCurrentProduct(@PathVariable("id") String id, Model model){
        model.addAttribute("productInfo",productService.getById(id));
        model.addAttribute("titleProduct", productService.getById(id).getName());
        return super.view("current-product");
    }


    @PostMapping("/{id}")
    public ModelAndView addCurrentProduct(@PathVariable("id") String id){
        userServiceImpl.addProduct(productService.getById(id));
        return super.redirect("/cart");
    }


    @GetMapping("/search")
    public ModelAndView search(@Param("keyword") String keyword, Model model){
        model.addAttribute("findsProduct", productService.search(keyword));
        model.addAttribute("keyword", keyword);
          return super.view("search");
    }


}
