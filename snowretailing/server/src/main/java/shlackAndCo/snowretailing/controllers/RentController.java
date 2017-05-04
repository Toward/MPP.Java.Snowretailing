package shlackAndCo.snowretailing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shlackAndCo.snowretailing.core.constants.Permissions;
import shlackAndCo.snowretailing.core.contracts.models.IRentReadModel;
import shlackAndCo.snowretailing.core.contracts.models.IRentWriteModel;
import shlackAndCo.snowretailing.core.contracts.models.IResultModel;
import shlackAndCo.snowretailing.core.contracts.services.IRentService;
import shlackAndCo.snowretailing.core.enums.ResultStatus;
import shlackAndCo.snowretailing.core.models.RentWriteModel;
import shlackAndCo.snowretailing.core.models.ResultModel;

import java.util.Collection;

@RestController
public class RentController {
    private final IRentService rentService;

    @Autowired
    public RentController(@Qualifier("rentService") IRentService rentService)
            throws IllegalArgumentException {
        if (rentService == null)
            throw new IllegalArgumentException("rentService is null");
        this.rentService =rentService;
    }

    @ResponseBody
    @Secured(Permissions.AdminRead)
    @RequestMapping(value = "api/rents", method = RequestMethod.GET)
    public IResultModel<Collection<IRentReadModel>> getRents() {
        Collection<IRentReadModel> rentModels = rentService.getAll();
        return new ResultModel<>(ResultStatus.OK, "All rents've been successfully got",  rentModels);
    }

    @ResponseBody
    @Secured(Permissions.AdminRead)
    @RequestMapping(value = "api/rents/{id}", method = RequestMethod.GET)
    public IResultModel<IRentReadModel> getRent(@PathVariable("id") int id) {
        IRentReadModel rentReadModel = rentService.getById(id);
        return new ResultModel<>(ResultStatus.OK, "Rent has been successfully got by id", rentReadModel);
    }

    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/rents", method = RequestMethod.POST)
    public IResultModel<IRentWriteModel> createRent(@RequestBody @Validated RentWriteModel rentWriteModel) {
        rentService.create(rentWriteModel);
        return new ResultModel<>(ResultStatus.OK, "Rent has been created", null);
    }

    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/rents", method = RequestMethod.PUT)
    public IResultModel<IRentWriteModel> editRent(@RequestBody @Validated RentWriteModel rentWriteModel) {
        rentService.edit(rentWriteModel);
        return new ResultModel<>(ResultStatus.OK, "Rent has been changed", null);
    }

    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/rents/{id}", method = RequestMethod.DELETE)
    public ResultModel<IRentReadModel> removeRent(@PathVariable("id") int id) {
        rentService.delete(id);

        return new ResultModel<>(ResultStatus.OK, "Rent has been changed", null);
    }
}
