package com.dsimao11.sharedaccount.services;

import com.dsimao11.sharedaccount.model.dto.inbound.CreateUserRequestDto;
import com.dsimao11.sharedaccount.model.dto.inbound.UpdateUserRequestDto;
import com.dsimao11.sharedaccount.model.dto.outbound.CreateUserResponseDto;
import com.dsimao11.sharedaccount.model.dto.outbound.FetchUserResponseDto;
import com.dsimao11.sharedaccount.model.dto.outbound.UpdateUserResponseDto;
import com.dsimao11.sharedaccount.model.entities.SharedAccount;
import com.dsimao11.sharedaccount.model.entities.User;
import com.dsimao11.sharedaccount.model.exceptions.UserCantBeDeletedException;
import com.dsimao11.sharedaccount.model.exceptions.UserDuplicatedException;
import com.dsimao11.sharedaccount.model.exceptions.UserNicknameNotFoundException;
import com.dsimao11.sharedaccount.model.exceptions.UserNotFoundException;
import com.dsimao11.sharedaccount.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SharedAccountService sharedAccountService;

    /* REST API methods */
    public CreateUserResponseDto createUser(CreateUserRequestDto requestDto) {
        checkNicknameDuplicated(requestDto.nickname);
        User user = requestDto.toUser();
        User savedUser = userRepository.save(user);
        return savedUser.toCreateUserResponseDto();
    }

    public FetchUserResponseDto fetchUser(String id) {
        return findUserById(id).toFetchUserResponseDto();
    }

    public List<User> searchSharedAccount(String nickname) {
        if (nickname != null) {
            Optional<User> userOptional = userRepository.findByNickname(nickname);
            if (userOptional.isPresent()) {
                return List.of(findUserByNickname(nickname));
            } else {
                return List.of();
            }
        } else {
            return userRepository.findAll();
        }
    }

    public UpdateUserResponseDto updateUser(String id, UpdateUserRequestDto requestDto) {
        findUserById(id);
        User user = requestDto.toUser();
        user.setId(id);
        return userRepository.save(user).toUpdateUserResponseDto();
    }

    public void removeUser(String nickname) {
        User user = findUserByNickname(nickname);
        checkUserInSharedAccounts(user);
        userRepository.deleteById(user.getId());
    }

    /* Class auxiliary methods */
    public User findUserById(String id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElseThrow(() -> new UserNotFoundException(id));
    }

    public User findUserByNickname(String nickname) {
        Optional<User> userOptional = userRepository.findByNickname(nickname);
        return userOptional.orElseThrow(() -> new UserNicknameNotFoundException(nickname));
    }

    private void checkNicknameDuplicated(String nickname) {
        userRepository.findByNickname(nickname)
                .ifPresent(s -> {
                    throw new UserDuplicatedException(nickname);
                });
    }

    private void checkUserInSharedAccounts(User user) {
        List<SharedAccount> sharedAccounts = sharedAccountService.searchSharedAccount(null, user.getNickname());
        if (!sharedAccounts.isEmpty()) throw new UserCantBeDeletedException(user.getNickname(), sharedAccounts);
    }
}
