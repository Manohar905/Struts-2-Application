/**
 * 
 */
angular.module("countryApp", []);
	var app = angular.module('myApp', []);

	function MyController($scope, $http) {

		$scope.getDataFromServer = function() {
			$http({
				method : 'GET',
				url : 'javaAngularJS'
			}).success(function(data, status, headers, config) {
				$scope.person = data;
			}).error(function(data, status, headers, config) {
				// called asynchronously if an error occurs
				// or server returns response with an error status.
			});

		};
	};
	var app=angular.module("countryApp", []);
	angular.module("countryApp")
    .controller("countryCtrl", function($scope, countryService){
        $scope.states = [];
        $scope.onCountryChange = function(countryName){
            //alert(countryName);
            $scope.states = countryService.getStatesByCountry(countryName);
            console.log($scope.states);
        };
    })
    .service("countryService", function(){
        this.getStatesByCountry = function(countryName){
            if(countryName === "India"){
                return ["Andhra Pradesh", "Bihar", "West Bengal", "Telangana", "Tamilnadu"];
            }
            else if(countryName === "USA")
                return ["CA", "TX", "WA", "OR"];
        }
    });