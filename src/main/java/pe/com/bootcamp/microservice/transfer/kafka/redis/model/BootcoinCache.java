package pe.com.bootcamp.microservice.transfer.kafka.redis.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pe.com.bootcamp.microservice.transfer.kafka.api.response.BootcoinResponse;

@RedisHash("Assurance")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BootcoinCache implements Serializable {
	private String  id;                // Identificador yanki
    private Integer mobile;            // numero movil
    private Integer documentNumber;    // Dni - Cex - pasaporte
    private String  email;             // Correo personal
    private Double balance;            // Saldo de bootcoin
    private Integer tasa;
    private LocalDate dateStar; 

//  public static BootcoinCache fromAssuranceResponse(BootcoinResponse bootcoin) {
//    return BootcoinCache.builder()
//      .id(bootcoin.getId())
//      .mobile(bootcoin.getMobile())
//      .documentNumber(bootcoin.getDocumentNumber())
//      .email(bootcoin.getEmail())
//      .balance(bootcoin.getBalance())
//      .tasa(bootcoin.getTasa())
//      .dateStar(bootcoin.getDateStar())
//      .build();
//  }
}
