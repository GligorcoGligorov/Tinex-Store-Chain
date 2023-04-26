package com.example.tinexchain.web.Controller;

import com.example.tinexchain.model.*;
import com.example.tinexchain.service.*;
import com.example.tinexchain.service.viewsService.ListanjeProduktiOdDeliveryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;
    private final ListanjeProduktiOdDeliveryService listanjeProduktiOdDeliveryService;
    private final DeliveryContainsProductService deliveryContainsProductService;
    private final WarehouseService warehouseService;
    private final StoreService storeService;
    private final ProductService productService;
    boolean searchProducts = false;
    private boolean makeDeliveryButton = false;
    boolean showDeliveries = true;
    boolean showDeliveries2 = true;
    boolean addedDelivery = false;
    boolean deliveryHaveProducts = false;
    private final StoreHaveProductService storeHaveProductService;
    private final WarehouseHaveProductService warehouseHaveProductService;
    List<Float> suma = new ArrayList<>();


    public DeliveryController(DeliveryService deliveryService, ListanjeProduktiOdDeliveryService listanjeProduktiOdDeliveryService, DeliveryContainsProductService deliveryContainsProductService, WarehouseService warehouseService, StoreService storeService, ProductService productService, StoreHaveProductService storeHaveProductService, WarehouseHaveProductService warehouseHaveProductService) {
        this.deliveryService = deliveryService;
        this.listanjeProduktiOdDeliveryService = listanjeProduktiOdDeliveryService;
        this.deliveryContainsProductService = deliveryContainsProductService;
        this.warehouseService = warehouseService;
        this.storeService = storeService;
        this.productService = productService;
        this.storeHaveProductService = storeHaveProductService;
        this.warehouseHaveProductService = warehouseHaveProductService;
        suma = new ArrayList<>();
    }

    @GetMapping
    public String getDeliveryPage(Model model){

        model.addAttribute("deliveries",deliveryService.listAll());
        System.out.println(deliveryService.listAll());
        System.out.println(deliveryService.listAll().get(0).getWarehouseList().get(0).getWarehouse_address());
        showDeliveries = true;
        showDeliveries2 = true;
        model.addAttribute("showDeliveries2",showDeliveries2);
        model.addAttribute("showDeliveries",showDeliveries);


        return "deliveries";


    }

    @PostMapping
    public String getProductsInDelivery(Model model, @RequestParam Long getProductsByDelivery){
        model.addAttribute("deliveries",deliveryService.listAll());
        model.addAttribute("productsByDelivery", listanjeProduktiOdDeliveryService.listProductsByDeliveryId(getProductsByDelivery));
        model.addAttribute("del", deliveryService.findDeliveryById(getProductsByDelivery.intValue()).get());
        searchProducts = true;
        model.addAttribute("searchProducts",searchProducts);
        model.addAttribute("showDeliveries2",showDeliveries2);
        return "deliveries";

    }
    @PostMapping("/makeDelivery")
    public String makeDelivery(Model model){
        makeDeliveryButton = true;
        showDeliveries = false;
        showDeliveries2=false;
        model.addAttribute("showDeliveries2",showDeliveries2);
        model.addAttribute("showDeliveries",showDeliveries);
        model.addAttribute("makeDeliveryButton",makeDeliveryButton);

        List<Warehouse> warehouseList = warehouseService.listAll();
        List<Store> stores = storeService.listAll();
        Set<String> drivers =  deliveryService.listAll().stream().map(i->i.getDriver_name()).collect(Collectors.toSet());

        List<String> vehicles = new ArrayList<>();
        vehicles.add("Car");
        vehicles.add("Van");

        model.addAttribute("warehouseList",warehouseList);
        model.addAttribute("stores",stores);
        model.addAttribute("drivers",drivers);
        model.addAttribute("vehicles",vehicles);


        return "deliveries";
    }

    @PostMapping("/addDelivery")
    public String addDelivery(Model model, @RequestParam int warehouse_id,
                              @RequestParam int store_id, @RequestParam String vehicle,
                              @RequestParam String driver, HttpServletRequest req){

        Warehouse warehouse = warehouseService.findWarehouseById(warehouse_id).get();
        req.getSession().setAttribute("warehouse",warehouse);
        Store store = storeService.findStoreById(store_id).get();
        model.addAttribute("deliveries",deliveryService.listAll());
        List<Warehouse> warehouses = new ArrayList<>();
        warehouses.add(warehouse);
        addedDelivery = true;
        int newDeliveryId= deliveryService.listAll().stream().mapToInt(i-> (int) i.getDelivery_Id()).max().getAsInt() + 1;
        LocalDate date = LocalDate.now();

        Delivery newDelivery = new Delivery(newDeliveryId, date, vehicle, driver, store);
        warehouse.getDeliveryList().add(newDelivery);
        newDelivery.setWarehouseList(warehouses);
        deliveryService.save(newDelivery);



        model.addAttribute("warehouse",warehouse.getWarehouse_address());
        model.addAttribute("store",store.getStore_Name());
        model.addAttribute("vehicle",vehicle);
        model.addAttribute("dateDelivery",date);

        model.addAttribute("deliveryId",newDeliveryId);
        model.addAttribute("driver",driver);
        model.addAttribute("addedDelivery",addedDelivery);
        model.addAttribute("products",productService.listAll());



        return "deliveries";
    }

    @PostMapping("/addToDelivery")
    public String addToDelivery(HttpServletRequest req,Model model,@RequestParam int quantity,@RequestParam int productId){
        model.addAttribute("products",productService.listAll());
        model.addAttribute("pe",deliveryService.listAll());
        model.addAttribute("stores",storeService.listAll());
        model.addAttribute("addedDelivery",addedDelivery);
        model.addAttribute("deliveries",deliveryService.listAll());

        deliveryHaveProducts =true;
        model.addAttribute("deliveryHaveProducts",deliveryHaveProducts);



        long deliveryId = deliveryService.listAll().stream().mapToLong(i->i.getDelivery_Id()).max().getAsLong();
        Delivery delivery = deliveryService.findDeliveryById((int) deliveryId).get();


        model.addAttribute("deliveryId",deliveryId);
        model.addAttribute("dateDelivery",delivery.getDelivery_Date_And_Time());
        model.addAttribute("store",delivery.getStore().getStore_Name());

        model.addAttribute("driver",delivery.getDriver_name());
        model.addAttribute("vehicle",delivery.getDelivery_vehicle());

        Product product = productService.findProductById(productId).get();



        deliveryContainsProductService.addProductToDeliivery(delivery,product,quantity);
        model.addAttribute("product",product);
        model.addAttribute("q",quantity);
        suma.add(product.getProduct_Price() * quantity);
        model.addAttribute("suma",suma.stream().mapToLong(i->i.longValue()).sum());

        List<DeliveryContainsProduct> deliveries = deliveryContainsProductService.listAll();
        List<DeliveryContainsProduct> list = deliveries.stream().filter(i->i.getDelivery().getDelivery_Id() == deliveryId).collect(Collectors.toList());
        list.stream().forEach(i->{

            storeHaveProductService.updateAdd(delivery.getStore(),i.getProduct(),i.getQuantity());
        });
        Warehouse warehouse = (Warehouse) req.getSession().getAttribute("warehouse");
        warehouse.getDeliveryList().add(delivery);

        List<WarehouseHaveProduct> warehouseHaveProductList = warehouseHaveProductService.listAll().stream().filter(i->i.getWarehouse().getWarehouse_Id() == warehouse.getWarehouse_Id()).collect(Collectors.toList());
        warehouseHaveProductService.update(product,warehouse,quantity);


        model.addAttribute("pp",list);
        long total = list.stream().mapToLong(i-> (long) (i.getQuantity() * i.getProduct().getProduct_Price())).sum();
        model.addAttribute("total",total);
//        haveProducts = true;
//        model.addAttribute("haveProducts",haveProducts);
        model.addAttribute("products",productService.listAll());

//        String text = !showPurchases ? "Show" : "Hide";
//        model.addAttribute("showPurchases",showPurchases);
//        model.addAttribute("text",text);
        return "deliveries";
    }

    @PostMapping("/finishDelivery")
    public String finishDelivery(Model model){

        makeDeliveryButton = false;
        showDeliveries = true;
        showDeliveries2=true;
        model.addAttribute("makeDeliveryButton",makeDeliveryButton);
        model.addAttribute("showDeliveries",showDeliveries);
        model.addAttribute("showDeliveries2",showDeliveries2);

        return "redirect:/delivery";
    }
}
