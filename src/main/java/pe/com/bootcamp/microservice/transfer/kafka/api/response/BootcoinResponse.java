package pe.com.bootcamp.microservice.transfer.kafka.api.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BootcoinResponse {
   
	  private String id;
	  private Double amount;         // cantidad solicitada de compra de bootcoin
	  private String type;           // bootcoin
	  private String paymentMethod;  // transferencia - yanki
	  private String accountYanki;   // numero de cuenta o telefono vendedor
	  private String idBuyer;        // id bootcoin del comprador
	  private String idSeller;       // id bootcoin del vendedor
	  private String status;         // estado de la solicitud:   proceso - terminado

}
