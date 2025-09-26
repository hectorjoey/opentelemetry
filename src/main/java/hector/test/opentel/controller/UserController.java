package hector.test.opentel.controller;

import hector.test.opentel.model.Users;
import hector.test.opentel.response.ApiResponse;
import hector.test.opentel.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UsersService usersService;



    @GetMapping("/all")
    public ApiResponse getUsers(){
        return usersService.getUsers();
    }

    @GetMapping("/{id}")
    public ApiResponse getUserById(@PathVariable ("id") long id){
        return usersService.findById(id);
    }

    @PostMapping("/create")
    public ApiResponse createUser(@RequestBody Users users){
        return usersService.createUser(users);
    }

}
