package com.user.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reviews {
    private Long id;
    private String name;
    private String position;
    private String employer;
    private String review;
    private String image;
    private Long user_id;
}
