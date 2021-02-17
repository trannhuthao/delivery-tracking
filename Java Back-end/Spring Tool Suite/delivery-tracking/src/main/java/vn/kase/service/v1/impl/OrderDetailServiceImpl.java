package vn.kase.service.v1.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.kase.domain.v1.OrderDetail;
import vn.kase.domain.v1.shipping_package.Package;
import vn.kase.domain.v1.Shipper;
import vn.kase.domain.v1.user.Address;
import vn.kase.domain.v1.user.User;
import vn.kase.dto.v1.mapper.OrderDetailMapper;
import vn.kase.dto.v1.model.OrderDetailDto;
import vn.kase.repository.v1.OrderDetailRepository;
import vn.kase.repository.v1.shipping_package.PackageRepository;
import vn.kase.repository.v1.user.UserRepository;
import vn.kase.service.v1.OrderDetailService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    private final PackageRepository packageRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository, PackageRepository packageRepository, UserRepository userRepository) {
        this.orderDetailRepository = orderDetailRepository;
        this.packageRepository = packageRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void add(OrderDetailDto orderDetailDto) {
        this.checkout(orderDetailDto);
        this.orderDetailRepository.save(OrderDetailMapper.toEntity(orderDetailDto));
    }

    @Override
    public List<OrderDetailDto> findAll() {
        List<OrderDetail> orderDetailList = this.orderDetailRepository.findAll();
        List<OrderDetailDto> orderDetailDtos = new ArrayList<OrderDetailDto>();
        for (OrderDetail orderDetail : orderDetailList) {
            orderDetailDtos.add(OrderDetailMapper.toDto(orderDetail));
        }

        return orderDetailDtos;
    }

    @Override
    public OrderDetailDto findById(Long id) {
        return OrderDetailMapper.toDto(this.orderDetailRepository.findById(id).get());
    }

    @Override
    public void update(OrderDetailDto orderDetailDto) {
        OrderDetail orderDetail = this.orderDetailRepository.findById(orderDetailDto.getId()).get();
        orderDetail.setUser(new User(orderDetailDto.getUserId()));
        orderDetail.setShippingPackage(new Package(orderDetailDto.getShippingPackageId()));
        orderDetail.setShipper(new Shipper(orderDetailDto.getShipperId()));
        orderDetail.setRecipient(new User(orderDetailDto.getRecipientId()));
        this.orderDetailRepository.save(orderDetail);
    }

    @Override
    public void delete(Long id) {
        this.orderDetailRepository.deleteById(id);
    }

    @Override
    public void checkout(OrderDetailDto orderDetailDto) {
//        Long userId = orderDetailDto.getUserId();
        Long shippingPackageId = orderDetailDto.getShippingPackageId();
        Long recipientId = orderDetailDto.getRecipientId();

//        User sender = new User(userId);
        Package shippingPackage = this.packageRepository.findById(shippingPackageId).get();
        User recipient = this.userRepository.findById(recipientId).get();

        double total = 15000.0;

        if (shippingPackage.getWeight().getId() == 1 && shippingPackage.getBoxSize().getId() == 1 && recipient.getAddress().getId() == 1) {
            total += 0.0;
        }

        if (shippingPackage.getWeight().getId() == 2) {
            total += 15000.0;
        }
        if (shippingPackage.getWeight().getId() == 3) {
            total += 30000.0;
        }
        if (shippingPackage.getWeight().getId() == 4) {
            total += 45000.0;
        }
        if (shippingPackage.getWeight().getId() == 5) {
            total += 60000.0;
        }
        if (shippingPackage.getWeight().getId() == 6) {
            total += 75000.0;
        }
        if (shippingPackage.getWeight().getId() == 7) {
            total += 90000.0;
        }
        if (shippingPackage.getWeight().getId() == 8) {
            total += 105000.0;
        }
        if (shippingPackage.getWeight().getId() == 9) {
            total += 120000.0;
        }
        if (shippingPackage.getWeight().getId() == 10) {
            total += 135000.0;
        }
        if (shippingPackage.getBoxSize().getId() == 2) {
            total += 15000.0;
        }
        if (shippingPackage.getBoxSize().getId() == 3) {
            total += 30000.0;
        }
        if (shippingPackage.getBoxSize().getId() == 4) {
            total += 45000.0;
        }
        if (shippingPackage.getBoxSize().getId() == 5) {
            total += 60000.0;
        }
        if (shippingPackage.getBoxSize().getId() == 6) {
            total += 75000.0;
        }
        if (shippingPackage.getBoxSize().getId() == 7) {
            total += 90000.0;
        }
        if (shippingPackage.getBoxSize().getId() == 8) {
            total += 105000.0;
        }
        if (shippingPackage.getBoxSize().getId() == 9) {
            total += 120000.0;
        }
        if (shippingPackage.getBoxSize().getId() == 10) {
            total += 135000.0;
        }
        if (recipient.getAddress().getId() == 2) {
            total += 15000.0;
        }
        if (recipient.getAddress().getId() == 3) {
            total += 30000.0;
        }
        if (recipient.getAddress().getId() == 4) {
            total += 45000.0;
        }
        if (recipient.getAddress().getId() == 5) {
            total += 60000.0;
        }
        if (recipient.getAddress().getId() == 6) {
            total += 75000.0;
        }
        if (recipient.getAddress().getId() == 7) {
            total += 90000.0;
        }
        if (recipient.getAddress().getId() == 8) {
            total += 105000.0;
        }
        if (recipient.getAddress().getId() == 9) {
            total += 120000.0;
        }
        if (recipient.getAddress().getId() == 10) {
            total += 135000.0;
        }
        if (recipient.getAddress().getId() == 11) {
            total += 150000.0;
        }
        if (recipient.getAddress().getId() == 12) {
            total += 165000.0;
        }
        if (recipient.getAddress().getId() == 13) {
            total += 180000.0;
        }
        if (recipient.getAddress().getId() == 14) {
            total += 195000.0;
        }
        if (recipient.getAddress().getId() == 15) {
            total += 205000.0;
        }
        if (recipient.getAddress().getId() == 16) {
            total += 220000.0;
        }
        if (recipient.getAddress().getId() == 17) {
            total += 235000.0;
        }
        if (recipient.getAddress().getId() == 18) {
            total += 250000.0;
        }
        if (recipient.getAddress().getId() == 19) {
            total += 265000.0;
        }
        if (recipient.getAddress().getId() == 20) {
            total += 285000.0;
        }

        orderDetailDto.setTotal(total);
    }
}