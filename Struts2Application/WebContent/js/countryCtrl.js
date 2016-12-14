/**
 * 
 */
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