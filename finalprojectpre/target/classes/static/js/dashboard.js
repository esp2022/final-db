
$(document).ready(function () {
    // XHR GET REQUEST TO FETCH DATA FROM SERVER

    var xhr = new XMLHttpRequest();
    xhr.withCredentials = true;

    xhr.addEventListener("readystatechange", function () {
        if (this.readyState === 4) {
            firstName = JSON.parse(this.responseText).firstName;
            lastName = JSON.parse(this.responseText).lastName;
            document.getElementById("hellomessage").innerHTML =  "Hello " + firstName + " " + lastName;
        }
    });

    xhr.open("GET", "/user");
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  // Set the correct header for form data

    xhr.send();

});