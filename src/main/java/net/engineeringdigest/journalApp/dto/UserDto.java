package net.engineeringdigest.journalApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotNull
    private String userName;
    private String email;
    private boolean sentimentAnalysis;

    @NonNull
    private String password;

}
