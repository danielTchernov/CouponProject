package com.daniel.server.logic;


import com.daniel.server.beans.Company;
import com.daniel.server.constants.Constants;
import com.daniel.server.dal.ICategoryDal;
import com.daniel.server.dal.ICompanyDal;
import com.daniel.server.entities.CompanyEntity;
import com.daniel.server.enums.ErrorType;
import com.daniel.server.exceptions.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyLogic {
    private ICompanyDal companyDal;
    private PurchaseLogic purchaseLogic;
    private CouponsLogic couponsLogic;
    private final ICategoryDal iCategoryDal;

    @Autowired
    public CompanyLogic(ICompanyDal companyDal , PurchaseLogic purchaseLogic, CouponsLogic couponsLogic,
                        ICategoryDal iCategoryDal){
        this.companyDal = companyDal;
        this.purchaseLogic = purchaseLogic;
        this.couponsLogic = couponsLogic;
        this.iCategoryDal = iCategoryDal;
    }


    public void createCompany(CompanyEntity company) throws ServerException {
        companyValidate(company);
        companyDal.save(company);
    }

    public CompanyEntity getCompany(long id) throws ServerException {
        CompanyEntity company = companyDal.findById(id).get();
        return company;
    }

    public void updateCompany(CompanyEntity company) throws ServerException{
        companyValidate(company);
        companyDal.save(company);
    }

    public void removeCompany(long id) throws Exception {
        companyDal.deleteById(id);
    }

    public List<Company> getAllCompanies(int page) throws ServerException{
        List<Company> companies;
        int offset = (page - 1) * Constants.recordsPerPage;
        companies = companyDal.getAllCompanies(offset);
        return companies;
    }

    public List<Company> getAllCompaniesByNameOrder(int page) throws ServerException{
        List<Company> companies;
        int offset = (page - 1) * Constants.recordsPerPage;
        companies = companyDal.getAllCompaniesByNameOrder(offset);
        return companies;
    }

    private boolean isValidatedAddress(String address) {
        if(address == null){
            return false;
        }
        return true;
    }

    private boolean isValidatedPhoneNum(String phoneNumber) throws ServerException {
        if (phoneNumber == null){
            return false;
        }
        if(companyDal.isPhoneNumberAlreadyExist(phoneNumber)){
            throw new ServerException(ErrorType.PHONE_ALREADY_EXIST, "Phone number already exist");
        }
        return true;
    }

    private void companyValidate(CompanyEntity company) throws ServerException {
        if (!isValidatedPhoneNum(company.getPhoneNumber())){
            throw new ServerException(ErrorType.BAD_PHONE , "Bad Phone Number");
        }
        if(!isValidatedAddress(company.getAddress())){
            throw new ServerException(ErrorType.BAD_ADDRESS, "Bad Address");
        }
    }




}
