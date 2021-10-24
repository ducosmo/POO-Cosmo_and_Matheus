package Steam_zuado;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Jogo {
	
	 private String nome;
	    private double preco;
	    private List<CategoriaDeJogo> categorias;
	    
	    public Jogo(String nome) {
	    	this(nome, 0.0, new ArrayList<>());
	    }

	    public Jogo(String nome, double preco, List<CategoriaDeJogo> categorias) {
	        this.nome = nome;
	        this.setPreco(preco);
	        this.categorias = categorias;
	    }
	    public Jogo() {
	    	this("", 0.0, new ArrayList<>());
	    }

	    public boolean adicionaCategoria(CategoriaDeJogo categoria) {
	    	if (!this.categorias.contains(categoria)) {
	    		this.categorias.add(categoria);
	    		return true;
	    	} else {
	    		return false;
	    	}
	    }
	    
	    public boolean ehDaCategoria(CategoriaDeJogo categoria) {
	    	for (CategoriaDeJogo cat : this.categorias) {
	            if (cat.equals(categoria)) {
	                return true;
	            }
	        }
	        return false;
	    }
	    
	    
		public String getNome() {
			return nome;
		}
		
		public double getPreco() {
			return preco;
		}
		
		public List<CategoriaDeJogo> getCategorias(){
			return categorias;
		}
		
		public void setPreco(double preco) {
			this.preco = preco;
		}
		
		public void setCategorias(List<CategoriaDeJogo> categorias) {
			this.categorias = categorias;
		}
		
		@Override
		public String toString() {
			return ("Nome["+nome+"] Preço["+preco+"]");
		}
		
		
		@Override
		public int hashCode() {
			return Objects.hash(nome);
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Jogo other = (Jogo) obj;
			return Objects.equals(nome, other.nome);
		}


}
