package pl.marekk.microlendingclient.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.marekk.microlendingclient.IdResponse;
import pl.marekk.microlendingclient.Page;
import pl.marekk.microlendingclient.PageImpl;
import pl.marekk.microlendingclient.Pageable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static pl.marekk.microlendingclient.Specification.API_CONTENT_TYPE;

@FeignClient(name = "customer", url = "${feign.url}/api")
public interface CustomerClient {

    @PostMapping(path = "/customers", consumes = API_CONTENT_TYPE, produces = API_CONTENT_TYPE)
    IdResponse register(@RequestBody @Valid @NotNull CustomerRegisterRequest registerRequest);

    @GetMapping(value = "/customers/{id}")
    CustomerSnapshot retrieve(@PathVariable("id") String id);

}
