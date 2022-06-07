package pe.com.bootcamp.microservice.transfer.kafka.service;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.com.bootcamp.microservice.transfer.dto.AccountUpdateForTrxRequest;
import pe.com.bootcamp.microservice.transfer.dto.AccountUpdateForTrxResponse;
import pe.com.bootcamp.microservice.transfer.kafka.api.client.BootcoinApiClient;
import pe.com.bootcamp.microservice.transfer.kafka.api.response.BootcoinResponse;
import pe.com.bootcamp.microservice.transfer.kafka.api.response.UpdateBootcoinTrxRequest;
import pe.com.bootcamp.microservice.transfer.kafka.api.response.UpdateBootcoinTrxResponse;
import pe.com.bootcamp.microservice.transfer.kafka.model.TransactionConfirmation;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
  //private final BootcoinService bootcoinService;
  private final BootcoinApiClient bootcoinApiClient;
  
  @Autowired
  private  WebClient.Builder builder;
  
  public Function<UpdateBootcoinTrxRequest, Mono<UpdateBootcoinTrxResponse>> msBootcoinUpdateTrx = (objeto) -> builder
		      .baseUrl("http://ms-bootcoin")
		      .build().put()
			.uri("/bootcoin/updateBootcoinTrx/")
			.body(Mono.just(objeto), UpdateBootcoinTrxResponse.class)
			.retrieve()
			.bodyToMono(UpdateBootcoinTrxResponse.class);
  
  @Override 
  public String processTransaction(TransactionConfirmation transaction) throws InterruptedException {
	  if(transaction.getStatus().equals("aprobado")) {
	     //validated
		  BootcoinResponse a = bootcoinApiClient.getBootcoinResponseList(transaction.getIdOrder());
		  if(a.getAmount().equals(transaction.getAmountRequest())) {
			   if(a.getPaymentMethod().equals(transaction.getPaymentMethod())) {
				   if(a.getAccountYanki().equals(transaction.getAccountYanki())) {
					   UpdateBootcoinTrxRequest bootcoinUpdateBuyer = UpdateBootcoinTrxRequest.builder()
							.idBootcoin(transaction.getIdBuyer())
							.type(-1)
							.amount(transaction.getAmountRequest())
							.build();

					   UpdateBootcoinTrxRequest bootcoinUpdateSeller = UpdateBootcoinTrxRequest.builder()
						    .idBootcoin(transaction.getIdSeller())
							.type(1)
							.amount(transaction.getAmountRequest())
							.build();  
					 
				      msBootcoinUpdateTrx.apply(bootcoinUpdateBuyer);
				      msBootcoinUpdateTrx.apply(bootcoinUpdateSeller);  
				      
				      return "Transaccion existosa"; 
				      
				   }else{return "Numero de cuenta de transaccion no coniciden";}
			   }else {return "Metodo de pago no coinciden";}
		  }else {return "Monto de transferencia del comprador y vendedor son diferentes";}
	  }else {return "Transferencia desaprobada";}
	
  }
}
