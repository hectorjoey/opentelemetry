package hector.test.opentel.service;

import hector.test.opentel.model.Users;
import hector.test.opentel.repository.UserRepository;
import hector.test.opentel.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UserRepository userRepository;


    public ApiResponse getUsers() {
        List<Users> users = userRepository.findAll();
        return new ApiResponse(200, "Processed Successfully", users);
    }

    public ApiResponse findById(Long id){
        Users users = userRepository.findById(id).orElse(null);
        if (users == null){
            return new ApiResponse(404, "User not found!");
        }
        return new ApiResponse(200, "Processed Successfully!", users);
    }

    public ApiResponse createUser(@RequestBody Users users){
        userRepository.save(users);
        return new ApiResponse(200, "Created Successfully!", users);
    }
}
