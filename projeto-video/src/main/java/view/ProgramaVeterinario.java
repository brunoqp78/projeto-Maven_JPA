package view;
import java.util.Iterator;
import java.util.List;
import control.VeterinarioControle;
import model.Veterinario;

public class ProgramaVeterinario {
	public static void main(String[] args) {
		//inserindo
		Veterinario novo = new Veterinario(null, "bruno", "clinica");		
		VeterinarioControle controle = new VeterinarioControle();	
		controle.inserir(novo);
		
		//buscando
		novo = controle.buscarPorId(3); //o id 3 precisa existir no banco, modifique o valor
		System.out.println(novo.getNome()); // substitua por um método get do seu projeto
		
		//modificando
		novo.setNome("bruno queiroz"); // no seu caso utilize um método set do seu projeto
		controle.alterar(novo);
		
		//buscar todos
		List<Veterinario> objetos = controle.buscarTodos();
		for (Iterator iterator = objetos.iterator(); iterator.hasNext();) {
			Veterinario obj = (Veterinario) iterator.next();
			System.out.println(obj.getNome());
		}
		
		//excluir
		controle.excluir(objetos.get(0));
		
		//excluir por id
		controle.excluirPorId(3); //o id 3 precisa existir no banco, modifique o valor	
	}
}
