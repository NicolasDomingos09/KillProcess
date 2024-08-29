package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	
	public KillController() {
		super();
	}
	
	private String identOS() {
		String sistema = System.getProperty("os.name");
		return sistema;
	}
	
	private void callProcess(String call) {
		String[] callArr = call.split(" ");
		
		try {
			Process process = Runtime.getRuntime().exec(callArr);
			InputStream retorno = process.getInputStream();
			InputStreamReader leitor = new InputStreamReader(retorno);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while(linha != null) {
				linha = buffer.readLine();
				System.out.println(linha);
			}
			
			retorno.close();
			leitor.close();
			buffer.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void listaProcessos() {
		String OS = identOS();
		
		if(OS.contains("Windows")) {
			String process = "TASKLIST /FO TABLE";
			callProcess(process);
			
			
		}else if (OS.contains("Linux")) {
			String process = "ps -ef";
			callProcess(process);
		}
	}
	
	public void mataPID(String PID) {
		String OS = identOS();
		
		if(OS.contains("Windows")) {
			String process = "TASKKILL /PID " + PID;
			callProcess(process);
			
		}else if(OS.contains("Linux")) {
			String process = "kill -9 " + PID;
			callProcess(process);
		}
		
	}
	
	public void mataNome(String nomeProc) {
		String OS = identOS();
		
		if(OS.contains("Windows")) {
			String process = "TASKKILL /IM " + nomeProc;
			callProcess(process);
			
		}else if(OS.contains("Linux")) {
			String process = "pkill -f " + nomeProc;
			callProcess(process);
		}
	}
}
