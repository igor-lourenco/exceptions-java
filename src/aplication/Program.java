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

		try {
			System.out.print("Numero quarto: ");
			int numeroQuarto = sc.nextInt();
			System.out.print("Data check-in (DD/MM/YYYY): ");
			LocalDate dataEntrada = LocalDate.parse(sc.next(), formatter);
			System.out.print("Data check-out (DD/MM/YYYY): ");
			LocalDate dataSaida = LocalDate.parse(sc.next(), formatter);

			Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);

			System.out.println(reserva);

			System.out.println("\nDigte as datas para atualização: ");
			System.out.print("Data check-in (DD/MM/YYYY): ");
			dataEntrada = LocalDate.parse(sc.next(), formatter);
			System.out.print("Data check-out (DD/MM/YYYY): ");
			dataSaida = LocalDate.parse(sc.next(), formatter);

			reserva.atualizaDatas(dataEntrada, dataSaida);

			System.out.println(reserva);
		} catch (ReservationException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		
		} catch (DateTimeParseException e) {
			System.out.println("Dados inválidos: " + e.getMessage());
		} finally {
			sc.close();
		}
	}
}
