package pl.marekk.microlendingclient.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import pl.marekk.microlendingclient.CreateResourceRequest;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
@AllArgsConstructor
@ToString
@Getter
public class CustomerRegisterRequest implements CreateResourceRequest {
    @NotNull
    String firstName;
    @NotNull
    String lastName;
    @NotNull
    @Email
    String email;
}
