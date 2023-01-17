package com.daniel.server.dal;

import com.daniel.server.dto.CouponPurchase;
import com.daniel.server.entities.PurchaseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPurchaseDal extends CrudRepository<PurchaseEntity, Long> {

    @Query()
    void removePurchasesOfCompanyCoupons(long companyId);

    @Query("DELETE p FROM PurchaseEntity p WHERE endDate < date(now())")
    void removePurchasesOfOutDatedCoupons();

    @Query("SELECT p FROM PurchaseEntity p")
    List<CouponPurchase> getAllPurchases(int offset);

    @Query("SELECT p FROM PurchaseEntity p ORDER BY amount ASC")
    List<CouponPurchase> getAllPurchasesByAmountAscending(int offset);

    @Query("SELECT p FROM PurchaseEntity p ORDER BY amount DESC")
    List<CouponPurchase> getAllPurchasesByAmountDesc(int offset);

    @Query("SELECT p FROM PurchaseEntity p ORDER BY timeStamp DESC")
    List<CouponPurchase> getAllPurchasesByTimeStampDescending(int offset);

    @Query("SELECT p FROM PurchaseEntity p ORDER BY timeStamp ASC")
    List<CouponPurchase> getAllPurchasesByTimeStampAscending(int offset);
}
