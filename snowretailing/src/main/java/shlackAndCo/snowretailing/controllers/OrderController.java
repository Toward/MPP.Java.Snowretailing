package shlackAndCo.snowretailing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
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
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public IResultModel<Collection<IOrderModel>> getOrders() {
        Collection<IOrderModel> orderModels = orderService.getAll();
        return new ResultModel<>(ResultStatus.OK, "All orders've been successfully got",  orderModels);
    }

    @ResponseBody
    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public IResultModel<IOrderModel> getOrder(@PathVariable("id") int id) {
        IOrderModel orderModel = orderService.getById(id);
        return new ResultModel<>(ResultStatus.OK, "Order has been successfully got by id", orderModel);
    }

    @ResponseBody
    @RequestMapping(value = "/orders/create", method = RequestMethod.GET)
    public IResultModel<OrderCreation> createOrder() {
        OrderCreation orderCreation = new OrderCreation();
        orderCreation.setOrderModel(new OrderModel());
        orderCreation.setAvailableEquipments(equipmentService.getAll());
        return new ResultModel<>(ResultStatus.OK, "All necessary data has been successfully sent", orderCreation);
    }
    //TODO validation
    @ResponseBody
    @RequestMapping(value = "/orders/create", method = RequestMethod.POST)
    public IResultModel<IOrderModel> createOrder(@RequestBody IOrderModel orderModel) {
        orderService.create(orderModel);
        return new ResultModel<IOrderModel>(ResultStatus.OK, "Order has been created", orderModel);
    }
    @ResponseBody
    @RequestMapping(value = "/orders/{id}", method = RequestMethod.PUT)
    public IResultModel<IOrderModel> editOrder(@PathVariable("id") int id, @RequestBody IOrderModel orderModel) {
        orderService.edit(orderModel);
        return new ResultModel<IOrderModel>(ResultStatus.OK, "Order has been changed", orderModel);
    }

    @ResponseBody
    @RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
    public ResultModel<IOrderModel> removeOrder(@PathVariable("id") int id) {
        orderService.delete(id);

        return new ResultModel<IOrderModel>(ResultStatus.OK, "Order has been changed", null);
    }
}
