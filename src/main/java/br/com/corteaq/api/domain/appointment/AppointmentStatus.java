package br.com.corteaq.api.domain.appointment;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public enum AppointmentStatus {
    PENDING("pending"),
    CONFIRMED("confirmed"),
    CANCELED("canceled");

    final String status;

    AppointmentStatus(String status) {
        this.status = status;
    }
}
