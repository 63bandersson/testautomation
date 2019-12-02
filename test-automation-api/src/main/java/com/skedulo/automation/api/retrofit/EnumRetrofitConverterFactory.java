package com.skedulo.automation.api.retrofit;

import com.google.gson.annotations.SerializedName;
import retrofit2.Converter;
import retrofit2.Retrofit;

import javax.annotation.Nullable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class EnumRetrofitConverterFactory extends Converter.Factory {
    @Override
    public Converter<?, String> stringConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        Converter<?, String> converter = null;
        if (type instanceof Class && ((Class<?>)type).isEnum()) {
            converter = value -> getSerializedNameValue((Enum) value);
        }
        return converter;
    }

    @Nullable
    static public <E extends Enum<E>> String getSerializedNameValue(E e) {
        try {
            return e.getClass().getField(e.name()).getAnnotation(SerializedName.class).value();
        } catch (Exception exception) {
            return e.toString();
        }
    }
}
