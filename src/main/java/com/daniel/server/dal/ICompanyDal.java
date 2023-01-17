package com.daniel.server.dal;

import com.daniel.server.beans.Company;
import com.daniel.server.entities.CompanyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICompanyDal extends CrudRepository<CompanyEntity, Long> {
    @Query("SELECT c FROM CompanyEntity c")
    List<Company> getAllCompanies(int offset);

    @Query("SELECT c FROM CompanyEntity c ORDER BY name")
    List<Company> getAllCompaniesByNameOrder(int offset);

    @Query("SELECT c FROM CompanyEntity c WHERE c.phoneNumber")
    boolean isPhoneNumberAlreadyExist(String phoneNumber);
}
