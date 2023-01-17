package com.daniel.server.logic;

import com.daniel.server.constants.Constants;
import com.daniel.server.dal.IPurchaseDal;
import com.daniel.server.dto.CouponPurchase;
import com.daniel.server.entities.PurchaseEntity;
import com.daniel.server.enums.ErrorType;
import com.daniel.server.exceptions.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseLogic {
    private IPurchaseDal purchaseDal;

    @Autowired
    public PurchaseLogic(IPurchaseDal purchaseDal) {
        this.purchaseDal = purchaseDal;
    }


    public void createPurchase(PurchaseEntity purchase) throws Exception {
        validatePurchase(purchase);
        purchaseDal.save(purchase);
    }

//    public CouponPurchase getPurchase(long id) throws Exception {
//        CouponPurchase purchase = purchaseDal.findById(id).get();
//        return purchase;
//    }

    public void removePurchase(long id) throws Exception {
        purchaseDal.deleteById(id);
    }

    public void removePurchasesOfCompanyCoupons(long companyId) throws Exception {
        purchaseDal.removePurchasesOfCompanyCoupons(companyId);
    }

    public void updatePurchase(PurchaseEntity purchase) throws Exception {
        validatePurchase(purchase);
        purchaseDal.save(purchase);
    }

    public void removePurchasesOfOutDatedCoupons() throws ServerException {
        purchaseDal.removePurchasesOfOutDatedCoupons();
    }

    public List<CouponPurchase> getAllPurchases (int page) throws ServerException{
        List<CouponPurchase> purchases;
        int offset = (page - 1) * Constants.recordsPerPage;
        purchases = purchaseDal.getAllPurchases(offset);
        return purchases;
    }

    public List<CouponPurchase> getAllPurchasesByAmountAscending(int page) throws ServerException{
        List<CouponPurchase> purchases;
        int offset = (page - 1) * Constants.recordsPerPage;
        purchases = purchaseDal.getAllPurchasesByAmountAscending(offset);
        return purchases;
    }

    public List<CouponPurchase> getAllPurchasesByAmountDesc(int page) throws ServerException{
        List<CouponPurchase> purchases;
        int offset = (page - 1) * Constants.recordsPerPage;
        purchases = purchaseDal.getAllPurchasesByAmountDesc(offset);
        return purchases;
    }

    public List<CouponPurchase> getAllPurchasesByTimeStampDescending (int page) throws ServerException{
        List<CouponPurchase> purchases;
        int offset = (page - 1) * Constants.recordsPerPage;
        purchases = purchaseDal.getAllPurchasesByTimeStampDescending(offset);
        return purchases;
    }

    public List<CouponPurchase> getAllPurchasesByTimeStampAscending (int page) throws ServerException{
        List<CouponPurchase> purchases;
        int offset = (page - 1) * Constants.recordsPerPage;
        purchases = purchaseDal.getAllPurchasesByTimeStampAscending(offset);
        return purchases;
    }
    private void validatePurchase(PurchaseEntity purchase) throws ServerException {
        if(!isAmountValidated(purchase.getAmount())){
            throw new ServerException(ErrorType.BAD_AMOUNT , "Bad amount");
        }
    }
    private boolean isAmountValidated(int amount) {
        if (amount <= 0){
            return false;
        }
        return true;
    }
}
