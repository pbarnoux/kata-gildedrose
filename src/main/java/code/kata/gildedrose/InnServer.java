package code.kata.gildedrose;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
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

	private final Inn inn = new Inn();

	@Override
	public void handle(final HttpExchange exchange) throws IOException {
		final String uri = exchange.getRequestURI().toString();
		final ObjectMapper mapper = new ObjectMapper();

		switch (uri) {
		case "/items": {
			final byte content[] = mapper.writeValueAsBytes(inn.getItems());
			exchange.getResponseHeaders().add("Content-Type", "application/json");
			exchange.sendResponseHeaders(200, content.length);
			exchange.getResponseBody().write(content);
			break;
		}
		default:
			final byte content[] = Files.readAllBytes(Paths.get("web", "index.html"));
			exchange.getResponseHeaders().add("Content-Type", "text/html");
			exchange.sendResponseHeaders(200, content.length);
			exchange.getResponseBody().write(content);
			break;
		}
		exchange.close();
	}

}
