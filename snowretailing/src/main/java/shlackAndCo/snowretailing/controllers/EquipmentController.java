package shlackAndCo.snowretailing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import shlackAndCo.snowretailing.auth.models.LoginModel;
import shlackAndCo.snowretailing.core.contracts.models.IEquipmentModel;
import shlackAndCo.snowretailing.core.contracts.models.IResultModel;
import shlackAndCo.snowretailing.core.contracts.services.IBrandService;
import shlackAndCo.snowretailing.core.contracts.services.ICharacteristicsService;
import shlackAndCo.snowretailing.core.contracts.services.IEquipmentService;
import shlackAndCo.snowretailing.core.contracts.services.ITypeService;
import shlackAndCo.snowretailing.core.enums.ResultStatus;
import shlackAndCo.snowretailing.core.models.EquipmentModel;
import shlackAndCo.snowretailing.core.models.ResultModel;
import shlackAndCo.snowretailing.core.utils.EquipmentCreation;

import java.util.Collection;

@RestController
public class EquipmentController {
    private final IEquipmentService equipmentService;
    private final ITypeService typeService;
    private final IBrandService brandService;
    private final ICharacteristicsService characteristicsService;

    @Autowired
    public EquipmentController(@Qualifier("equipmentService") IEquipmentService equipmentService,
                               @Qualifier("brandService") IBrandService brandService,
                               @Qualifier("typeService") ITypeService typeService,
                               @Qualifier("characteristicsService") ICharacteristicsService characteristicsService)
            throws IllegalArgumentException {
        if (equipmentService == null)
            throw new IllegalArgumentException("equipmentService is null");
        if (brandService == null)
            throw new IllegalArgumentException("brandService is null");
        if (typeService == null)
            throw new IllegalArgumentException("typeService is null");
        if (characteristicsService == null)
            throw new IllegalArgumentException("characteristicsService is null");

        this.equipmentService =equipmentService;
        this.brandService = brandService;
        this.typeService = typeService;
        this.characteristicsService = characteristicsService;
    }

    @ResponseBody
    @RequestMapping(value = "/equipments", method = RequestMethod.GET)
    public IResultModel<Collection<IEquipmentModel>> getEquipments() {
        Collection<IEquipmentModel> equipmentModels = equipmentService.getAll();
        return new ResultModel<>(ResultStatus.OK, "All equipments've been successfully got", equipmentModels);
    }

    @ResponseBody
    @RequestMapping(value = "/equipments/{id}", method = RequestMethod.GET)
    public IResultModel<EquipmentCreation> getEquipment(@PathVariable("id") int id) {
        IEquipmentModel equipmentModel = equipmentService.getById(id);
        EquipmentCreation equipmentCreation = new EquipmentCreation();
        equipmentCreation.setAvailableBrands(brandService.getAll());
        equipmentCreation.setAvailableTypes(typeService.getAll());
        equipmentCreation.setEquipmentModel(equipmentModel);
        equipmentCreation.setAvailableCharacteristics(characteristicsService.getAll());
        return new ResultModel<>(ResultStatus.OK, "Equipment has been successfully got by id", equipmentCreation);
    }

    @ResponseBody
    @RequestMapping(value = "/equipments/create", method = RequestMethod.GET)
    public IResultModel<EquipmentCreation> createEquipment() {
        EquipmentCreation equipmentCreation = new EquipmentCreation();
        equipmentCreation.setAvailableBrands(brandService.getAll());
        equipmentCreation.setAvailableTypes(typeService.getAll());
        equipmentCreation.setEquipmentModel(new EquipmentModel());
        equipmentCreation.setAvailableCharacteristics(characteristicsService.getAll());
        return new ResultModel<>(ResultStatus.OK, "All necessary data has been successfully sent", equipmentCreation);
    }
    //TODO validation
    @ResponseBody
    @RequestMapping(value = "/equipments/create", method = RequestMethod.POST)
    public IResultModel<IEquipmentModel> createEquipment(@RequestBody @Validated IEquipmentModel equipmentModel) {
        equipmentService.create(equipmentModel);
        return new ResultModel<IEquipmentModel>(ResultStatus.OK, "Equipment has been created", equipmentModel);
    }
    @ResponseBody
    @RequestMapping(value = "/equipments/{id}", method = RequestMethod.PUT)
    public IResultModel<IEquipmentModel> editEquipment(@PathVariable("id") int id, @RequestBody @Validated IEquipmentModel equipmentModel) {
        equipmentService.edit(equipmentModel);
        return new ResultModel<IEquipmentModel>(ResultStatus.OK, "Equipment has been changed", equipmentModel);
    }

    @ResponseBody
    @RequestMapping(value = "/equipments/{id}", method = RequestMethod.DELETE)
    public ResultModel<IEquipmentModel> removeEquipment(@PathVariable("id") int id) {
        equipmentService.delete(id);

        return new ResultModel<IEquipmentModel>(ResultStatus.OK, "Equipment has been changed", null);
    }
}
