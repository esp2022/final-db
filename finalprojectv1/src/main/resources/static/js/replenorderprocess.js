$(document).ready(function () {
    // XHR GET REQUEST TO FETCH User DATA FROM SERVER

    var xhr = new XMLHttpRequest();
    xhr.withCredentials = true;

    xhr.addEventListener("readystatechange", function () {
        if (this.readyState === 4) {
            firstName = JSON.parse(this.responseText).firstName;
            lastName = JSON.parse(this.responseText).lastName;
            document.getElementById("hellomessage").innerHTML = "Hello " + firstName + " " + lastName;
        }
    });

    xhr.open("GET", "/user");
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send();

})

// ReplenOrder Status
$("#replentorederviewsubmitbtn").click(function () {
    event.preventDefault();  // Prevent the default form submission

    var asnordernumber = document.getElementById("asnordernumberinput").value;
    const formData = new FormData();
    formData.append("orderNumber", asnordernumber);
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
                document.getElementById("modalbodyid1").innerHTML = "Order Status: " + this.responseText;
                //alert ("Order Status: " + this.responseText);
            }
        }
    });

    xhr.open("POST", "/replenorderprocess/status");
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  // Set the correct header for form data
    // Convert FormData to URL encoded string
    var urlEncodedDataPairs = [];
    for (var pair of formData.entries()) {
        urlEncodedDataPairs.push(encodeURIComponent(pair[0]) + '=' + encodeURIComponent(pair[1]));
    }
    xhr.send(urlEncodedDataPairs.join('&'));  // Send the URL encoded form data
})

// ReplenOrder Receive

$("#replentorederreceivesubmitbtn").click(function () {
    event.preventDefault();  // Prevent the default form submission
    var asnordernumber = document.getElementById("asnordernumberinput").value;
    const formData = new FormData();
    formData.append("orderNumber", asnordernumber);
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

                document.getElementById("modalbodyid2").innerHTML = "Order Status: " + this.responseText;
                //alert ("Order Status: " + this.responseText);
            }
        }
    });

    xhr.open("POST", "/replenorderprocess/receive");
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  // Set the correct header for form data
    // Convert FormData to URL encoded string
    var urlEncodedDataPairs = [];
    for (var pair of formData.entries()) {
        urlEncodedDataPairs.push(encodeURIComponent(pair[0]) + '=' + encodeURIComponent(pair[1]));
    }
    xhr.send(urlEncodedDataPairs.join('&'));  // Send the URL encoded form data

})

// ReplenOrder PutAway
$("#replentorederputawaysubmitbtn").click(function () {
    event.preventDefault();  // Prevent the default form submission
    var asnordernumber = document.getElementById("asnordernumberinput").value;
    var putAwayAisle = document.getElementById("PutAwayAisleinput").value;
    var putAwayBin = document.getElementById("PutAwayBininput").value;
    const formData = new FormData();
    formData.append("orderNumber", asnordernumber);
    formData.append("putAwayAisle", putAwayAisle);
    formData.append("putAwayBin", putAwayBin);
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

                document.getElementById("modalbodyid3").innerHTML = "Order Status: " + this.responseText;
                //alert ("Order Status: " + this.responseText);
            }
        }
    })

    xhr.open("POST", "/replenorderprocess/putaway");
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  // Set the correct header for form data
    // Convert FormData to URL encoded string
    var urlEncodedDataPairs = [];
    for (var pair of formData.entries()) {
        
        urlEncodedDataPairs.push(encodeURIComponent(pair[0]) + '=' + encodeURIComponent(pair[1]));

    }
    xhr.send(urlEncodedDataPairs.join('&'));  // Send the URL encoded form data
})