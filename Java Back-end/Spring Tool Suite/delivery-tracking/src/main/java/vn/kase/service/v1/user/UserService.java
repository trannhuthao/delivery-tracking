package vn.kase.service.v1.user;

import vn.kase.dto.v1.model.user.UserDto;

import java.util.List;

import org.springframework.data.domain.Page;

public interface UserService {
    void add(UserDto userDto);

    List<UserDto> findAll();
    
    Page<UserDto> findAllPaginated(int page, int size);

    UserDto findById(Long id);

    void update(UserDto userDto);

    void delete(Long id);
}