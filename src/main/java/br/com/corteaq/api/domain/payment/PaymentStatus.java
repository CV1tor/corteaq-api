package br.com.corteaq.api.domain.payment;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor

public enum PaymentStatus {
    PENDING("pending"),
    CONCLUDED("concluded");

    final String status;
}
