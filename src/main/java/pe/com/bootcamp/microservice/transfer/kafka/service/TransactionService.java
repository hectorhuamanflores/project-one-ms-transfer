package pe.com.bootcamp.microservice.transfer.kafka.service;

import pe.com.bootcamp.microservice.transfer.kafka.model.TransactionConfirmation;

public interface TransactionService {
  String processTransaction(TransactionConfirmation transaction) throws InterruptedException;
  
}
