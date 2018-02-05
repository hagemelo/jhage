package br.com.jhage.pedido;

//import static org.junit.Assert.assertNotNull;

//import java.util.ArrayList;
//import java.util.List;

//import javax.annotation.Resource;

import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;

//import br.com.jhage.pedido_api.dao.MovimentoDao;
//import br.com.jhage.pedido_api.modelo.Movimento;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("/testContext.xml")
//@Transactional
public class MovimentoDaoTest {
	
//	@Autowired
//    private SessionFactory sessionFactory;
	
    @SuppressWarnings("unused")
	private Session currentSession;
    
//    @ResourceC
//    private MovimentoDao movimentoDao;
	
//    @Before
    public void openSession() {
//        currentSession = sessionFactory.getCurrentSession();
    }
	
//    @Test
    public void shouldHaveASessionFactory() {
    	
//        assertNotNull(sessionFactory);
    }
	
//	@Test
	public void deveAbrirMovimentoComOrdemEm1ParaMovimentosNull() throws Exception{

//		Assert.assertEquals(VALOR_1, movimentoDao.getMovimentoAberto().getOrdem());
	}
	
//	@Test
	public void deveAbrirMovimentoComOrdemEm1ParaMovimentosNotNull() throws Exception{
		
//		MovimentoDao movimentoDao = new MovimentoDao();
//		MovimentoDao movimentoDaoSpy = PowerMockito.spy(movimentoDao);	
//		PowerMockito.doNothing().when(movimentoDaoSpy, "carregarMovimentosDodia");
//		
//		PowerMockito.doReturn(this.getListMovimentosDiaEfechados()).when(movimentoDaoSpy, method(MovimentoDao.class, "getMovimentosDoDia"));
//		
//		Assert.assertEquals(new Integer(1), movimentoDaoSpy.getMovimentoAberto().getOrdem());
//		PowerMockito.verifyPrivate(movimentoDaoSpy).invoke("carregarMovimentosDodia");
//		PowerMockito.verifyPrivate(movimentoDaoSpy).invoke("getMovimentosDoDia");
	}
	
//	@Testo
//	public void deveAbrirMOvimentoDoDiaComOrdem1ComDiaAnteriorComMovimentoAberto(){
//		
////		when(movimentoDao.carregarMovimentosDodia()).thenReturn(2.8);
////		Assert.assertTrue(movimentoDao.buscarTodos().stream().filter(m -> m.isAberto()).count()>ValoresConstantes.ZERO);
////		Assert.assertEquals(new Integer(1), movimentoDao.getMovimentoAberto().getOrdem());
//		Assert.assertTrue(false);
//	}
	
//	private List<Movimento> getListMovimentosDiaEfechados(){
//		
//		List<Movimento> result =  new ArrayList<>();
//		Movimento mov = new Movimento(VALOR_1);
//		result.add(mov);
//		return result;
//	}

	
	public static final Integer VALOR_1 = new Integer(1);
}
