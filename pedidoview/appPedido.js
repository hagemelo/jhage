angular.module("appPedido", []);


angular.module("appPedido").controller("pedidocontroller", function ($scope, $http) { 

	$scope.message="Alexsander";
	$scope.produtos = [];


	var carregarProdutos = function(){

		$http.get("http://localhost:8080/cadastro/produto/all").then(function (response) {

		    var data = response.data;
		    var status = response.status;
		    var statusText = response.statusText;
		    var headers = response.headers;
		    var config = response.config;

		    $scope.user = data;
		    console.log(data);

		});


		//$http.get("http://localhost:8080/produto");


		

	};
	carregarProdutos();

});
