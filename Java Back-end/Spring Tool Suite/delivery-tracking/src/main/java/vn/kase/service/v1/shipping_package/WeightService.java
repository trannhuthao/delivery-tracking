package vn.kase.service.v1.shipping_package;

import vn.kase.dto.v1.model.shipping_package.WeightDto;

import java.util.List;

public interface WeightService {
    void add(WeightDto weightDto);

    List<WeightDto> findAll();

    WeightDto findById(Long id);

    void update(WeightDto weightDto);

    void delete(Long id);
}