package vn.kase.service.v1.impl.shipping_package;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.kase.domain.v1.shipping_package.BoxSize;
import vn.kase.dto.v1.mapper.shipping_package.BoxSizeMapper;
import vn.kase.dto.v1.model.shipping_package.BoxSizeDto;
import vn.kase.repository.v1.shipping_package.BoxSizeRepository;
import vn.kase.service.v1.shipping_package.BoxSizeService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BoxSizeServiceImpl implements BoxSizeService {
    private final BoxSizeRepository boxSizeRepository;

    @Autowired
    public BoxSizeServiceImpl(BoxSizeRepository boxSizeRepository) {
        this.boxSizeRepository = boxSizeRepository;
    }

    @Override
    public void add(BoxSizeDto boxSizeDto) {
        this.boxSizeRepository.save(BoxSizeMapper.toEntity(boxSizeDto));
    }

    @Override
    public List<BoxSizeDto> findAll() {
        List<BoxSize> boxSizes = this.boxSizeRepository.findAll();
        List<BoxSizeDto> boxSizeDtos = new ArrayList<BoxSizeDto>();
        for (BoxSize boxSize : boxSizes) {
            boxSizeDtos.add(BoxSizeMapper.toDto(boxSize));
        }

        return boxSizeDtos;
    }
    
    @Override
	public Page<BoxSizeDto> findAllPaginated(int page, int size) {
		Pageable pageable = PageRequest.of(page - 1, size);
		Page<BoxSize> boxSizesPaginated = this.boxSizeRepository.findAll(pageable);
		Page<BoxSizeDto> boxSizeDtosPaginated = boxSizesPaginated.map(element -> BoxSizeMapper.toDto(element));

		return boxSizeDtosPaginated;
	}

    @Override
    public BoxSizeDto findById(Long id) {
        return BoxSizeMapper.toDto(this.boxSizeRepository.findById(id).get());
    }

    @Override
    public void update(BoxSizeDto boxSizeDto) {
        BoxSize boxSize = this.boxSizeRepository.findById(boxSizeDto.getId()).get();
        boxSize.setBoxSize(boxSizeDto.getBoxSize());
        this.boxSizeRepository.save(boxSize);
    }

    @Override
    public void delete(Long id) {
        this.boxSizeRepository.deleteById(id);
    }
}