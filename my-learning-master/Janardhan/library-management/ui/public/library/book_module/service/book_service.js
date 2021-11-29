angular.module('book_module').service('bookService', function($http){


	
	this.allBooks = function(){
		return $http.get("http://localhost:8080/books");
	};

	this.addNewBook = function(book){
		$http({
			method : 'POST',
			url :'http://localhost:8080/books',
			data : book
		});
	};

	this.getBook = function (id) {
		return $http.get("http://localhost:8080/books/"+id);
	};
	
});


