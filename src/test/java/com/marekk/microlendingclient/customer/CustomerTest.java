package com.marekk.microlendingclient.customer;

import com.marekk.microlendingclient.IdResponse;
import com.marekk.microlendingclient.MicrolendingClientApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MicrolendingClientApplication.class)
@IfProfileValue(name = "spring.profiles.active", value = "production")
public class CustomerTest {

    @Autowired
    private CustomerClient customerClient;

    private String createdId;

    @Before
    public void setUp() throws Exception {
        IdResponse found = customerClient.register(Customers.marek);
        createdId = found.getId();
    }

    @Test
    public void shouldFindById() {
        //When
        CustomerSnapshot marek = customerClient.retrieve(createdId);
        //Then
        assertThat(marek.getEmail()).isEqualTo("marek.kapowicki@gmail.com");

    }
}
