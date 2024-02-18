package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Aplicacao {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		Pessoa p1 = new Pessoa(null,"Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null,"Otavio da Silva", "otavio@gmail.com");
		Pessoa p3 = new Pessoa(null,"Bruna da Silva", "bruna@gmail.com");
		
		//Quando o JPA não faz uma simples leitura do banco de dados ele tem que fazer uma transação
		//Iniciando uma transação com o Banco de Dados
		em.getTransaction().begin();
		//Pega o objeto e salva no banco de dados
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		//Confirmando as alterações que eu fiz
		em.getTransaction().commit();
		
		System.out.println("Deu crrto");
		

	}

}
