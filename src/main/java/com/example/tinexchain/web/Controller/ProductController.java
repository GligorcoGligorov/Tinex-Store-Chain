package com.example.tinexchain.web.Controller;

import com.example.tinexchain.model.Product;
import com.example.tinexchain.model.views.ListanjeProduktiOdManufacturer;
import com.example.tinexchain.service.ProductService;
import com.example.tinexchain.service.viewsService.ListanjeProduktiOdManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ListanjeProduktiOdManufacturerService listanjeProduktiOdManufacturerService;



    public ProductController(ProductService productService, ListanjeProduktiOdManufacturerService listanjeProduktiOdManufacturerService) {
        this.productService = productService;
        this.listanjeProduktiOdManufacturerService = listanjeProduktiOdManufacturerService;
    }

    @GetMapping
    public String getProductPage(Model model){
        model.addAttribute("products",productService.listAll());
        System.out.println(productService.listAll());

        return "products";
    }

    @PostMapping
    public String getProductsByManufacturer(Model model, @RequestParam String manufacturer){
        model.addAttribute("products",productService.listAll());

        List<ListanjeProduktiOdManufacturer> lista = listanjeProduktiOdManufacturerService.listProductsByManufacturerId(StringUtils.capitalize(manufacturer));
        model.addAttribute("pbm",listanjeProduktiOdManufacturerService.listProductsByManufacturerId(StringUtils.capitalize(manufacturer)));


        return "products";
    }
}
