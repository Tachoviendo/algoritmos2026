package com.ucu.algoritmos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger implements Observador {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void actualizar(String evento) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println("[LOGGER] [" + timestamp + "] " + evento);
    }
}
