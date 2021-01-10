package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Empregados;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Digite um caminho completo de arquivo: ");
		String caminho = sc.nextLine();
		System.out.print("Digite o salário: ");
		double salario = sc.nextDouble();

		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

			List<Empregados> lista = new ArrayList<>();

			String linha = br.readLine();
			while (linha != null) {
				String[] campos = linha.split(",");
				lista.add(new Empregados(campos[0], campos[1], Double.parseDouble(campos[2])));
				linha = br.readLine();
			}

			System.out.println("E-mail das pessoas que possuem salário maior que "
								+ String.format("%.2f", salario) + ":");

			List<String> emails = lista.stream().filter(p -> p.getSalario() > salario).map(p -> p.getEmail()).sorted()
					.collect(Collectors.toList());

			emails.forEach(System.out::println);

			double soma = lista.stream().filter(x -> x.getNome().charAt(0) == 'M').map(x -> x.getSalario()).reduce(0.0,
					(x, y) -> x + y);

			System.out.println("Soma dos salários das pessoas que começam com 'M': " + String.format("%.2f", soma));

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}

}
