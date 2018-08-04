
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaladinTest {
    @Test
    public void whenBlockSuccess() {
        Paladin paladin = new Paladin("Poebator");
        paladin.setBlock(1);
        paladin.turn(1,8);
        assertThat(paladin.getHealth(), is(100));
    }

}
