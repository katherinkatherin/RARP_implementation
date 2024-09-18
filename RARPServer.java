import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class RARPServer {
    private static final int PORT = 5000;
    private static final Map<String, String> macToIpMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        // Initialize the MAC to IP map
        macToIpMap.put("00:1A:2B:3C:4D:5E", "192.168.1.10");
        macToIpMap.put("00:1A:2B:3C:4D:5E", "192.168.1.10");
        macToIpMap.put("00:1A:2B:3C:4D:5F", "192.168.1.11");
        macToIpMap.put("00:1A:2B:3C:4D:60", "192.168.1.12");
        macToIpMap.put("00:1A:2B:3C:4D:61", "192.168.1.13");
        macToIpMap.put("00:1A:2B:3C:4D:62", "192.168.1.14");
        macToIpMap.put("00:1A:2B:3C:4D:63", "192.168.1.15");
        macToIpMap.put("00:1A:2B:3C:4D:64", "192.168.1.16");
        macToIpMap.put("00:1A:2B:3C:4D:65", "192.168.1.17");
        macToIpMap.put("00:1A:2B:3C:4D:66", "192.168.1.18");
        macToIpMap.put("00:1A:2B:3C:4D:67", "192.168.1.19");
        macToIpMap.put("00:1A:2B:3C:4D:68", "192.168.1.20");
        macToIpMap.put("00:1A:2B:3C:4D:69", "192.168.1.21");
        macToIpMap.put("00:1A:2B:3C:4D:6A", "192.168.1.22");
        macToIpMap.put("00:1A:2B:3C:4D:6B", "192.168.1.23");
        macToIpMap.put("00:1A:2B:3C:4D:6C", "192.168.1.24");
        macToIpMap.put("00:1A:2B:3C:4D:6D", "192.168.1.25");
        macToIpMap.put("00:1A:2B:3C:4D:6E", "192.168.1.26");
        macToIpMap.put("00:1A:2B:3C:4D:6F", "192.168.1.27");
        macToIpMap.put("00:1A:2B:3C:4D:70", "192.168.1.28");
        macToIpMap.put("00:1A:2B:3C:4D:71", "192.168.1.29");
        macToIpMap.put("00:1A:2B:3C:4D:72", "192.168.1.30");
        macToIpMap.put("00:1A:2B:3C:4D:73", "192.168.1.31");
        macToIpMap.put("00:1A:2B:3C:4D:74", "192.168.1.32");
        macToIpMap.put("00:1A:2B:3C:4D:75", "192.168.1.33");
        macToIpMap.put("00:1A:2B:3C:4D:76", "192.168.1.34");
        macToIpMap.put("00:1A:2B:3C:4D:77", "192.168.1.35");
        macToIpMap.put("00:1A:2B:3C:4D:78", "192.168.1.36");
        macToIpMap.put("00:1A:2B:3C:4D:79", "192.168.1.37");
        macToIpMap.put("00:1A:2B:3C:4D:7A", "192.168.1.38");
        macToIpMap.put("00:1A:2B:3C:4D:7B", "192.168.1.39");
        macToIpMap.put("00:1A:2B:3C:4D:7C", "192.168.1.40");
        macToIpMap.put("00:1A:2B:3C:4D:7D", "192.168.1.41");
        macToIpMap.put("00:1A:2B:3C:4D:7E", "192.168.1.42");
        macToIpMap.put("00:1A:2B:3C:4D:7F", "192.168.1.43");
        macToIpMap.put("00:1A:2B:3C:4D:80", "192.168.1.44");
        macToIpMap.put("00:1A:2B:3C:4D:81", "192.168.1.45");
        macToIpMap.put("00:1A:2B:3C:4D:82", "192.168.1.46");
        macToIpMap.put("00:1A:2B:3C:4D:83", "192.168.1.47");
        macToIpMap.put("00:1A:2B:3C:4D:84", "192.168.1.48");
        macToIpMap.put("00:1A:2B:3C:4D:85", "192.168.1.49");
        macToIpMap.put("00:1A:2B:3C:4D:86", "192.168.1.50");
        macToIpMap.put("00:1A:2B:3C:4D:87", "192.168.1.51");
        macToIpMap.put("00:1A:2B:3C:4D:88", "192.168.1.52");
        macToIpMap.put("00:1A:2B:3C:4D:89", "192.168.1.53");
        macToIpMap.put("00:1A:2B:3C:4D:8A", "192.168.1.54");
        macToIpMap.put("00:1A:2B:3C:4D:8B", "192.168.1.55");
        macToIpMap.put("00:1A:2B:3C:4D:8C", "192.168.1.56");
        macToIpMap.put("00:1A:2B:3C:4D:8D", "192.168.1.57");
        macToIpMap.put("00:1A:2B:3C:4D:8E", "192.168.1.58");
        macToIpMap.put("00:1A:2B:3C:4D:8F", "192.168.1.59");
        macToIpMap.put("00:1A:2B:3C:4D:90", "192.168.1.60");
        macToIpMap.put("00:1A:2B:3C:4D:91", "192.168.1.61");
        macToIpMap.put("00:1A:2B:3C:4D:92", "192.168.1.62");
        macToIpMap.put("00:1A:2B:3C:4D:93", "192.168.1.63");
        macToIpMap.put("00:1A:2B:3C:4D:94", "192.168.1.64");
        macToIpMap.put("00:1A:2B:3C:4D:95", "192.168.1.65");
        macToIpMap.put("00:1A:2B:3C:4D:96", "192.168.1.66");
        macToIpMap.put("00:1A:2B:3C:4D:97", "192.168.1.67");
        macToIpMap.put("00:1A:2B:3C:4D:98", "192.168.1.68");
        macToIpMap.put("00:1A:2B:3C:4D:99", "192.168.1.69");
        macToIpMap.put("00:1A:2B:3C:4D:9A", "192.168.1.70");


        // Create and start the server
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        server.createContext("/resolve", RARPServer::handleRequest);
        server.setExecutor(null); // creates a default executor
        System.out.println("RARP HTTP Server started on port " + PORT);
        server.start();
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        // Add CORS headers
        exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "Content-Type");

        if ("POST".equals(exchange.getRequestMethod())) {
            // Read the request body (MAC Address)
            String macAddress = new String(exchange.getRequestBody().readAllBytes()).trim();

            // Lookup the IP address
            String ipAddress = macToIpMap.getOrDefault(macAddress, "MAC Address not found.");

            // Send the response
            byte[] responseBytes = ipAddress.getBytes();
            exchange.sendResponseHeaders(200, responseBytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(responseBytes);
            os.close();
        } else {
            // For methods other than POST, respond with Method Not Allowed
            exchange.sendResponseHeaders(405, -1); // Method Not Allowed
        }
    }
}
