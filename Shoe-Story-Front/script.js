console.log("this is it");

function setupButtons() {
  $("#add").on("click", addShoe);
}

function stockList() {
  $.ajax({
    url: "http://localhost:8080/",
    async: true,
    success: successCallback,
    error: errorCallback,
  });
}

function successCallback(response) {
  response.forEach(function (element) {
    var table = $("#stock-table");
    var HTMLstr =
      "<tr><th scope=\"row\"> " +
      element.id +
      "</th>" +
      "<td> " +
      element.shoename +
      "</td>" +
      "<td> " +
      element.description +
      "</td>" +
      "<td> " +
      element.amount +
      "</td>" +
      "<td> " +
      element.in_stock +
      "</td>" +
      '<td><a class="btn btn-warning">Edit</a></td>' +
      '<td><a class="btn btn-danger">Delete</a></td>' +
      "</tr>";
    $(HTMLstr).appendTo(table);
  });
}

function errorCallback(request, status, error) {
  console.log("Error " + error + " for " + request + ". Status: " + status);
}

function addShoe() {
  hideAll();
  $("#added").show();

  $.ajax({
    url: "http://localhost:8080/",
    type: "POST",
    data: JSON.stringify({
      shoename: $("#shoename").val(),
      description: $("#description").val(),
      amount: $("#amount").val(),
      in_stock: $("#in_stock").val(),
    }),
    contentType: "application/json",
    async: true,
    success: updateData,
    error: errorCallback,
  });

  $("#stock-table").empty();
  refreshTable();
}

function updateData() {
  $("form").trigger("reset");
  successCallback();
}

function hideAll() {
  $(".alert").hide();
}

function refreshTable() {
  $("#stock-table").empty();
  $.ajax({
    url: "http://localhost:8080/",
    async: true,
    success: successCallback,
    error: errorCallback,
  });
}


$(document).ready(function () {
  stockList();
  setupButtons();
});
