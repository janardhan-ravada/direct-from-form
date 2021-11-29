angular.module('book_module').controller('bookViewController', function ($scope, $stateParams, bookService) {
    bookService.getBook($stateParams.id).success(function (data) {
        $scope.book=data;
    });

});