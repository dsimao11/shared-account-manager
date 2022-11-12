package com.dsimao11.sharedaccount.services;

import com.dsimao11.sharedaccount.model.dto.inbound.CreateSharedAccountRequestDto;
import com.dsimao11.sharedaccount.model.dto.inbound.UpdateSharedAccountRequestDto;
import com.dsimao11.sharedaccount.model.dto.outbound.CreateSharedAccountResponseDto;
import com.dsimao11.sharedaccount.model.dto.outbound.FetchSharedAccountResponseDto;
import com.dsimao11.sharedaccount.model.dto.outbound.UpdateSharedAccountResponseDto;
import com.dsimao11.sharedaccount.model.entities.SharedAccount;
import com.dsimao11.sharedaccount.model.entities.SharedAccountUser;
import com.dsimao11.sharedaccount.model.exceptions.SharedAccountNotFoundException;
import com.dsimao11.sharedaccount.model.exceptions.SharedAccountUserNotFoundException;
import com.dsimao11.sharedaccount.model.exceptions.UserAlreadyPresentException;
import com.dsimao11.sharedaccount.repositories.SharedAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SharedAccountService {

    @Autowired
    private SharedAccountRepository sharedAccountRepository;
    @Autowired
    private UserService userService;

    private static void checkDuplicatedSharedAccountUser(String userId, SharedAccount sharedAccount) {
        sharedAccount.getUsers().stream()
                .filter(user -> user.getNickname().equals(userId))
                .findAny()
                .ifPresent(s -> {
                    throw new UserAlreadyPresentException(userId, sharedAccount);
                });
    }

    /* REST API methods */
    public CreateSharedAccountResponseDto createSharedAccount(CreateSharedAccountRequestDto requestDto) {
        SharedAccount sharedAccount = requestDto.toSharedAccount();
        SharedAccount savedSharedAccount = sharedAccountRepository.save(sharedAccount);
        return savedSharedAccount.toCreateSharedAccountResponseDto();
    }

    public FetchSharedAccountResponseDto fetchSharedAccount(String id) {
        return findSharedAccountById(id).toFetchSharedAccountResponseDto();
    }

    public List<SharedAccount> searchSharedAccount(String platform, String userNickname) {
        if (platform != null && userNickname != null) {
            return sharedAccountRepository.findByPlatformAndUsersNickname(platform, userNickname);
        } else if (platform != null) {
            return sharedAccountRepository.findByPlatform(platform);
        } else if (userNickname != null) {
            return sharedAccountRepository.findByUsersNickname(userNickname);
        }
        return sharedAccountRepository.findAll();
    }

    public UpdateSharedAccountResponseDto updateSharedAccount(String id, UpdateSharedAccountRequestDto requestDto) {
        findSharedAccountById(id);
        SharedAccount sharedAccount = requestDto.toSharedAccount();
        sharedAccount.setId(id);
        return sharedAccountRepository.save(sharedAccount).toUpdateSharedAccountResponseDto();
    }

    public void removeSharedAccount(String id) {
        findSharedAccountById(id);
        sharedAccountRepository.deleteById(id);
    }

    public void addUserToSharedAccount(String id, SharedAccountUser sharedAccountUser) {
        userService.findUserByNickname(sharedAccountUser.getNickname());
        SharedAccount sharedAccount = findSharedAccountById(id);
        checkDuplicatedSharedAccountUser(sharedAccountUser.getNickname(), sharedAccount);
        sharedAccount.getUsers().add(sharedAccountUser);
        sharedAccountRepository.save(sharedAccount);
    }

    public void removeUserToSharedAccount(String id, String userNickname) {
        userService.findUserByNickname(userNickname);
        SharedAccount sharedAccount = findSharedAccountById(id);
        boolean removed = sharedAccount.getUsers()
                .removeIf(sharedAccountUser -> sharedAccountUser.getNickname().equals(userNickname));
        if (!removed) throw new SharedAccountUserNotFoundException(userNickname, id);
        sharedAccountRepository.save(sharedAccount);
    }

    public void fetchSharedAccountsByUserNickname(String userNickname) {
        userService.fetchUser(userNickname);

    }

    /* Class auxiliary methods */
    private SharedAccount findSharedAccountById(String id) {
        Optional<SharedAccount> sharedAccountOptional = sharedAccountRepository.findById(id);
        return sharedAccountOptional.orElseThrow(() -> new SharedAccountNotFoundException(id));
    }
}
