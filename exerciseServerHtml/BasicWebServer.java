package exerciseServerHtml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BasicWebServer {

    public static void main(String[] args) {
        try {
            // Create a server socket on port 8080
            ServerSocket serverSocket = new ServerSocket(8080);

            System.out.println("Server started on port " + serverSocket.getLocalPort() + "...");

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Read the request from the client
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String request = in.readLine();
                System.out.println("Request received: " + request);

                // Only handle GET requests
                if (request.startsWith("GET")) {
                    // Send the response
                    OutputStream out = clientSocket.getOutputStream();
                    out.write("HTTP/1.1 200 OK\r\n".getBytes());
                    out.write("Content-Type: text/html\r\n".getBytes());
                    out.write("\r\n".getBytes());
                    out.write("<html><body><h1>Hello, World!</h1></body></html>".getBytes());
                    out.flush();
                }

                // Close the client socket
                clientSocket.close();
                System.out.println("Client disconnected.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
