package com.project.passwordpolicy.DTO;


import lombok.Data;

@Data
public class PolicyDTO {
    private long id;
    private String policyName;
    private boolean enable;
    private int value;

    // Getters and Setters
}
