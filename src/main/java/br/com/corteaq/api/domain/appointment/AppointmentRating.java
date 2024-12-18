package br.com.corteaq.api.domain.appointment;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public enum AppointmentRating {
    BAD(1),
    NOT_GOOD(2),
    REGULAR(3),
    GOOD(4),
    PERFECT(5);

    final Integer rating;

    AppointmentRating(Integer rating) {
        this.rating = rating;
    }
}
