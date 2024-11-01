package com.tech.bikemember.controller;

import com.tech.bikemember.exception.ResourceNotFoundException;
import com.tech.bikemember.model.BikeMember;
import com.tech.bikemember.repository.BikeMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/bikemembers")
public class BikeMemberController {
    @Autowired
    private BikeMemberRepository bikeMemberRepository;

    @GetMapping
    public List<BikeMember> getAllBikeMembers(){
        System.out.print("getAllBikeMembers");
        return bikeMemberRepository.findAll();
    }
    @PostMapping
    public BikeMember createBikeMembers(@RequestBody BikeMember bikeMember){
        System.out.print("createBikeMembers");
        return bikeMemberRepository.save(bikeMember);
    }
    @GetMapping("{id}")
    public ResponseEntity<BikeMember> getBikeMemberById(@PathVariable long id){
        System.out.print("getBikeMemberById");
        BikeMember bikeMember=bikeMemberRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Bikemember not exist with id : "+id));

        return ResponseEntity.ok(bikeMember);
    }
    @PutMapping("{id}")
    public ResponseEntity<BikeMember> updateBikeMember(@PathVariable long id,@RequestBody BikeMember bikeMember){
        System.out.print("updateBikeMember>>>>>>>>>>>>");
        BikeMember updateBikeMember=bikeMemberRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Bikemember not exist with id : "+id));

        //update
        updateBikeMember.setFirstName(bikeMember.getFirstName());
        updateBikeMember.setLastName(bikeMember.getLastName());
        updateBikeMember.setEmailId(bikeMember.getEmailId());

        bikeMemberRepository.save(updateBikeMember);

        return ResponseEntity.ok(updateBikeMember);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteBikeMember(@PathVariable long id){
        System.out.print("deleteBikeMember");
        BikeMember bikeMember=bikeMemberRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Bikemember not exist with id : "+id));
        bikeMemberRepository.delete(bikeMember);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
