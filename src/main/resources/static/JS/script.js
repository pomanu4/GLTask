
$(document).ready(function() {
	getAllBooks();
	 moneyEarned(0);
});

function getAllBooks() {
	$
			.ajax({
				type : "GET",
				contentType : "application/json",
				url : "/books/all",
				success : function(result) {
					prepareTable();
					$(result)
							.each(
									function(index) {
										var count = index + 1;
										$("#table")
												.append(
														"<tr>"
																+ "<th>"
																+ count
																+ "</th>"
																+ '<th id="name">'
																+ this.bookName
																+ "</th>"
																+ "<th>"
																+ this.bookPrice
																+ "</th>"
																+ "<th>"
																+ '<button id="btn" type="button" class="btn btn-primary">buy</button>'
																+ "</th>"
																+ "<th class='bought'>" + 0
																+ "</th>"
																+ "</tr>");
									});
				},
				error : function() {
					$("#frame").append("<h5>" + "no data found" + "</h5>");
				}

			});
}

var total = 0;
$("#table").on("click", "button", function() {
	var name = $(this).parent().prevAll("#name").html();
	var price = $(this).parent().prev().html();
	var bought = $(this).parent().next().html();

	$(this).parent().next().text(parseInt(bought) + 1);

	total = total + parseInt(price);
	moneyEarned(total)
	$("#totalPrice").text(total);

	var count = 0;

	if ($("#bucket").html().indexOf(name) == -1) {
		$("#bucket").append("<span> " + name + " </span>");
	}

});

function moneyEarned(summ) {
	var number = summ;
	return $("#moneyEarned").text(number);
}

$("#refresh").on("click", function() {
	refresh();
});

function refresh() {
	total = 0;
	$(".bought").text(0);
	$("#bucket").children().filter(function(index) {
		return index != 0
	}).remove();
	$("#totalPrice").text(0);
	moneyEarned(0)
}

function prepareTable() {
	var t = $("#table tr").filter(function(index) {
		return index != 0;
	}).remove();
}


function addBook() {
		
	var content = $("#addBook");
			
		$.ajax({
			type : "POST",
			url : "/books/addone",
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			data : content.serialize(),
									
			success : function(result) {
				$("#addBook").prev().text(result).css("color", "blue");
				getAllBooks();
			},
			
			error : function(xhr, ajaxOptions, thrownError) {
				$("#addBook").prev().text("error occured !!!").css("color", "red");
			}
		});
}

$("#addBook").submit( function(event) {
	event.preventDefault();
	
	addBook();	
});


function addBookObject() {
		
	var book = {"bookName" : "bookObject", "bookPrice" : 55};
		
		$.ajax({
			type : "POST",
			url : "/books/object",
			contentType : "application/json; charset=UTF-8",
			data : JSON.stringify(book),
			dataType: "text",
						
			success : function(result) {
				$("#addBook").prev().text(result).css("color", "blue");
			},
			
			error : function(error) {
				$("#addBook").prev().text("error occured !!!").css("color", "red");
			}
		});
}
