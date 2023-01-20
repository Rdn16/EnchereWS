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
import java.util.ArrayList;

@CrossOrigin("*")
@RestController
@RequestMapping("/recherches")

public class RechercheController {
    @Autowired
    private EnchereRepository repo;
    @GetMapping
    public Object getAll(Recherche recherche){
        try{
            return new Data( recherche.search(new ArrayList<>(repo.findAll())));
        }catch(Exception e){
            return new Error(e);
        }
    }

}
