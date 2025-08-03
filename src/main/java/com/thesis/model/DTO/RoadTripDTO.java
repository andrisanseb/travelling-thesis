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
    private String route;
    private String days;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
