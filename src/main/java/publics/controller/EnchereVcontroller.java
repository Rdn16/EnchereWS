package publics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import publics.model.EnchereV;
import publics.repository.EnchereVRepository;
import publics.service.Data;
import publics.service.EnchereVservice;

@CrossOrigin("*")
@RestController
@RequestMapping("/enchereV")
public class EnchereVcontroller {

    @Autowired
    private EnchereVRepository enchV;

    @PostMapping
    public Object AddEnchere(@RequestBody EnchereV ench) {
        try {
            return new Data(enchV.save(ench));
        } catch (Exception e) {
            return new Error(e);
        }
    }
}
