package com.user.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skills {

    private Long id;
    private String name;
    private String description;
    private String image;
    private Long user_id;
}
