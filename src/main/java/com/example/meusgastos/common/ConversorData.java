package com.example.meusgastos.common;

import java.util.Date;
import java.text.SimpleDateFormat;

public class ConversorData {
    
    public static String converterDateParaDataEHora(Date date) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
        return formatador.format(date);
    }
}
