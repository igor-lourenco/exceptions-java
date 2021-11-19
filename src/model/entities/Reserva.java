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
			return	dataSaida.toEpochDay() - dataEntrada.toEpochDay() ; //pega a diferenca em dias
	}
	
	public String atualizaDatas(LocalDate entrada, LocalDate saida) {
		LocalDate agora = LocalDate.now();
		
		if(entrada.isBefore(agora) || saida.isBefore(agora)) {
			return "Datas não pode ser passadas!";
		}if (dataEntrada.isAfter(dataSaida)) {
			return "Check-out não pode ser menor que check-in!!";
		}
		
		dataEntrada = entrada;
		dataSaida = saida;
		return null; //se retorna null é porque não ocorreu nenhum erro
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
