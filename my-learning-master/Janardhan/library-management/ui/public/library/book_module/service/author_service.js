angular.module('book_module').service('authorService', function($http){
	var authors = [];

	this.authors = function(){
		return $http.get("http://localhost:8080/authors");
	} ;

	this.addAuthor = function(author){
		$http({
			method : 'POST',
			url :'http://localhost:8080/authors',
			data : author
		});
	};
});