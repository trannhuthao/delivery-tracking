package vn.kase.service.v1.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.kase.domain.v1.Role;
import vn.kase.domain.v1.user.Address;
import vn.kase.domain.v1.user.User;
import vn.kase.dto.v1.mapper.user.UserMapper;
import vn.kase.dto.v1.model.user.UserDto;
import vn.kase.repository.v1.user.UserRepository;
import vn.kase.service.v1.user.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void add(UserDto userDto) {
        this.userRepository.save(UserMapper.toEntity(userDto));
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = this.userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<UserDto>();
        for (User user : users) {
            userDtos.add(UserMapper.toDto(user));
        }

        return userDtos;
    }

    @Override
    public UserDto findById(Long id) {
        return UserMapper.toDto(this.userRepository.findById(id).get());
    }

    @Override
    public void update(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).get();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setAddress(new Address(userDto.getAddressId()));
        user.setRole(new Role(userDto.getRoleId()));
        user.setOrderDetailList(userDto.getOrderDetails());
        user.setShippingPackages(userDto.getShippingPackages());
        this.userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }
}