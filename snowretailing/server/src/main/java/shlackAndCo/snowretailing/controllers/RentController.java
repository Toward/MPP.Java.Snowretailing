package shlackAndCo.snowretailing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shlackAndCo.snowretailing.core.constants.Permissions;
import shlackAndCo.snowretailing.core.contracts.models.IRentModel;
import shlackAndCo.snowretailing.core.contracts.models.IResultModel;
import shlackAndCo.snowretailing.core.contracts.services.ICredentialService;
import shlackAndCo.snowretailing.core.contracts.services.IEquipmentItemService;
import shlackAndCo.snowretailing.core.contracts.services.IEquipmentService;
import shlackAndCo.snowretailing.core.contracts.services.IRentService;
import shlackAndCo.snowretailing.core.enums.ResultStatus;
import shlackAndCo.snowretailing.core.models.RentModel;
import shlackAndCo.snowretailing.core.models.ResultModel;
import shlackAndCo.snowretailing.core.utils.RentCreation;

import java.util.Collection;

@RestController
public class RentController {
    private final IRentService rentService;
    private final IEquipmentItemService equipmentItemService;
    private final IEquipmentService equipmentService;
    private final ICredentialService credentialService;

    @Autowired
    public RentController(@Qualifier("rentService") IRentService rentService,
                          @Qualifier("equipmentItemService") IEquipmentItemService equipmentItemService,
                          @Qualifier("equipmentService") IEquipmentService equipmentService,
                          @Qualifier("credentialService") ICredentialService credentialService)
            throws IllegalArgumentException {
        if (rentService == null)
            throw new IllegalArgumentException("rentService is null");
        if (equipmentItemService == null)
            throw new IllegalArgumentException("equipmentItemService is null");
        if (equipmentService == null)
            throw new IllegalArgumentException("equipmentService is null");
        if (credentialService == null)
            throw new IllegalArgumentException("credentialService is null");
        this.rentService =rentService;
        this.credentialService =credentialService;
        this.equipmentItemService = equipmentItemService;
        this.equipmentService = equipmentService;
    }

    @ResponseBody
    @Secured(Permissions.AdminRead)
    @RequestMapping(value = "api/rents", method = RequestMethod.GET)
    public IResultModel<Collection<IRentModel>> getRents() {
        Collection<IRentModel> rentModels = rentService.getAll();
        return new ResultModel<>(ResultStatus.OK, "All rents've been successfully got",  rentModels);
    }

    @ResponseBody
    @Secured(Permissions.AdminRead)
    @RequestMapping(value = "api/rents/{id}", method = RequestMethod.GET)
    public IResultModel<IRentModel> getRent(@PathVariable("id") int id) {
        IRentModel rentModel = rentService.getById(id);
        return new ResultModel<>(ResultStatus.OK, "Rent has been successfully got by id", rentModel);
    }

    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/rents", method = RequestMethod.POST)
    public IResultModel<IRentModel> createRent(@RequestBody @Validated RentModel rentModel) {
        rentService.create(rentModel);
        return new ResultModel<>(ResultStatus.OK, "Rent has been created", null);
    }

    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/rents", method = RequestMethod.PUT)
    public IResultModel<IRentModel> editRent(@RequestBody @Validated RentModel rentModel) {
        rentService.edit(rentModel);
        return new ResultModel<>(ResultStatus.OK, "Rent has been changed", null);
    }

    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/rents/{id}", method = RequestMethod.DELETE)
    public ResultModel<IRentModel> removeRent(@PathVariable("id") int id) {
        rentService.delete(id);

        return new ResultModel<>(ResultStatus.OK, "Rent has been changed", null);
    }
}
