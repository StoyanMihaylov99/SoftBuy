package com.example.softbuyappdeploy.web;

import com.example.softbuyappdeploy.models.dtos.UserEntityDTO;
import com.example.softbuyappdeploy.services.Impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class  UserController extends BaseController {
    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute(name = "user") UserEntityDTO user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("user", user).
                    addFlashAttribute("org.springframework.validation.BindingResult.user", bindingResult);
            return "redirect:register";
        }
        return userServiceImpl.registerUser(user) == null ? "error-register" : "redirect:/user/login";
    }

    @ModelAttribute(name = "user")
    public UserEntityDTO initUserRegister() {
        return new UserEntityDTO();
    }


    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute UserEntityDTO user, Model model) {
        UserEntityDTO authenticatedUser = userServiceImpl.authenticate(user);
        return authenticatedUser == null ? super.view("error-login") : super.redirect("/");
    }

    @PostMapping("/logout")
    public ModelAndView logOut() {
        this.userServiceImpl.logout();
        return super.redirect("/");
    }


}
