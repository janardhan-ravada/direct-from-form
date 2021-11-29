angular.module('book_module').directive('bookDetails',function(){
	return{
		scope:{
			book:'=book'
		},
		templateUrl:'library/book_module/templates/directives/book_details.html'
	}
});