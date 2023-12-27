package in.ineuron;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.service.CoronaVaccineMgmtServiceImpl;
import in.ineuron.service.ICoronaVaccineMgmtService;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(Application.class, args);
		ICoronaVaccineMgmtService service = factory.getBean(CoronaVaccineMgmtServiceImpl.class);
		
		//Fetch multiple vaccines::
		/*
		 * service.fetchvaccinesByCompany("Bharat-Biotech").forEach(System.out::println);
		 */
		
		
		
		/*
		 * List<CoronaVaccine> companies =
		 * service.fetchVaccinesByMultipleCompanies("Bharat-Biotech", "Serum");
		 * companies.forEach(System.out::println); System.out.println();
		 * 
		 * 
		 * 
		 * List<String> result = service.fetchVaccinesByPriceRange(400.0, 500.0);
		 * result.forEach(vacc -> { System.out.print(vacc); }); System.out.println();
		 * 
		 * 
		 * 
		 * 
		 * List<Object[]> vaccines = service.fetchVaccinesByName("Covaxin", "Covovax");
		 * vaccines.forEach(vacc -> { for (Object obj : vacc) { System.out.print(obj +
		 * " "); } System.out.println(); }); System.out.println();
		 */
		
		
		int rowAffected = service.modifyingPrice(800.0, "USA");
		System.out.println(rowAffected);
		
		int rowAffec = service.removeVaccinesByPrice(500.0, 1000.0);
		System.out.println("The Number of Vaccines deleted are: " + rowAffec);
		
		
		((ConfigurableApplicationContext) factory).close();
	}

}
