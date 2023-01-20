package publics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import publics.model.*;
import publics.service.*;
import publics.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.Error;

@CrossOrigin("*")
@RestController
@RequestMapping("/encheres")

public class EnchereController {
    @Autowired
    private EnchereRepository enchereRepository;
    @GetMapping
    public Object getAll(){
        try{
            return new Data( enchereRepository.findAll());
        }catch(Exception e){
            return new Error(e);
        }
    }
    @GetMapping("{idenchere}")
    public Object getHistoriqueByUSer(@PathVariable int idenchere){
        try{
            return new Data(enchereRepository.byId(idenchere));
        }catch(Exception e){
            return new Error(e);
        }

    }
    @PostMapping(value = "/ajout")
    public Object create(@RequestBody Enchere enchere) {
        try {
            return new Data(enchereRepository.save(enchere));
        } catch (Exception e) {
            return new Error(e);
        }
    }
}
