package shlackAndCo.snowretailing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shlackAndCo.snowretailing.core.constants.Permissions;
import shlackAndCo.snowretailing.core.contracts.models.IOrderModel;
import shlackAndCo.snowretailing.core.contracts.models.IResultModel;
import shlackAndCo.snowretailing.core.contracts.models.IUserReadModel;
import shlackAndCo.snowretailing.core.contracts.services.IOrderService;
import shlackAndCo.snowretailing.core.contracts.services.IUserService;
import shlackAndCo.snowretailing.core.enums.ResultStatus;
import shlackAndCo.snowretailing.core.enums.Role;
import shlackAndCo.snowretailing.core.models.OrderModel;
import shlackAndCo.snowretailing.core.models.ResultModel;

import java.util.ArrayList;
import java.util.Collection;

@RestController
public class OrderController {
    private final IOrderService orderService;
    private final IUserService userService;

    @Autowired
    public OrderController(@Qualifier("orderService") IOrderService orderService,
                           @Qualifier("userService") IUserService userService)
            throws IllegalArgumentException {
        if (orderService == null)
            throw new IllegalArgumentException("orderService is null");
        if(userService == null)
            throw new IllegalArgumentException("userService is null");
        this.orderService =orderService;
        this.userService = userService;
    }

    @ResponseBody
    @Secured(Permissions.UserRead)
    @RequestMapping(value = "api/orders", method = RequestMethod.GET)
    public IResultModel<Collection<IOrderModel>> getOrders() {
        Collection<IOrderModel> orderModels = filter(orderService.getAll());
        return new ResultModel<>(ResultStatus.OK, "All orders've been successfully got",  orderModels);
    }

    @ResponseBody
    @Secured(Permissions.UserRead)
    @RequestMapping(value = "api/orders/{id}", method = RequestMethod.GET)
    public IResultModel<IOrderModel> getOrder(@PathVariable("id") int id) {
        IOrderModel orderModel = filter(orderService.getById(id));
        return new ResultModel<>(ResultStatus.OK, "Order has been successfully got by id", orderModel);
    }


    @ResponseBody
    @Secured(Permissions.UserWrite)
    @RequestMapping(value = "api/orders", method = RequestMethod.POST)
    public IResultModel<IOrderModel> createOrder(@RequestBody @Validated OrderModel orderModel) {
        orderModel.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        orderService.create(orderModel);
        return new ResultModel<>(ResultStatus.OK, "Order has been created", null);
    }
    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/orders/{id}", method = RequestMethod.PUT)
    public IResultModel<IOrderModel> editOrder(@RequestBody @Validated OrderModel orderModel) {
        orderModel.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        orderService.edit(orderModel);
        return new ResultModel<>(ResultStatus.OK, "Order has been changed", null);
    }

    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
    public ResultModel<IOrderModel> removeOrder(@PathVariable("id") int id) {
        orderService.delete(id);

        return new ResultModel<>(ResultStatus.OK, "Order has been changed", null);
    }

    private Collection<IOrderModel> filter(Collection<IOrderModel> filteredCollection){
        IUserReadModel currentUser = userService.getByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        if(currentUser.getRole().getId() != Role.USER.getIndex())
            return filteredCollection;

        Collection<IOrderModel> result = new ArrayList<>();
        for (IOrderModel orderModel : filteredCollection){
            if(orderModel.getUserName().equals(currentUser.getLogin()))
                result.add(orderModel);
        }
        return result;
    }

    private IOrderModel filter(IOrderModel filteredItem) {
        IUserReadModel currentUser = userService.getByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        if (currentUser.getRole().getId() != Role.USER.getIndex())
            return filteredItem;
        if (filteredItem.getUserName().equals(currentUser.getLogin()))
            return filteredItem;
        return null;
    }
}
