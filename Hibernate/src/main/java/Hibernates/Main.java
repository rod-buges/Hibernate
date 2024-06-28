package Hibernates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Aponta para o local onde se encontram as configurações feitas no hibernate.cfg.xml
        Configuration cfg = new Configuration().configure("/hibernate.cfg.xml");
        //Cria uma factory
        SessionFactory factory = cfg.buildSessionFactory();

        //Cria uma nova session
        Session session = factory.openSession();

        //Inicia uma nova transaction
        session.beginTransaction();

        //Cria um novo objeto departamento
        Departamento departamento = new Departamento();
        departamento.setNome("Desenvolvimento");
        
        //Salva o novo departamento no repositório
        session.persist(departamento);

        //Cria um novo objeto funcionário
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Ana");
        funcionario.setSalario(900.0);

        //Devemos buscar o departamento da nossa base de dados para aí então atribui-lo a nosso funcionário.
        Departamento departamento = session.createQuery("SELECT d from Departamento d WHERE d.nome=:nome", Departamento.class).setParameter("nome", "Financeiro").getSingleResult();

        funcionario.setDepartamento(departamento);

        //Salva o novo departamento no repositório
        session.persist(funcionario);

        //Buscando todos os departamentos
        List<Departamento> departamentos = session.createQuery("SELECT d from Departamento d").getResultList();
        //Buscando todos os departamentos
        List<Funcionario> funcionarios = session.createQuery("SELECT f from Funcionario f").getResultList();


        //Confirma a transação. Caso alguma das ações dadas após beginTransacation(), de errado, todas as outras ações feitas são canceladas.
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}