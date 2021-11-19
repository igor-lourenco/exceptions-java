package aplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("Numero quarto: ");
		int numeroQuarto = sc.nextInt();
		System.out.print("Data check-in (DD/MM/YYYY): ");
		LocalDate dataEntrada = LocalDate.parse(sc.next(), formatter);
		System.out.print("Data check-out (DD/MM/YYYY): ");
		LocalDate dataSaida = LocalDate.parse(sc.next(), formatter);

		Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);

		if (dataEntrada.isAfter(dataSaida)) { // se a data de entrada for maior que data de saida
			System.out.println("Erro na reserva: check-out n�o pode ser menor que check-in!!");
		} else {
			System.out.println(reserva);
			
			System.out.println("\nDigte as datas para atualiza��o: ");
			System.out.print("Data check-in (DD/MM/YYYY): ");
			dataEntrada = LocalDate.parse(sc.next(), formatter);
			System.out.print("Data check-out (DD/MM/YYYY): ");
			dataSaida = LocalDate.parse(sc.next(), formatter);
			
			LocalDate agora = LocalDate.now();
			
			if(dataEntrada.isBefore(agora) || dataSaida.isBefore(agora)) {
				System.out.println("Erro na atualiza��o: Datas n�o pode ser passadas!");
			}else if (dataEntrada.isAfter(dataSaida)) {
				System.out.println("Erro na atualiza��o: check-out n�o pode ser menor que check-in!!");
			}else {
			reserva.atualizaDatas(dataEntrada, dataSaida);
			System.out.println(reserva);
			}
		}

		sc.close();
	}

}