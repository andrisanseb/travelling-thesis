package com.thesis.model.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ActivityDTO {
    private int id;
    private String name;
    private String description;
    private int cost;
    private String category;
    private Integer duration;
    private Integer destinationId;
    private Integer createdByUserId;
    private LocalDateTime createdAt;
}
