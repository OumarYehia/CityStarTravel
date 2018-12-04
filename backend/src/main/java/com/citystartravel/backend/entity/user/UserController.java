package com.citystartravel.backend.entity.user;


import com.citystartravel.backend.entity.user.response.UserProfileResponse;
import com.citystartravel.backend.entity.user.response.UserSummaryResponse;
import com.citystartravel.backend.exception.ResourceNotFoundException;
import com.citystartravel.backend.entity.bus.BusRepository;
import com.citystartravel.backend.security.UserPrincipal;
import com.citystartravel.backend.entity.bus.BusService;
import com.citystartravel.backend.security.CurrentUser;
import com.citystartravel.backend.entity.user.response.UserIdentityAvailabilityResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BusRepository busRepository;
    

    @Autowired
    private BusService busService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummaryResponse getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        return new UserSummaryResponse(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailabilityResponse checkUsernameAvailability(@RequestParam(value = "username") String username) {
        Boolean isAvailable = !userRepository.existsByUsername(username);
        return new UserIdentityAvailabilityResponse(isAvailable);
    }

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailabilityResponse checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentityAvailabilityResponse(isAvailable);
    }

    @GetMapping("/users/{username}")
    public UserProfileResponse getUserProfileResponse(@PathVariable(value = "username") String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        UserProfileResponse userProfileResponse = new UserProfileResponse(user.getId(), user.getUsername(), user.getName(), user.getCreatedAt());

        return userProfileResponse;
    }


    /*@GetMapping("/users/{username}/votes")
    public PagedResponse<BusResponse> getBussVotedBy(@PathVariable(value = "username") String username,
                                                       @CurrentUser UserPrincipal currentUser,
                                                       @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                       @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        return busService.getBussVotedBy(username, currentUser, page, size);
    }*/

}