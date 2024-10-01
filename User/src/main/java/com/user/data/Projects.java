package com.user.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Projects {

    private Long id;
    private String name;
    private String description;
    private String image;
    private String source_url;
    private Long user_id;
}
