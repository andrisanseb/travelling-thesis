package com.thesis.model.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

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
}
