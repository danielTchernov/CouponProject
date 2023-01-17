package com.daniel.server.controllers;

import com.daniel.server.dto.CouponCompany;
import com.daniel.server.entities.CouponEntity;
import com.daniel.server.exceptions.ServerException;
import com.daniel.server.logic.CouponsLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupons")
public class CouponsController {

    private CouponsLogic couponsLogic;

    @Autowired
    public CouponsController(CouponsLogic couponsLogic){
        this.couponsLogic = couponsLogic;
    }

    @PostMapping
    public void createCoupons (@RequestBody CouponEntity coupon) throws Exception {
        couponsLogic.createCoupon(coupon);
    }
    @PutMapping
    public void updateCoupons (@RequestBody CouponEntity coupon) throws Exception {
        couponsLogic.updateCoupon(coupon);
    }

    @DeleteMapping("{couponId}")
    public void removeCoupon (@PathVariable ("couponId") long id) throws Exception {
        couponsLogic.remove(id);
    }

    @GetMapping("{couponId}")
    public CouponCompany getCoupon(@PathVariable("couponId") long id) throws Exception {
        CouponCompany couponCompany = couponsLogic.getCoupon(id);
        return couponCompany;
    }

    @GetMapping
    public List<CouponCompany> getAllCoupons (@RequestParam("page") int page) throws ServerException {
        List<CouponCompany> couponsCompanies = couponsLogic.getAllCoupons(page);
        return couponsCompanies;
    }

    @GetMapping("/byName")
    public List<CouponCompany> getAllCouponsByNameOrder(@RequestParam("page") int page) throws ServerException {
        List<CouponCompany> couponsCompanies = couponsLogic.getAllCouponByNameOrder(page);
        return couponsCompanies;
    }

    @GetMapping("/byPriceAsc")
    public List<CouponCompany> getAllCouponsByPriceAscending(@RequestParam("page") int page) throws ServerException{
        List<CouponCompany> couponsCompanies = couponsLogic.getAllCouponByPriceAscending(page);
        return couponsCompanies;
    }

    @GetMapping("/byPriceDes")
    public List<CouponCompany> getAllCouponsByPriceDesc(@RequestParam("page") int page) throws ServerException {
        List<CouponCompany> couponsCompanies = couponsLogic.getAllCouponByPriceDesc(page);
        return couponsCompanies;
    }

    @GetMapping("/ByCategoryDes")
    public List<CouponCompany> getAllCouponsByCategoryDesc(@RequestParam("page")int page) throws ServerException {
        List<CouponCompany> couponsCompanies = couponsLogic.getAllCouponByCategoryDesc(page);
        return couponsCompanies;
    }

    @GetMapping("/ByCategoryAsc")
    public List<CouponCompany> getAllCouponsByCategoryAscending(@RequestParam("page") int page) throws ServerException {
        List<CouponCompany> couponsCompanies = couponsLogic.getAllCouponByCategoryAscending(page);
        return couponsCompanies;
    }

}
