package vn.kase.service.v1;

import vn.kase.dto.v1.model.OrderDetailDto;

import java.util.List;

import org.springframework.data.domain.Page;

public interface OrderDetailService {
    void add(OrderDetailDto orderDetailDto);

    List<OrderDetailDto> findAll();

    Page<OrderDetailDto> findAllPaginated(int page, int size, String sortField, String sortDirection);

    OrderDetailDto findById(Long id);

    void update(OrderDetailDto orderDetailDto);

    void delete(Long id);

    void checkout(OrderDetailDto orderDetailDto);
}