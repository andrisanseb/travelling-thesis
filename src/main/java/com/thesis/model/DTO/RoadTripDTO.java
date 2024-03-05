package com.thesis.model.DTO;

import java.util.List;

public class RoadTripDTO {
    private int id;
    private String name;
    private String description;
    private List<Integer> destination_ids_ordered;
    private List<Integer> activity_ids_list;
}
