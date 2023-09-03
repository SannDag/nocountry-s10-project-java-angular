package s1014ftjavaangular.loan.domain.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.MockitoAnnotations;
import s1014ftjavaangular.loan.domain.services.AmortizationService;
import s1014ftjavaangular.loan.domain.services.SimpleInterestStrategy;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AmortizationServiceTest {

    @InjectMocks
    private AmortizationService amortizationService;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void when_interest_is_simple(){
        Mockito.doNothing().when(amortizationService).setStrategy(new SimpleInterestStrategy());

    }
}
