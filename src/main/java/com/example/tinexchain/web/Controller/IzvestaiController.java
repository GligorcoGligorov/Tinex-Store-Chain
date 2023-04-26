package com.example.tinexchain.web.Controller;

import com.example.tinexchain.service.izvestaiService.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/izvestai")
public class IzvestaiController {

    private final BroenjeQuantityICenaNaProduktiteVoDadenStoreService broenjeQuantityICenaNaProduktiteVoDadenStoreService;
    private final MesecenIGodisenProfitVoMagacinService mesecenIGodisenProfitVoMagacinService;
    private final MesecenIGodisenProfitVoProdavnicaService mesecenIGodisenProfitVoProdavnicaService;
    private final VkupenIznosNaSmetkaIProduktiService vkupenIznosNaSmetkaIProduktiService;
    private final VkupnaKolicinaIVkupnaCenaNaProduktiVoWarehouseService vkupnaKolicinaIVkupnaCenaNaProduktiVoWarehouseService;
    private final VkupnoProduktiIVkupnaSumaVoStoreOdDeliveryService vkupnoProduktiIVkupnaSumaVoStoreOdDeliveryService;

    public IzvestaiController(BroenjeQuantityICenaNaProduktiteVoDadenStoreService broenjeQuantityICenaNaProduktiteVoDadenStoreService, MesecenIGodisenProfitVoMagacinService mesecenIGodisenProfitVoMagacinService, MesecenIGodisenProfitVoProdavnicaService mesecenIGodisenProfitVoProdavnicaService, VkupenIznosNaSmetkaIProduktiService vkupenIznosNaSmetkaIProduktiService, VkupnaKolicinaIVkupnaCenaNaProduktiVoWarehouseService vkupnaKolicinaIVkupnaCenaNaProduktiVoWarehouseService, VkupnoProduktiIVkupnaSumaVoStoreOdDeliveryService vkupnoProduktiIVkupnaSumaVoStoreOdDeliveryService) {
        this.broenjeQuantityICenaNaProduktiteVoDadenStoreService = broenjeQuantityICenaNaProduktiteVoDadenStoreService;
        this.mesecenIGodisenProfitVoMagacinService = mesecenIGodisenProfitVoMagacinService;
        this.mesecenIGodisenProfitVoProdavnicaService = mesecenIGodisenProfitVoProdavnicaService;
        this.vkupenIznosNaSmetkaIProduktiService = vkupenIznosNaSmetkaIProduktiService;
        this.vkupnaKolicinaIVkupnaCenaNaProduktiVoWarehouseService = vkupnaKolicinaIVkupnaCenaNaProduktiVoWarehouseService;
        this.vkupnoProduktiIVkupnaSumaVoStoreOdDeliveryService = vkupnoProduktiIVkupnaSumaVoStoreOdDeliveryService;
    }

    @GetMapping
    public String getIzvestaiPage(Model model){

        return "izvestai";
    }

    @GetMapping("/izvestaj1")
    public String getIzvestaj1(Model model){
        model.addAttribute("izvestaj1",broenjeQuantityICenaNaProduktiteVoDadenStoreService.listAll());
        return "izvestai";
    }

    @GetMapping("/izvestaj2")
    public String getIzvestaj2(Model model){
        model.addAttribute("izvestaj2",mesecenIGodisenProfitVoMagacinService.listAll());
        return "izvestai";
    }

    @GetMapping("/izvestaj3")
    public String getIzvestaj3(Model model){
        model.addAttribute("izvestaj3",mesecenIGodisenProfitVoProdavnicaService.listAll());
        return "izvestai";
    }

    @GetMapping("/izvestaj4")
    public String getIzvestaj4(Model model){
        model.addAttribute("izvestaj4",vkupenIznosNaSmetkaIProduktiService.listAll());
        return "izvestai";
    }

    @GetMapping("/izvestaj5")
    public String getIzvestaj5(Model model){
        model.addAttribute("izvestaj5",vkupnaKolicinaIVkupnaCenaNaProduktiVoWarehouseService.listAll());
        return "izvestai";
    }

    @GetMapping("/izvestaj6")
    public String getIzvestaj6(Model model){
        model.addAttribute("izvestaj6",vkupnoProduktiIVkupnaSumaVoStoreOdDeliveryService.listAll());
        return "izvestai";
    }
}
