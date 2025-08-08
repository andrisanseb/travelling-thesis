package com.thesis.model.DTO;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DestinationDTO {
    private int id;
    private String name;
    private String description;
    private String img_path;
    private CountryDTO country;
    private List<ActivityDTO> activities;
}
