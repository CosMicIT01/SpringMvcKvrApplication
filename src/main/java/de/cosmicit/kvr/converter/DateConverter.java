package de.cosmicit.kvr.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateConverter implements Converter<String, Date> {

    final Logger logger = LoggerFactory.getLogger(DateConverter.class);

    @Override
    public Date convert(String source) {
        SimpleDateFormat sf = new SimpleDateFormat("dd.MM.yyyy");
        if (!source.isEmpty()) {
            try {
                return sf.parse(source);
            } catch (ParseException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
        return null;
    }
}