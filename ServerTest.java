import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.Socket;

import static org.junit.Assert.*;

public class ServerTest {

    private Server server;

    @Before
    public void setUp() {
        server = new Server(12345);
    }

    @After
    public void tearDown() {
        server = null;
    }

    @Test
    public void testServerConnection() {
        try {
            Socket clientSocket = new Socket("localhost", 12345);
            assertNotNull(clientSocket);
            clientSocket.close();
        } catch (IOException e) {
            fail("Server connection test failed: " + e.getMessage());
        }
    }

    @Test
    public void testServerInitialization() {
        assertNotNull(server);
        assertEquals(12345, server.getPort());
    }
}
