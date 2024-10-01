package com.user.data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String location;
    private String image;
    private String position;
    private String description;
    private String number;

    private ExperienceDTO[] experiences;
}



