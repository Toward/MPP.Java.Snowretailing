package shlackAndCo.snowretailing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import shlackAndCo.snowretailing.core.contracts.models.IBrandModel;
import shlackAndCo.snowretailing.core.contracts.models.IResultModel;
import shlackAndCo.snowretailing.core.contracts.services.IBrandService;
import shlackAndCo.snowretailing.core.enums.ResultStatus;
import shlackAndCo.snowretailing.core.models.BrandModel;
import shlackAndCo.snowretailing.core.models.ResultModel;

import javax.validation.Valid;
import java.util.Collection;

@RestController
public class BrandController {
    private final IBrandService brandService;

    @Autowired
    public BrandController(@Qualifier("brandService") IBrandService brandService)
            throws IllegalArgumentException {
        if (brandService == null)
            throw new IllegalArgumentException("brandService is null");

        this.brandService = brandService;
    }

    @ResponseBody
    @RequestMapping(value = "/brands", method = RequestMethod.GET)
    public IResultModel<Collection<IBrandModel>> getBrands() {
        Collection<IBrandModel> brandModels = brandService.getAll();
        return new ResultModel<>(ResultStatus.OK, "All brands've been successfully got", brandModels);
    }

    @ResponseBody
    @RequestMapping(value = "/brands/{id}", method = RequestMethod.GET)
    public IResultModel<IBrandModel> getBrand(@PathVariable("id") int id) {
        IBrandModel brandModel = brandService.getById(id);
        return new ResultModel<>(ResultStatus.OK, "Brand has been successfully got by id", brandModel);
    }

    @ResponseBody
    @RequestMapping(value = "/brands/create", method = RequestMethod.GET)
    public IResultModel<IBrandModel> createBrand() {
        return new ResultModel<>(ResultStatus.OK, "All necessary data has been successfully sent", new BrandModel());
    }
    //TODO validation
    @ResponseBody
    @RequestMapping(value = "/brands/create", method = RequestMethod.POST)
    public IResultModel<IBrandModel> createBrand(@RequestBody @Validated IBrandModel brandModel) {
        brandService.create(brandModel);
        return new ResultModel<IBrandModel>(ResultStatus.OK, "Brand has been created", brandModel);
    }
    @ResponseBody
    @RequestMapping(value = "/brands/{id}", method = RequestMethod.PUT)
    public IResultModel<IBrandModel> editBrand(@PathVariable("id") int id, @RequestBody @Validated IBrandModel brandModel) {
        brandService.edit(brandModel);
        return new ResultModel<IBrandModel>(ResultStatus.OK, "Brand has been changed", brandModel);
    }

    @ResponseBody
    @RequestMapping(value = "/brands/{id}", method = RequestMethod.DELETE)
    public ResultModel<IBrandModel> removeEquipment(@PathVariable("id") int id) {
        brandService.delete(id);

        return new ResultModel<IBrandModel>(ResultStatus.OK, "Brand has been changed", null);
    }
}
