package pl.marekk.microlendingclient.customer;

import io.specto.hoverfly.junit.core.SimulationSource;
import io.specto.hoverfly.junit.rule.HoverflyRule;
import org.junit.ClassRule;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;

import static io.specto.hoverfly.junit.core.SimulationSource.dsl;
import static io.specto.hoverfly.junit.dsl.HoverflyDsl.service;
import static io.specto.hoverfly.junit.dsl.HttpBodyConverter.jsonWithSingleQuotes;
import static io.specto.hoverfly.junit.dsl.ResponseCreators.success;
import static org.junit.Assert.assertEquals;

public class HoverflyApiIntegrationTest {

    private static final SimulationSource source = dsl(service("http://www.tix.com")
            .get("/api/courses/1")
            .willReturn(success().body(jsonWithSingleQuotes("{'id':'1','name':'HCI'}"))));

    @ClassRule
    public static final HoverflyRule rule = HoverflyRule.inSimulationMode(source);
    private final RestTemplate restTemplate = new RestTemplate();

    @Test
    public void givenGetCourseById_whenRequestSimulated_thenAPICalledSuccessfully() throws URISyntaxException {
        final ResponseEntity<String> courseResponse = restTemplate.getForEntity("http://www.tix.com/api/courses/1", String.class);

        assertEquals(HttpStatus.OK, courseResponse.getStatusCode());
        assertEquals("{\"id\":\"1\",\"name\":\"HCI\"}", courseResponse.getBody());
    }


}