package com.velazco.velazco_back.dto.order.requests;

import com.velazco.velazco_back.model.Order;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderStatusUpdateRequestDto {
    @NotNull
    private Order.OrderStatus status;
}
