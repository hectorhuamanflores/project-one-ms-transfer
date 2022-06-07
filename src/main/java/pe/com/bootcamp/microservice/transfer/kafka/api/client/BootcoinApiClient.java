package pe.com.bootcamp.microservice.transfer.kafka.api.client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.com.bootcamp.microservice.transfer.kafka.api.response.BootcoinResponse;
import pe.com.bootcamp.microservice.transfer.kafka.config.BootcoinApiProperties;
import reactor.core.scheduler.Schedulers;

@Slf4j
@Component
@RequiredArgsConstructor
public class BootcoinApiClient {
  private final WebClient webClient;
  private final BootcoinApiProperties bootcoinApiProperties;

  public BootcoinResponse getBootcoinResponseList(String id) throws InterruptedException {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    List<BootcoinResponse> result = new ArrayList<>();
    webClient.get().uri(bootcoinApiProperties.getBaseUrl() + "/orderPurchase/"+id)
      .accept(MediaType.TEXT_EVENT_STREAM)
      .retrieve()
      .bodyToFlux(BootcoinResponse.class)
      .publishOn(Schedulers.fromExecutor(executor))
      .subscribe(assuranceResponse -> result.add(assuranceResponse));

    executor.awaitTermination(1, TimeUnit.SECONDS);
    log.info("Solicitud de compra: " + result);
    return result.get(0);
  }
}
