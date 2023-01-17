package com.daniel.server.controllers;


import com.daniel.server.beans.Company;
import com.daniel.server.entities.CompanyEntity;
import com.daniel.server.exceptions.ServerException;
import com.daniel.server.logic.CompanyLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompaniesController {


    private CompanyLogic companyLogic;

    @Autowired
    public CompaniesController(CompanyLogic companyLogic) {
        this.companyLogic = companyLogic;
    }

    @PostMapping
    public void createCompany (@RequestBody CompanyEntity company) throws ServerException {
        companyLogic.createCompany(company);
    }
    @PutMapping
    public void updateCompany (@RequestBody CompanyEntity company) throws ServerException {
        companyLogic.updateCompany(company);
    }

    @DeleteMapping("{companyId}")
    public void removeCompany (@PathVariable ("companyId") long id) throws Exception {
        companyLogic.removeCompany(id);
    }

    @GetMapping("{companyId}")
    public CompanyEntity getCompany(@PathVariable("companyId") long id) throws ServerException {
        CompanyEntity company = companyLogic.getCompany(id);
        return company;
    }

    @GetMapping
    public List<Company> getAllCompanies(@RequestParam("page") int page) throws ServerException {
        List<Company> companies = companyLogic.getAllCompanies(page);
        return companies;
    }

    @GetMapping("/byName")
    public List<Company> getAllCompaniesByNameOrder(@RequestParam ("page") int page) throws ServerException {
        List<Company> companies = companyLogic.getAllCompaniesByNameOrder(page);
        return companies;
    }

}
