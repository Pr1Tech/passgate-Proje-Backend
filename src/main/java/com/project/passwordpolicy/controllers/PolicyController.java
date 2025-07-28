package com.project.passwordpolicy.controllers;

import com.project.passwordpolicy.DTO.LinkDTO;
import com.project.passwordpolicy.DTO.PolicyDTO;
import com.project.passwordpolicy.DTO.RequestDTO;
import com.project.passwordpolicy.DTO.ResponseDTO;
import com.project.passwordpolicy.entities.Link;
import com.project.passwordpolicy.entities.Policy;
import com.project.passwordpolicy.repos.LinkRepository;
import com.project.passwordpolicy.repos.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/policy")
@CrossOrigin(origins = "http://localhost:5173/") // frontend adresine göre ayarla
public class PolicyController {

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private LinkRepository linkRepository;


    @GetMapping("/all")
    public ResponseEntity<ResponseDTO> getAllData() {
        ResponseDTO response = new ResponseDTO();
        response.setPolicies(policyRepository.findAll());
        response.setLinks(linkRepository.findAll());

        return ResponseEntity.ok(response);
    }

    @PutMapping("/change")
    public ResponseEntity<String> updateData(@RequestBody RequestDTO request) {

        // POLICIES
        for (PolicyDTO dto : request.getPolicies()) {
            policyRepository.findById(dto.getId()).ifPresent(policy -> {
                policy.setPolicyName(dto.getPolicyName());
                policy.setEnable(dto.isEnable());
                policy.setValue(dto.getValue());
                policyRepository.save(policy);
            });
        }

        // LINKS
        for (LinkDTO dto : request.getLinks()) {
            linkRepository.findById(dto.getLinkId()).ifPresent(link -> {
                link.setLinkName(dto.getLinkName());
                linkRepository.save(link);
            });
        }

        return ResponseEntity.ok("Ayarlar başarıyla güncellendi.");
    }




    @PostMapping("/save")
    public ResponseEntity<String> saveData(@RequestBody RequestDTO request) {

        // DTO -> Entity dönüştür ve kaydet
        var policyEntities = request.getPolicies().stream().map(dto -> {
            Policy entity = new Policy();
            entity.setPolicyName(dto.getPolicyName());
            entity.setValue(dto.getValue());
            return entity;
        }).collect(Collectors.toList());

        policyRepository.saveAll(policyEntities);

        var linkEntities = request.getLinks().stream().map(dto -> {
            Link entity = new Link();
            entity.setLinkName(dto.getLinkName());
            return entity;
        }).collect(Collectors.toList());

        linkRepository.saveAll(linkEntities);

        return ResponseEntity.ok("Veriler başarıyla kaydedildi.");
    }
}
