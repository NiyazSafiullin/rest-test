package ServiceTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.safiullin.rest.model.Clients;
import ru.safiullin.rest.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ClientServiceTest {
    @MockBean
    private ClientRepository clientRepository;

    @Test
    public void testGetByIdFromDb() {
        Clients clients = clientRepository.getById(1L);//из базы
        assertEquals(clients.getId(),1);
    }

    @Test
    public void testSaveAndGet() {
        List<Clients> actual = new ArrayList<>();
        actual.add(new Clients("Alex", "Kazan st dobra 1", 1, 2L, "Admin"));

        Clients fromDb = clientRepository.getById(2L);
        assertEquals(actual, fromDb);

    }
}


