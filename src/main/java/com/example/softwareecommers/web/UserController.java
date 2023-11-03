package com.example.softwareecommers.web;

import com.example.softwareecommers.models.dtos.UserEntityDTO;
import com.example.softwareecommers.services.Impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
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
        UserEntityDTO registeredUser = userServiceImpl.registerUser(user.getUserName(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        return registeredUser == null ? "error-register" : "redirect:/user/login";
    }


    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute UserEntityDTO user, Model model) {
        System.out.println("login request: " + user);
        UserEntityDTO authenticatedUser = userServiceImpl.authenticate(user.getUserName(), user.getPassword());
        if (authenticatedUser != null) {
            model.addAttribute("userLogin", authenticatedUser.getUserName());
            return super.redirect("/");
        } else {
            return super.view("error-login");
        }
    }


    @ModelAttribute(name = "user")
    public UserEntityDTO initUserRegister() {
        return new UserEntityDTO();
    }

    @PostMapping("/logout")
    public ModelAndView logOut() {
        this.userServiceImpl.logout();
        return super.redirect("/");
    }


}
