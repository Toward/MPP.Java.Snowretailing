package shlackAndCo.snowretailing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import shlackAndCo.snowretailing.core.contracts.models.IOrderModel;
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
    @RequestMapping(value = "/rents", method = RequestMethod.GET)
    public IResultModel<Collection<IRentModel>> getRents() {
        Collection<IRentModel> rentModels = rentService.getAll();
        return new ResultModel<>(ResultStatus.OK, "All rents've been successfully got",  rentModels);
    }

    @ResponseBody
    @RequestMapping(value = "/rents/{id}", method = RequestMethod.GET)
    public IResultModel<RentCreation> getRent(@PathVariable("id") int id) {
        IRentModel rentModel = rentService.getById(id);
        RentCreation rentCreation = new RentCreation();
        rentCreation.setRentModel(rentModel);
        rentCreation.setAvailableEquipments(equipmentService.getAll());
        rentCreation.setAvailablePassports(credentialService.getAll());
        return new ResultModel<>(ResultStatus.OK, "Rent has been successfully got by id", rentCreation);
    }

    @ResponseBody
    @RequestMapping(value = "/rents/create", method = RequestMethod.GET)
    public IResultModel<RentCreation> createRent() {
        RentCreation rentCreation = new RentCreation();
        rentCreation.setRentModel(new RentModel());
        rentCreation.setAvailableEquipments(equipmentService.getAll());
        rentCreation.setAvailablePassports(credentialService.getAll());
        return new ResultModel<>(ResultStatus.OK, "All necessary data has been successfully sent", rentCreation);
    }
    //TODO validation
    @ResponseBody
    @RequestMapping(value = "/orders/create", method = RequestMethod.POST)
    public IResultModel<IRentModel> createRent(@RequestBody IRentModel rentModel) {
        rentService.create(rentModel);
        return new ResultModel<IRentModel>(ResultStatus.OK, "Rent has been created", rentModel);
    }
    @ResponseBody
    @RequestMapping(value = "/rents/{id}", method = RequestMethod.PUT)
    public IResultModel<IRentModel> editRent(@PathVariable("id") int id, @RequestBody IRentModel rentModel) {
        rentService.edit(rentModel);
        return new ResultModel<IRentModel>(ResultStatus.OK, "Rent has been changed", rentModel);
    }

    @ResponseBody
    @RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
    public ResultModel<IRentModel> removeRent(@PathVariable("id") int id) {
        rentService.delete(id);

        return new ResultModel<IRentModel>(ResultStatus.OK, "Rent has been changed", null);
    }
}
