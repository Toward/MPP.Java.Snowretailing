package shlackAndCo.snowretailing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shlackAndCo.snowretailing.core.constants.Permissions;
import shlackAndCo.snowretailing.core.contracts.models.IResultModel;
import shlackAndCo.snowretailing.core.contracts.models.IUserReadModel;
import shlackAndCo.snowretailing.core.contracts.services.IUserService;
import shlackAndCo.snowretailing.core.enums.ResultStatus;
import shlackAndCo.snowretailing.core.enums.Role;
import shlackAndCo.snowretailing.core.models.ResultModel;
import shlackAndCo.snowretailing.core.models.UserWriteModel;

import java.util.ArrayList;
import java.util.Collection;

@RestController
public class UserController {
    private final IUserService userService;

    @Autowired
    public UserController(@Qualifier("userService") IUserService userService){
        this.userService = userService;
    }

    @ResponseBody
    @Secured(Permissions.AdminRead)
    @RequestMapping(value = "api/users",method = RequestMethod.GET)
    public IResultModel<Collection<IUserReadModel>> GetUsers(){
        Collection<IUserReadModel> result = filter(userService.getAll());
        return new ResultModel<>(ResultStatus.OK, "Successful", result);
    }

    @ResponseBody
    @Secured(Permissions.AdminRead)
    @RequestMapping(value = "api/users/{id}",method = RequestMethod.GET)
    public IResultModel<IUserReadModel> GetCredential(@PathVariable int id){
        IUserReadModel result = filter(userService.getById(id));
        return new ResultModel<>(ResultStatus.OK, "Successful", result);
    }

    @ResponseBody
    @Secured(Permissions.RootWrite)
    @RequestMapping(value = "api/users",method = RequestMethod.POST)
    public IResultModel CreateCredential(@RequestBody @Validated UserWriteModel user){
        userService.create(user);
        return new ResultModel(ResultStatus.OK, "Successful user creation", null);
    }

    @ResponseBody
    @Secured(Permissions.RootWrite)
    @RequestMapping(value = "api/users",method = RequestMethod.PUT)
    public IResultModel UpdateCredential(@RequestBody @Validated UserWriteModel userEditModel){
        userService.edit(userEditModel);
        return new ResultModel(ResultStatus.OK, "Successful user editing", null);
    }

    @ResponseBody
    @Secured(Permissions.RootWrite)
    @RequestMapping(value = "api/users/{id}",method = RequestMethod.DELETE)
    public IResultModel DeleteCredential(@PathVariable int id){
        userService.delete(id);
        return new ResultModel(ResultStatus.OK, "Successful user deleting", null);
    }

    private Collection<IUserReadModel> filter(Collection<IUserReadModel> filteredCollection){
        IUserReadModel currentUser = userService.getByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        if(currentUser.getRole().getId() == Role.ROOT.getIndex())
            return RemoveRootFromUsers(filteredCollection);

        Collection<IUserReadModel> result = new ArrayList<>();
        for (IUserReadModel userReadModel : filteredCollection){
            if(userReadModel.getRole().getId() == Role.USER.getIndex())
                result.add(userReadModel);
        }
        return result;
    }

    private IUserReadModel filter(IUserReadModel filteredItem){
        IUserReadModel currentUser = userService.getByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        if(currentUser.getRole().getId() == Role.ROOT.getIndex())
            return filteredItem;
        if(filteredItem.getRole().getId() == Role.USER.getIndex())
            return filteredItem;
        return null;
    }

    private Collection<IUserReadModel> RemoveRootFromUsers(Collection<IUserReadModel> filteredCollection){
        IUserReadModel root = null;
        for(IUserReadModel userReadModel: filteredCollection){
            if(userReadModel.getRole().getId() == Role.ROOT.getIndex()){
                root = userReadModel;
            }
        }
        filteredCollection.remove(root);
        return filteredCollection;
    }
}
