package pe.com.bootcamp.microservice.transfer.kafka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;
import pe.com.bootcamp.microservice.transfer.kafka.config.Util;
import pe.com.bootcamp.microservice.transfer.kafka.model.TransactionConfirmation;
import pe.com.bootcamp.microservice.transfer.kafka.service.TransactionService;

@Component
@Slf4j
public class KafkaConsumer {

  @Autowired
  private TransactionService transactionService;
  
  @KafkaListener(topics = "${kafka.subscribed-topic.name-confirmation}")
  public void consumeEventConfirmation(String message) throws JsonProcessingException, InterruptedException {
	  TransactionConfirmation transaction = Util.OBJECT_MAPPER.readValue(message, TransactionConfirmation.class);
    log.info("Message received " + message);
    transactionService.processTransaction(transaction);
  }
}
