package com.example.tinexchain.web.Controller;

import com.example.tinexchain.model.*;
import com.example.tinexchain.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;
    private final PurchaseContainsProductService purchaseContainsProductService;
    private final SaleWorkerService saleWorkerService;
    private final StoreService storeService;
    private final ProductService productService;
    private final StoreHaveProductService storeHaveProductService;
    private boolean getProducts = false;
    private boolean purchaseAdded = false;
    private boolean haveProducts = false;
    private boolean seeProductsOnPurchase = false;
    private boolean showPurchases = false;
    List<Float> suma = new ArrayList<>();
    List<Product> productList = new ArrayList<>();

    public PurchaseController(PurchaseService purchaseService, PurchaseContainsProductService purchaseContainsProductService, SaleWorkerService saleWorkerService, StoreService storeService, ProductService productService, StoreHaveProductService storeHaveProductService) {
        this.purchaseService = purchaseService;
        this.purchaseContainsProductService = purchaseContainsProductService;
        this.saleWorkerService = saleWorkerService;
        this.storeService = storeService;
        this.productService = productService;
        this.storeHaveProductService = storeHaveProductService;
        suma = new ArrayList<>();
        productList = new ArrayList<>();
    }

    @GetMapping
    public String getPurchasePage(Model model){
        String text = !showPurchases ? "Show" : "Hide";
        model.addAttribute("showPurchases",showPurchases);
        model.addAttribute("text",text);

        model.addAttribute("pe",purchaseService.listAll());
//        model.addAttribute("pp",purchaseContainsProductService.listAll());
        model.addAttribute("stores",storeService.listAll());
        model.addAttribute("products",productService.listAll());
        seeProductsOnPurchase = true;
        model.addAttribute("seeProductsOnPurchase",seeProductsOnPurchase);

        return "purchase";
    }

    @GetMapping("/getPurchases")
    public String getPurchasesPage(Model model){
        showPurchases = !showPurchases;
        String text = !showPurchases ? "Show" : "Hide";
        model.addAttribute("showPurchases",showPurchases);
        model.addAttribute("text",text);

        model.addAttribute("pe",purchaseService.listAll());
//        model.addAttribute("pp",purchaseContainsProductService.listAll());
        model.addAttribute("stores",storeService.listAll());
        model.addAttribute("products",productService.listAll());
        seeProductsOnPurchase = true;
        model.addAttribute("seeProductsOnPurchase",seeProductsOnPurchase);

        return "purchase";
    }

    @PostMapping
    public String getProductsFromPurchase(Model model, @RequestParam Long purchaseId){

        getProducts = true;
        seeProductsOnPurchase = true;
        model.addAttribute("seeProductsOnPurchase",seeProductsOnPurchase);
        model.addAttribute("getProducts",getProducts);
        List<PurchaseContainsProduct> purchases = purchaseContainsProductService.listAll();
        List<PurchaseContainsProduct> list = purchases.stream().filter(i->i.getPurchase().getPurchase_id() == purchaseId).collect(Collectors.toList());
        model.addAttribute("pe",purchaseService.listAll());
        model.addAttribute("pp",list);

        long total = list.stream().mapToLong(i-> (long) (i.getQuantity() * i.getProduct().getProduct_Price())).sum();
        model.addAttribute("total",total);
        model.addAttribute("stores",storeService.listAll());

        String text = !showPurchases ? "Show" : "Hide";
        model.addAttribute("showPurchases",showPurchases);
        model.addAttribute("text",text);

        return "purchase";
    }

    @PostMapping("/addPurchase")
    public String addPurchase(Model model,@RequestParam int storeId){
        seeProductsOnPurchase = false;
        model.addAttribute("seeProductsOnPurchase",seeProductsOnPurchase);

        model.addAttribute("getProducts",getProducts);
        model.addAttribute("pe",purchaseService.listAll());


        model.addAttribute("stores",storeService.listAll());
        model.addAttribute("stor",storeService.findStoreById(storeId).get());

        long pId = purchaseService.listAll().stream().mapToLong(i->i.getPurchase_id()).max().getAsLong() + 1;
        long employeeId = purchaseService.listAll().stream().filter(i->i.getSaleWorker().getStore().getStore_Id() == storeId).mapToLong(j->j.getSaleWorker().getEmployee_Id()).findFirst().getAsLong();

        SaleWorker worker = saleWorkerService.findEmployeeById(employeeId).get();
        Store store = storeService.findStoreById(storeId).get();
        LocalDate date = LocalDate.now();


        model.addAttribute("pid",pId);
        model.addAttribute("date",date);
        model.addAttribute("worker",worker.getEmployee_name() + ' ' + worker.getEmployee_surname());
        model.addAttribute("store",store.getStore_Name());

        purchaseService.addPurchase((int) pId,date,worker,store);
        this.purchaseAdded = true;
        model.addAttribute("purchaseAdded",purchaseAdded);
        model.addAttribute("products",productService.listAll());

        String text = !showPurchases ? "Show" : "Hide";
        model.addAttribute("showPurchases",showPurchases);
        model.addAttribute("text",text);

        return "purchase";
    }

    @PostMapping("/addToPurchase")
    public String addToPurchase(Model model,@RequestParam int quantity,@RequestParam int productId){


            seeProductsOnPurchase = false;
            model.addAttribute("seeProductsOnPurchase",seeProductsOnPurchase);
            model.addAttribute("getProducts",getProducts);
            model.addAttribute("pe",purchaseService.listAll());
            model.addAttribute("stores",storeService.listAll());
            model.addAttribute("purchaseAdded",purchaseAdded);



            long pId = purchaseService.listAll().stream().mapToLong(i->i.getPurchase_id()).max().getAsLong();
            Purchase p = purchaseService.findById((int) pId).get();

            model.addAttribute("pid",pId);
            model.addAttribute("date",p.getDate_and_time());
            model.addAttribute("worker",p.getSaleWorker().getEmployee_name() + ' ' + p.getSaleWorker().getEmployee_surname());
            model.addAttribute("store",p.getStore().getStore_Name());

            Product product = productService.findProductById(productId).get();
            System.out.println(p);
            System.out.println(product);
            System.out.println(quantity);


            purchaseContainsProductService.addProductToPurchase(p,product,quantity);
            model.addAttribute("product",product);
            model.addAttribute("q",quantity);
            suma.add(product.getProduct_Price() * quantity);
            model.addAttribute("suma",suma.stream().mapToLong(i->i.longValue()).sum());

            List<PurchaseContainsProduct> purchases = purchaseContainsProductService.listAll();
            List<PurchaseContainsProduct> list = purchases.stream().filter(i->i.getPurchase().getPurchase_id() == pId).collect(Collectors.toList());
            list.stream().forEach(i->{
                storeHaveProductService.update(p.getStore(),i.getProduct(),i.getQuantity());
            });
            model.addAttribute("pp",list);
            long total = list.stream().mapToLong(i-> (long) (i.getQuantity() * i.getProduct().getProduct_Price())).sum();
            model.addAttribute("total",total);
            haveProducts = true;
            model.addAttribute("haveProducts",haveProducts);
            model.addAttribute("products",productService.listAll());

            String text = !showPurchases ? "Show" : "Hide";
            model.addAttribute("showPurchases",showPurchases);
            model.addAttribute("text",text);



        return "purchase";
    }

    @PostMapping("/finishPurchase")
    public String finishPurchase(Model model){

        purchaseAdded = false;
        model.addAttribute("purchaseAdded",purchaseAdded);

        showPurchases =!showPurchases;
        model.addAttribute("showPurchases",showPurchases);

        return "redirect:/purchase";
    }

}
