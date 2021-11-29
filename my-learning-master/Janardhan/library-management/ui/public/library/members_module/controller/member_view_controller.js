angular.module('members_module').controller('memberViewController', function($scope, $stateParams){
	$scope.member = JSON.parse($stateParams.member); 
});