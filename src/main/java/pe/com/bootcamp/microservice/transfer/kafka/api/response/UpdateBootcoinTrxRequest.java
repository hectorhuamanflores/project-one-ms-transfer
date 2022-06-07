package pe.com.bootcamp.microservice.transfer.kafka.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateBootcoinTrxRequest {
      
	private String   idBootcoin; // id bootcoin
	private Integer  type;       // type=1=añade   type=-1=quita  bootcoin
	private Double   amount;     // monto de la transaccion de bootcoin
}
