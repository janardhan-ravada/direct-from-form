angular.module('book_module').controller('authorAddController', function($scope, authorService){

    $scope.author={ };

    $scope.addAuthor = function () {
        alert($scope.author.emailAddress);
        authorService.addAuthor($scope.author);
        $scope.author={};
    };

});