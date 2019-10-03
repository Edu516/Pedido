import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Pedido p = new Pedido();
		Produto pr = new Produto();
		Scanner entrada =  new Scanner(System.in);
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		
		Produto pd = new Produto();
		
		pd.setCodigo(1);
		pd.setDescricao("Teclado");
		pd.setQuantidade(5);
		pd.setValor(25);
		
		Produto pc = new Produto();
		
		pc.setCodigo(2);
		pc.setDescricao("CD");
		pc.setQuantidade(6);
		pc.setValor(25);
		Cliente cli = new Cliente();
		cli.setNome("Edy");
		cli.setCodigo(1);
		cli.setEmail("edy@hotmail");
		
		Vendedor v = new Vendedor();
		
		v.setNome("Carlos");
		v.setCodigo(2);
		p.setVendedor(v);
		p.setCliente(cli);
		p.addProduto(pc);
		p.addProduto(pd);
		//só pra teste ex2
		p.addProduto(pc);
		//ex3
		System.out.println(pc.totalItem());
		System.out.println(pd.totalItem());
		//ex4
		System.out.println(p.totalPedido());
		//ex5
		System.out.println("Ex 5: "+p.valorMedio());
		//
		System.out.println("ex 6");
		ArrayList<Produto> ex6 = new ArrayList<Produto>();
		ex6= (ArrayList<Produto>) p.quantidadeMaior(6);
		for (int i = 0; i < ex6.size(); i++) {
			System.out.println(ex6.get(i).getDescricao());
			System.out.println(ex6.get(i).getQuantidade());
		}
		//ex7
		System.out.println("ex7"+p.nomeVendedor());
		//ex8
		System.out.println("ex8: "+ p.emailCliente());
		//ex9
		System.out.println("Ex9 :Pesquisa substring");
		ArrayList<Produto> ex9 = new ArrayList<Produto>();
		
		
		
	}

}
