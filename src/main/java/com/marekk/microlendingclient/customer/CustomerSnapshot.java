package com.marekk.microlendingclient.customer;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import com.marekk.microlendingclient.Snapshot;

import static lombok.AccessLevel.MODULE;
import static lombok.AccessLevel.PRIVATE;

@Getter
@FieldDefaults(level = PRIVATE)
@AllArgsConstructor(access = MODULE)
@NoArgsConstructor(access = PRIVATE)
@ToString
@EqualsAndHashCode
public final class CustomerSnapshot implements Snapshot {
    String identityNo;
    String fullName;
    String email;

}
