@RestController
@RequestMapping("/me")
@RequiredArgsConstructor
public class UserController {

    private final UserProfileService userProfileService;

    @GetMapping
    public ResponseEntity<UserProfileResponse> getMyProfile(@AuthenticationPrincipal CustomUserDetails userDetails) {
        UserProfileResponse response = userProfileService.getProfile(userDetails.getId());
        return ResponseEntity.ok(response);
    }
}

@PatchMapping
public ResponseEntity<UserProfileResponse> updateMyProfile(
        @AuthenticationPrincipal CustomUserDetails userDetails,
        @RequestBody @Valid UserProfileUpdateRequest request
) {
    UserProfileResponse response = userProfileService.updateProfile(userDetails.getId(), request);
    return ResponseEntity.ok(response);
}
