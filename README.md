
# RARP Server

## Overview

This project implements a simple Reverse Address Resolution Protocol (RARP) server using Java. The server listens for incoming HTTP POST requests containing a MAC address and responds with the corresponding IP address. If the MAC address is not found, it returns an appropriate error message.

## Features

- **MAC to IP Resolution**: Maps MAC addresses to IP addresses and responds to client requests with the corresponding IP.
- **Simple HTTP Interface**: Provides a straightforward HTTP API for querying IP addresses based on MAC addresses.
- **Easy Integration**: Can be easily integrated with a web-based frontend or any client capable of making HTTP POST requests.

## Prerequisites

- Java 11 or higher
- Maven (for building the project)
- A running instance of the RARP server

## Installation and Setup

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/rarp-server.git
   cd rarp-server
   ```

2. **Build the Project**:
   ```bash
   mvn clean install
   ```

3. **Run the Server**:
   ```bash
   mvn exec:java -Dexec.mainClass="com.example.RARPServer"
   ```

   The server will start on port 5000 by default.

## Usage

1. Open a web browser or a REST client.
2. Send a POST request to `http://localhost:5000/resolve` with the MAC address in the request body.
3. The server will respond with the associated IP address or an error message if the MAC address is not found.

## Example Request

**Request**:
```
POST /resolve HTTP/1.1
Host: localhost:5000
Content-Type: text/plain

00:1A:2B:3C:4D:5E
```

**Response**:
```
192.168.1.10
```

## Contributing

Feel free to fork the repository and submit pull requests. Contributions are welcome to enhance the functionality or improve the server.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

