package br.com.jhage.pedido_api.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import br.com.jhage.pedido_api.excecao.ConverterDataParaCaracterException;
import br.com.jhage.pedido_api.excecao.FormatarDataParaPadraoException;
import br.com.jhage.pedido_api.excecao.PedidoException;

/***
 * 
 * @author Alexsander Melo
 * @since 09/01/2013
 * @version 1.0 Classe responsavel por fomata��o e valida��o de datas
 */
final public class FormatDateHelper {

	private static SimpleDateFormat formatoPadraoDaData = null;
	private static final String FORMAT_DEFAULT = "dd/MM/yyyy";
	
	public static String converterDataParaCaracter(final Date date) throws PedidoException {
			
			return FormatDateHelper.converterDataParaCaracter(date, FORMAT_DEFAULT);
	}

	public static String converterDataParaCaracter(final Date date, final String value) throws PedidoException {

		try {
			FormatDateHelper.inserirFormatoPadraoDaData(value);
			return FormatDateHelper.formatoPadraoDaData.format(date).toString();
		} catch (final Exception e) {
			throw new ConverterDataParaCaracterException();
		}
	}

	public static boolean isMesmadata(final Date date1, final Date date2) throws PedidoException {

		final Date primeiraData = FormatDateHelper.formatarDataParaPadrao(date1, "dd/MM/yyyy hh:mm:ss");
		final Date segundaData = FormatDateHelper.formatarDataParaPadrao(date2, "dd/MM/yyyy hh:mm:ss");
		return primeiraData.compareTo(segundaData) == 0;
	}
	
	public static boolean isData1MenorQueData2(final Date date1, final Date date2)
			throws PedidoException {

		final Date primeiraData = FormatDateHelper
				.formatarDataParaPadrao(date1, "dd/MM/yyyy hh:mm:ss");
		final Date segundaData = FormatDateHelper
				.formatarDataParaPadrao(date2, "dd/MM/yyyy hh:mm:ss");
		return primeiraData.compareTo(segundaData) <= 0;
	}

	public static Date formatarDataParaPadrao(final String date, final String value) throws PedidoException {

		try {
			FormatDateHelper.inserirFormatoPadraoDaData(value);
			return FormatDateHelper.formatoPadraoDaData.parse(date);
		} catch (final Exception e) {
			throw new FormatarDataParaPadraoException();
		}
	}
	
	public static Date formatarDataParaPadrao(final Date date, final String value) throws PedidoException {

		try {
			FormatDateHelper.inserirFormatoPadraoDaData(value);
			return FormatDateHelper.formatoPadraoDaData.parse(FormatDateHelper.formatoPadraoDaData.format(date));
		} catch (final Exception e) {
			throw new FormatarDataParaPadraoException();
		}
	}

	private static void inserirFormatoPadraoDaData(final String formato) {
		FormatDateHelper.formatoPadraoDaData = new SimpleDateFormat(formato, new Locale("pt", "BR"));
	}
	
}
