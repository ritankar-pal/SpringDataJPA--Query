package in.ineuron.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;
import jakarta.transaction.Transactional;


@Service("service")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo repo;

	
	@Override
	public List<CoronaVaccine> fetchvaccinesByCompany(String company) {
		return repo.searchVaccinesByCompany(company);
	}


	@Override
	public List<CoronaVaccine> fetchVaccinesByMultipleCompanies(String name1, String name2) {
		return repo.searchVaccinesByCompanies(name1, name2);
	}

	@Override
	public List<String> fetchVaccinesByPriceRange(double min, double max) {
		return repo.searchVaccinesByPriceRange(min, max);
	}


	@Override
	public List<Object[]> fetchVaccinesByName(String name1, String name2) {
		return repo.searchVaccinesByName(name1, name2);
	}

	
	@Transactional
	@Override
	public int modifyingPrice(double newPrice, String country) {
		return repo.updatePriceByCountry(newPrice, country);
	}


	@Override
	public int removeVaccinesByPrice(double min, double max) {
		return repo.deleteVaccineByPrice(min, max);
	}
	
}
