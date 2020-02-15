import java.io.IOException;

public class Main {
    public static void main(String [] args) throws IOException {
//        Http HttpClient = new Http();
        System.out.println(Http.Request());
        Loghme loghme = new Loghme();
        loghme.CommandHandler();
    }

}
