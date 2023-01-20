package publics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import publics.model.Historique;
import publics.repository.HistoriqueRepository;
import publics.service.Data;

@CrossOrigin("*")
@RestController
@RequestMapping("/historiques")
public class HistoriqueController {
    @Autowired
    private HistoriqueRepository historique;

    @GetMapping
    public Object getAll(){
        try{
            return new Data( historique.findAll());
        }catch(Exception e){
            return new Error(e);
        }
    }
    @GetMapping("{iduser}")
    public Object getHistoriqueByUSer(@PathVariable int iduser){
        try{
            return new Data(historique.historiqueEncherebyUser(iduser));
        }catch(Exception e){
            return new Error(e);
        }

    }
    @PostMapping
    public Object saveHistorique(@RequestBody Historique h) {
        try {
            Boolean prix = Historique.checkPrix(h, historique.findAll());
            if (prix == false) {
                return new Error("valeur inférieur à la normale");
            }
            return new Data(historique.save(h));
        } catch (Exception e) {
            return new Error(e);
        }
    }
}
