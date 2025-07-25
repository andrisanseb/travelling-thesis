package com.thesis.model.DTO;

import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
public class CountryDTO {
    private int id;
    private String name;
    private String img_path;
}
