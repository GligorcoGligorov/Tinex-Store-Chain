package com.example.tinexchain.web.Controller;

import com.example.tinexchain.model.Warehouse;
import com.example.tinexchain.service.WarehouseService;
import com.example.tinexchain.service.WarehouseWorkerService;
import com.example.tinexchain.service.WarehouseWorkerWorksAtWarehouseService;
import com.example.tinexchain.service.viewsService.ListanjeProduktiOdWarehouseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/warehouse")
public class WarehouseController {

    private final WarehouseService warehouseService;
    private final WarehouseWorkerService warehouseWorkerService;
    private final WarehouseWorkerWorksAtWarehouseService warehouseWorkerWorksAtWarehouseService;
    boolean showEmployees = false;
    boolean showProducts = false;
    private final ListanjeProduktiOdWarehouseService listanjeProduktiOdWarehouseService;

    public WarehouseController(WarehouseService warehouseService, WarehouseWorkerService warehouseWorkerService, WarehouseWorkerWorksAtWarehouseService warehouseWorkerWorksAtWarehouseService, ListanjeProduktiOdWarehouseService listanjeProduktiOdWarehouseService) {
        this.warehouseService = warehouseService;
        this.warehouseWorkerService = warehouseWorkerService;
        this.warehouseWorkerWorksAtWarehouseService = warehouseWorkerWorksAtWarehouseService;
        this.listanjeProduktiOdWarehouseService = listanjeProduktiOdWarehouseService;
    }


    @GetMapping
    public String getWarehousePage(Model model){
        model.addAttribute("warehouseList",warehouseService.listAll());
        model.addAttribute("w1",warehouseWorkerService.listAll());
        model.addAttribute("w2",warehouseWorkerWorksAtWarehouseService.listAll());
        model.addAttribute("l",listanjeProduktiOdWarehouseService.listAll());
        return "warehouse";
    }

    @PostMapping
    public String showEmployee(Model model){

        showEmployees = !showEmployees;
        model.addAttribute("showEmployees",showEmployees);
        model.addAttribute("warehouseList",warehouseService.listAll());
        model.addAttribute("w2",warehouseWorkerWorksAtWarehouseService.listAll());


        return "warehouse";
    }

    @PostMapping("/getProductsByWarehouse")
    public String showProductsByWarehouse(Model model, @RequestParam int warehouseId){
        showProducts = true;
        model.addAttribute("showProducts",showProducts);
        model.addAttribute("showEmployees",showEmployees);
        model.addAttribute("warehouseList",warehouseService.listAll());
        model.addAttribute("w2",warehouseWorkerWorksAtWarehouseService.listAll());
        model.addAttribute("products",listanjeProduktiOdWarehouseService.listProductsByWarehouseId(warehouseId));
        model.addAttribute("w",warehouseService.findWarehouseById(warehouseId).get());

        return "warehouse";
    }
}
