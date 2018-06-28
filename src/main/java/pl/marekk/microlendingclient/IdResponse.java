package pl.marekk.microlendingclient;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class IdResponse {
    String id;
}
