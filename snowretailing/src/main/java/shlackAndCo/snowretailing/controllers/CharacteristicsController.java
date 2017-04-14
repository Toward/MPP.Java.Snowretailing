package shlackAndCo.snowretailing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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
    @RequestMapping(value = "/characteristics", method = RequestMethod.GET)
    public IResultModel<Collection<ICharacteristicsModel>> getCharacteristics() {
        Collection<ICharacteristicsModel> models = service.getAll();
        return new ResultModel<>(ResultStatus.OK, "All characteristics've been successfully got", models);
    }

    @ResponseBody
    @RequestMapping(value = "/characteristics/{id}", method = RequestMethod.GET)
    public IResultModel<ICharacteristicsModel> getCharacteristic(@PathVariable("id") int id) {
        ICharacteristicsModel model = service.getById(id);
        return new ResultModel<>(ResultStatus.OK, "Characteristic has been successfully got by id", model);
    }

    @ResponseBody
    @RequestMapping(value = "/characteristics/create", method = RequestMethod.GET)
    public IResultModel<ICharacteristicsModel> createCharacteristic() {
        return new ResultModel<>(ResultStatus.OK, "All necessary data has been successfully sent", new CharacteristicsModel());
    }
    //TODO validation
    @ResponseBody
    @RequestMapping(value = "/characteristics/create", method = RequestMethod.POST)
    public IResultModel<ICharacteristicsModel> createCharacteristic(@RequestBody @Validated ICharacteristicsModel model) {
        service.create(model);
        return new ResultModel<ICharacteristicsModel>(ResultStatus.OK, "Characteristic has been created", model);
    }
    @ResponseBody
    @RequestMapping(value = "/characteristics/{id}", method = RequestMethod.PUT)
    public IResultModel<ICharacteristicsModel> editCharacteristic(@PathVariable("id") int id, @RequestBody @Validated ICharacteristicsModel model) {
        service.edit(model);
        return new ResultModel<ICharacteristicsModel>(ResultStatus.OK, "Characteristic has been changed", model);
    }

    @ResponseBody
    @RequestMapping(value = "/characteristics/{id}", method = RequestMethod.DELETE)
    public ResultModel<ICharacteristicsModel> removeCharacteristic(@PathVariable("id") int id) {
        service.delete(id);

        return new ResultModel<ICharacteristicsModel>(ResultStatus.OK, "Characteristics has been changed", null);
    }
}
