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
import shlackAndCo.snowretailing.core.contracts.models.IBrandModel;
import shlackAndCo.snowretailing.core.contracts.services.IBrandService;
import shlackAndCo.snowretailing.core.models.BrandModel;

import javax.validation.Valid;
import java.util.Collection;

@Controller
public class BrandController {
    private final IBrandService brandService;

    @Autowired
    public BrandController(@Qualifier("brandService") IBrandService brandService) throws IllegalArgumentException {
        if (brandService == null)
            throw new IllegalArgumentException("brandService is null");

        this.brandService = brandService;
    }

    @RequestMapping(value = "/brands", method = RequestMethod.GET)
    public ModelAndView getBrands() {
        ModelAndView view = new ModelAndView("brands/brandsView");

        Collection<IBrandModel> brandModels = brandService.getAll();
        view.addObject("brands", brandModels);

        return view;
    }

    @RequestMapping(value = "/brands/{id}", method = RequestMethod.GET)
    public ModelAndView getBrand(@PathVariable("id") int id) {
        ModelAndView view = new ModelAndView("brands/brandView");

        IBrandModel brandModel = brandService.getById(id);
        view.addObject("brand", brandModel);

        return view;
    }

    @RequestMapping(value = "/brands/create", method = RequestMethod.GET)
    public ModelAndView createBrand() {
        return new ModelAndView("brands/createBrand", "brand", new BrandModel());
    }

    @RequestMapping(value = "/brands/create", method = RequestMethod.POST)
    public ModelAndView createBrand(@Valid @ModelAttribute("brand") BrandModel brand, BindingResult result) {
        if (result.hasErrors())
            return new ModelAndView("brands/createBrand", result.getModel());

        brandService.create(brand);

        return new ModelAndView("redirect:/brands");
    }

    @RequestMapping(value = "/brands/{id}/edit", method = RequestMethod.GET)
    public ModelAndView editBrand(@PathVariable("id") int id) {
        IBrandModel brand = brandService.getById(id);

        return new ModelAndView("brands/editBrand", "brand", brand);
    }

    @RequestMapping(value = "/brands/{id}/edit", method = RequestMethod.POST)
    public ModelAndView editBrand(@PathVariable("id") int id, @Valid @ModelAttribute("brand") BrandModel brandModel, BindingResult result) {
        if (result.hasErrors())
            return new ModelAndView("brands/editBrand", result.getModel());

        brandService.edit(id, brandModel);

        return new ModelAndView("redirect:/brands");
    }

    @RequestMapping(value = "/brands/{id}/delete")
    public ModelAndView removeBrand(@PathVariable("id") int id) {
        brandService.delete(id);

        return new ModelAndView("redirect:/brands");
    }
}
