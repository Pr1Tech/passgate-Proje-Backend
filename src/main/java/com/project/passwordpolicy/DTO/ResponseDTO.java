package com.project.passwordpolicy.DTO;

import com.project.passwordpolicy.entities.Link;
import com.project.passwordpolicy.entities.Policy;
import lombok.Data;

import java.util.List;

@Data
public class ResponseDTO {
    private List<Policy> policies;
    private List<Link> links;

}
