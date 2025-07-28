package com.project.passwordpolicy.DTO;

import lombok.Data;

import java.util.List;

@Data
public class RequestDTO {
    private List<PolicyDTO> policies;
    private List<LinkDTO> links;

    // Getters and Setters
}
