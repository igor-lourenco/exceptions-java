package aplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.ReservationException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		boolean continueLoop = true;
		LocalDate dataEntrada;
		LocalDate dataSaida;
		Reserva reserva = new Reserva();

		do {
			try {
				System.out.print("Numero quarto: ");
				int numeroQuarto = sc.nextInt();
				System.out.print("Data check-in (DD/MM/YYYY): ");
				dataEntrada = LocalDate.parse(sc.next(), formatter);
				System.out.print("Data check-out (DD/MM/YYYY): ");
				dataSaida = LocalDate.parse(sc.next(), formatter);

				reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);

				continueLoop = false;
			} catch (ReservationException e) {
				System.out.println("\nErro na reserva: " + e.getMessage());
				sc.nextLine();
				System.out.println("Por favor, tente novamente.\n");

			} catch (DateTimeParseException e) {
				System.out.println("\nDados inválidos: " + e.getMessage());
				sc.nextLine();
				System.out.println("Por favor, tente novamente.\n");
			}
		} while (continueLoop);

		continueLoop = true;
		System.out.println(reserva);
		System.out.println("\nDigte as datas para atualização: ");
		do {
			try {
				System.out.print("Data check-in (DD/MM/YYYY): ");
				dataEntrada = LocalDate.parse(sc.next(), formatter);
				System.out.print("Data check-out (DD/MM/YYYY): ");
				dataSaida = LocalDate.parse(sc.next(), formatter);

				reserva.atualizaDatas(dataEntrada, dataSaida);

				continueLoop = false;
			} catch (ReservationException e) {
				System.out.println("\nErro na reserva: " + e.getMessage());
				sc.nextLine();
				System.out.println("Por favor, tente novamente.\n");

			} catch (DateTimeParseException e) {
				System.out.println("\nDados inválidos: " + e.getMessage());
				sc.nextLine();
				System.out.println("Por favor, tente novamente.\n");
			}
		} while (continueLoop);
		System.out.println(reserva);
		sc.close();
	}
}
