package publics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import publics.model.DemandeCredit;
import publics.repository.DemandeCreditRepository;
import publics.service.Data;


@CrossOrigin("*")
@RestController
@RequestMapping("/demandes")
public class DemandeCreditController {
    @Autowired
    private DemandeCreditRepository demandeRepository;


    @GetMapping
    public Object getAllDemandeCredit(){
        try{
            return new Data( demandeRepository.findAll());
        }catch(Exception e){
            return new Error(e);
        }
    }

    @PostMapping
    public Object createDemandeCredit(@RequestBody DemandeCredit demande) {
        try{
            return new Data(demandeRepository.save(demande));
        }catch(Exception e){
            return new Error(e);
        }
    }

}
