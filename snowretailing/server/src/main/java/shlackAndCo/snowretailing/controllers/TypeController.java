package shlackAndCo.snowretailing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shlackAndCo.snowretailing.core.constants.Permissions;
import shlackAndCo.snowretailing.core.contracts.models.IResultModel;
import shlackAndCo.snowretailing.core.contracts.models.ITypeModel;
import shlackAndCo.snowretailing.core.contracts.services.ITypeService;
import shlackAndCo.snowretailing.core.enums.ResultStatus;
import shlackAndCo.snowretailing.core.models.ResultModel;

import java.util.Collection;

@RestController
public class TypeController {
    private final ITypeService service;

    @Autowired
    public TypeController(@Qualifier("typeService") ITypeService typeService) throws IllegalArgumentException {
        if (typeService == null)
            throw new IllegalArgumentException("brandService is null");

        this.service =typeService;
    }

    @ResponseBody
    @Secured(Permissions.AdminRead)
    @RequestMapping(value = "api/types", method = RequestMethod.GET)
    public IResultModel<Collection<ITypeModel>> getTypes() {
        Collection<ITypeModel> models = service.getAll();
        return new ResultModel<>(ResultStatus.OK, "All types've been successfully got", models);
    }

    @ResponseBody
    @Secured(Permissions.AdminRead)
    @RequestMapping(value = "api/types/{id}", method = RequestMethod.GET)
    public IResultModel<ITypeModel> getType(@PathVariable("id") int id) {
        ITypeModel model = service.getById(id);
        return new ResultModel<>(ResultStatus.OK, "Type has been successfully got by id", model);
    }

    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/types", method = RequestMethod.POST)
    public IResultModel<ITypeModel> createType(@RequestBody @Validated ITypeModel model) {
        service.create(model);
        return new ResultModel<>(ResultStatus.OK, "Characteristic has been created", null);
    }

    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/type", method = RequestMethod.PUT)
    public IResultModel<ITypeModel> editType(@RequestBody @Validated ITypeModel model) {
        service.edit(model);
        return new ResultModel<>(ResultStatus.OK, "Type has been changed",  null);
    }

    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/types/{id}", method = RequestMethod.DELETE)
    public ResultModel<ITypeModel> removeType(@PathVariable("id") int id) {
        service.delete(id);

        return new ResultModel<>(ResultStatus.OK, "Types has been changed", null);
    }
}
