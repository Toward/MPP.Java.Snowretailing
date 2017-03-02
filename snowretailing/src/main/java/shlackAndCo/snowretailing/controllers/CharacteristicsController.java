package shlackAndCo.snowretailing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import shlackAndCo.snowretailing.core.contracts.models.ICharacteristicsModel;
import shlackAndCo.snowretailing.core.contracts.services.ICharacteristicsService;
import shlackAndCo.snowretailing.core.models.CharacteristicsModel;

import javax.validation.Valid;
import java.util.Collection;

/**
 * Created by Владелец on 03/03/2017.
 */
@Controller
public class CharacteristicsController {
    private final ICharacteristicsService service;

    @Autowired
    public CharacteristicsController(@Qualifier("characteristicsService") ICharacteristicsService service) throws IllegalArgumentException {
        if (service == null)
            throw new IllegalArgumentException("Service is null");

        this.service = service;
    }

    @RequestMapping(value = "/characteristics", method = RequestMethod.GET)
    public ModelAndView getBrands() {
        ModelAndView view = new ModelAndView("characteristics/characteristicsView");

        Collection<ICharacteristicsModel> characteristicModels = service.getAll();
        view.addObject("characteristics", characteristicModels);

        return view;
    }

    @RequestMapping(value = "/characteristics/{id}", method = RequestMethod.GET)
    public ModelAndView getBrand(@PathVariable("id") int id) {
        ModelAndView view = new ModelAndView("characteristics/characteristicView");

        ICharacteristicsModel characteristicModel = service.getById(id);
        view.addObject("characteristic", characteristicModel);

        return view;
    }

    @RequestMapping(value = "/characteristics/create", method = RequestMethod.GET)
    public ModelAndView createBrand() {
        return new ModelAndView("characteristics/createCharacteristic", "characteristic", new CharacteristicsModel());
    }

    @RequestMapping(value = "/characteristics/create", method = RequestMethod.POST)
    public ModelAndView createBrand(@Valid @ModelAttribute("brand") CharacteristicsModel characteristic, BindingResult result) {
        if (result.hasErrors())
            return new ModelAndView("characteristics/createCharacteristic", result.getModel());

        service.create(characteristic);

        return new ModelAndView("redirect:/characteristics");
    }

    @RequestMapping(value = "/characteristics/{id}/edit", method = RequestMethod.GET)
    public ModelAndView editBrand(@PathVariable("id") int id) {
        ICharacteristicsModel characteristic = service.getById(id);

        return new ModelAndView("characteristics/editCharacteristic", "characteristic", characteristic);
    }

    @RequestMapping(value = "/characteristics/{id}/edit", method = RequestMethod.POST)
    public ModelAndView editBrand(@PathVariable("id") int id, @Valid @ModelAttribute("characteristic") CharacteristicsModel model, BindingResult result) {
        if (result.hasErrors())
            return new ModelAndView("characteristic/editCharacteristic", result.getModel());

        service.edit(id, model);

        return new ModelAndView("redirect:/characteristics");
    }

    @RequestMapping(value = "/characteristics/{id}/delete")
    public ModelAndView removeBrand(@PathVariable("id") int id) {
        service.delete(id);

        return new ModelAndView("redirect:/characteristics");
    }
}
