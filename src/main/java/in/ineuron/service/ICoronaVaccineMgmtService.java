package in.ineuron.service;
import java.util.List;
import in.ineuron.bo.CoronaVaccine;


public interface ICoronaVaccineMgmtService {
	public List<CoronaVaccine> fetchvaccinesByCompany(String company);
	public List<CoronaVaccine> fetchVaccinesByMultipleCompanies(String name1, String name2);
	public List<String> fetchVaccinesByPriceRange(double min, double max);
	public List<Object[]> fetchVaccinesByName(String name1, String name2);
	public int modifyingPrice(double newPrice, String country);
	public int removeVaccinesByPrice(double min, double max);
}

