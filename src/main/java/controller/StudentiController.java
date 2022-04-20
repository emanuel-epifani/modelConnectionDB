package controller;


import model.Studente;
import org.springframework.web.bind.annotation.*;
import repository.StudenteRepository;

import java.util.ArrayList;

@RestController
@RequestMapping("/studente")
public class StudentiController {

    //estraggo un array di studenti dal db
    @GetMapping("/selezionaStudenti")
    public ArrayList<Studente> getStudents(){
        return StudenteRepository.selectStudenti();
    }

    //inserisco un singolo studente nel db
    @PostMapping("/inserisciStudente")
    public void postStudent(@RequestBody Studente studente){
        StudenteRepository.insertStudenti(studente);
    }

    //modifico uno studente nel db
    @PostMapping("/modificaStudente")
    public void updateStudent(@RequestBody Studente studente){
        StudenteRepository.updateStudente(studente);
    }

    //elimino uno studente dal db
    @PostMapping("/eliminaStudente")
    public void deleteStudent(@RequestBody Studente studente){
        StudenteRepository.deleteStudente(studente);
    }
}
