package com.example.Nguyenngoctrunghieu.controller;

import com.example.Nguyenngoctrunghieu.entity.BookDetailsEntity;
import com.example.Nguyenngoctrunghieu.service.BookDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class WebController {
    @Autowired
    BookDetailsService bookDetailsService;

    @GetMapping("/add")
    public String add(Model model) {
        BookDetailsEntity bookDetailsEntity = new BookDetailsEntity();
        model.addAttribute("user", bookDetailsEntity);
        return "add";
    }
dạ vâng ạ

        @PostMapping("/save")
    public String save(@ModelAttribute BookDetailsEntity bookDetailsEntity, Model model) {
        bookDetailsService.createBook(bookDetailsEntity);
        return "redirect:/list";
    }

    @GetMapping({"/", "/list"})
    public ModelAndView listUser(@RequestParam("s") Optional<String> s, Pageable pageable) {
        Page<BookDetailsEntity> users;
        if(s.isPresent()){
            users = bookDetailsService.findAllByFirstNameContaining(s.get(), pageable);
        } else {
            users = bookDetailsService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

//        @GetMapping({"/","/list"})
//    public String listUser(Model model) {
//        List<BookDetailsEntity> users = bookDetailsService.getAll();
//        model.addAttribute("users", users);
//        return "list";
//    }


}
