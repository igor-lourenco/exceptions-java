package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.exceptions.ReservationException;

public class Reserva {

	private Integer numeroQuarto;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	
	public Reserva() {
		
	}

	public Reserva(Integer numeroQuarto, LocalDate dataEntrada, LocalDate dataSaida) {
		
		if (dataEntrada.isAfter(dataSaida)) // se a data de entrada for maior que a data de saida
			throw new ReservationException("Check-out n?o pode ser menor que check-in!!");
		
		this.numeroQuarto = numeroQuarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}
	
	public long duracao() {
			return	dataSaida.toEpochDay() - dataEntrada.toEpochDay() ; //pega a diferenca em dias
	}
	
	public void atualizaDatas(LocalDate entrada, LocalDate saida) {
		LocalDate agora = LocalDate.now();
		
		// se  entrada for menor que a data atual, e saida for menor que a data atual
		if(entrada.isBefore(agora) || saida.isBefore(agora)) 
			throw new ReservationException("Datas n?o pode ser passadas!");
		
		if (entrada.isAfter(saida)) // se a data de entrada for maior que a data de saida
			throw new ReservationException("Check-out n?o pode ser menor que check-in!!");
		
		dataEntrada = entrada;
		dataSaida = saida;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nReserva: Quarto ");
		builder.append(numeroQuarto);
		builder.append(", Data Entrada: ");
		builder.append( dataEntrada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		builder.append(", Data Saida: ");
		builder.append(dataSaida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		builder.append(", " + duracao());
		builder.append(" noites");
		return builder.toString();
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}
}
