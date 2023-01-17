package com.daniel.server.dal;

import com.daniel.server.dto.CouponCompany;
import com.daniel.server.entities.CouponEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICouponDal extends CrudRepository<CouponEntity, Long> {

    @Query("DELETE c FROM CouponEntity c WHERE c.companyId")
    void removeCouponByCompanyCoupon(long companyId);

    @Query("DELETE c FROM CouponEntity c WHERE c.endDate < date(now())")
    void removeOutDated();

    @Query("SELECT c FROM CouponEntity c")
    List<CouponCompany> getAllCoupons(int offset);

    @Query("SELECT c FROM CouponEntity c ORDER BY name")
    List<CouponCompany> getAllCouponByNameOrder(int offset);


    @Query("SELECT c FROM CouponEntity c ORDER BY price ASC")
    List<CouponCompany> getAllCouponByPriceAscending(int offset);

    @Query("SELECT c FROM CouponEntity c ORDER BY price DESC")
    List<CouponCompany> getAllCouponByPriceDesc(int offset);

    @Query("SELECT c FROM CouponEntity c ORDER BY category DESC")
    List<CouponCompany> getAllCouponsByCategoryDesc(int offset);

    @Query("SELECT c FROM CouponEntity c ORDER BY category ASC")
    List<CouponCompany> getAllCouponByCategoryAscending(int offset);
}
