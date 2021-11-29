angular.module('book_module').controller('bookController', function($scope, bookService, authorService, publisherService){
	bookService.allBooks().success(function(data){
		$scope.books = data;
	});

	authorService.authors().success(function (data) {
		$scope.authors = data;
	});

	publisherService.publishers().success(function (data) {
		$scope.publishers =data;
	});

	$scope.book={ };

	$scope.book.authors = [];
	$scope.multiselectsettings = {displayProp: 'name', enableSearch: true};



	$scope.addBook = function(){
		bookService.addNewBook($scope.book);
	};


});