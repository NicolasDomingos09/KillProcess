package view;

import java.util.Scanner;

import controller.KillController;

public class Main {

	public static void main(String[] args) {
		KillController kCont = new KillController();
		Scanner scan = new Scanner(System.in);
		
		String menu = """
				1 - Listar processos
				2 - Mata processo por PID
				3 - Mata processo por nome
				9 - Finalizar
				""";
		
		int opc = 0;
		while(opc != 9) {
			System.out.println(menu);
			opc = scan.nextInt();
			
			switch(opc) {
				case 1:
					kCont.listaProcessos();
					break;
				case 2:
					System.out.println("Entre com o PID do processo: ");
					String PID = scan.next();
					kCont.mataPID(PID);
					break;
				case 3:
					System.out.println("Entre com o nome do processo: ");
					String nome = scan.next();
					kCont.mataPID(nome);
					break;
				case 9:
					System.out.println("Finalizando");
					break;
				default:
					System.out.println("Opção inválida");
			}
		}
		scan.close();	
	}

}
