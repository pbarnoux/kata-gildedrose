package code.kata.gildedrose;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.*;

public class InnServer {

	@SuppressWarnings("restriction")
	public static void main(final String args[]) throws IOException {
		final HttpServer server = HttpServer.create(new InetSocketAddress(8080), 100);
		server.createContext("/", new InnServerHandler());
		server.setExecutor(null);
		server.start();
	}
}

@SuppressWarnings("restriction")
class InnServerHandler implements HttpHandler {

	@Override
	public void handle(final HttpExchange exchange) throws IOException {
		final String uri = exchange.getRequestURI().toString();

		switch (uri) {
		case "/": {
			final byte content[] = "Hello World".getBytes();
			exchange.getResponseHeaders().add("Content-Type", "text/html");
			exchange.sendResponseHeaders(200, content.length);
			exchange.getResponseBody().write(content);
			break;
		}
		default:
			exchange.sendResponseHeaders(404, -1);
		}
		exchange.close();
	}

}
