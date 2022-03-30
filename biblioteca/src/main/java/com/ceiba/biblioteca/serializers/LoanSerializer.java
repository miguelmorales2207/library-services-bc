package com.ceiba.biblioteca.serializers;

import com.ceiba.biblioteca.models.Prestamos;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;

public class LoanSerializer extends StdSerializer<Prestamos> {

    private static final long serialVersionUID = 1482971865173250765L;

    protected LoanSerializer(Class<Prestamos> t) {
        super(t);
    }

    protected LoanSerializer() {
        this(null);
    }

    @Override
    public void serialize(Prestamos prestamo, JsonGenerator jsonGenerator,
        SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", prestamo.getId());
        jsonGenerator.writeStringField("isbn", prestamo.getIsbn());
        jsonGenerator.writeStringField("identificacion_usuario",
            prestamo.getIdentificacionUsuario());

        jsonGenerator.writeNumberField("tipo_usuario", prestamo.getTipoUsuario());
        jsonGenerator.writeStringField("fecha_devolucion",
            prestamo.getFechaDevolucion().toString());

        jsonGenerator.writeEndObject();

    }

}
