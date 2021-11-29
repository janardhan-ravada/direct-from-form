angular.module('members_module').controller('membersController', function($scope, membersService, $state){

	var member ={};

	$scope.addMember = function(){
		alert($scope.member.name);
		membersService.addMember($scope.member);
	};

	$scope.members = membersService.allMembers();


	$scope.viewMember= function(member){
		alert('hai');
		alert(member.name);
		$state.go('view_member',{member:JSON.stringify(member)}, {location: false, inherit : false});
	}
});