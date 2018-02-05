package br.com.jhage.pedido_api.helper;

import java.text.NumberFormat;

/**
 * 
 * @author Alexsander Melo
 * @since 25/01/2017
 *
 */
public class NumberHelp {

	public static String parseDoubleToString(Double valor){
		
		StringBuffer build = new StringBuffer();
		final NumberFormat nf = NumberFormat.getNumberInstance();
		try{
			
			build.append(nf.format(valor));
		}catch (Exception e) {

			return "";
		}
		return build.toString().trim();
	}
	
}
