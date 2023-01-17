package com.daniel.server.controllers;

import com.daniel.server.dto.CouponPurchase;
import com.daniel.server.entities.PurchaseEntity;
import com.daniel.server.exceptions.ServerException;
import com.daniel.server.logic.PurchaseLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchasesController {

    private PurchaseLogic purchaseLogic;

    @Autowired
    public PurchasesController(PurchaseLogic purchaseLogic){
        this.purchaseLogic = purchaseLogic;
    }

    @PostMapping
    public void createPurchase (@RequestBody PurchaseEntity purchase) throws Exception {
       purchaseLogic.createPurchase(purchase);
    }
    @PutMapping
    public void updatePurchase (@RequestBody PurchaseEntity purchase) throws Exception {
        purchaseLogic.updatePurchase(purchase);
    }

    @DeleteMapping("{purchaseId}")
    public void removePurchase (@PathVariable ("purchaseId") long id) throws Exception {
        purchaseLogic.removePurchase(id);
    }

    @GetMapping("{purchaseId}")
    public CouponPurchase getPurchase(@PathVariable("purchaseId") long id) throws Exception {
        CouponPurchase couponPurchase = purchaseLogic.getPurchase(id);
        return couponPurchase;
    }

    @GetMapping
    public List<CouponPurchase> getAllPurchases (@RequestParam("page") int page) throws ServerException {
        List<CouponPurchase> couponPurchases = purchaseLogic.getAllPurchases(page);
        return couponPurchases;
    }

    @GetMapping("/byAmountAsc")
    public List<CouponPurchase> getAllPurchasesByAmountAscending(@RequestParam("page") int page) throws ServerException {
        List<CouponPurchase> couponPurchases = purchaseLogic.getAllPurchasesByAmountAscending(page);
        return couponPurchases;
    }

    @GetMapping("/byAmountDes")
    public List<CouponPurchase> getAllPurchasesByAmountDesc(@RequestParam("page") int page) throws ServerException {
        List<CouponPurchase> couponPurchases = purchaseLogic.getAllPurchasesByAmountDesc(page);
        return couponPurchases;
    }

    @GetMapping("/byTimeStampDes")
    public List<CouponPurchase> getAllPurchasesByTimeStampDescending(@RequestParam("page") int page) throws ServerException {
        List<CouponPurchase> couponPurchases = purchaseLogic.getAllPurchasesByTimeStampDescending(page);
        return couponPurchases;
    }

    @GetMapping("/ByTimeStampAsc")
    public List<CouponPurchase> getAllPurchasesByTimeStampAscending(@RequestParam("page") int page) throws ServerException {
        List<CouponPurchase> couponPurchases = purchaseLogic.getAllPurchasesByTimeStampAscending(page);
        return couponPurchases;
    }



}
