package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.exception.OrderNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    @GetMapping
    public List<OrderDto> getOrders() {
        return Arrays.asList(OrderDto.builder()
                        .id(1L)
                        .deliveryAddress("ul.Warszawska 21, 02-550 Warszawa")
                        .deliveryMethod("Courier GLS")
                        .orderData(LocalDateTime.now())
                        .value(new BigDecimal(200L))
                        .build(),

                OrderDto.builder()
                        .id(2L)
                        .deliveryAddress("ul.Wrocławska 22, 03-220 Wrocław")
                        .deliveryMethod("Courier UPS")
                        .orderData(LocalDateTime.now())
                        .value(new BigDecimal(200L))
                        .build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        return OrderDto.builder()
                .id(3L)
                .deliveryAddress("ul.Poznańska 22, 03-220 Poznań")
                .deliveryMethod("Courier UPS")
                .orderData(LocalDateTime.now())
                .value(new BigDecimal(200L))
                .build();
    }

    @GetMapping(value = "/{id}")
    public OrderDto getOrder(@PathVariable long id) throws OrderNotFoundException {
        return OrderDto.builder()
                .id(id)
                .deliveryAddress("Warszawska 21, 02-550 Warszawa")
                .deliveryMethod("Courier GLS")
                .orderData(LocalDateTime.now())
                .value(new BigDecimal(200L))
                .build();

    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) throws OrderNotFoundException {
        return orderDto;
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable long id) {
    }


}
