function resolveMacAddress() {
    const macAddress = document.getElementById("macAddress").value;
    const responseDiv = document.getElementById("response");

    fetch('http://localhost:5000/resolve', {
        method: 'POST',
        headers: {
            'Content-Type': 'text/plain'
        },
        body: macAddress
    })
    .then(response => response.text())
    .then(data => {
        if (data.includes("MAC Address not found")) {
            responseDiv.textContent = "MAC Address not found.";
            responseDiv.style.color = "red";  // Display error in red
        } else {
            responseDiv.textContent = "The allocated IP address is: " + data;
            responseDiv.style.color = "green";  // Display success in green
        }
    })
    .catch(error => {
        console.error("Error:", error);
        responseDiv.textContent = "Error resolving MAC Address.";
        responseDiv.style.color = "red";
    });
}
