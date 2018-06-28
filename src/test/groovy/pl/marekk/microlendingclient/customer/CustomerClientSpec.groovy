package pl.marekk.microlendingclient.customer

import io.specto.hoverfly.junit.core.SimulationSource
import io.specto.hoverfly.junit.rule.HoverflyRule
import org.junit.ClassRule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import pl.marekk.microlendingclient.BaseConfig

import static io.specto.hoverfly.junit.core.SimulationSource.dsl
import static io.specto.hoverfly.junit.dsl.HoverflyDsl.service
import static io.specto.hoverfly.junit.dsl.HttpBodyConverter.jsonWithSingleQuotes
import static io.specto.hoverfly.junit.dsl.ResponseCreators.success
import static io.specto.hoverfly.junit.rule.HoverflyRule.inSimulationMode

@SpringBootTest
@ActiveProfiles(value = "test")
class CustomerClientSpec extends BaseConfig {

    private static final SimulationSource source = dsl(service("http://www.tix.com")
            .get("/api/customers/1")
            .willReturn(success().body(jsonWithSingleQuotes("{'identityNo':'13','fullName':'marek kapowicki', 'email' : 'marek1@gmail.com'}"))));

    @ClassRule
    public static final HoverflyRule rule = inSimulationMode(source);
    @Autowired
    private CustomerClient customerClient;

    @Value('${feign.url}')
    private String value

    String createdId = 1

//    void setup() {
//        println value
//        IdResponse foundId = customerClient.register(Customers.marek)
//        createdId = foundId.id
//    }

    def "get by id"() {
        when:
            CustomerSnapshot marek = customerClient.retrieve(createdId)
        then:
            with(marek) {
                fullName == 'marek kapowicki'
                email == 'marek2@gmail.com'
            }
    }
}
