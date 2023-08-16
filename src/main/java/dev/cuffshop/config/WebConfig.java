package dev.cuffshop.config;

import dev.cuffshop.test.typeconverter.converter.IntegerToStringConverter;
import dev.cuffshop.test.typeconverter.converter.IpPortToStringConverter;
import dev.cuffshop.test.typeconverter.converter.StringToIntegerConverter;
import dev.cuffshop.test.typeconverter.converter.StringToIpPortConverter;
import dev.cuffshop.test.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(new StringToIntegerConverter());
//        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());

        //추가
        registry.addFormatter(new MyNumberFormatter());
    }
}
