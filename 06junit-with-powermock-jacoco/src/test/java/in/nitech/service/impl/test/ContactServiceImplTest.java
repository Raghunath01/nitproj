package in.nitech.service.impl.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import in.nitech.dao.IContactDao;
import in.nitech.service.impl.ContactServiceImpl;

public class ContactServiceImplTest {
	
	
	@Test
	public void testFindContactNumByName() {
		
		IContactDao daooo = Mockito.mock(IContactDao.class);
		IContactDao mockDao = PowerMockito.mock(IContactDao.class);
		
		
		PowerMockito.when(mockDao.findContactNumByName("Ajay")).thenReturn(12345L);
		
		ContactServiceImpl service = new ContactServiceImpl();
		service.setDao(mockDao);
		Long num = service.findContactNumByName("Ajay");
		assertNotNull(num);

	}
	
}
