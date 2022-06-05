package com.peerlearn.peerlearn.modules.group.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GroupCreateDto {
    @NotBlank(message = "You must provide a name for a group")
    private String name;
    @NotNull(message = "You must provide a description")
    @Length(min = 4,max=255,message = "Description must be between 4 and 255 character")
    private String description;
}
