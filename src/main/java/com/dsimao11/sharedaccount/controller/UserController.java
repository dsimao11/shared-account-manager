package com.dsimao11.sharedaccount.controller;

import com.dsimao11.sharedaccount.model.dto.inbound.CreateUserRequestDto;
import com.dsimao11.sharedaccount.model.dto.inbound.UpdateUserRequestDto;
import com.dsimao11.sharedaccount.model.dto.outbound.CreateUserResponseDto;
import com.dsimao11.sharedaccount.model.dto.outbound.FetchUserResponseDto;
import com.dsimao11.sharedaccount.model.dto.outbound.UpdateUserResponseDto;
import com.dsimao11.sharedaccount.model.entities.User;
import com.dsimao11.sharedaccount.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Creates a new User")
    public CreateUserResponseDto createUser(@RequestBody CreateUserRequestDto requestDto) {
        return userService.createUser(requestDto);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Returns User by nickname")
    public FetchUserResponseDto fetchUser(@PathVariable String id) {
        return userService.fetchUser(id);
    }

    @GetMapping()
    @Operation(summary = "Returns Shared Account by search criteria")
    public List<User> searchSharedAccounts(
            @RequestParam(value = "nickname", required = false) String nickname) {
        return userService.searchSharedAccount(nickname);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update User by id")
    public UpdateUserResponseDto updateUser(@PathVariable String id,
                                            @RequestBody UpdateUserRequestDto requestDto) {
        return userService.updateUser(id, requestDto);
    }

    @DeleteMapping("{nickname}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Remove User by nickname")
    public void removeUser(@PathVariable String nickname) {
        userService.removeUser(nickname);
    }

}