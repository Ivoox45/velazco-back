package com.velazco.velazco_back.service;

import org.springframework.data.domain.Pageable;

import com.velazco.velazco_back.dto.PaginatedResponseDto;
import com.velazco.velazco_back.dto.order.requests.OrderStartRequestDto;
import com.velazco.velazco_back.dto.order.responses.OrderListResponseDto;
import com.velazco.velazco_back.dto.order.responses.DeliveredOrderResponseDto;
import com.velazco.velazco_back.dto.order.responses.OrderConfirmDispatchResponseDto;
import com.velazco.velazco_back.dto.order.responses.OrderConfirmSaleResponseDto;
import com.velazco.velazco_back.dto.order.responses.OrderStartResponseDto;
import com.velazco.velazco_back.model.Order;
import com.velazco.velazco_back.model.User;

public interface OrderService {
    PaginatedResponseDto<OrderListResponseDto> getOrdersByStatus(Order.OrderStatus status, Pageable pageable);

    Order getOrderById(Long id);

    OrderStartResponseDto startOrder(User user, OrderStartRequestDto orderRequest);

    OrderConfirmSaleResponseDto confirmSale(Long orderId, User cashier, String paymentMethod);

    void deleteCancelledOrdersOlderThanOneDay();

    OrderConfirmDispatchResponseDto confirmDispatch(Long orderId, User dispatchedBy);

    void cancelOrder(Long orderId);

    PaginatedResponseDto<OrderListResponseDto> filterOrders(String status,
            Long orderId,
            String clientName,
            Pageable pageable);

    PaginatedResponseDto<DeliveredOrderResponseDto> getDeliveredOrders(Pageable pageable);

}
