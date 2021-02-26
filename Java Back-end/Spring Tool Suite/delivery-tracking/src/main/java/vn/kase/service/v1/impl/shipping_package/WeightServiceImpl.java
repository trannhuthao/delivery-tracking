package vn.kase.service.v1.impl.shipping_package;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.kase.domain.v1.shipping_package.Weight;
import vn.kase.dto.v1.mapper.shipping_package.WeightMapper;
import vn.kase.dto.v1.model.shipping_package.WeightDto;
import vn.kase.repository.v1.shipping_package.WeightRepository;
import vn.kase.service.v1.shipping_package.WeightService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class WeightServiceImpl implements WeightService {
    private final WeightRepository weightRepository;

    @Autowired
    public WeightServiceImpl(WeightRepository weightRepository) {
        this.weightRepository = weightRepository;
    }

    @Override
    public void add(WeightDto weightDto) {
        this.weightRepository.save(WeightMapper.toEntity(weightDto));
    }

    @Override
    public List<WeightDto> findAll() {
        List<Weight> weights = this.weightRepository.findAll();
        List<WeightDto> weightDtos = new ArrayList<WeightDto>();
        for (Weight weight : weights) {
            weightDtos.add(WeightMapper.toDto(weight));
        }

        return weightDtos;
    }

    @Override
	public Page<WeightDto> findAllPaginated(int page, int size, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(page - 1, size, sort);
		Page<Weight> weights = this.weightRepository.findAll(pageable);
		Page<WeightDto> weightDtos = weights.map(element -> WeightMapper.toDto(element));

		return weightDtos;
	}

    @Override
    public WeightDto findById(Long id) {
        return WeightMapper.toDto(this.weightRepository.findById(id).get());
    }

    @Override
    public void update(WeightDto weightDto) {
        Weight weight = this.weightRepository.findById(weightDto.getId()).get();
        weight.setWeightRange(weightDto.getWeightRange());
        this.weightRepository.save(weight);
    }

    @Override
    public void delete(Long id) {
        this.weightRepository.deleteById(id);
    }
}