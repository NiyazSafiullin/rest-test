package ServiceTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.safiullin.rest.model.Clients;
import ru.safiullin.rest.repository.ClientRepository;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class ClientServiceTest {
    @MockBean
    private ClientRepository clientRepository;

//    @Test
//    public void testGetByIdFromDb() {
//        Clients clients = clientRepository.getById(1L);//из базы
//        assertThat(clients.getId()).isEqualTo(1);
//    }
//
//    @Test
//    public void testSaveAndGet() {
//        clientRepository.getById(new Clients("Ivan", "Sidorov", "Mira",1));
//        Clients fromDb = clientRepository.getById(1);
//        assertThat(fromDb.getId()).isEqualTo(1);
//
//    }
}


