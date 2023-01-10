package wab.spring_3_1_2.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import wab.spring_3_1_2.model.User;
import wab.spring_3_1_2.service.UserService;


@Controller
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping( "/")
    public String printUserList(Model model) {
        model.addAttribute("messages", service.getUser());
        return "list";
    }

    @GetMapping("/user")
    public String printUser(Model model) {
        model.addAttribute("messages", service.getUser());
        return "user";
    }


    @GetMapping("pages/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("users", service.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("users") User user) {

        return "new";
    }

    @PostMapping("/saveUser")
    public String create(@ModelAttribute("users") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        service.save(user);
        return "redirect:/";

    }

    @GetMapping("{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("users", service.show(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("users") @Valid User users,
                         BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        service.update(id, users);
        return "redirect:/user";
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/user";
    }


}
