package com.merveadler.manager;

import com.merveadler.dto.request.ToAuthPasswordChangeDto;
import com.merveadler.dto.request.UpdateEmailOrUsernameRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(url = "http://localhost:8090/api/v1/auth", name = "userprofile-auth",decode404 = true)
public interface IAuthManager {
    @PutMapping("/update-username-email")
    public ResponseEntity<Boolean> updateUsernameOrEmail(@RequestBody UpdateEmailOrUsernameRequestDto dto);

    @GetMapping("/find-by-role/{role}")
    public ResponseEntity<List<Long>> findByRole(@RequestHeader(value = "Authorization")String token, @PathVariable String role);

    @PutMapping("/change-password")
    public ResponseEntity<Boolean> changePassword(@RequestBody ToAuthPasswordChangeDto dto);
}
