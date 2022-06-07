package pe.com.bootcamp.microservice.transfer.kafka.config;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class Util {
  public static ObjectMapper OBJECT_MAPPER = new ObjectMapper();
  public static String DRAFT_TRANSACTION = "D";
}
