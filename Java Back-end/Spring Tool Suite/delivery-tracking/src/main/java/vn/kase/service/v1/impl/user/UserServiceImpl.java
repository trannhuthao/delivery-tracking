package vn.kase.service.v1.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
@Transactional
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
    public Page<UserDto> findAllPaginated(int page, int size, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(page - 1, size, sort);
		Page<User> usersPaginated = this.userRepository.findAll(pageable);
		Page<UserDto> userDtosPaginated = usersPaginated.map(element -> UserMapper.toDto(element));

		return userDtosPaginated;
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