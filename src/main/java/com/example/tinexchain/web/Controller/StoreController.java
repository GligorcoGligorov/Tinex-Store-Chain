package com.example.tinexchain.web.Controller;

import com.example.tinexchain.model.*;
import com.example.tinexchain.model.izestai.MesecenIGodisenProfitVoMagacin;
import com.example.tinexchain.service.*;
import com.example.tinexchain.service.izvestaiService.BroenjeQuantityICenaNaProduktiteVoDadenStoreService;
import com.example.tinexchain.service.izvestaiService.MesecenIGodisenProfitVoMagacinService;
import com.example.tinexchain.service.izvestaiService.VkupenIznosNaSmetkaIProduktiService;
import com.example.tinexchain.service.izvestaiService.VkupnoProduktiIVkupnaSumaVoStoreOdDeliveryService;
import com.example.tinexchain.service.viewsService.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/stores")
public class StoreController {

    private final StoreService storeService;
    private final ProductService productService;
    private final StoreHaveProductService storeHaveProductService;
    private final DeliveryService deliveryService;
    private final DeliveryContainsProductService deliveryContainsProductService;
    private final WarehouseService warehouseService;
    private final WarehouseHaveProductService warehouseHaveProductService;
    private final CategoryService categoryService;
    private final PurchaseContainsProductService purchaseContainsProductService;
    private final PurchaseService purchaseService;
    private final EmployeeService employeeService;
    private final WarehouseWorkerWorksAtWarehouseService warehouseWorkerWorksAtWarehouseService;
    private final WarehouseWorkerService warehouseWorkerService;
    private final MesecenIGodisenProfitVoMagacinService mesecenIGodisenProfitVoMagacinService;
    private final ListanjeProduktiOdStoreService listanjeProduktiOdStoreService;
    private final ListanjeProduktiOdDeliveryService listanjeProduktiOdDeliveryService;
    private final ListanjeProduktiOdWarehouseService listanjeProduktiOdWarehouseService;
    private final ListanjeProduktiOdManufacturerService listanjeProduktiOdManufacturerService;
    private final ListanjeProduktiPoKategorijaService listanjeProduktiPoKategorijaService;
    private final BroenjeQuantityICenaNaProduktiteVoDadenStoreService broenjeQuantityICenaNaProduktiteVoDadenStoreService;
    private final VkupenIznosNaSmetkaIProduktiService vkupenIznosNaSmetkaIProduktiService;
    private final VkupnoProduktiIVkupnaSumaVoStoreOdDeliveryService vkupnoProduktiIVkupnaSumaVoStoreOdDeliveryService;
    private final SaleWorkerService saleWorkerService;
    boolean showSaleWorkers = false;
    boolean showStore= false;
    boolean isSelectedStore = false;



    public StoreController(StoreService storeService, ProductService productService, StoreHaveProductService storeHaveProductService, DeliveryService deliveryService, DeliveryContainsProductService deliveryContainsProductService, WarehouseService warehouseService, WarehouseHaveProductService warehouseHaveProductService, CategoryService categoryService, PurchaseContainsProductService purchaseContainsProductService, PurchaseService purchaseService, EmployeeService employeeService, WarehouseWorkerWorksAtWarehouseService warehouseWorkerWorksAtWarehouseService, WarehouseWorkerService warehouseWorkerService, MesecenIGodisenProfitVoMagacinService mesecenIGodisenProfitVoMagacinService, ListanjeProduktiOdStoreService listanjeProduktiOdStoreService, ListanjeProduktiOdDeliveryService listanjeProduktiOdDeliveryService, ListanjeProduktiOdWarehouseService listanjeProduktiOdWarehouseService, ListanjeProduktiOdManufacturerService listanjeProduktiOdManufacturerService, ListanjeProduktiPoKategorijaService listanjeProduktiPoKategorijaService, BroenjeQuantityICenaNaProduktiteVoDadenStoreService broenjeQuantityICenaNaProduktiteVoDadenStoreService, VkupenIznosNaSmetkaIProduktiService vkupenIznosNaSmetkaIProduktiService, VkupnoProduktiIVkupnaSumaVoStoreOdDeliveryService vkupnoProduktiIVkupnaSumaVoStoreOdDeliveryService, SaleWorkerService saleWorkerService) {
        this.storeService = storeService;
        this.productService = productService;
        this.storeHaveProductService = storeHaveProductService;
        this.deliveryService = deliveryService;
        this.deliveryContainsProductService = deliveryContainsProductService;

        this.warehouseService = warehouseService;
        this.warehouseHaveProductService = warehouseHaveProductService;
        this.categoryService = categoryService;
        this.purchaseContainsProductService = purchaseContainsProductService;
        this.purchaseService = purchaseService;
        this.employeeService = employeeService;
        this.warehouseWorkerWorksAtWarehouseService = warehouseWorkerWorksAtWarehouseService;

        this.warehouseWorkerService = warehouseWorkerService;
        this.mesecenIGodisenProfitVoMagacinService = mesecenIGodisenProfitVoMagacinService;
        this.listanjeProduktiOdStoreService = listanjeProduktiOdStoreService;
        this.listanjeProduktiOdDeliveryService = listanjeProduktiOdDeliveryService;
        this.listanjeProduktiOdWarehouseService = listanjeProduktiOdWarehouseService;
        this.listanjeProduktiOdManufacturerService = listanjeProduktiOdManufacturerService;
        this.listanjeProduktiPoKategorijaService = listanjeProduktiPoKategorijaService;
        this.broenjeQuantityICenaNaProduktiteVoDadenStoreService = broenjeQuantityICenaNaProduktiteVoDadenStoreService;
        this.vkupenIznosNaSmetkaIProduktiService = vkupenIznosNaSmetkaIProduktiService;
        this.vkupnoProduktiIVkupnaSumaVoStoreOdDeliveryService = vkupnoProduktiIVkupnaSumaVoStoreOdDeliveryService;
        this.saleWorkerService = saleWorkerService;
    }

    @GetMapping
    public String getStorePage(Model model){
//        List<Store> stores = storeService.listAll();
//        model.addAttribute("stores",stores);

        String showStoreText = showStore != true ? "see" : "hide";
        model.addAttribute("showStore",showStoreText);

        Optional<Store> store = storeService.findStoreById(3);
        Optional<Product> product = productService.findProductById(3);
        Optional<Delivery> delivery = deliveryService.findDeliveryById(1);
        Optional<Product> product2 = productService.findProductById(1);
        Optional<Warehouse> warehouse = warehouseService.findWarehouseById(1);
//        List<Category> categories = categoryService.listAll();
        Optional<Category> category1 = categoryService.findCategoryById(2);
        Optional<Category> category2 = categoryService.findCategoryById(7);
        Optional<Purchase> purchase = purchaseService.findById(10);
        Optional<Employee> employee = employeeService.findEmployeeById(10);
        Optional<Employee> employee2 = employeeService.findEmployeeById(2);
        Optional<WarehouseWorker> warehouseWorker = warehouseWorkerService.findEmployeeById(2);
        List<MesecenIGodisenProfitVoMagacin> mesecenIGodisenProfitVoMagacinList = mesecenIGodisenProfitVoMagacinService.listAll();


        showStore = false;
        isSelectedStore = false;
//        System.out.println(categories);
        if(category1.isPresent()){
            model.addAttribute("categories", categoryService.listAll());
            if (category1.get().getProductList().size() > 0){
                System.out.println(category1.get().getProductList());
            }else {
                System.out.println("NULL");
            }

        }

        if(category2.isPresent()){
            if (category2.get().getSur_categories().size() > 0){
                System.out.println(category2.get().getSur_categories());
            }else {
                System.out.println("NULL");
            }

        }


        if (store.isPresent() && product.isPresent() && warehouse.isPresent()) {
            // do something with the found store
            System.out.println(store.get().getStore_Id());
            System.out.println(product.get().getProduct_Name());
            Store s1 = store.get();
            Product p1 = product.get();
            if(storeHaveProductService.getQuantityForStoreAndProduct(s1,p1).isPresent()){
                StoreHaveProduct storeHaveProduct = storeHaveProductService.getQuantityForStoreAndProduct(s1,p1).get();
                System.out.println(storeHaveProduct.getQuantity());
                System.out.println(product.get());
                System.out.println("PRODUCT TEST");
            }else{
                System.out.println("E NEMA");
            }

            WarehouseHaveProduct wh = warehouseHaveProductService.getQuantityForWarehouseAndProduct(warehouse.get(),product.get()).get();
            System.out.println(wh.getQuantity());
            warehouse.get().getDeliveryList().stream().forEach(i-> System.out.println(i.getDelivery_Id()));
            System.out.println(warehouse.get());
            System.out.println("WAREHOUSE TEST");

//            if(store.get().getDeliveries().size()>0){
//                store.get().getDeliveries().get(0);
//            }
            System.out.println("PRASANJE");


        } else {
            // store not found
            System.out.println("NEMA");
        }

        if (delivery.isPresent() && product2.isPresent()) {
            DeliveryContainsProduct dcp = deliveryContainsProductService.getQuantityForDeliveryAndProduct(delivery.get(),product2.get()).get();
            System.out.println(dcp.getQuantity());
            System.out.println(delivery.get());
            System.out.println(delivery.get().getWarehouseList());
            System.out.println("DELIVERY TEST");

        }

        if(employee.isPresent()){
            System.out.println(employee.get());
            System.out.println("EMPLOYEE TEST");
        }

        if(purchase.isPresent() && product.isPresent()){
            System.out.println(purchase.get());
            System.out.println("PURCHASE TEST");


            System.out.println(purchaseContainsProductService.getQuantityForPurchaseAndProduct(purchase.get(),product.get()).get().getQuantity());
            System.out.println("PURCHASE_CONTAINS_PRODUCT TEST");
        }

        if(warehouse.isPresent() && warehouseWorker.isPresent()){
            System.out.println(warehouseWorker.get());
            System.out.println("WAREHOUSE_WORKER TEST");

            System.out.println(warehouseWorkerWorksAtWarehouseService.getWorkStartsIn(warehouseWorker.get(),warehouse.get()).get());
            System.out.println(warehouseWorkerWorksAtWarehouseService.getWorkEndsIn(warehouseWorker.get(),warehouse.get()).get());
            System.out.println("WarehouseWorker_WorksAt_Warehouse TEST");

        }

        for(MesecenIGodisenProfitVoMagacin m : mesecenIGodisenProfitVoMagacinList){
            System.out.println(m);

        }
        System.out.println("VIEW TEST");


        System.out.println(broenjeQuantityICenaNaProduktiteVoDadenStoreService.listAll());
        System.out.println("IZVESTAI TEST");
        System.out.println(vkupnoProduktiIVkupnaSumaVoStoreOdDeliveryService.listAll());

            model.addAttribute("deliveries", deliveryService.listAll());

        return "stores";
    }



    @PostMapping
    public String getStores(Model model){
        showStore=!showStore;
        List<Store> stores = storeService.listAll();
        if (showStore){
            model.addAttribute("stores",stores);

        }else{
            model.addAttribute("stores",new ArrayList<>());

        }
        String showStoreText = showStore != true ? "see" : "hide";
        model.addAttribute("showStoreText",showStoreText);
        model.addAttribute("showStores",showStore);




        return "stores";

    }

    @PostMapping("/getSaleWorkers")
    public String getSaleWorkers(Model model){
        this.showSaleWorkers = !this.showSaleWorkers;
        model.addAttribute("showSaleWorkers",showSaleWorkers);
        model.addAttribute("saleWorkers",saleWorkerService.listAll());
        System.out.println(saleWorkerService.listAll());
        System.out.println(showSaleWorkers);
        List<SaleWorker> list = saleWorkerService.listAll();
        List<Store> storeList = new ArrayList<>();
        list.stream().forEach(i->{
            storeList.add(saleWorkerService.findEmployeeById(i.getEmployee_Id()).get().getStore());
        });
        model.addAttribute("storeList",storeList);
        model.addAttribute("stores",storeService.listAll());


        String showStoreText = showStore != true ? "see" : "hide";
        model.addAttribute("showStoreText",showStoreText);
        model.addAttribute("showStores",showStore);
        return "stores";
    }

    @PostMapping("/getProductsByStore")
    public String GetProductsByStore(Model model, @RequestParam Long getProductsByStore){

        model.addAttribute("stores",storeService.listAll());
        isSelectedStore = true;
        String showStoreText = showStore != true ? "see" : "hide";
        model.addAttribute("showStoreText",showStoreText);
        model.addAttribute("showStores",showStore);
        model.addAttribute("stor",storeService.findStoreById(getProductsByStore.intValue()).get());
        model.addAttribute("productsInStore",listanjeProduktiOdStoreService.listProductsByStoreId(getProductsByStore));
        model.addAttribute("isSelectedStore",isSelectedStore);

        model.addAttribute("showSaleWorkers",showSaleWorkers);
        model.addAttribute("saleWorkers",saleWorkerService.listAll());

        List<SaleWorker> list = saleWorkerService.listAll();
        List<Store> storeList = new ArrayList<>();
        list.stream().forEach(i->{
            storeList.add(saleWorkerService.findEmployeeById(i.getEmployee_Id()).get().getStore());
        });
        model.addAttribute("storeList",storeList);

        return "stores";
    }
}
