
import Data.Asmenys;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        boolean tikrinti = true;
        Main main=new Main();
        File file =new File("Pirmas.json");
        if (!file.exists()){
            file.createNewFile();
            List<Asmenys> nuskaitymoSarasas= new ArrayList<>();
        }

        List<Asmenys> nuskaitymoSarasas=mapper.readValue(file, new TypeReference<>() {
        });
        while (tikrinti){
            System.out.println("Pasirinkite norimą komanda:");
            System.out.println("1-Registruotis");
            System.out.println("2-Atspausdinti visus vartotojus");
            System.out.println("0-Išeiti");
            String check=main.sc.nextLine();
            switch (check){
                case "1":
                    nuskaitymoSarasas.add(main.asmuo());break;
                case "2":main.spausdinti(nuskaitymoSarasas);break;
                case "0": tikrinti=false;break;
            }
        }
        mapper.writeValue(file,nuskaitymoSarasas);
    }
    private Asmenys asmuo (){
        System.out.println("Iveskite varda");
        String vardas=sc.nextLine();
        System.out.println("Iveskite pavarde");
        String pavarde = sc.nextLine();
        System.out.println("Iveskite asmens koda");
        String asmensKodas=sc.nextLine();
        Asmenys asmuo =new Asmenys(vardas,pavarde,asmensKodas);
        return asmuo;
    }
    private void spausdinti(List<Asmenys> sarasas){
        sarasas.forEach(System.out::println);
    }
    private void tikrintiVienoduma(List<Asmenys> asmenuSarasas,Asmenys asmuo) throws Exception {
       if(asmenuSarasas.stream().filter(v->v.getAsmensKodas().equals(asmuo.getAsmensKodas())).findAny().isPresent()){
        throw new Exception("Asmesns kodas egzistuoja");
       }
    }


}
