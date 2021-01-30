package vn.kase.service.v1.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.kase.domain.v1.OrderDetail;
import vn.kase.domain.v1.shipping_package.Package;
import vn.kase.domain.v1.Shipper;
import vn.kase.domain.v1.User;
import vn.kase.dto.v1.mapper.OrderDetailMapper;
import vn.kase.dto.v1.model.OrderDetailDto;
import vn.kase.repository.v1.OrderDetailRepository;
import vn.kase.service.v1.OrderDetailService;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public void add(OrderDetailDto orderDetailDto) {
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
        orderDetail.setStatus(orderDetailDto.getStatus());
        orderDetail.setShipper(new Shipper(orderDetailDto.getShipperId()));
        this.orderDetailRepository.save(orderDetail);
    }

    @Override
    public void delete(Long id) {
        this.orderDetailRepository.deleteById(id);
    }
}