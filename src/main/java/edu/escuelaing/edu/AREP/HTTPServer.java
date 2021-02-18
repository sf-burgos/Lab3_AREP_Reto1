package edu.escuelaing.edu.AREP;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HTTPServer {
    public static void main(String[] args) throws IOException {
        int port = 9009;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        HttpContext ctx = server.createContext("/");
        ctx.setHandler(HTTPServer::gestionarSolicitud);
        server.start();

    }

    private static void gestionarSolicitud(HttpExchange httpExchange) throws IOException {
        final  int CodeRespuesta = 200;
        String contenido = "Rta de respuesta desde el servidor HTTP";

        httpExchange.sendResponseHeaders(CodeRespuesta,contenido.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(contenido.getBytes());
        os.close();
    }
}
