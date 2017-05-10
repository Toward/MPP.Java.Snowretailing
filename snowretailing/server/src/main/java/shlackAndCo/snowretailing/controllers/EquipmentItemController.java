package shlackAndCo.snowretailing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shlackAndCo.snowretailing.core.constants.Permissions;
import shlackAndCo.snowretailing.core.contracts.models.IEquipmentItemModel;
import shlackAndCo.snowretailing.core.contracts.models.IEquipmentModel;
import shlackAndCo.snowretailing.core.contracts.models.IResultModel;
import shlackAndCo.snowretailing.core.contracts.services.IEquipmentItemService;
import shlackAndCo.snowretailing.core.contracts.services.IEquipmentService;
import shlackAndCo.snowretailing.core.enums.ResultStatus;
import shlackAndCo.snowretailing.core.models.EquipmentItemModel;
import shlackAndCo.snowretailing.core.models.EquipmentModel;
import shlackAndCo.snowretailing.core.models.ResultModel;

import java.util.Collection;

@RestController
public class EquipmentItemController {
    private final IEquipmentItemService equipmentService;

    @Autowired
    public EquipmentItemController(@Qualifier("equipmentItemService") IEquipmentItemService equipmentService)
            throws IllegalArgumentException {
        if (equipmentService == null)
            throw new IllegalArgumentException("equipmentService is null");

        this.equipmentService =equipmentService;
    }

    @ResponseBody
    @Secured(Permissions.AdminRead)
    @RequestMapping(value = "api/equipment_items", method = RequestMethod.GET)
    public IResultModel<Collection<IEquipmentItemModel>> getEquipments() {
        Collection<IEquipmentItemModel> equipmentModels = equipmentService.getAll();
        return new ResultModel<>(ResultStatus.OK, "All equipments've been successfully got", equipmentModels);
    }

    @ResponseBody
    @Secured(Permissions.AdminRead)
    @RequestMapping(value = "api/equipment_items/{id}", method = RequestMethod.GET)
    public IResultModel<IEquipmentItemModel> getEquipment(@PathVariable("id") int id) {
        IEquipmentItemModel equipmentModel = equipmentService.getById(id);
        return new ResultModel<>(ResultStatus.OK, "Equipment Item has been successfully got by id", equipmentModel);
    }

    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/equipment_items", method = RequestMethod.POST)
    public IResultModel<IEquipmentItemModel> createEquipment(@RequestBody @Validated EquipmentItemModel equipmentModel) {
        equipmentService.create(equipmentModel);
        return new ResultModel<>(ResultStatus.OK, "Equipment Item has been created", null);
    }
    @ResponseBody
    @Secured(Permissions.UserWrite)
    @RequestMapping(value = "api/equipment_items", method = RequestMethod.PUT)
    public IResultModel<IEquipmentItemModel> editEquipment(@RequestBody @Validated EquipmentItemModel equipmentModel) {
        equipmentService.edit(equipmentModel);
        return new ResultModel<>(ResultStatus.OK, "Equipment Item has been changed", null);
    }

    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/equipment_items/{id}", method = RequestMethod.DELETE)
    public ResultModel<IEquipmentModel> removeEquipment(@PathVariable("id") int id) {
        equipmentService.delete(id);
        return new ResultModel<>(ResultStatus.OK, "Equipment Item has been changed", null);
    }
}
