package vn.kase.service.v1.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.kase.domain.v1.OrderDetail;
import vn.kase.domain.v1.shipping_package.BoxSize;
import vn.kase.domain.v1.shipping_package.Package;
import vn.kase.domain.v1.User;
import vn.kase.domain.v1.shipping_package.Weight;
import vn.kase.dto.v1.mapper.shipping_package.PackageMapper;
import vn.kase.dto.v1.model.shipping_package.PackageDto;
import vn.kase.repository.v1.PackageRepository;
import vn.kase.service.v1.PackageService;

import java.util.ArrayList;
import java.util.List;

@Service
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
    public PackageDto findById(Long id) {
        return PackageMapper.toDto(this.packageRepository.findById(id).get());
    }

    @Override
    public void update(PackageDto packageDto) {
        Package shippingPackage = this.packageRepository.findById(packageDto.getId()).get();
        shippingPackage.setPackageName(packageDto.getPackageName());
        shippingPackage.setImage(packageDto.getImage());
        shippingPackage.setWeight(new Weight(packageDto.getWeightId()));
        shippingPackage.setBoxSize(new BoxSize(packageDto.getBoxSizeId()));
        shippingPackage.setDescription(packageDto.getDescription());
        shippingPackage.setUser(new User(packageDto.getUserId()));
        shippingPackage.setOrderDetail(new OrderDetail(packageDto.getOrderDetailId()));
        this.packageRepository.save(shippingPackage);
    }

    @Override
    public void delete(Long id) {
        this.packageRepository.deleteById(id);
    }
}