package br.com.corteaq.api.domain.payment;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



public enum PaymentMethod {
    MONEY("money"),
    CREDIT_CARD("credit card"),
    DEBIT_CARD("debit card"),
    PIX("pix");

    final String method;

    PaymentMethod(String method) {
        this.method = method;
    }
}
