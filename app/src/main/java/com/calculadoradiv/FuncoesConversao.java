package com.calculadoradiv;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FuncoesConversao {

	private static DateFormat dateFormatNfe = new SimpleDateFormat("yyyy-MM-dd");;
	private static DateFormat dateFormatAAAAMMDD = new SimpleDateFormat("yyyyMMdd");;
	private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private static DateFormat dateFormatDiaMes = new SimpleDateFormat("dd/MM");
	private static DateFormat dateFormatDiaMesNumber = new SimpleDateFormat("MM.dd");
	private static DateFormat dateFormatMesAno = new SimpleDateFormat("MM/YYYY");
	private static DateFormat dateFormatFull = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static DecimalFormat formatDoubleToStr = new DecimalFormat("###,###.##");
	private static DecimalFormat formatDoubleToCurrency = new DecimalFormat("R$ ###,###,##0.00");

	static {
		dateFormatNfe.setLenient(false);
		dateFormat.setLenient(false);
		dateFormatDiaMes.setLenient(false);
		dateFormatFull.setLenient(false);
	}

	public static Date stringAAAAMMDDParaDate(String data) throws ParseException {
		return dateFormatAAAAMMDD.parse(data);
	}

	public static Date stringNfeParaDate(String data) throws ParseException {
		return dateFormatNfe.parse(data);
	}

	public static Date stringParaDate(String data) throws ParseException {
		return dateFormat.parse(data);
	}

	public static String dateTimeParaSring(Date data) {
		return dateFormatFull.format(data);
	}
	
	public static String dateParaSring(Date data) {
		try {
			return dateFormat.format(data);
		} catch (NullPointerException e) {
			return null;
		}
	}

	public static String dateParaStringInvertido(Date data) {
		try {
			return dateFormatNfe.format(data);
		} catch (NullPointerException e) {
			return null;
		}
	}

	public static String dateParaSringDiaMes(Date data) {
		try {
			return dateFormatDiaMes.format(data);
		} catch (NullPointerException e) {
			return null;
		}
	}

	public static String dateParaNumberMesDia(Date data) {
		try {
			return dateFormatDiaMesNumber.format(data);
		} catch (NullPointerException e) {
			return null;
		}
	}

	public static String doubleParaMoeda(Double n) {

		try {
			n.toString();
			return formatDoubleToCurrency.format(n);
		} catch (Exception e) {
			return formatDoubleToCurrency.format(0.0);
		}
	}

	public static String bdParaMoeda(BigDecimal n) {

		try {
			n.toString();
			return formatDoubleToCurrency.format(n);
		} catch (Exception e) {
			return formatDoubleToCurrency.format(0.0);
		}
	}

	public static String StrDoubleToStrMoeda(String n) {

		try {
			return FuncoesConversao.doubleParaMoeda(Double.parseDouble(n));
		} catch (Exception e) {
			return formatDoubleToCurrency.format(0.0);
		}
	}

	public static String StrDoubleToStrQtd(String n) {

		try {
			return FuncoesConversao.doubleparaQuantidade(Double.parseDouble(n));
		} catch (Exception e) {
			return formatDoubleToCurrency.format(0.0);
		}
	}

	public static String doubleParaPorcentagem(double n) {

		try {
			if (Double.isNaN(n)) {
				return "0%";
			} else {
				return formatDoubleToStr.format(n) + "%";
			}
		} catch (Exception e) {
			return "0%";
		}
	}

	public static String doubleparaQuantidade(Double n) {

		try {
			return formatDoubleToStr.format(n);
		} catch (Exception e) {
			return formatDoubleToStr.format(0.0);
		}
	}

	public static String bdparaQuantidade(BigDecimal n) {

		try {
			return formatDoubleToStr.format(n);
		} catch (Exception e) {
			return formatDoubleToStr.format(0.0);
		}
	}

	public static double stringParaDouble(String text) {
		try {
			return Double.parseDouble(text.replace("/", "").replace(".", "").replace("-", "").replace("R$", "")
					.replace("%", "").replace(",", "."));
		} catch (NumberFormatException e) {
			return 0.0;
		}
	}
	
	public static String removeMascara(String text) {
		return text.replace("/", "").replace(".", "").replace("-", "").replace("R$", "").replace("%", "")
				.replace(",", "").replace(" ", "").replace("(", "").replace(")", "").replace("_", "");
	}

	public static Double stringMoedaParaDouble(String text) {
		try {
			return Double.parseDouble(removeMascaraMoedaString(text));
		} catch (NumberFormatException e) {
			return 0.0;
		}
	}

	public static BigDecimal stringMoedaParaBd(String text) {
		try {
			String vlr = removeMascaraMoedaString(text);
			return new BigDecimal(vlr);
		} catch (NumberFormatException e) {
			return BigDecimal.ZERO;
		}
	}

	public static String removeMascaraMoedaString(String text) {
		try {
			return text.replace("/", "").replace(".", "").replace("-", "").replace("R$", "").replace("%", "")
					.replace(",", ".").replaceAll(" ", "");
		} catch (NumberFormatException e) {
			return "0";
		}
	}

	public static String formataCpfCnpj(String cpfCnpj) {

		try {
			if (cpfCnpj.length() == 11) {
				return formataCpf(cpfCnpj);
			} else {
				return formataCnpj(cpfCnpj);
			}
		} catch (NullPointerException e) {
			return "";
		}
	}

	public static String formataCnpj(String cnpj) {

		try {
			return cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." + cnpj.substring(5, 8) + "/"
					+ cnpj.substring(8, 12) + "-" + cnpj.substring(12, 14);
		} catch (Exception e) {
			return "";
		}
	}

	public static String formataCpf(String cnpj) {

		try {
			return cnpj.substring(0, 3) + "." + cnpj.substring(3, 6) + "." + cnpj.substring(6, 9) + "-"
					+ cnpj.substring(9, 11);
		} catch (Exception e) {
			return "";
		}
	}

	public static Object formataTelefone(String telefone) {

		try {
			return "(" + telefone.substring(0, 2) + ")" + telefone.substring(2, 6) + "-" + telefone.substring(6, 10);
		} catch (Exception e) {
			return "";
		}
	}

	public static String transformaCPF(String cpfCnpj) {

		return cpfCnpj.replaceAll("[^0-9]","");
	}



	public static String CidadeDatePorExtenso(Date data) {

		return DataPorExtenso("Brasília", data);
	}

	private static String NomeDoMes(int i, int tipo) {
		String mes[] = {"janeiro", "fevereiro", "março", "abril",
				"maio", "junho", "julho", "agosto", "setembro", "outubro",
				"novembro", "dezembro"};
		if (tipo == 0)
			return(mes[i-1]); 
		else return(mes[i-1].substring(0, 3)); 
	}

	@SuppressWarnings("deprecation")
	private static String DataPorExtenso(String cidade, Date dt) {
		int d = dt.getDate();
		int m = dt.getMonth()+1;
		int a = dt.getYear()+1900;

		return(cidade + ", " + d + " de " + NomeDoMes(m, 0) + " de " +
				a );
	}

	public static String dateParaStringMesAno(Date data) {
		try {
			return dateFormatMesAno.format(data);
		} catch (NullPointerException e) {
			return null;
		}
	}

}
