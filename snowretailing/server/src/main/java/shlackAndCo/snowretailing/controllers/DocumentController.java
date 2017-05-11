package shlackAndCo.snowretailing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import shlackAndCo.snowretailing.core.contracts.services.IGenerationService;
import shlackAndCo.snowretailing.core.enums.DocumentType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class DocumentController
{
    private final IGenerationService generationService;

    @Autowired
    public DocumentController(@Qualifier("generationService") IGenerationService generationService){
        this.generationService = generationService;
    }

    //PDF--------------------------------------------------------------------------------

    @RequestMapping(value = "documents/equipmentsCost/pdf", method = RequestMethod.GET, produces = "application/pdf")
    @ResponseBody
    public ResponseEntity getClassPupilsListPDFDocument(HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment;filename=priceList.pdf");
        generationService.generateEquipmentsCostsDocument(response.getOutputStream(), DocumentType.PDF);
        return new ResponseEntity(HttpStatus.OK);
    }
}