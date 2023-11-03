package com.example.softwareecommers.web;

import com.example.softwareecommers.services.Impl.OrderServiceImpl;
import com.example.softwareecommers.services.Impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController {


    private final UserServiceImpl userServiceImpl;
    private final OrderServiceImpl orderServiceImpl;

    public CartController(UserServiceImpl userServiceImpl, OrderServiceImpl orderServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.orderServiceImpl = orderServiceImpl;
    }

    @GetMapping("")
    public ModelAndView getCart(Model model) {
        if (this.userServiceImpl.getProductsInCart() == null) {
            return super.view("login");
        }
        model.addAttribute("cartInfo", this.userServiceImpl.getProductsInCart());
        return super.view("my-cart");
    }

    @DeleteMapping("/{id}")
    public ModelAndView removeCurrentProduct(@PathVariable String id) {
        userServiceImpl.removeProduct(id);
        return super.redirect("/cart");
    }


    @GetMapping("/check-out")
    public ModelAndView getCheckOut(){
        if (this.userServiceImpl.getProductsInCart() == null) {
            return super.view("login");
        }
        orderServiceImpl.save();
        return super.view("check-out");
    }
}
