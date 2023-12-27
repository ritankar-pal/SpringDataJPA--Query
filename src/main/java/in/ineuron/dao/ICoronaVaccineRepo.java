package in.ineuron.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.ineuron.bo.CoronaVaccine;
import jakarta.transaction.Transactional;


public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {	
	
	@Query("from in.ineuron.bo.CoronaVaccine where company = :comp")  //binding 'comp' and 'vendor' but if the names prammatches 
	//then no need to bind
	public List<CoronaVaccine> searchVaccinesByCompany(@Param("comp") String vendor);
	
	@Query("from in.ineuron.bo.CoronaVaccine where company in (:name1, :name2)")
	public List<CoronaVaccine> searchVaccinesByCompanies(String name1, String name2);
	
	@Query("select name from in.ineuron.bo.CoronaVaccine where price between :min and :max")
	public List<String> searchVaccinesByPriceRange(double min, double max);
	
	@Query("select name, company, price from in.ineuron.bo.CoronaVaccine where name in (:name1, :name2)")
	public List<Object[]> searchVaccinesByName(String name1, String name2);
	
	@Modifying
	@Query("update in.ineuron.bo.CoronaVaccine set price = :newPrice where country = :country")
	public int updatePriceByCountry(double newPrice, String country);
	
	
	@Transactional   //Since we have used @Transactional here so not required in service method::
	@Modifying
	@Query("delete from in.ineuron.bo.CoronaVaccine where price between :min and :max")
	public int deleteVaccineByPrice(double min, double max);
}
