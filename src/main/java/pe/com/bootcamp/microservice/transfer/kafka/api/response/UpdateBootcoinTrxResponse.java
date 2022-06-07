package pe.com.bootcamp.microservice.transfer.kafka.api.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBootcoinTrxResponse {
  
	private String  id;                // Identificador bootcoin
    private Integer mobile;            // numero movil
    private Integer documentNumber;    // Dni - Cex - pasaporte
    private String  email;             // Correo personal
    private Double balance;            // Saldo de bootcoin
    private LocalDate     dateStar;    // Fecha de creacion de la cuenta yanki
}
