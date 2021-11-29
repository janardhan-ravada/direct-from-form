angular.module('members_module').service('membersService', function(){
	var members= [];

	this.addMember = function(member){
		members.push(member);
	};

	this.allMembers = function(){
		return members;
	};

});