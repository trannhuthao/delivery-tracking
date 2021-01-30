package vn.kase.service.v1.shipping_package;

import vn.kase.dto.v1.model.shipping_package.BoxSizeDto;

import java.util.List;

public interface BoxSizeService {
    void add(BoxSizeDto boxSizeDto);

    List<BoxSizeDto> findAll();

    BoxSizeDto findById(Long id);

    void update(BoxSizeDto boxSizeDto);

    void delete(Long id);
}