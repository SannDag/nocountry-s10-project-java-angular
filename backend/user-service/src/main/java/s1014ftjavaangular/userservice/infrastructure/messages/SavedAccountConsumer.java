package s1014ftjavaangular.userservice.infrastructure.messages;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import s1014ftjavaangular.userservice.domain.models.dto.request.UserSaveMessage;
import s1014ftjavaangular.userservice.domain.usecase.CreateUserUseCase;

@Slf4j
@RequiredArgsConstructor
@Component
public class SavedAccountConsumer implements AcknowledgingMessageListener<String, String> {
    private final CreateUserUseCase useCase;
    private final ObjectMapper objectMapper;


    @Override
    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void onMessage(ConsumerRecord<String, String> consumerRecord, Acknowledgment acknowledgment) {
        //<<<<<<<<
        log.info("Consumer Receives in Microservice Security");
        log.info("Consumer Record	:	{}", consumerRecord.value());

        consumerRecord.value();

        try{
            UserSaveMessage message = objectMapper.readValue(consumerRecord.value(), UserSaveMessage.class);
            useCase.saveUser(message);
        } catch(Exception ex){

        }

        acknowledgment.acknowledge();
    }


}
