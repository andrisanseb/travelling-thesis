package com.thesis.model.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class RoadTripDTO {
    private int id;
    private String name;
    private Integer userId;
    private String details; // TODO: replaces route, day
    private String route;   // TODO: Will be removed
    private String days;    // TODO: Will be removed
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
