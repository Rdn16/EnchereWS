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

@RestController
@CrossOrigin("*")
@RequestMapping("/encheresEnCours")

public class EnchereEnCoursController{
    @Autowired
    private EnchereRepository enchereRepository;
    @GetMapping
    public Object getAll(){
        try{
            return new Data( enchereRepository.nonVendue());
        }catch(Exception e){
            return new Error(e);
        }
    }
    @GetMapping("{idenchere}")
    public Object getHistoriqueByUSer(@PathVariable int idenchere){
        try{
            return new Data(enchereRepository.byIdEnCours(idenchere));
        }catch(Exception e){
            return new Error(e);
        }

    }
}
