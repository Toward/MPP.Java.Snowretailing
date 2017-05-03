package shlackAndCo.snowretailing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shlackAndCo.snowretailing.core.constants.Permissions;
import shlackAndCo.snowretailing.core.contracts.models.ICharacteristicsModel;
import shlackAndCo.snowretailing.core.contracts.models.IResultModel;
import shlackAndCo.snowretailing.core.contracts.services.ICharacteristicsService;
import shlackAndCo.snowretailing.core.enums.ResultStatus;
import shlackAndCo.snowretailing.core.models.CharacteristicsModel;
import shlackAndCo.snowretailing.core.models.ResultModel;

import java.util.Collection;

@RestController
public class CharacteristicsController {
    private final ICharacteristicsService service;

    @Autowired
    public CharacteristicsController(@Qualifier("characteristicsService") ICharacteristicsService service) throws IllegalArgumentException {
        if (service == null)
            throw new IllegalArgumentException("Service is null");

        this.service = service;
    }

    @ResponseBody
    @Secured(Permissions.AdminRead)
    @RequestMapping(value = "api/characteristics", method = RequestMethod.GET)
    public IResultModel<Collection<ICharacteristicsModel>> getCharacteristics() {
        Collection<ICharacteristicsModel> models = service.getAll();
        return new ResultModel<>(ResultStatus.OK, "All characteristics've been successfully got", models);
    }

    @ResponseBody
    @Secured(Permissions.AdminRead)
    @RequestMapping(value = "api/characteristics/{id}", method = RequestMethod.GET)
    public IResultModel<ICharacteristicsModel> getCharacteristic(@PathVariable("id") int id) {
        ICharacteristicsModel model = service.getById(id);
        return new ResultModel<>(ResultStatus.OK, "Characteristic has been successfully got by id", model);
    }

    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/characteristics", method = RequestMethod.POST)
    public IResultModel<ICharacteristicsModel> createCharacteristic(@RequestBody @Validated CharacteristicsModel model) {
        service.create(model);
        return new ResultModel<>(ResultStatus.OK, "Characteristic has been created", null);
    }

    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/characteristics", method = RequestMethod.PUT)
    public IResultModel<ICharacteristicsModel> editCharacteristic(@RequestBody @Validated CharacteristicsModel model) {
        service.edit(model);
        return new ResultModel<>(ResultStatus.OK, "Characteristic has been changed", null);
    }

    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/characteristics/{id}", method = RequestMethod.DELETE)
    public ResultModel<ICharacteristicsModel> removeCharacteristic(@PathVariable("id") int id) {
        service.delete(id);
        return new ResultModel<>(ResultStatus.OK, "Characteristics has been deleted", null);
    }
}
