package servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;

public class AssertTest {

    @Test
    public void test(){
        Assert.assertTrue(true);
        Assert.assertFalse(false);

        Assert.assertEquals(1, 1);

        Assert.assertEquals(1.52, 1.52, 0.01);
        Assert.assertEquals(1.5254, 1.52546, 0.0001);

        int i = 5;
        Integer i2 = 5;

        //Assert.assertEquals(i, i2);

        Assert.assertEquals(Integer.valueOf(i), i2);
        Assert.assertEquals(i, i2.intValue());

        Assert.assertEquals("bola", "bola"); // Teste não passa: Assert.assertEquals("bola", "Bola");
        Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
        Assert.assertTrue("bola".startsWith("bo"));

        Usuario u1 = new Usuario("Usuario 1");
        Usuario u2 = new Usuario("Usuario 2");

        Assert.assertEquals("Não são o mesmo objeto", u1, u2); // Utiliza o HashCode e Equals

        Assert.assertSame(u1, u2); // Verifica se são da mesma instância
    }
}