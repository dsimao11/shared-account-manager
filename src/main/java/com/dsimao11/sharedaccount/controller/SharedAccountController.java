package com.dsimao11.sharedaccount.controller;

import com.dsimao11.sharedaccount.model.dto.inbound.CreateSharedAccountRequestDto;
import com.dsimao11.sharedaccount.model.dto.outbound.CreateSharedAccountResponseDto;
import com.dsimao11.sharedaccount.model.dto.outbound.FetchSharedAccountResponseDto;
import com.dsimao11.sharedaccount.model.entities.SharedAccount;
import com.dsimao11.sharedaccount.model.entities.SharedAccountUser;
import com.dsimao11.sharedaccount.services.SharedAccountService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("shared-account")
public class SharedAccountController {

    @Autowired
    private SharedAccountService sharedAccountService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Creates a new Shared Account")
    public CreateSharedAccountResponseDto createSharedAccount(@RequestBody @Valid CreateSharedAccountRequestDto requestDto) {
        return sharedAccountService.createSharedAccount(requestDto);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Returns Shared Account by id")
    public FetchSharedAccountResponseDto fetchSharedAccount(@PathVariable String id) {
        return sharedAccountService.fetchSharedAccount(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Returns Shared Account by search criteria")
    public List<SharedAccount> searchSharedAccounts(
            @RequestParam(value = "platform", required = false) String platform,
            @RequestParam(value = "userNickname", required = false) String userNickname) {
        return sharedAccountService.searchSharedAccount(platform, userNickname);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Removes Shared Account by id")
    public void removeSharedAccount(@PathVariable String id) {
        sharedAccountService.removeSharedAccount(id);
    }

    @PatchMapping("{id}/users")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Adds a User to a Shared Account")
    public void addUserToSharedAccount(@PathVariable String id,
                                       @RequestBody SharedAccountUser sharedAccountUser) {
        sharedAccountService.addUserToSharedAccount(id, sharedAccountUser);
    }

    @PatchMapping("{id}/users/{userNickname}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Remove User to a Shared Account")
    public void removeUserToSharedAccount(@PathVariable String id,
                                          @PathVariable String userNickname) {
        sharedAccountService.removeUserToSharedAccount(id, userNickname);
    }

}