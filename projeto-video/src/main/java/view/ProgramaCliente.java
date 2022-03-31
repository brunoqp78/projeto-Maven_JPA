package view;
import java.util.Iterator;
import java.util.List;
import control.ClienteControle;
import model.Cliente;

public class ProgramaCliente {
	public static void main(String[] args) {
		//inserindo
		Cliente novo = new Cliente(null, "bruno", "555.555.555-55", "bruno", "672846237846");		
		ClienteControle controle = new ClienteControle();	
		controle.inserir(novo);
		
		//buscando
		novo = controle.buscarPorId(3); //o id 3 precisa existir no banco, modifique o valor
		if (novo!=null) {
			System.out.println(novo.getNome()); // substitua por um método get do seu projeto
		}
		
		//modificando
		if (novo!=null) {
			novo.setNome("bruno queiroz"); // no seu caso utilize um método set do seu projeto
			controle.alterar(novo);
		}
		
		//buscar todos
		System.out.println("Listando todos:");
		List<Cliente> objetos = controle.buscarTodos();
		for (Iterator iterator = objetos.iterator(); iterator.hasNext();) {
			Cliente obj = (Cliente) iterator.next();
			System.out.println(obj.getNome());
		}
		
		//excluir
		controle.excluir(objetos.get(0));
		
		//excluir por id
		controle.excluirPorId(10); //o id 10 precisa existir no banco, modifique o valor	
	}
}
