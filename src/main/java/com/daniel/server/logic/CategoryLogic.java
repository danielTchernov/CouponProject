package com.daniel.server.logic;

import com.daniel.server.beans.Category;
import com.daniel.server.constants.Constants;
import com.daniel.server.dal.ICategoryDal;
import com.daniel.server.dal.ICompanyDal;
import com.daniel.server.entities.CategoryEntity;
import com.daniel.server.enums.ErrorType;
import com.daniel.server.exceptions.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryLogic {
    private ICategoryDal categoryDal;
    private final ICompanyDal iCompanyDal;

    @Autowired
    public CategoryLogic(ICategoryDal categoryDal,
                         ICompanyDal iCompanyDal){
        this.categoryDal = categoryDal;
        this.iCompanyDal = iCompanyDal;
    }

    public void createCategory(CategoryEntity category) throws Exception {
        if(categoryDal.isCategoryExist(category.getName())){
            throw new ServerException(ErrorType.CATEGORY_EXIST , "CategoryEntity exist");
        }
        categoryDal.save(category);
    }


    public void remove(long id) throws Exception {
        categoryDal.deleteById(id);
    }

    public CategoryEntity getCategory(long id) throws Exception{
        CategoryEntity category = categoryDal.findById(id).get();
        if(category == null){
            throw new ServerException(ErrorType.NO_CATEGORY_FOUND , "No category found");
        }
        return category;
    }

    public void updateCategory(CategoryEntity category) throws Exception {
        if(categoryDal.isCategoryExist(category.getName())){
            throw new ServerException(ErrorType.CATEGORY_EXIST , "CategoryEntity already exist");
        }
        categoryDal.save(category);
    }

    public List<Category> getAllCategories(int page) throws ServerException {
        List<Category> categories;
        int offset = (page - 1) * Constants.recordsPerPage;
        categories = categoryDal.getAllCategories(offset);
        return categories;
    }

    public List<Category> getAllCategoriesByNameOrder(int page) throws ServerException{
        List<Category> categories;
        int offset = (page - 1)* Constants.recordsPerPage;
        categories = categoryDal.getAllCategoriesByNameOrder(offset);
        return categories;
    }
}
