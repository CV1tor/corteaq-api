package br.com.corteaq.api.domain.payment;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



public enum PaymentStatus {
    PENDING("pending"),
    CONCLUDED("concluded");

    final String status;

    PaymentStatus(String status) {
        this.status = status;
    }
}
