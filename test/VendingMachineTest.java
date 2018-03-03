import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class VendingMachineTest {

    @Test
    public void whenNoCoinsAreInsertedVendingMachineDisplaysInsertCoinsMessage() {
        VendingMachine vendingMachine = new VendingMachine();

        assertEquals("INSERT COINS", vendingMachine.getDisplayMessage());
    }
}
