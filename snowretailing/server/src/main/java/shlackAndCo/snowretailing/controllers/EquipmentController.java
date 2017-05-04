package shlackAndCo.snowretailing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shlackAndCo.snowretailing.core.constants.Permissions;
import shlackAndCo.snowretailing.core.contracts.models.IEquipmentModel;
import shlackAndCo.snowretailing.core.contracts.models.IResultModel;
import shlackAndCo.snowretailing.core.contracts.services.IEquipmentService;
import shlackAndCo.snowretailing.core.enums.ResultStatus;
import shlackAndCo.snowretailing.core.models.EquipmentModel;
import shlackAndCo.snowretailing.core.models.ResultModel;

import java.util.Collection;

@RestController
public class EquipmentController {
    private final IEquipmentService equipmentService;

    @Autowired
    public EquipmentController(@Qualifier("equipmentService") IEquipmentService equipmentService)
            throws IllegalArgumentException {
        if (equipmentService == null)
            throw new IllegalArgumentException("equipmentService is null");

        this.equipmentService =equipmentService;
    }

    @ResponseBody
    @RequestMapping(value = "/equipments", method = RequestMethod.GET)
    public IResultModel<Collection<IEquipmentModel>> getEquipments() {
        Collection<IEquipmentModel> equipmentModels = equipmentService.getAll();
        return new ResultModel<>(ResultStatus.OK, "All equipments've been successfully got", equipmentModels);
    }

    @ResponseBody
    @RequestMapping(value = "/equipments/{id}", method = RequestMethod.GET)
    public IResultModel<IEquipmentModel> getEquipment(@PathVariable("id") int id) {
        IEquipmentModel equipmentModel = equipmentService.getById(id);
        return new ResultModel<>(ResultStatus.OK, "Equipment has been successfully got by id", equipmentModel);
    }

    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/equipments", method = RequestMethod.POST)
    public IResultModel<IEquipmentModel> createEquipment(@RequestBody @Validated EquipmentModel equipmentModel) {
        equipmentService.create(equipmentModel);
        return new ResultModel<>(ResultStatus.OK, "Equipment has been created", null);
    }
    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/equipments", method = RequestMethod.PUT)
    public IResultModel<IEquipmentModel> editEquipment(@RequestBody @Validated EquipmentModel equipmentModel) {
        equipmentService.edit(equipmentModel);
        return new ResultModel<>(ResultStatus.OK, "Equipment has been changed", null);
    }

    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/equipments/{id}", method = RequestMethod.DELETE)
    public ResultModel<IEquipmentModel> removeEquipment(@PathVariable("id") int id) {
        equipmentService.delete(id);
        return new ResultModel<>(ResultStatus.OK, "Equipment has been changed", null);
    }
}
