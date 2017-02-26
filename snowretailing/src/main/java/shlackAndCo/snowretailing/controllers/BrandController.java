package shlackAndCo.snowretailing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import shlackAndCo.snowretailing.core.contracts.models.IBrandModel;
import shlackAndCo.snowretailing.core.contracts.services.IBrandService;
import shlackAndCo.snowretailing.core.models.BrandModel;

import java.util.Collection;

@Controller
public class BrandController {
    private final IBrandService brandService;

    @Autowired
    public BrandController(@Qualifier("brandService") IBrandService brandService){

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
    public String createBrand(BrandModel brand) {
        brandService.create(brand);

        return "redirect:/brands";
    }

    @RequestMapping(value = "/brands/{id}/edit", method = RequestMethod.GET)
    public ModelAndView editBrand(@PathVariable("id") int id) {
        IBrandModel brand = brandService.getById(id);

        return new ModelAndView("brands/editBrand", "brand", brand);
    }

    @RequestMapping(value = "/brands/{id}/edit", method = RequestMethod.POST)
    public String editBrand(@PathVariable("id") int id, BrandModel model) {
        brandService.edit(id, model);

        return "redirect:/brands";
    }

    @RequestMapping(value = "/brands/{id}/delete")
    public String removeBrand(@PathVariable("id") int id) {
        brandService.delete(id);

        return "redirect:/brands";
    }
}
