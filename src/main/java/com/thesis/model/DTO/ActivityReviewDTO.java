package com.thesis.model.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActivityReviewDTO {
    private Integer userId;
    private Integer activityId;
    private Integer stars;
    private String comment;
}
