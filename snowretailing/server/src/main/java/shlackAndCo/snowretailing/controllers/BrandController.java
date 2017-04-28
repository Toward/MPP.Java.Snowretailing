package shlackAndCo.snowretailing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shlackAndCo.snowretailing.core.constants.Permissions;
import shlackAndCo.snowretailing.core.contracts.models.IBrandModel;
import shlackAndCo.snowretailing.core.contracts.models.IResultModel;
import shlackAndCo.snowretailing.core.contracts.services.IBrandService;
import shlackAndCo.snowretailing.core.enums.ResultStatus;
import shlackAndCo.snowretailing.core.models.ResultModel;

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
    @Secured(Permissions.AdminRead)
    @RequestMapping(value = "api/brands", method = RequestMethod.GET)
    public IResultModel<Collection<IBrandModel>> getBrands() {
        Collection<IBrandModel> brandModels = brandService.getAll();
        return new ResultModel<>(ResultStatus.OK, "All brands've been successfully got", brandModels);
    }

    @ResponseBody
    @Secured(Permissions.AdminRead)
    @RequestMapping(value = "api/brands/{id}", method = RequestMethod.GET)
    public IResultModel<IBrandModel> getBrand(@PathVariable("id") int id) {
        IBrandModel brandModel = brandService.getById(id);
        return new ResultModel<>(ResultStatus.OK, "Brand has been successfully got by id", brandModel);
    }

    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/brands", method = RequestMethod.POST)
    public IResultModel<IBrandModel> createBrand(@RequestBody @Validated IBrandModel brandModel) {
        brandService.create(brandModel);
        return new ResultModel<>(ResultStatus.OK, "Brand has been created", brandModel);
    }
    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/brands", method = RequestMethod.PUT)
    public IResultModel<IBrandModel> editBrand(@RequestBody @Validated IBrandModel brandModel) {
        brandService.edit(brandModel);
        return new ResultModel<>(ResultStatus.OK, "Brand has been changed", brandModel);
    }

    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/brands/{id}", method = RequestMethod.DELETE)
    public ResultModel<IBrandModel> removeEquipment(@PathVariable("id") int id) {
        brandService.delete(id);
        return new ResultModel<>(ResultStatus.OK, "Brand has been changed", null);
    }
}
