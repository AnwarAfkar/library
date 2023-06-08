package com.sau.library.controllers;

import com.sau.library.models.Book;
import com.sau.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @GetMapping("/book")
    public String getIndex(Model model){
        Iterable<Book> bookList = bookRepository.findAll();
        model.addAttribute("bookList", bookList);
        return "book/index";
    }

    @GetMapping("/book/add")
    public String addBook(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        return "/book/addbook";
    }

    @PostMapping("/book/add")
    public String bookAdd (Book book){
        if (book == null){
            System.out.println("Book is null");
            return "redirect:/book";
        }
        bookRepository.save(book);
        return "redirect:/book";
    }

    @GetMapping("/book/del")
    public String deleteBook(@RequestParam("id") int id, Model model){
        Optional<Book> book = bookRepository.findById(id);
        model.addAttribute("book", book);
        return "/book/deletebook";
    }
    @PostMapping("/book/del")
    public String bookDelete(Book book){
        if(book == null) {
            System.out.println("Book is null");
            return "redirect:/book";
        }
        bookRepository.delete(book);
        return "redirect:/book";
    }

    @GetMapping("/book/update")
    public String bookBook(@RequestParam("id") int id, Model model){
        Optional<Book> book = bookRepository.findById(id);
        model.addAttribute("book", book);
        return "/book/updatebook";
    }
    @PostMapping("/book/update")
    public String bookUpdate(Book book){
        if(book == null) {
            System.out.println("Book is null");
            return "redirect:/book";
        }
        bookRepository.save(book);
        return "redirect:/book";
    }
}
