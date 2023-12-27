package in.ineuron.bo;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class CoronaVaccine implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long regNo;
	
	@NonNull
	private String name;
	
	@NonNull
	private String company;
	
	@NonNull
	private String country;
	
	@NonNull
	private Double price;
	
	@NonNull
	private Integer requiredDoseCount;
	
	
	
}
