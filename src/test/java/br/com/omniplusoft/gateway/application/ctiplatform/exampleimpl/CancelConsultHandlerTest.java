package br.com.omniplusoft.gateway.application.ctiplatform.exampleimpl;

import br.com.omniplusoft.gateway.CtiPlatformApplication;
import br.com.omniplusoft.gateway.domain.ctiplatform.CTIEventHandler;
import br.com.omniplusoft.gateway.domain.ctiplatform.event.CancelConsultEvent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hermeswaldemarin on 14/12/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CtiPlatformApplication.class)
public class CancelConsultHandlerTest {

    CancelConsultEvent event;
    private boolean called;

    @Autowired
    private CTIEventHandler handler;

    @Before
    public void init(){

        event = Mockito.mock(CancelConsultEvent.class);

        Mockito.doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                called = true;
                return null;
            }
        }).when(event).getArguments();


    }

    @Test
    public void shouldReceiveALoginEvent(){

        handler.dispatch(event);

        Assert.assertTrue(called);

    }

}
