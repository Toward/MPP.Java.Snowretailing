package shlackAndCo.snowretailing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import shlackAndCo.snowretailing.core.contracts.services.IGenerationService;
import shlackAndCo.snowretailing.core.enums.DocumentType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class    DocumentController
{
    private final IGenerationService generationService;

    @Autowired
    public DocumentController(@Qualifier("generationService") IGenerationService generationService){
        this.generationService = generationService;
    }

    //PDF--------------------------------------------------------------------------------

    @RequestMapping(value = "documents/equipmentsList/pdf", method = RequestMethod.GET, produces = "application/pdf")
    @ResponseBody
    public ResponseEntity getEquipmentsListPDFDocument(HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment;filename=equipments.pdf");
        generationService.generateEquipmentsListDocument(response.getOutputStream(), DocumentType.PDF);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "documents/clientsList/pdf", method = RequestMethod.GET, produces = "application/pdf")
    @ResponseBody
    public ResponseEntity getClientsListPDFDocument(HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment;filename=clients.pdf");
        generationService.generateClientsListDocument(response.getOutputStream(), DocumentType.PDF);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "documents/equipmentsCost/pdf", method = RequestMethod.GET, produces = "application/pdf")
    @ResponseBody
    public ResponseEntity getEquipmentsCostPDFDocument(HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment;filename=priceList.pdf");
        generationService.generateEquipmentsCostsDocument(response.getOutputStream(), DocumentType.PDF);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "documents/equipmentsItemsHistory/{id}/pdf", method = RequestMethod.GET, produces = "application/pdf")
    @ResponseBody
    public ResponseEntity getEquipmentsItemHistoryPDFDocument(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id)
            throws Exception{
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment;filename=equipmentsItemHistory.pdf");
        generationService.generateEquipmentsItemHistoryDocument(response.getOutputStream(), DocumentType.PDF, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "documents/rent/{id}/pdf", method = RequestMethod.GET, produces = "application/pdf")
    @ResponseBody
    public ResponseEntity getRentPDFDocument(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id)
            throws Exception{
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment;filename=rent.pdf");
        generationService.generateRentDocument(response.getOutputStream(), DocumentType.PDF,id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = "documents/equipmentsCost/csv", method = RequestMethod.GET, produces = "application/csv")
    @ResponseBody
    public ResponseEntity getEquipmentsCostCSVDocument(HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        response.setContentType("application/csv");
        response.setHeader("Content-Disposition", "attachment;filename=priceList.csv");
        generationService.generateEquipmentsCostsDocument(response.getOutputStream(), DocumentType.CSV);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "documents/equipmentsCost/xlsx", method = RequestMethod.GET, produces = "application/xlsx")
    @ResponseBody
    public ResponseEntity getEquipmentsCostXLSXDocument(HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        response.setContentType("application/xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=priceList.xlsx");
        generationService.generateEquipmentsCostsDocument(response.getOutputStream(), DocumentType.XLSX);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "documents/equipmentsList/csv", method = RequestMethod.GET, produces = "application/csv")
    @ResponseBody
    public ResponseEntity getEquipmentsListCSVDocument(HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        response.setContentType("application/csv");
        response.setHeader("Content-Disposition", "attachment;filename=equipmentsList.csv");
        generationService.generateEquipmentsListDocument(response.getOutputStream(), DocumentType.CSV);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "documents/equipmentsList/xlsx", method = RequestMethod.GET, produces = "application/xlsx")
    @ResponseBody
    public ResponseEntity getEquipmentsListXLSXDocument(HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        response.setContentType("application/xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=equipmentsList.xlsx");
        generationService.generateEquipmentsListDocument(response.getOutputStream(), DocumentType.XLSX);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "documents/clientsList/csv", method = RequestMethod.GET, produces = "application/csv")
    @ResponseBody
    public ResponseEntity getClientsListCSVDocument(HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        response.setContentType("application/csv");
        response.setHeader("Content-Disposition", "attachment;filename=clientsList.csv");
        generationService.generateClientsListDocument(response.getOutputStream(), DocumentType.CSV);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "documents/clientsList/xlsx", method = RequestMethod.GET, produces = "application/xlsx")
    @ResponseBody
    public ResponseEntity getClientsListXLSXDocument(HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        response.setContentType("application/xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=clientsList.xlsx");
        generationService.generateClientsListDocument(response.getOutputStream(), DocumentType.XLSX);
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = "documents/equipmentsItemsHistory/{id}/csv", method = RequestMethod.GET, produces = "application/csv")
    @ResponseBody
    public ResponseEntity getEquipmentsItemHistoryCSVDocument(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id)
            throws Exception{
        response.setContentType("application/csv");
        response.setHeader("Content-Disposition", "attachment;filename=equipmentsItemHistory.csv");
        generationService.generateEquipmentsItemHistoryDocument(response.getOutputStream(), DocumentType.CSV, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "documents/equipmentsItemsHistory/{id}/xlsx", method = RequestMethod.GET, produces = "application/xlsx")
    @ResponseBody
    public ResponseEntity getEquipmentsItemHistoryDocument(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id)
            throws Exception{
        response.setContentType("application/xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=equipmentsItemHistory.xlsx");
        generationService.generateEquipmentsItemHistoryDocument(response.getOutputStream(), DocumentType.XLSX, id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = "documents/rent/{id}/xlsx", method = RequestMethod.GET, produces = "application/pdf")
    @ResponseBody
    public ResponseEntity getRentXLSXDocument(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id)
            throws Exception{
        response.setContentType("application/xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=rent.xlsx");
        generationService.generateRentDocument(response.getOutputStream(), DocumentType.XLSX,id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "documents/rent/{id}/csv", method = RequestMethod.GET, produces = "application/csv")
    @ResponseBody
    public ResponseEntity getRentPCSVDocument(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id)
            throws Exception{
        response.setContentType("application/csv");
        response.setHeader("Content-Disposition", "attachment;filename=rent.csv");
        generationService.generateRentDocument(response.getOutputStream(), DocumentType.CSV,id);
        return new ResponseEntity(HttpStatus.OK);
    }

}