package com.notifications.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class NotificationRequest {

    @JsonProperty
    @NotNull(message = "El mensaje es requerido")
    @Size(min = 1, max = 500, message = "El mensaje debe tener entre {min} y {max} caracteres")
    private String msg;

    @JsonProperty
    @NotNull(message = "El teléfono es requerido")
    @Pattern(regexp = "(91)[ -]*([0-9][ -]*){7}", message = "El número de telefono debe ser de Madrid (que empiece por 91) y ser válido (9 dígitos) ")
    private String phoneNumber;

    @JsonProperty
    @NotNull(message = "El tipo de comunicación es requerido")
    @Pattern(regexp = "FAX", message = "El servicio solo soporta comunicaciones de tipo FAX")
    private String type;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
