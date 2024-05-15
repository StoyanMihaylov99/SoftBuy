package com.example.softbuyappdeploy.web;


import com.example.softbuyappdeploy.services.Impl.OrderServiceImpl;
import com.example.softbuyappdeploy.services.Impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController extends BaseController {


    private final UserServiceImpl userServiceImpl;
    private final OrderServiceImpl orderServiceImpl;

    public CartController(UserServiceImpl userServiceImpl, OrderServiceImpl orderServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.orderServiceImpl = orderServiceImpl;
    }

    @GetMapping("/cart")
    public ModelAndView getCart(Model model) {
        if (this.userServiceImpl.getProductsInCart() == null) {
            return super.view("login");
        }
        model.addAttribute("cartInfo", this.userServiceImpl.getProductsInCart());
        return super.view("my-cart");
    }

    @GetMapping("/cart/{id}")
    public ModelAndView removeCurrentProduct(@PathVariable String id) {
        this.userServiceImpl.removeProduct(id);
        return super.redirect("/cart");
    }


    @GetMapping("/cart/check-out")
    public ModelAndView getCheckOut(){
        if (this.userServiceImpl.getProductsInCart() == null) {
            return super.view("login");
        }
        orderServiceImpl.save();
        return super.view("check-out");
    }
}
