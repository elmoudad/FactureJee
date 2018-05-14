package madwols;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import madwols.dao.FactureRepository;
import madwols.entities.Facture;

@SpringBootApplication
public class MadwolsApplication {

	public static void main(String[] args) {
		ApplicationContext apx= SpringApplication.run(MadwolsApplication.class, args);
		FactureRepository factureRepository = apx.getBean(FactureRepository.class);
		factureRepository.save(new Facture(Date.valueOf(LocalDate.now()),120.12,"madwols","false"));
		factureRepository.save(new Facture(Date.valueOf(LocalDate.now()),120.12,"madwols12","true"));
		factureRepository.save(new Facture(Date.valueOf(LocalDate.now()),120.12,"madwols12","false"));
		factureRepository.save(new Facture(Date.valueOf(LocalDate.now()),120.12,"madwols","true"));
		factureRepository.save(new Facture(Date.valueOf(LocalDate.now()),120.12,"madwols","false"));
		
		factureRepository.findAll().forEach(f->System.out.println(f.getNumero()+" "+f.getNomSoc()));
	}
}
