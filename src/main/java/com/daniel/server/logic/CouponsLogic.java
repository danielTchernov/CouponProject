package com.daniel.server.logic;

import com.daniel.server.constants.Constants;
import com.daniel.server.dal.ICouponDal;
import com.daniel.server.dto.CouponCompany;
import com.daniel.server.entities.CouponEntity;
import com.daniel.server.enums.ErrorType;
import com.daniel.server.exceptions.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CouponsLogic {
    private ICouponDal couponDal;
    private PurchaseLogic purchaseLogic;

    @Autowired
    public CouponsLogic(ICouponDal couponDal , PurchaseLogic purchaseLogic) {
        this.couponDal = couponDal;
        this.purchaseLogic = purchaseLogic;
    }

    public void createCoupon(CouponEntity coupon) throws Exception {
        couponValidate(coupon);
        couponDal.save(coupon);
    }

//    public CouponCompany getCoupon(long id) throws Exception {
//        CouponCompany couponCompany = couponDal.findById(id).get();
//        return couponCompany;
//    }

    public void remove(long id) throws Exception {
        couponDal.deleteById(id);
    }

    public void updateCoupon(CouponEntity coupon) throws Exception{
        couponValidate(coupon);
        couponDal.save(coupon);
    }

    public void removeCouponByCompanyCoupon(long companyId) throws Exception {
        couponDal.removeCouponByCompanyCoupon(companyId);
    }

    public void removeOutDated() throws ServerException {
        couponDal.removeOutDated();
    }

    public List<CouponCompany> getAllCoupons (int page) throws ServerException {
        List<CouponCompany> couponsCompanies;
        int offset = (page - 1) * Constants.recordsPerPage;
        couponsCompanies = couponDal.getAllCoupons(offset);
        return couponsCompanies;
    }

    public List<CouponCompany> getAllCouponByNameOrder (int page) throws ServerException{
        List<CouponCompany> couponsCompanies;
        int offset = (page - 1) * Constants.recordsPerPage;
        couponsCompanies = couponDal.getAllCouponByNameOrder(offset);
        return couponsCompanies;
    }

    public List<CouponCompany> getAllCouponByPriceAscending (int page) throws ServerException{
        List<CouponCompany> couponCompanies;
        int offset = (page - 1) * Constants.recordsPerPage;
        couponCompanies = couponDal.getAllCouponByPriceAscending(offset);
        return couponCompanies;
    }

    public List<CouponCompany> getAllCouponByPriceDesc (int page) throws ServerException{
        List<CouponCompany> couponCompanies;
        int offset = (page - 1) * Constants.recordsPerPage;
        couponCompanies = couponDal.getAllCouponByPriceDesc(offset);
        return couponCompanies;
    }

    public List<CouponCompany> getAllCouponByCategoryDesc (int page) throws ServerException {
        List<CouponCompany> couponCompanies;
        int offset = (page - 1) * Constants.recordsPerPage;
        couponCompanies = couponDal.getAllCouponsByCategoryDesc(offset);
        return couponCompanies;
    }

    public List<CouponCompany> getAllCouponByCategoryAscending (int page) throws ServerException{
        List<CouponCompany> couponCompanies;
        int offset= (page - 1) * Constants.recordsPerPage;
        couponCompanies = couponDal.getAllCouponByCategoryAscending(offset);
        return couponCompanies;
    }

    private void couponValidate(CouponEntity coupon) throws ServerException {
        if (!isDateValidate(coupon.getStartDate(), coupon.getEndDate())) {
            throw new ServerException(ErrorType.DATE_ERROR, "Date Error");
        }
        if (!isPriceValidate(coupon.getPrice())) {
            throw new ServerException(ErrorType.PRICE_ERROR, "Price can't be below or equal to 0");
        }
    }

    private boolean isPriceValidate(float price) {
        if (price <= 0) {
            return false;
        }
        return true;
    }

    private boolean isDateValidate(Date startDate, Date endDate) {
        if (!startDate.before(endDate)){
            return false;
        }
        return true;
    }

}
