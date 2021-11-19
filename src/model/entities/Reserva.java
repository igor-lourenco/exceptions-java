package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva {

	private Integer numeroQuarto;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;

	public Reserva(Integer numeroQuarto, LocalDate dataEntrada, LocalDate dataSaida) {
		this.numeroQuarto = numeroQuarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}
	
	public long duracao() {
		//long diff =
			return	dataSaida.toEpochDay() - dataEntrada.toEpochDay() ; //pega a diferenca em dias
		//return TimeUnit.DAYS.convert(diff, TimeUnit.DAYS); // converte os milisegundos em dias
	}
	
	public void atualizaDatas(LocalDate entrada, LocalDate saida) {
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
