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

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) { boloRepo.deleteById(id); }
}
