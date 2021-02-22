package vn.kase.dto.v1.mapper.shipping_package;

import vn.kase.domain.v1.shipping_package.Weight;
import vn.kase.dto.v1.model.shipping_package.WeightDto;

public class WeightMapper {
    public static WeightDto toDto(Weight weight) {
        WeightDto weightDto = new WeightDto();
        weightDto.setId(weight.getId());
        weightDto.setWeightRange(weight.getWeightRange());
        return weightDto;
    }

    public static Weight toEntity(WeightDto weightDto) {
        Weight weight = new Weight();
        weight.setId(weightDto.getId());
        weight.setWeightRange(weightDto.getWeightRange());
        return weight;
    }
}