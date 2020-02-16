import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;


public class Server{

    public static void createServer(Loghme loghme){
        Javalin app = Javalin.create().start(8080);
        app.get("/", ctx -> ctx.html("<h1>Welcome to Loghmeh</h1>"));
        app.get("/getRestaurants", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                String row = "<tr>\n" +
                        "            <td>1</td>\n" +
                        "            <td><img class=\"logo\" src=\"https://picsum.photos/536/354\" alt=\"logo\"></td>\n" +
                        "            <td>restaurant 1 name</td>\n" +
                        "            <td>luxury</td>\n" +
                        "        </tr>";
                String Table = "<table>\n" +
                        "        <tr>\n" +
                        "            <th>id</th>\n" +
                        "            <th>logo</th>\n" +
                        "            <th>name</th>\n" +
                        "            <th>description</th>\n" +
                        "        </tr>\n" +
                        "    </table>";
            }
        })
    }


}
