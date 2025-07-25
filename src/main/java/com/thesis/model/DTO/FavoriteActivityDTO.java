package com.thesis.model.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FavoriteActivityDTO {
    private Integer userId;
    private Integer activityId;
}
