package api.builders;

import api.dto.request.UserDto;

public class UserBuilders {

    public UserDto userDefaultBuilder() {
        return UserDto.builder()
                .userName("user13")
                .password("12345678Qa!")
                .build();
    }
}
