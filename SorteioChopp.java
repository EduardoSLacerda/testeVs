/**************************************************
 * 
 * @author Eduardo Lacerda
 *
 * Data: 08/03/2018
 * 
 * 	"Um Pub solicitou o desenvolvimento de um
 *	sistema para auxiliar no sorteio de chopp para
 *	os clientes que estejam no estabelecimento."
 *
 *	• Como funciona a promoção:
 *		– Todo cliente que ingressar no Pub, deve fornecer o
 *		seu número de celular (somente os números) para
 *		a atendente.
 *		– De tempos em tempos a atendente vai solicitar o
 *		sistema para que o mesmo sorteie um número de
 *		celular.
 *		– Após sorteado o número deve ser retirado da lista,
 *		garantindo que sempre serão sorteadas pessoas
 *		diferentes.
 *
 *	• Requisitos do sistema:
 *		– Todo novo cliente que ingressar no Pub deve ser
 *		adicionado ao final da lista;
 *		– O sistema deve permitir a baixa do cliente quando
 *		o mesmo pagar a conta;
 *		 -- Deve-se localizar se o mesmo está na lista e remover o
 *		 número do celular;
 *		– Caso o número do celular não exista na lista, deve-se
 *		informação que ele não foi encontrado.
 *		
 *	• Requisitos do sistema:
 *		– O sistema deve sortear os números disponíveis na
 *		lista, para isso deve;se utilizar a classe Random do
 *		Java a partir do índice da lista.
 *		 -- Ao sortear um número de celular o mesmo deve ser
 *		 removido da lista;
 *		– Caso o sistema não possua nenhum número de
 *		celular cadastrado e seja solicitado um novo
 *		sorteio ou a baixa de um cliente, deve;se
 *		apresentar uma mensagem informando que a lista
 *		está vazia.
 *
 *	• Requisitos do sistema:
 *		– O sistema deve utilizar como base a classe
 *		ListaSequencial.
 *	• Exemplo do uso da classe Random
 *		
 *		Random randomico = new Random();
 *		int aux = rendomico.nextInt(6);
 *
 *		System.out.println(aux);
 *		
 */

import java.util.Random;
import javax.swing.JOptionPane;

public class SorteioChopp {
	
	static int[] lista = new int[6];
	static int quantidade, i;
	private static Object rendomico;
	
	public static String listarCelulares() {
			
		String elementos = "\n";
			
		for (i = 0; i < 6; i++) {
				
			elementos += (i+1) + "º "+ lista[i] + "\n";
				
		}
			
		return elementos;
			
	}
	
	public static void adicionarCliente(int novoNumero) {
		
		if (quantidade < 6) {
					
			lista[quantidade++] = novoNumero;
					
		}else{
					
			JOptionPane.showMessageDialog(null, "Lista cheia.");
		}
	}
	
	public static void removerCliente(int removerNumero) {
		
		if (removerNumero < quantidade) {
			if (quantidade < 10) {
				
				for (i = removerNumero; i < quantidade-1; i++) {
					
					lista[i] = lista[i+1];
					
				}
				
				lista[quantidade-1] = 0;
				quantidade --;
			
			}else{
			
				JOptionPane.showMessageDialog(null, "Lista cheia");
			}
			
		}else{
			
			JOptionPane.showMessageDialog(null, "Posição não compatível");
			
		}
	}
	
	public static int sortearPosicao() {
		Random randomico = new Random();
		int posicaoSorteado = -1;
		
		if(quantidade > 0) {
			posicaoSorteado = randomico.nextInt(quantidade);
			return posicaoSorteado;
		}
		
		return posicaoSorteado;
		
	}
	
	public static void main(String[] args) {
		
		int controle = 1;

	    while (controle != 0) {

	    	controle = Integer.parseInt(JOptionPane.showInputDialog(null,
	          "1) Listar os números de celulares. \n"
	        + "2) Adicionar novo cliente. \n"
	        + "3) Remover cliente. \n"
	        + "4) Sortear valor. \n"
	        + "0) Finalizar",
	          "Boteco do Dilhos", JOptionPane.PLAIN_MESSAGE));
	    	 
	    	switch (controle) {

		        case 1:
		        	
		        	JOptionPane.showMessageDialog(null, "Os elementos do vetor são: " + listarCelulares());
	
		        	break;
		        	 
		        case 2:
		        	 
		        	int novoNumero = Integer.parseInt(JOptionPane.showInputDialog("Valor que deseja inserir no início"));
		        	 
		        	adicionarCliente(novoNumero);
		        	 
		        	break;
		        	
		        case 3:
		        	
		        	int removerNumero = Integer.parseInt(JOptionPane.showInputDialog("Conta que deseja remover")) - 1;
					removerCliente(removerNumero);
					
					break;
					
		        case 4:
		        	int posicao = sortearPosicao();
		        	JOptionPane.showMessageDialog(null, "O celular sorteado e: "+lista[posicao]+" na posicao = " + (posicao + 1));
		        	break;
				
		        case 0:
		        	
		        	break;
		        	
	    	}
	    }
	}
}