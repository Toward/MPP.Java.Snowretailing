package shlackAndCo.snowretailing.controllers;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import shlackAndCo.snowretailing.dao.BrandEntity;
import shlackAndCo.snowretailing.utils.HibernateSessionFactory;
import java.util.List;

@Controller
public class BrandController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getBrands() {
        ModelAndView model = new ModelAndView("brandView");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        List<BrandEntity> brands = (List<BrandEntity>)session.createCriteria(BrandEntity.class).list();
        session.getTransaction().commit();
        session.close();

        model.addObject("brands", brands);
        return model;
    }
}
