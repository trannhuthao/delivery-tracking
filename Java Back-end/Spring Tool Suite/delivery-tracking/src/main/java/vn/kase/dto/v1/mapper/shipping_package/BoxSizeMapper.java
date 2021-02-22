package vn.kase.dto.v1.mapper.shipping_package;

import vn.kase.domain.v1.shipping_package.BoxSize;
import vn.kase.dto.v1.model.shipping_package.BoxSizeDto;

public class BoxSizeMapper {
    public static BoxSizeDto toDto(BoxSize boxSize) {
        BoxSizeDto boxSizeDto = new BoxSizeDto();
        boxSizeDto.setId(boxSize.getId());
        boxSizeDto.setBoxSize(boxSize.getBoxSize());
        return boxSizeDto;
    }

    public static BoxSize toEntity(BoxSizeDto boxSizeDto) {
        BoxSize boxSize = new BoxSize();
        boxSize.setId(boxSize.getId());
        boxSize.setBoxSize(boxSizeDto.getBoxSize());
        return boxSize;
    }
}