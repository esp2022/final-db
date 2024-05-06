
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
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  // Set the correct header for form data
    xhr.send();

    // XHR GET REQUEST TO FETCH Snapshot DATA FROM SERVER

    var xhr = new XMLHttpRequest();
    xhr.withCredentials = true;

    xhr.addEventListener("readystatechange", function () {
        if (this.readyState === 4) {
            gvarsnapshot = JSON.parse(this.responseText);
            //console.log(gvarsnapshot);

            // Suppliers
            var supplierselect = document.getElementById("optionoforsupplierselection");
            for (var i = 0; i < gvarsnapshot.suppliers.length; i++) {
                var option = document.createElement("option");
                option.text = gvarsnapshot.suppliers[i].supplierName;
                option.value = gvarsnapshot.suppliers[i].supplierId;
                supplierselect.appendChild(option);
            }
            $('.selectpicker').selectpicker('refresh')

            // 3PL Partners
            var partnerselect = document.getElementById("optionoforpartnerselection");
            for (var i = 0; i < gvarsnapshot.partners.length; i++) {
                var option = document.createElement("option");
                option.text = gvarsnapshot.partners[i].partnerName;
                option.value = gvarsnapshot.partners[i].partnerId;
                partnerselect.appendChild(option);
            }
            $('.selectpicker').selectpicker('refresh')

            // Carriers
            var carrierselect = document.getElementById("optionoforcarrierselection");
            for (var i = 0; i < gvarsnapshot.carriers.length; i++) {
                var option = document.createElement("option");
                option.text = gvarsnapshot.carriers[i].carrierName;
                option.value = gvarsnapshot.carriers[i].carrierId;
                carrierselect.appendChild(option);
            }
            $('.selectpicker').selectpicker('refresh')

            // Stock Items
            var itemselect = document.getElementById("optionoforitemselection");
            for (var i = 0; i < gvarsnapshot.stocks.length; i++) {
                var option = document.createElement("option");
                option.text = gvarsnapshot.stocks[i].partNumber;
                option.value = gvarsnapshot.stocks[i].itemId;
                itemselect.appendChild(option);
            }
            $('.selectpicker').selectpicker('refresh')
        }
    });

    xhr.open("GET", "/snapshot");
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  // Set the correct header for form data
    xhr.send();

});

// Create Replenishment Order
$("#replentoredercreatesubmitbtn").click(function () {
    event.preventDefault();  // Prevent the default form submission
    const supplier = document.getElementById('optionoforsupplierselection').value;
    const partner = document.getElementById('optionoforpartnerselection').value;
    const carrier = document.getElementById('optionoforcarrierselection').value;
    const item = document.getElementById('optionoforitemselection').value;
    const quantity = document.getElementById('Quantityinput').value;
    const date = $("#datepicker").data('datepicker').getFormattedDate('yyyy-mm-dd')
    const awb = document.getElementById('AirWayBillNumberinput').value;
    const formData = new FormData();
    formData.append('supplier', supplier);
    formData.append('partner', partner);
    formData.append('carrier', carrier);
    formData.append('item', item);
    formData.append('quantity', quantity);
    formData.append('date', date);
    formData.append('awb', awb);
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
                //console.log("response text:" + this.responseText);
                orderNumber = JSON.parse(this.responseText);
                alert("Replenishment Order Created : " + orderNumber + " Please make a note of this!");
                window.location.href = "/replenordercreate";
            }

        }
    });

    xhr.open("POST", "/replenordercreate");
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  // Set the correct header for form data
    // Convert FormData to URL encoded string
    var urlEncodedDataPairs = [];
    for (var pair of formData.entries()) {
        urlEncodedDataPairs.push(encodeURIComponent(pair[0]) + '=' + encodeURIComponent(pair[1]));
    }
    xhr.send(urlEncodedDataPairs.join('&'));  // Send the URL encoded form data
});

$(function () {
    $("#datepicker").datepicker({
        autoclose: true,
        todayHighlight: true
    }).datepicker('update', new Date());
});

