angular.module('book_module').directive('newAuthor',function(){
	return{
		controller :'authorAddController',
		templateUrl:'library/book_module/templates/directives/author_add.html'
	}
});