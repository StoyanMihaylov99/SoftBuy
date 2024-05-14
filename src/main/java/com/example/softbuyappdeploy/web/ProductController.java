package com.example.softbuyappdeploy.web;


import com.example.softbuyappdeploy.models.dtos.ProductDTO;
import com.example.softbuyappdeploy.services.Impl.ProductServiceImpl;
import com.example.softbuyappdeploy.services.Impl.UserServiceImpl;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController extends BaseController{
    private final ProductServiceImpl productServiceImpl;
    private final UserServiceImpl userServiceImpl;



    public ProductController(ProductServiceImpl productService, UserServiceImpl userServiceImpl) {
        this.productServiceImpl = productService;
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping()
    public ModelAndView getProducts(){
        return super.view("products");
    }

    @GetMapping("/games")
    public ModelAndView listGames(Model model){
        model.addAttribute("gamesCatalog", productServiceImpl.getProductsGames());
        return super.view("games");
    }

    @GetMapping("/software")
    public ModelAndView listSoftware(Model model){
        model.addAttribute("softwareCatalog", productServiceImpl.getProductsSoftware());
        return super.view("software");
    }

    @GetMapping("/subscriptions")
    public ModelAndView listSubscriptions(Model model){
        model.addAttribute("subscriptionCatalog", productServiceImpl.getProductsSubscriptions());
        return super.view("subscriptions");
    }

    @GetMapping("/{id}")
    public ModelAndView getCurrentProduct(@PathVariable("id") String id, Model model){
        model.addAttribute("productInfo", productServiceImpl.getById(id));
        return super.view("current-product");
    }


    @PostMapping("/{id}")
    public ModelAndView addCurrentProduct(@PathVariable("id") String id){
        userServiceImpl.addProduct(productServiceImpl.getById(id));
        return super.redirect("/cart");
    }


    @GetMapping("/search")
    public ModelAndView search(@Param("keyword") String keyword, Model model){
        model.addAttribute("findsProduct", productServiceImpl.search(keyword));
        model.addAttribute("keyword", keyword);
          return super.view("search");
    }


    @GetMapping("/adding")
    public ModelAndView adding(){
        return super.view("adding-product");
    }

    @PostMapping("/adding")
    public String uploadProduct(@ModelAttribute(name = "product") ProductDTO productDTO){

        return this.productServiceImpl.uploadProduct(productDTO) == null ? "upload-error" : "redirect:/";
    }

    @GetMapping("/delete")
    public ModelAndView deleteRequest(){
        return super.view("delete-product");
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@ModelAttribute(name = "product") ProductDTO productDTO){
        this.productServiceImpl.deleteProduct(productDTO.getId());
        return "index";
    }

}
