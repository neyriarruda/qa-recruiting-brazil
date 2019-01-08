package br.gov.pe.tce.folha.entity;

import java.util.HashMap;

public class Classe {

	private HashMap<String, Preco> itens = new HashMap<String, Preco>();

	class Preco {
		public int valorUnitario;
		public int valorComposto;
		public int quantidadeTotal;
		public int quantidadeMinimaValorUnitario;

		public int getValorUnitario() {
			return valorUnitario;
		}

		public void setValorUnitario(int valorUnitario) {
			this.valorUnitario = valorUnitario;
		}

		public int getValorComposto() {
			return valorComposto;
		}

		public void setValorComposto(int valorComposto) {
			this.valorComposto = valorComposto;
		}

		public int getQuantidadeTotal() {
			return quantidadeTotal;
		}

		public void setQuantidadeTotal(int quantidadeTotal) {
			this.quantidadeTotal = quantidadeTotal;
		}

		public int getQuantidadeMinimaValorUnitario() {
			return quantidadeMinimaValorUnitario;
		}

		public void setQuantidadeMinimaValorUnitario(int quantidadeMinimaValorUnitario) {
			this.quantidadeMinimaValorUnitario = quantidadeMinimaValorUnitario;
		}

		int calcularPreco() {
			if (quantidadeTotal == 0) {
				return 0;
			} else {
				if (quantidadeMinimaValorUnitario != 0) {
					if (quantidadeTotal % quantidadeMinimaValorUnitario == 0) {
						int quantidadeValorComposto = quantidadeTotal / quantidadeMinimaValorUnitario;
						return quantidadeValorComposto * valorComposto;
					} else if (quantidadeTotal >= quantidadeMinimaValorUnitario) {
						int quantidadeValorComposto = quantidadeTotal / quantidadeMinimaValorUnitario;
						int calculoValorComposto = quantidadeValorComposto * valorComposto;
						int quantidadeUnitario = quantidadeTotal % quantidadeMinimaValorUnitario;
						int calculoValorUnitario = valorUnitario * quantidadeUnitario;
						return calculoValorComposto + calculoValorUnitario;
					} else {
						int quantidadeValorComposto = quantidadeTotal * valorUnitario;
						return quantidadeValorComposto;
					}
				} else {
					int quantidadeValorComposto = quantidadeTotal * valorUnitario;
					return quantidadeValorComposto;
				}
			}
		}
	}

	public int ler(String letra) {
		for (int i = 0; i < letra.length(); i++) {
			getItens().get(letra.charAt(i) + "").quantidadeTotal = getItens().get(letra.charAt(i) + "").quantidadeTotal
					+ 1;
		}

		int precoTotal = 0;
		for (Preco preco : getItens().values()) {
			precoTotal = precoTotal + preco.calcularPreco();
		}

		for (int i = 0; i < letra.length(); i++) {
			getItens().get(letra.charAt(i) + "").quantidadeTotal = 0;
		}

		return precoTotal;
	}

	public void adicionarPrecos(String name, int valorUnitario, int valorComposto, int quantidadeMinimaValorUnitario) {
		Preco preco = new Preco();
		preco.setQuantidadeMinimaValorUnitario(quantidadeMinimaValorUnitario);
		preco.setValorComposto(valorComposto);
		preco.setValorUnitario(valorUnitario);
		this.getItens().put(name, preco);
	}

	public HashMap<String, Preco> getItens() {
		return itens;
	}

	public void setItens(HashMap<String, Preco> itens) {
		this.itens = itens;
	}
}
