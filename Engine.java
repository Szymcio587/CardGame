public class Engine {

    private static PlayerClass player;

    public static void main(String[] args) {
        Engine e = new Engine();
    }

    public Engine() {
        player = new PlayerClass("localhost", 6666);
        while(!player.HasStarted()) {
            System.out.print("");
        }
        Run();
    }

    public void Run() {
        player.Read().readPaths();
        GameWindow window = new GameWindow(player);
    }
}
