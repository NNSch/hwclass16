import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void testForFirstPlayer() {
        Player mars = new Player(5, "Марс", 100);
        Player sirius = new Player(10, "Сириус", 150);
        Game game = new Game();

        game.register(mars);
        game.register(sirius);

        int actual = game.round("Сириус", "Марс");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testForSecondPlayer() {
        Player mars = new Player(5, "Марс", 100);
        Player sirius = new Player(10, "Сириус", 150);
        Game game = new Game();

        game.register(mars);
        game.register(sirius);

        int actual = game.round("Марс", "Сириус");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testGameDraw() {
        Player mars = new Player(5, "Марс", 150);
        Player sirius = new Player(10, "Сириус", 150);
        Game game = new Game();

        game.register(mars);
        game.register(sirius);

        int actual = game.round("Марс", "Сириус");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testNotRegisteredExceptionFirstPlayer() {
        Player mars = new Player(5, "Марс", 150);
        Player sirius = new Player(10, "Сириус", 150);
        Game game = new Game();

        game.register(mars);
        game.register(sirius);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Луна", "Сириус"));
    }
    @Test
    public void testNotRegisteredExceptionSecondPlayer() {
        Player mars = new Player(5, "Марс", 150);
        Player sirius = new Player(10, "Сириус", 150);
        Game game = new Game();

        game.register(mars);
        game.register(sirius);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Марс", "Луна"));
    }
    @Test
    public void testNotRegisteredExceptionTwoPlayers() {
        Player mars = new Player(5, "Марс", 150);
        Player sirius = new Player(10, "Сириус", 150);
        Game game = new Game();

        game.register(mars);
        game.register(sirius);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Мурка", "Луна"));
    }
}
