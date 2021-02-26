package vn.kase.service.v1.shipping_package;

import vn.kase.dto.v1.model.shipping_package.BoxSizeDto;

import java.util.List;

import org.springframework.data.domain.Page;

public interface BoxSizeService {
    void add(BoxSizeDto boxSizeDto);

    List<BoxSizeDto> findAll();
    
    Page<BoxSizeDto> findAllPaginated(int page, int size, String sortField, String sortDirection);

    BoxSizeDto findById(Long id);

    void update(BoxSizeDto boxSizeDto);

    void delete(Long id);
}