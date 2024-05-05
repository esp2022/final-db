$("#operatorselectedsubmitbtn").click(function (event) {
    event.preventDefault();  // Prevent the default form submission

    // Capture Operator First name, Last name, username, and password
    const firstName = document.getElementById('operatorfirstname').value;
    const lastName = document.getElementById('operatorlastname').value;
    const username = document.getElementById('operatorusername').value;
    const password = document.getElementById('operatorpassword').value;
    const passwordRepeat = document.getElementById('operatorpasswordrepeat').value; // Assuming this element exists

    // Log the values (optional, for debugging)

    // Create a FormData object and append the form fields
    var formData = new FormData();
    formData.append('firstName', firstName);
    formData.append('lastName', lastName);
    formData.append('username', username);
    formData.append('password', password);
    formData.append('passwordRepeat', passwordRepeat);

    // Make an XHR HTTP Post Request
    var xhr = new XMLHttpRequest();
    xhr.withCredentials = true;

    xhr.addEventListener("readystatechange", function () {
        if (this.readyState === 4) {
            // if response url error parameter exists, show error message otherwise redirect to login page
            if (this.responseURL.includes("error")) {
                const url = new URL(this.responseURL);
                const error = url.searchParams.get("error");
                alert(error);
            }
            else {
                window.location.href = "/login";
            }

        }
    });

    xhr.open("POST", "/register");
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  // Set the correct header for form data

    // Convert FormData to URL encoded string
    var urlEncodedDataPairs = [];
    for (var pair of formData.entries()) {
        urlEncodedDataPairs.push(encodeURIComponent(pair[0]) + '=' + encodeURIComponent(pair[1]));
    }
    xhr.send(urlEncodedDataPairs.join('&'));  // Send the URL encoded form data
});



