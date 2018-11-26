package br.com.zebra.product.util;

import java.util.Locale;

public interface MessageService {

    String getMessage(String key);

    String getMessage(String key, Object... objects);

    String getMessage(String key, Locale locale);

    String getMessage(String key, Locale locale, Object... objects);
}
