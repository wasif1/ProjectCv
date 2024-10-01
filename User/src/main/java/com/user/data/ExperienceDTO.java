package com.user.data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceDTO {
    private Long id;
    private String employer;
    private String start_date;
    private String end_date;
    private String logo;
    private Long user_id;
}



