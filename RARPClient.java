<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RARP Client</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 300px;
        }

        .container h2 {
            margin-bottom: 20px;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: #007BFF;
            border: none;
            color: white;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }

        #response {
            margin-top: 20px;
            color: green;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>RARP Client</h2>
        <input type="text" id="macAddress" placeholder="Enter MAC Address">
        <button onclick="resolveMacAddress()">Send Request</button>
        <div id="response"></div>
    </div>

    <script>
        function resolveMacAddress() {
            const macAddress = document.getElementById('macAddress').value.trim();
            const responseDiv = document.getElementById('response');

            if (macAddress === "") {
                responseDiv.innerText = "MAC Address cannot be empty.";
                responseDiv.style.color = "red";
                return;
            }

            // Send POST request to the RARP server
            fetch('http://localhost:5000/resolve', {
                method: 'POST',
                headers: {
                    'Content-Type': 'text/plain'
                },
                body: macAddress
            })
            .then(response => response.text())
            .then(data => {
                responseDiv.innerText = data;
                responseDiv.style.color = "green";
            })
            .catch(error => {
                responseDiv.innerText = "Error: " + error.message;
                responseDiv.style.color = "red";
            });
        }
    </script>

</body>
</html>
