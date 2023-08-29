package s1014ftjavaangular.loan.infrastructure.messages;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import s1014ftjavaangular.loan.domain.model.dtos.ApplicationLoanMessage;
import s1014ftjavaangular.loan.domain.usecase.CreateLoanUseCase;

@Slf4j
@RequiredArgsConstructor
@Component
public class LoanApplicationApproved implements AcknowledgingMessageListener<String, String> {
    private final CreateLoanUseCase useCase;
    private final ObjectMapper objectMapper;

    @Override
    @KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void onMessage(ConsumerRecord<String, String> consumerRecord, Acknowledgment acknowledgment) {
        //
        log.info("Consumer Receives in Microservice Security");
        log.info("Consumer Record	:	{}", consumerRecord.value());

        consumerRecord.value();

        try{
            var message = objectMapper.readValue(consumerRecord.value(), ApplicationLoanMessage.class);
            useCase.createLoan(message);
        } catch(Exception ex){
            log.error("Exception message: {}", ex);
        }

        acknowledgment.acknowledge();
    }
}

