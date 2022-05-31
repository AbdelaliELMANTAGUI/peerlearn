package com.peerlearn.peerlearn.modules.user.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ToString
@Data
@NoArgsConstructor
public class UserSignupDto {
    @Email(message = "Email should be a valid format")
    @NotNull(message = "You must provide an email")
    private String email;
    @NotNull(message = "You must provide an firstname")
    @NotBlank(message = "Firstname can not be empty")
    private String firstname;
    @NotNull(message = "You must provide an lastname")
    @NotBlank(message = "Lastname can not be empty")
    private String lastname;
    @NotNull(message = "You must provide an password")
    @Length(min = 4,max = 64 , message = "Password must have between 4 and 64 characters")
    private String password;
}
