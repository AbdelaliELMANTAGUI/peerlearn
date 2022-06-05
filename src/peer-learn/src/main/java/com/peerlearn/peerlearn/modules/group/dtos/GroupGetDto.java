package com.peerlearn.peerlearn.modules.group.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GroupGetDto {
    private Long id;
    private String name;
    private String description;
}
