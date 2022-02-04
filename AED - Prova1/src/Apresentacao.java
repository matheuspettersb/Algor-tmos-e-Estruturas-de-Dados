import javax.swing.JOptionPane;
public class Apresentacao {
	
	public static void main(String[] args) {
		String str;
		int opcao;
		Calculadora c = new Calculadora();
		PilhaVetor<Integer> p = new PilhaVetor<Integer>(100);
		PilhaLista<Integer> p2 = new PilhaLista<Integer>();
		
		
		do{	str=JOptionPane.showInputDialog("\nMENU: \nSelecione o tipo da Pilha: \n\n1. Pilha Vetor  \n2. Pilha Lista \n\n99. Fechar o programa");
		opcao=Integer.parseInt(str);
		switch (opcao)
			{default: System.out.print("Opção inválida");
			
			case 1:	c.setPilha(p);
				str=JOptionPane.showInputDialog("\nDigite a expressão:");
				c.leitura(str);
				JOptionPane.showMessageDialog(null, "Resultado: "+c.getPilha().peek());
			break;
				
			case 2: c.setPilha(p2);
				str=JOptionPane.showInputDialog("\nDigite a expressão:");
				c.leitura(str);
				JOptionPane.showMessageDialog(null, "Resultado: "+c.getPilha().peek());
			break;
			
			case 99: JOptionPane.showMessageDialog(null, "Obrigado, até uma próxima!");
			break;
			}

		} while (opcao!=99);
		
		
	}
}