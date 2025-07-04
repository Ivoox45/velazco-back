package com.velazco.velazco_back.controller;

import com.velazco.velazco_back.dto.PaginatedResponseDto;
import com.velazco.velazco_back.dto.order.requests.OrderConfirmSaleRequestDto;
import com.velazco.velazco_back.dto.order.requests.OrderStartRequestDto;
import com.velazco.velazco_back.dto.order.responses.DeliveredOrderResponseDto;
import com.velazco.velazco_back.dto.order.responses.OrderConfirmDispatchResponseDto;
import com.velazco.velazco_back.dto.order.responses.OrderConfirmSaleResponseDto;
import com.velazco.velazco_back.dto.order.responses.OrderListResponseDto;
import com.velazco.velazco_back.dto.order.responses.OrderStartResponseDto;
import com.velazco.velazco_back.model.Order;
import com.velazco.velazco_back.model.User;
import com.velazco.velazco_back.service.OrderService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping("/status/{status}")
  public ResponseEntity<PaginatedResponseDto<OrderListResponseDto>> getOrdersByStatus(
      @PathVariable String status,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size) {

    Pageable pageable = PageRequest.of(page, size);

    Order.OrderStatus orderStatus;
    try {
      orderStatus = Order.OrderStatus.valueOf(status.toUpperCase());
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().build();
    }

    return ResponseEntity.ok(orderService.getOrdersByStatus(orderStatus, pageable));
  }

  @GetMapping("/delivered")
  public ResponseEntity<PaginatedResponseDto<DeliveredOrderResponseDto>> getDeliveredOrders(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size) {

    Pageable pageable = PageRequest.of(page, size);

    return ResponseEntity.ok(orderService.getDeliveredOrders(pageable));
  }

  @PostMapping("/start")
  public ResponseEntity<OrderStartResponseDto> startOrder(
      @AuthenticationPrincipal User user,
      @Valid @RequestBody OrderStartRequestDto orderRequest) {

    OrderStartResponseDto responseDto = orderService.startOrder(user, orderRequest);

    return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
  }

  @PostMapping("/{id}/confirm-sale")
  public ResponseEntity<OrderConfirmSaleResponseDto> confirmSale(
      @PathVariable Long id,
      @AuthenticationPrincipal User cashier,
      @Valid @RequestBody OrderConfirmSaleRequestDto requestDto) {

    OrderConfirmSaleResponseDto responseDto = orderService.confirmSale(id, cashier, requestDto.getPaymentMethod());

    return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
  }

  @PostMapping("/{id}/confirm-dispatch")
  public ResponseEntity<OrderConfirmDispatchResponseDto> confirmDispatch(
      @PathVariable Long id,
      @AuthenticationPrincipal User dispatchedBy) {

    OrderConfirmDispatchResponseDto responseDto = orderService.confirmDispatch(id, dispatchedBy);

    return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);

  }

  @PutMapping("/{orderId}/cancel")
  public ResponseEntity<Void> cancelOrder(@PathVariable Long orderId) {
    // Check if the order exists
    // Order order = orderService.getOrderById(orderId);
    orderService.cancelOrder(orderId);

    return ResponseEntity.noContent().build();
  }

  @GetMapping("/filter")
  public ResponseEntity<PaginatedResponseDto<OrderListResponseDto>> filterOrders(
      @RequestParam String status,
      @RequestParam(required = false) Long orderId,
      @RequestParam(required = false) String clientName,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size) {

    Pageable pageable = PageRequest.of(page, size);

    PaginatedResponseDto<OrderListResponseDto> response = orderService.filterOrders(status, orderId, clientName,
        pageable);

    return ResponseEntity.ok(response);
  }

}