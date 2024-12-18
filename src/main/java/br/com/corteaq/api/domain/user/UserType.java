package br.com.corteaq.api.domain.user;

import lombok.AllArgsConstructor;



public enum UserType {
    ADMIN("admin"),
    CUSTOMER("customer"),
    BARBER("barber");

    final String type;

    UserType(String type) {
        this.type = type;
    }


}
