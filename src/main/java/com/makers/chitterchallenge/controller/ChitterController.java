package com.makers.chitterchallenge.controller;

import com.makers.chitterchallenge.model.Chitter;
import com.makers.chitterchallenge.repository.ChitterRepository;
import com.makers.chitterchallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping
public class ChitterController {

    @Autowired
    private ChitterRepository chitterRepository;




//@GetMapping(path="/api/chitters")
//public List<Chitter> retrieveAllChitters() {
//    return chitterRepository.findAll();
//}
//public @ResponseBody Iterable<Chitter> getAll() {
//    // This returns a JSON or XML with the users
//    return chitterRepository.findAll();
//}

    @GetMapping("/api/chitters")
    public List<Chitter> getAllChitters(){
        List<Chitter> chitters = new ArrayList<>();
        chitterRepository.findAll().forEach(chitters::add);
        return chitters;
    }

    @PostMapping("/api/chitters")
    public Chitter Chitter(@Valid @RequestBody Chitter chitter) {
        return chitterRepository.save(chitter);
    }

    @DeleteMapping("/api/chitters/{id}")
    public void deleteChitter(@PathVariable long id) {
        chitterRepository.deleteById(id);
    }

    @PutMapping("/api/chitters/{id}")
    public ResponseEntity<Object> updateChitter(@RequestBody Chitter chitter, @PathVariable long id) {

        Optional<Chitter> chitterOptional = chitterRepository.findById(id);

        if (!chitterOptional.isPresent())
            return ResponseEntity.notFound().build();

        chitter.setChitter_id(id);

        chitterRepository.save(chitter);

        return ResponseEntity.noContent().build();
    }

}