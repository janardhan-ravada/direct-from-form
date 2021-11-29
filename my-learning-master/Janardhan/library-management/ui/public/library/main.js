var libraryapp = angular.module('libraryapp',['ui.router', 'book_module','members_module']);

libraryapp.config(function($stateProvider, $urlRouterProvider){
	//When no route was provided
	$urlRouterProvider.otherwise('/home');

	$stateProvider.state('home',{
		url:'/home',
		//templateUrl : 'library/home/home.html'
	})
	.state('book_module',{
		url:'/bookmodule',
		templateUrl: 'library/book_module/bookindex.html'
	})
	.state('members_module',{
		url:'/membersmodule',
		templateUrl:'library/members_module/membersindex.html'
	})
	.state('all_books',{
		url:'/allbooks',
		templateUrl:'library/book_module/templates/all_books.html',
		parent :'book_module'
	})
	.state('add_book',{
		url:'/addbook',
		templateUrl:'library/book_module/templates/new_book.html',
		parent :'book_module'
	})
	.state('add_author',{
		url:'/addauthor',
		templateUrl:'library/book_module/templates/new_author.html',
		parent :'book_module'
	})
	.state('edit_book',{
		url:'/editbook',
		template:'<h1>Editing a book</h1>',
		parent :'book_module'
	})
	.state('delete_book',{
		url:'/deletebook',
		template:'<h1>deleting a book</h1>',
		parent :'book_module'
	})
	.state('book_details',{
		url:'/book/:id',
		templateUrl:'library/book_module/templates/book_view.html',
		controller :'bookViewController',
		parent :'book_module'
	})
	.state('add_member',{
		url:'/addmember',
		templateUrl:'library/members_module/templates/new_member.html',
		parent :'members_module'
	})
	.state('view_member',{
		url:'/viewmember/:member',
		controller: 'memberViewController',
		templateUrl:'library/members_module/templates/member_view.html',
		parent :'members_module'
	})
	.state('all_members',{
		url:'/addmember',
		templateUrl:'library/members_module/templates/all_members.html',
		parent :'members_module'
	})
	.state('edit_member',{
		url:'/editmember',
		template:'<h1>editmember</h1>',
		parent :'members_module'
	})
	.state('delete_member',{
		url:'/deletemember',
		template:'<h1>deletemember</h1>',
		parent :'members_module'
	});

});

