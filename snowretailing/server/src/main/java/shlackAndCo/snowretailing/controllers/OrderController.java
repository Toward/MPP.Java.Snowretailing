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
import shlackAndCo.snowretailing.core.contracts.services.IEquipmentItemService;
import shlackAndCo.snowretailing.core.contracts.services.IEquipmentService;
import shlackAndCo.snowretailing.core.contracts.services.IOrderService;
import shlackAndCo.snowretailing.core.enums.ResultStatus;
import shlackAndCo.snowretailing.core.models.OrderModel;
import shlackAndCo.snowretailing.core.models.ResultModel;
import shlackAndCo.snowretailing.core.utils.OrderCreation;

import java.util.Collection;

@RestController
public class OrderController {
    private final IOrderService orderService;
    private final IEquipmentItemService equipmentItemService;
    private final IEquipmentService equipmentService;

    @Autowired
    public OrderController(@Qualifier("orderService") IOrderService orderService,
                           @Qualifier("equipmentItemService") IEquipmentItemService equipmentItemService,
                           @Qualifier("equipmentService") IEquipmentService equipmentService)
            throws IllegalArgumentException {
        if (orderService == null)
            throw new IllegalArgumentException("orderService is null");
        if (equipmentItemService == null)
            throw new IllegalArgumentException("equipmentItemService is null");
        if (equipmentService == null)
            throw new IllegalArgumentException("equipmentService is null");
        this.orderService =orderService;
        this.equipmentItemService = equipmentItemService;
        this.equipmentService = equipmentService;
    }

    @ResponseBody
    @Secured(Permissions.AdminRead)
    @RequestMapping(value = "api/orders", method = RequestMethod.GET)
    public IResultModel<Collection<IOrderModel>> getOrders() {
        Collection<IOrderModel> orderModels = orderService.getAll();
        return new ResultModel<>(ResultStatus.OK, "All orders've been successfully got",  orderModels);
    }

    @ResponseBody
    @Secured(Permissions.AdminRead)
    @RequestMapping(value = "api/orders/{id}", method = RequestMethod.GET)
    public IResultModel<IOrderModel> getOrder(@PathVariable("id") int id) {
        IOrderModel orderModel = orderService.getById(id);
        return new ResultModel<>(ResultStatus.OK, "Order has been successfully got by id", orderModel);
    }


    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/orders/create", method = RequestMethod.POST)
    public IResultModel<IOrderModel> createOrder(@RequestBody @Validated IOrderModel orderModel) {
        orderModel.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        orderService.create(orderModel);
        return new ResultModel<>(ResultStatus.OK, "Order has been created", null);
    }
    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/orders}", method = RequestMethod.PUT)
    public IResultModel<IOrderModel> editOrder(@RequestBody @Validated IOrderModel orderModel) {
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
}
