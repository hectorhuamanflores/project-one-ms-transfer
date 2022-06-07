package pe.com.bootcamp.microservice.transfer.kafka.model;

import lombok.*;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class TransactionConfirmation implements Serializable {
  private String id;
  private String idOrder;        // id del pedido de compra
  private String idBuyer;        // id bootcoin del comprador
  private String idSeller;       // id bootcoin del vendedor
  private String status;         // aprobado - desaprobado por el vendedor
  private String paymentMethod;  // transferencia - yanki
  private String accountYanki;   // numero de cuenta o telefono del vendedor
  private Double amountRequest;  // cantidad solicitada por el comprador - x bootcoin
  
}
