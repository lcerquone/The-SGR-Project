package impl;

import org.apache.commons.validator.routines.DateValidator;

import java.util.Objects;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateVO {
    private static final DateValidator validator = DateValidator.getInstance();
    private final String value;
    // Tuve que agregar pattern por que el default de DateValidator no me funciona
    private final String pattern = "dd/MM/yyyy";

    public DateVO(String value) throws Exception {
        // Agregar pattern
        if (!validator.isValid(value,pattern)) {
            throw new  Exception("Error: Fecha invalida.");
        }
        this.value = value;
    }

    public DateVO change(String value) throws Exception {
        return new DateVO(value);
    }
    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DateVO that = (DateVO) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private String getValue(){return this.value;}

    public int compararFechas(DateVO dia){
        int com = -100;
        String fecha = dia.getValue();
        try {
            DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
            Date convertido = date.parse(fecha);
            Date convertido1 = date.parse(this.value);
            com = validator.compareDates(convertido1,convertido,null);
        } catch (ParseException e){
            System.out.println("Error: " + e.getMessage());
        }
        return com;
    }
}