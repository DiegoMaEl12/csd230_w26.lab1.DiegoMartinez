package csd230.lab1.controllers;

import csd230.lab1.repositories.ProductEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ProductController {

    @Autowired
    private ProductEntityRepository productRepository;



}
