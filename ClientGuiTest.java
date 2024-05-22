import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientGuiTest {

    private ClientGui clientGUI;

    @Before
    public void setUp() {
        clientGUI = new ClientGUI();
    }

    @After
    public void tearDown() {
        clientGUI = null;
    }

    @Test
    public void testClientGUIInitialization() {
        assertNotNull(clientGUI);
        assertFalse(clientGUI.isConnected());
        assertEquals("localhost", clientGUI.getServerAddress());
        assertEquals(12345, clientGUI.getServerPort());
    }

    @Test
    public void testSendMessage() {
        clientGUI.sendMessage("Hello Server!");
        String lastMessageSent = clientGUI.getLastMessageSent();
        assertEquals("Hello Server!", lastMessageSent);
    }
}
