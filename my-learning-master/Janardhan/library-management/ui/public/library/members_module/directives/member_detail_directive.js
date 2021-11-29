angular.module('members_module').directive('memberDetail',function(){
	return{
		scope:{
			member:'=member'
		},
		templateUrl:'library/members_module/templates/directives/member_detail.html'
	}
});