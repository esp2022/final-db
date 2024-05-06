
$("#operatorselectedsubmitbtnlogin").click(function (event) {
    event.preventDefault();  // Prevent the default form submission
    const username = document.getElementById('operatorname').value;
    const password = document.getElementById('operatorpassword').value;
    console.log(username, password);
    const formData = new FormData();
    formData.append('username', username);
    formData.append('password', password);
    var xhr = new XMLHttpRequest();
    xhr.withCredentials = true;
    xhr.addEventListener("readystatechange", function () {
        if (this.readyState === 4) {
            if (this.responseURL.includes("error")) {
                const url = new URL(this.responseURL);
                const error = url.searchParams.get("error");
                alert(error);
            }
            else {
                window.location.href = "/dashboard";
            }

        }
    });
    xhr.open("POST", "/login");
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  // Set the correct header for form data
    // Convert FormData to URL encoded string
    var urlEncodedDataPairs = [];
    for (var pair of formData.entries()) {
        urlEncodedDataPairs.push(encodeURIComponent(pair[0]) + '=' + encodeURIComponent(pair[1]));
    }
    xhr.send(urlEncodedDataPairs.join('&'));  // Send the URL encoded form data
})  
