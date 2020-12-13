let app = angular.module("app", []);

app.controller("CategoriesController", function ($scope, $http) {

    $scope.categories = [];

    $http.get('http://localhost:8080/getCategories').then(function (response) {
        $scope.categories=response.data;
    });
})
app.controller("SubCategoriesController", function ($scope, $http) {
    $scope.subCategories = [];

    $http.get('http://localhost:8080/getSubCategories').then(function (response) {
        $scope.subCategories=response.data;
    });
})
app.controller("CurrentUserController", function ($scope, $http) {
    $http.get('http://localhost:8080/user/getCurrent').then(function (response) {
        $scope.currentUser=response.data;
    });
})
app.controller("ContactInformationController", function ($scope, $http) {
    $http.get('http://localhost:8080/getContactInformation').then(function (response) {
        $scope.contactInformation=response.data;
    });
})
app.controller("add",function ($scope) {
    $scope.arr = [];

    $scope.addSubCat = function(name,id){
        let subcategory = {
            id:id,
            name:name
        };
        $.ajax( {
            method: 'POST',
            url:'admin/addSubCategory',
            contentType: 'application/json',
            data: JSON.stringify(subcategory)
        }).done(function(data) {
            window.location.reload();
        })
    };
})
