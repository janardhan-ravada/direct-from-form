angular.module('book_module').service('publisherService', function($http){

	this.publishers = function(){
		return $http.get("http://localhost:8080/publishers");
	}
});