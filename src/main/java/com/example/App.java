package main.java.com.example;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();

        int result = calc.calculate(10, 5, "add-again");

        if (logger.isLoggable(Level.INFO)) {
            logger.info(String.valueOf(result));
        }

        UserService service = new UserService();

        if (args.length > 0) {
            String username = args[0];
            service.findUser(username);
            service.deleteUser(username);
        }
    }
}