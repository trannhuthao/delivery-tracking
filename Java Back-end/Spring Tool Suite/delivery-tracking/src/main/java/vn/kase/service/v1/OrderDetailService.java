package vn.kase.service.v1;

import vn.kase.dto.v1.model.OrderDetailDto;

import java.util.List;

public interface OrderDetailService {
    void add(OrderDetailDto orderDetailDto);

    List<OrderDetailDto> findAll();

    OrderDetailDto findById(Long id);

    void update(OrderDetailDto orderDetailDto);

    void delete(Long id);

    void checkout(OrderDetailDto orderDetailDto);
}