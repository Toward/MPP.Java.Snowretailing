package shlackAndCo.snowretailing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shlackAndCo.snowretailing.core.contracts.models.ICredentialModel;
import shlackAndCo.snowretailing.core.contracts.models.IResultModel;
import shlackAndCo.snowretailing.core.contracts.services.ICredentialService;
import shlackAndCo.snowretailing.core.enums.ResultStatus;
import shlackAndCo.snowretailing.core.models.CredentialModel;
import shlackAndCo.snowretailing.core.models.ResultModel;

import java.util.Collection;

@RestController
public class CredentialController {
    private final ICredentialService credentialService;

    @Autowired
    public CredentialController(@Qualifier("credentialService") ICredentialService credentialService){
        this.credentialService = credentialService;
    }

    @ResponseBody
    @RequestMapping(value = "/credential",method = RequestMethod.GET)
    public IResultModel<Collection<ICredentialModel>> GetCredentials(){
        Collection<ICredentialModel> result = credentialService.getAll();
        return new ResultModel<>(ResultStatus.OK, "Successful. Credentials in data", result);
    }

    @ResponseBody
    @RequestMapping(value = "/credential/{id}",method = RequestMethod.GET)
    public IResultModel<ICredentialModel> GetCredential(@PathVariable int id){
        ICredentialModel result = credentialService.getById(id);
        return new ResultModel<>(ResultStatus.OK, "Successful. Credential in data", result);
    }

    @ResponseBody
    @RequestMapping(value = "/credential",method = RequestMethod.POST)
    public IResultModel<ICredentialModel> CreateCredential(@RequestBody @Validated CredentialModel credential){
        credentialService.create(credential);
        return new ResultModel<>(ResultStatus.OK, "Successful", null);
    }

    @ResponseBody
    @RequestMapping(value = "/credential",method = RequestMethod.PUT)
    public IResultModel<ICredentialModel> UpdateCredential(@RequestBody @Validated CredentialModel credential){
        credentialService.edit(credential);
        return new ResultModel<>(ResultStatus.OK, "Successful", null);
    }

    @ResponseBody
    @RequestMapping(value = "/credential/{id}",method = RequestMethod.DELETE)
    public IResultModel<ICredentialModel> DeleteCredential(@PathVariable int id){
        credentialService.delete(id);
        return new ResultModel<>(ResultStatus.OK, "Successful", null);
    }
}
