package com.tomek.shop.controllers;

import com.tomek.shop.models.Macintosh;
import com.tomek.shop.repositories.MacintoshRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("macintosh")
public class MacintoshController {

    @Autowired
    MacintoshRepository macintoshRepository;

    @GetMapping
    public List<Macintosh> getMacintoshes() {
        return macintoshRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Macintosh> getMacintosh(@PathVariable Long id) {
        return macintoshRepository.findById(id);
    }

    @GetMapping("/many/{ids}")
    public List<Macintosh> getMacintoshesByIds(@PathVariable Set<Long> ids) {
        return macintoshRepository.findAllById(ids);
    }

    @PostMapping
    public Macintosh addMacintosh(@RequestBody Macintosh macintosh) {
        macintoshRepository.save(macintosh);
        return macintosh;
    }

    @PostMapping("/many")
    public List<Macintosh> addMacintoshes(@RequestBody List<Macintosh> macintoshes) {
        macintoshRepository.saveAll(macintoshes);
        return macintoshes;
    }

    @DeleteMapping("{id}")
    public Long deleteMacintosh(@PathVariable Long id) {
        macintoshRepository.deleteById(id);
        return id;
    }

    @DeleteMapping("many/{ids}")
    public Set<Long> deleteMacintoshesByIds(@PathVariable Set<Long> ids) {
        macintoshRepository.deleteAll(macintoshRepository.findAllById(ids));
        return ids;
    }

    @DeleteMapping
    public ArrayList<Macintosh> deleteMacintoshes() {
        macintoshRepository.deleteAll();
        return new ArrayList<>();
    }

}
