package com.java.bolo_tematico.controller;

import com.java.bolo_tematico.model.Bolo;
import com.java.bolo_tematico.repository.BoloRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bolos")
public class BoloController {

    @Autowired
    private BoloRepository boloRepo;

    @GetMapping("/list")
    public List<Bolo> list(HttpSession session) {
        return boloRepo.findAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Bolo bolo) {
        boloRepo.save(bolo);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody Bolo bolo) { boloRepo.save(bolo); }

    @GetMapping("{id}")
    public Bolo findById(@PathVariable Long id) { return boloRepo.findById(id).get(); }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) { boloRepo.deleteById(id); }
}
