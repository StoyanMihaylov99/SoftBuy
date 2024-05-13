package com.example.softbuyappdeploy.web;


import com.example.softbuyappdeploy.services.Impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/learning")
public class LearningController extends BaseController {
    private final ProductServiceImpl productService;

    public LearningController(ProductServiceImpl productService) {
        this.productService = productService;
    }


    @GetMapping
    public ModelAndView getLearning(Model model){
        model.addAttribute("learningCatalog",productService.getProductsCourse());
        return super.view("learning");
    }
}
