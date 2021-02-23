package vn.kase.service.v1.impl.shipping_package;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.kase.domain.v1.shipping_package.BoxSize;
import vn.kase.domain.v1.shipping_package.Package;
import vn.kase.domain.v1.user.User;
import vn.kase.domain.v1.shipping_package.Weight;
import vn.kase.dto.v1.mapper.shipping_package.PackageMapper;
import vn.kase.dto.v1.model.shipping_package.PackageDto;
import vn.kase.repository.v1.shipping_package.PackageRepository;
import vn.kase.service.v1.shipping_package.PackageService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PackageServiceImpl implements PackageService {
    private final PackageRepository packageRepository;

    @Autowired
    public PackageServiceImpl(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    @Override
    public void add(PackageDto packageDto) {
        this.packageRepository.save(PackageMapper.toEntity(packageDto));
    }

    @Override
    public List<PackageDto> findAll() {
        List<Package> shippingPackages = this.packageRepository.findAll();
        List<PackageDto> shippingPackageDtos = new ArrayList<PackageDto>();
        for (Package shippingPackage : shippingPackages) {
            shippingPackageDtos.add(PackageMapper.toDto(shippingPackage));
        }

        return shippingPackageDtos;
    }

    @Override
	public Page<PackageDto> findAllPaginated(int page, int size) {
		Pageable pageable = PageRequest.of(page - 1, size);
		Page<Package> shippingPackages = this.packageRepository.findAll(pageable);
		Page<PackageDto> shippingPackageDtos = shippingPackages.map(element -> PackageMapper.toDto(element));

		return shippingPackageDtos;
	}

    @Override
    public PackageDto findById(Long id) {
        return PackageMapper.toDto(this.packageRepository.findById(id).get());
    }

    @Override
    public void update(PackageDto packageDto) {
        Package shippingPackage = this.packageRepository.findById(packageDto.getId()).get();
        shippingPackage.setPackageName(packageDto.getPackageName());
//        shippingPackage.setImage(packageDto.getImage());
        shippingPackage.setWeight(new Weight(packageDto.getWeightId()));
        shippingPackage.setBoxSize(new BoxSize(packageDto.getBoxSizeId()));
        shippingPackage.setDescription(packageDto.getDescription());
        shippingPackage.setStatus(packageDto.getStatus());
        shippingPackage.setUser(new User(packageDto.getUserId()));
        this.packageRepository.save(shippingPackage);
    }

    @Override
    public void delete(Long id) {
        this.packageRepository.deleteById(id);
    }
}