package io;

import javax.swing.JOptionPane;

/**
 * A classe <tt>leDadosWin</tt> permite a leitura de dados de tipos nativos e de
 * instâncias da classe <tt>String</tt> a partir do teclado, através de uma
 * janela. Basicamente esta classe encapsula o funcionamento dos métodos da clase
 * <tt>JOptionPane</tt>, que pode ser usado como entrada padrão de dados.
 * <ul>
 * <li>Os métodos são estáticos para facilitar o uso da classe
 * <li>Criação de métodos sobrecarregados para que valores <i>default</i> possam ser 
 *     usados
 * <li>Tratamento das exceções
 *   
 * @author Cinthia Cristina Lucio Caliari
 * @version 1.1
 */
public class InOut {
	/**
	 * Este método é para entrada de uma String. Tem como parâmetro de entrada
	 * uma String que indicará para o usuário qual o dado que será lido naquele
	 * momento por aquela caixa de texto e retorna a String lida
	 * 
	 * @param frase que será usada para o usuário saber qual dado será lido
	 * @return String que foi lida
	 */
	public static String leString (String frase){
		String Entrada;
		
		Entrada = JOptionPane.showInputDialog (null, frase, "Entrada de dados", 
											   JOptionPane.QUESTION_MESSAGE);
		return Entrada;
	}
	
	/**
	 * Este método é para entrada de um objeto do tipo byte. Tem como parâmetro 
	 * de entrada uma String que indicará para o usuário qual o dado que será 
	 * lido naquele momento por aquela caixa de texto. 
	 * Lê então uma String e a converte para um objeto do tipo byte. 
	 * Se na conversão ocorrer algum erro, o processo será feito novamente, 
	 * ou seja, será lida outra String e convertida para byte. O processo só 
	 * pára quando a conversão for bem sucedida.  
	 * 
	 * @param frase que será usada para o usuário saber qual dado será lido
	 * @return um objeto do tipo byte
	 */
	public static byte leByte (String frase){
		byte num = 0;
		String Entrada;
		boolean ERRO;
		
		do{
			try{
				Entrada = JOptionPane.showInputDialog (null, frase, "Entrada de dados", 
						   								JOptionPane.QUESTION_MESSAGE);
				num = Byte.parseByte(Entrada);
				ERRO = false;
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "VALOR DEVE SER UM NÚMERO DO TIPO " +
											  "BYTE", "   >>>      ERRO     <<<", 
											  JOptionPane.ERROR_MESSAGE);
				ERRO = true;
			}
		}while (ERRO);	
		return num;
	}
	
	/**
	 * Este método é para entrada de um objeto do tipo short. Tem como parâmetro 
	 * de entrada uma String que indicará para o usuário qual o dado que será 
	 * lido naquele momento por aquela caixa de texto. 
	 * Lê então uma String e a converte para um objeto do tipo short. 
	 * O processo só pára quando a conversão for bem sucedida.  
	 * 
	 * @param frase que será usada para o usuário saber qual dado será lido
	 * @return um objeto do tipo short
	 */
	public static short leShort (String frase){
		short num=0;
		String Entrada;
		boolean ERRO;
		
		do{
			try{
				Entrada = JOptionPane.showInputDialog (null, frase, "Entrada de dados", 
						   								JOptionPane.QUESTION_MESSAGE);
				num = Short.parseShort(Entrada);
				ERRO = false;
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "VALOR DEVE SER UM NÚMERO DO TIPO " +
											  "SHORT", "   >>>      ERRO     <<<", 
											  JOptionPane.ERROR_MESSAGE);
				ERRO = true;
			}
		}while (ERRO);	
		return num;
	}
	
	/**
	 * Este método é para entrada de um objeto do tipo int. Tem como parâmetro 
	 * de entrada uma String que indicará para o usuário qual o dado que será 
	 * lido naquele momento por aquela caixa de texto. 
	 * Lê então uma String e a converte para um objeto do tipo int. 
	 * O processo só pára quando a conversão for bem sucedida.  
	 * 
	 * @param frase que será usada para o usuário saber qual dado será lido
	 * @return um objeto do tipo int
	 */
	public static int leInt (String frase){
		int num = 0;
		String Entrada;
		boolean ERRO;
		
		do{
			try{
				Entrada = JOptionPane.showInputDialog (null, frase, "Entrada de dados", 
						   								JOptionPane.QUESTION_MESSAGE);
				num = Integer.parseInt(Entrada);
				ERRO = false;
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "VALOR DEVE SER UM NÚMERO DO TIPO " +
											  "INTEIRO ", "   >>>      ERRO     <<<", 
											  JOptionPane.ERROR_MESSAGE);
				ERRO = true;
			}
		}while (ERRO);		
		return num;
	}
	
	/**
	 * Este método é para entrada de um objeto do tipo long. Tem como parâmetro 
	 * de entrada uma String que indicará para o usuário qual o dado que será 
	 * lido naquele momento por aquela caixa de texto. 
	 * Lê então uma String e a converte para um objeto do tipo long. 
	 * O processo só pára quando a conversão for bem sucedida.  
	 * 
	 * @param frase que será usada para o usuário saber qual dado será lido
	 * @return um objeto do tipo long
	 */
	public static long leLong (String frase){
		long num = 0;
		String Entrada;
		boolean ERRO;
		
		do{
			try{
				Entrada = JOptionPane.showInputDialog (null, frase, "Entrada de dados", 
						   								JOptionPane.QUESTION_MESSAGE);
				num = Long.parseLong(Entrada);
				ERRO = false;
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "VALOR DEVE SER UM NÚMERO DO TIPO " +
											  "LONG ", "   >>>      ERRO     <<<", 
											  JOptionPane.ERROR_MESSAGE);
				ERRO = true;
			}
		}while (ERRO);		
		return num;
	}

	/**
	 * Este método é para entrada de um objeto do tipo float. Tem como parâmetro 
	 * de entrada uma String que indicará para o usuário qual o dado que será 
	 * lido naquele momento por aquela caixa de texto. 
	 * Lê então uma String e a converte para um objeto do tipo float. 
	 * O processo só pára quando a conversão for bem sucedida.  
	 * 
	 * @param frase que será usada para o usuário saber qual dado será lido
	 * @return um objeto do tipo float
	 */
	public static float leFloat (String frase){
		float num = 0;
		String Entrada;
		boolean ERRO;
		
		do{
			try{
				Entrada = JOptionPane.showInputDialog (null, frase, "Entrada de dados", 
						   JOptionPane.QUESTION_MESSAGE);
				num = Float.parseFloat(Entrada);
				ERRO = false;
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "VALOR DEVE SER UM NÚMERO DO TIPO " +
 											  "FLOAT", "   >>>      ERRO     <<<", 
											  JOptionPane.ERROR_MESSAGE);
				ERRO = true;
			}
		}while (ERRO);	
		return num;
	}

	/**
	 * Este método é para entrada de um objeto do tipo double. Tem como parâmetro 
	 * de entrada uma String que indicará para o usuário qual o dado que será 
	 * lido naquele momento por aquela caixa de texto. 
	 * Lê então uma String e a converte para um objeto do tipo double. 
	 * O processo só pára quando a conversão for bem sucedida.  
	 * 
	 * @param frase que será usada para o usuário saber qual dado será lido
	 * @return um objeto do tipo double
	 */
	public static double leDouble (String frase){
		double num = 0;
		String Entrada;
		boolean ERRO;
		
		do{
			try{
				Entrada = JOptionPane.showInputDialog (null, frase, "Entrada de dados", 
						   								JOptionPane.QUESTION_MESSAGE);
				num = Double.parseDouble(Entrada);
				ERRO = false;
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "VALOR DEVE SER UM NÚMERO DO TIPO " +
											  "DOUBLE", "   >>>      ERRO     <<<", 
											  JOptionPane.ERROR_MESSAGE);
				ERRO = true;
			}
		}while (ERRO);	
		return num;
	}

	/**
	 * Este método é para entrada de um objeto do tipo char. Tem como parâmetro 
	 * de entrada uma String que indicará para o usuário qual o dado que será 
	 * lido naquele momento por aquela caixa de texto. 
	 * Lê então uma String e retorna apenas o primeiro caracter da String.  
	 * 
	 * @param frase que será usada para o usuário saber qual dado será lido
	 * @return um objeto do tipo char
	 */
	public static char leChar (String frase){
		String Entrada;
		
		Entrada = JOptionPane.showInputDialog (null, frase, "Entrada de dados", 
				   								JOptionPane.QUESTION_MESSAGE);
		return Entrada.charAt(0);
	}
	
	/**
	 * Este método foi criado para mandar uma mensagem com o ícone de
	 * ERRO
	 *  
	 * @param cabeçalho que aparecerá no topo da mensagem
	 * @param frase     que aparecerá dentro da caixa de mensagem
	 */
	public static void MsgDeErro(String cabeçalho, String frase){
		JOptionPane.showMessageDialog(null, frase, cabeçalho, 
				  					  JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Este método foi criado para mandar uma mensagem com o ícone de
	 * INFORMAÇÃO
	 *  
	 * @param cabeçalho que aparecerá no topo da mensagem
	 * @param frase     que aparecerá dentro da caixa de mensagem
	 */
	public static void MsgDeInformação(String cabeçalho, String frase){
		JOptionPane.showMessageDialog(null, frase, cabeçalho, 
				  					  JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Este método foi criado para mandar uma mensagem sem ícone 
	 *  
	 * @param cabeçalho que aparecerá no topo da mensagem
	 * @param frase     que aparecerá dentro da caixa de mensagem
	 */
	public static void MsgSemIcone(String cabeçalho, String frase){
		JOptionPane.showMessageDialog(null, frase, cabeçalho, 
				  					  JOptionPane.PLAIN_MESSAGE);
	}
	
	/**
	 * Este método foi criado para mandar uma mensagem com o ícone de
	 * AVISO
	 *  
	 * @param cabeçalho que aparecerá no topo da mensagem
	 * @param frase     que aparecerá dentro da caixa de mensagem
	 */
	public static void MsgDeAviso (String cabeçalho, String frase){
		JOptionPane.showMessageDialog(null, frase, cabeçalho, 
				  					  JOptionPane.WARNING_MESSAGE);
	}

}
