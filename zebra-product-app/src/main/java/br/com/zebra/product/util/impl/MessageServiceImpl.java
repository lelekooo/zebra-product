package br.com.zebra.product.util.impl;

import br.com.zebra.product.util.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageSource messages;

    @Override
    public String getMessage(String key) {
        return messages.getMessage(key, null, LocaleContextHolder.getLocale());
    }

    @Override
    public String getMessage(String key, Object... objects) {
        return messages.getMessage(key, objects, LocaleContextHolder.getLocale());
    }

    @Override
    public String getMessage(String key, Locale locale) {
        return messages.getMessage(key, null, locale);
    }

    @Override
    public String getMessage(String key, Locale locale, Object... objects) {
        return messages.getMessage(key, objects, LocaleContextHolder.getLocale());
    }
}
