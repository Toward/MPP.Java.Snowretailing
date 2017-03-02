package shlackAndCo.snowretailing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import shlackAndCo.snowretailing.core.contracts.models.ITypeModel;
import shlackAndCo.snowretailing.core.contracts.services.ITypeService;
import shlackAndCo.snowretailing.core.models.TypeModel;

import javax.validation.Valid;
import java.util.Collection;

@Controller
public class TypeController {
    private final ITypeService typeService;

    @Autowired
    public TypeController(@Qualifier("typeService") ITypeService typeService) throws IllegalArgumentException {
        if (typeService == null)
            throw new IllegalArgumentException("brandService is null");

        this.typeService =typeService;
    }

    @RequestMapping(value = "/types", method = RequestMethod.GET)
    public ModelAndView getBrands() {
        ModelAndView view = new ModelAndView("types/typesView");

        Collection<ITypeModel> typeModels = typeService.getAll();
        view.addObject("types", typeModels);

        return view;
    }

    @RequestMapping(value = "/types/{id}", method = RequestMethod.GET)
    public ModelAndView getBrand(@PathVariable("id") int id) {
        ModelAndView view = new ModelAndView("types/typeView");

        ITypeModel typeModel = typeService.getById(id);
        view.addObject("type", typeModel);

        return view;
    }

    @RequestMapping(value = "/types/create", method = RequestMethod.GET)
    public ModelAndView createBrand() {
        return new ModelAndView("types/createType", "type", new TypeModel());
    }

    @RequestMapping(value = "/types/create", method = RequestMethod.POST)
    public ModelAndView createBrand(@Valid @ModelAttribute("type") TypeModel type, BindingResult result) {
        if (result.hasErrors())
            return new ModelAndView("types/createType", result.getModel());

        typeService.create(type);

        return new ModelAndView("redirect:/types");
    }

    @RequestMapping(value = "/types/{id}/edit", method = RequestMethod.GET)
    public ModelAndView editBrand(@PathVariable("id") int id) {
        ITypeModel type = typeService.getById(id);

        return new ModelAndView("types/editType", "type", type);
    }

    @RequestMapping(value = "/types/{id}/edit", method = RequestMethod.POST)
    public ModelAndView editBrand(@PathVariable("id") int id, @Valid @ModelAttribute("type") TypeModel typeModel, BindingResult result) {
        if (result.hasErrors())
            return new ModelAndView("types/editType", result.getModel());

        typeService.edit(id,typeModel);

        return new ModelAndView("redirect:/types");
    }

    @RequestMapping(value = "/types/{id}/delete", method = RequestMethod.GET)
    public ModelAndView removeBrand(@PathVariable("id") int id) {
        typeService.delete(id);

        return new ModelAndView("redirect:/types");
    }
}
