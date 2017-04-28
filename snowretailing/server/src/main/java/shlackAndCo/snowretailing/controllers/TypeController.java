package shlackAndCo.snowretailing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shlackAndCo.snowretailing.core.contracts.models.IResultModel;
import shlackAndCo.snowretailing.core.contracts.models.ITypeModel;
import shlackAndCo.snowretailing.core.contracts.services.ITypeService;
import shlackAndCo.snowretailing.core.enums.ResultStatus;
import shlackAndCo.snowretailing.core.models.ResultModel;
import shlackAndCo.snowretailing.core.models.TypeModel;

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
    @RequestMapping(value = "/types", method = RequestMethod.GET)
    public IResultModel<Collection<ITypeModel>> getTypes() {
        Collection<ITypeModel> models = service.getAll();
        return new ResultModel<>(ResultStatus.OK, "All types've been successfully got", models);
    }

    @ResponseBody
    @RequestMapping(value = "/types/{id}", method = RequestMethod.GET)
    public IResultModel<ITypeModel> getType(@PathVariable("id") int id) {
        ITypeModel model = service.getById(id);
        return new ResultModel<>(ResultStatus.OK, "Type has been successfully got by id", model);
    }

    @ResponseBody
    @RequestMapping(value = "/types/create", method = RequestMethod.GET)
    public IResultModel<ITypeModel> createType() {
        return new ResultModel<>(ResultStatus.OK, "All necessary data has been successfully sent", new TypeModel());
    }
    //TODO validation
    @ResponseBody
    @RequestMapping(value = "/types/create", method = RequestMethod.POST)
    public IResultModel<ITypeModel> createType(@RequestBody @Validated ITypeModel model) {
        service.create(model);
        return new ResultModel<ITypeModel>(ResultStatus.OK, "Characteristic has been created", model);
    }
    @ResponseBody
    @RequestMapping(value = "/type/{id}", method = RequestMethod.PUT)
    public IResultModel<ITypeModel> editType(@PathVariable("id") int id, @RequestBody @Validated ITypeModel model) {
        service.edit(model);
        return new ResultModel<ITypeModel>(ResultStatus.OK, "Type has been changed", model);
    }

    @ResponseBody
    @RequestMapping(value = "/types/{id}", method = RequestMethod.DELETE)
    public ResultModel<ITypeModel> removeType(@PathVariable("id") int id) {
        service.delete(id);

        return new ResultModel<ITypeModel>(ResultStatus.OK, "Types has been changed", null);
    }
}
