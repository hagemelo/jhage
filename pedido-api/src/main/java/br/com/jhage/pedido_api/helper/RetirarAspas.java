package br.com.jhage.pedido_api.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RetirarAspas {

	public static String retirarAspasSimples(final String value) throws Exception {

		Pattern padrao = null;
		Matcher matcher = null;
		padrao = Pattern.compile("'");
		matcher = padrao.matcher(value.trim());
		return matcher.replaceAll("").trim();
	}

}
