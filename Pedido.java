import java.util.ArrayList;
import java.util.List;

public class Pedido extends Operacao{
	private int codigo;
	protected Vendedor vendedor;
	protected Cliente cliente;
	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	
	public Pedido() {
		vendedor = new Vendedor();
		cliente = new Cliente();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public ArrayList<Produto> getListaProdutos() {
		return listaProdutos;
	}
	public void setListaProdutos(ArrayList<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	public boolean verificaProdutoUnico(Produto produto) {
		for (int i = 0; i < listaProdutos.size(); i++) {
			if(produto.getDescricao().equalsIgnoreCase(listaProdutos.get(i).getDescricao())) {
				return true;
			}
		}
		return false;
	}
	public boolean addProduto(Produto produto) {
		if(!verificaProdutoUnico(produto)) {
			listaProdutos.add(produto);
			return false;
		}else {
			return true;
		}
	}
	public double totalPedido() {
		double total =0;
		for (int i = 0; i < listaProdutos.size(); i++) {
			total = listaProdutos.get(i).totalItem()+ total;
		}
		return total;
	}
	public double valorMedio() {
		double total =0;
		for (int i = 0; i < listaProdutos.size(); i++) {
			total = listaProdutos.get(i).getValor()+ total;
		}
		return total / listaProdutos.size();
	}
	
	public List<Produto> quantidadeMaior(int quantidade){
		List<Produto> quantidadeMaior = new ArrayList<Produto>();
		for (int i = 0; i < listaProdutos.size(); i++) {
			if(listaProdutos.get(i).getQuantidade()< quantidade)
				quantidadeMaior.add(listaProdutos.get(i));
		}
		return quantidadeMaior;
	}
	public String nomeVendedor() {
		return vendedor.getNome();
	}
	public String emailCliente() {
		return cliente.getEmail();
	}
	public List<Produto> buscaProdutoDescricao(String descricao){
		List<Produto> listaDescricao = new ArrayList<Produto>();
		
		for (int i = 0; i < listaProdutos.size(); i++) {
			if(listaProdutos.get(i).getDescricao().substring(0, descricao.length()).equalsIgnoreCase(descricao)){
				listaDescricao.add(listaProdutos.get(i));
			}
		}
		return listaDescricao;
	}
	
	public int dias() {
		long secIn= getDtInicio().getTime();
		long secFi = getDtFim().getTime();
		long dif = ((((((secFi - secIn)/1000)/100)/60)/60)/24);
		return (int) dif;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido [codigo=");
		builder.append(codigo);
		builder.append(", vendedor=");
		builder.append(vendedor);
		builder.append(", cliente=");
		builder.append(cliente);
		builder.append(", listaProdutos=");
		builder.append(listaProdutos);
		builder.append("]");
		return builder.toString();
	}
	
	
}
