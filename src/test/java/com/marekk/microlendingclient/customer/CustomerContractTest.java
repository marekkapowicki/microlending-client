package com.marekk.microlendingclient.customer;


import com.marekk.microlendingclient.IdResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.junit4.SpringRunner;
import com.marekk.microlendingclient.MicrolendingClientApplication;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MicrolendingClientApplication.class)
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = { "com.marekk:microlending:+8081" })
@IfProfileValue(name = "spring.profiles.active", value = "test")
public class CustomerContractTest {

    @Autowired
    private CustomerClient customerClient;
    @Test
    public void shouldFindClient() {
        //When
        CustomerSnapshot found = customerClient.retrieve("1");
        //Then
        assertThat(found.getEmail()).isEqualTo("marek.kapowicki@gmail.com");
        assertThat(found.getFullName()).isEqualTo("Marek Kapowicki");
        assertThat(found.getIdentityNo()).isEqualTo("1");
    }

    @Test
    public void shouldAddClient() {
        //Given
        CustomerRegisterRequest customerRegisterRequest = new CustomerRegisterRequest("Marek", "Kapowicki", "marek.kapowicki@gmail.com");
        //When
        IdResponse result = customerClient.register(customerRegisterRequest);
        //Then
        assertThat(result.getId()).isEqualTo("123");
    }
}
