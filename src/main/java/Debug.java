import modelconnectiondb.model.Studente;
import modelconnectiondb.repository.StudenteRepository;

public class Debug {


    public static void main(String[] args) {

        //Read
        System.out.println("\n\n\n\n----------SELECT-----------");
        System.out.println(StudenteRepository.selectStudenti());

        //Insert
        System.out.println("\n\n\n\n----------INSERT-----------");
        Studente s1= new Studente("Mario","Gialli", "Maschio");
        StudenteRepository.insertStudenti(s1);
        System.out.println(StudenteRepository.selectStudenti());//x vedere se inserito

        //Delete
        System.out.println("\n\n\n\n----------DELETE-----------");
        StudenteRepository.deleteStudente(s1);
        System.out.println(StudenteRepository.selectStudenti());//x vedere se eliminato

        //Update
        System.out.println("\n\n\n\n----------UPDATE-----------");
        Studente s2= new Studente("Giggio","Papparonzi", "Maschio");
        StudenteRepository.updateStudente(s2);
        System.out.println(StudenteRepository.selectStudenti());//x vedere se modificato


    }
}
