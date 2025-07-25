package com.thesis.model.DTO;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DestinationDTO {
    private int id;
    private String name;
    private String description;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String img_path;
}
