import com.personagemrpg.modelo.Item;
import com.personagemrpg.modelo.Personagem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gustavo
 */
public class TesteItem {

    EntityManagerFactory emf;
    EntityManager em;

    public TesteItem() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("PersonagemRPGPU");
        em = emf.createEntityManager();
    }
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    @Test
    public void testePersistirPais() {
        boolean exception = false;
        try {
            Item i = new Item();
            
            i.setDescricao("Pão");
            i.setPeso(15.0);
            em.getTransaction().begin();
            em.persist(i);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
            
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }

}
