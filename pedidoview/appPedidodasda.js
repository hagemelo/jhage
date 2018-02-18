angular.module("appPedido", []);



angular.module("appPedido").controller("pedidocontroller", function ($scope, $http) { 

	
	$scope.showformnovopedido = false;
	$scope.habilitarButtonnovopedido = false;

	var carregarPedidos = function(){

		$http.get("http://localhost:8080/atendimento/pedidosdodia").then(function (response) {

		    var data = response.data;
		    var status = response.status;
		    var statusText = response.statusText;
		    var headers = response.headers;
		    var config = response.config;
		    $scope.pedidos = data;
		});
	};
	
	carregarPedidos();

	$scope.novopedido = function(){



		console.log("Teste");

		$scope.showformnovopedido = true;
		$scope.habilitarButtonnovopedido = true;

		$http.get("http://localhost:8080/cadastro/produto/all").then(function (response) {

		   $scope.produtos =  response.data;
		});

	};



});



function onlynumbers(evt) {
	var theEvent = evt || window.event;
	var key = theEvent.which;
	var k = theEvent.keyCode;
	key = String.fromCharCode(key);
	var regex = /\d/;
	if (!regex.test(key)) {
		if (k != 46 && k != 9 && k != 8 && k != 13 && k != 36 && k != 35
				&& k != 37 && k != 38 && k != 39 && k != 40) {
			theEvent.returnValue = false;
			if (theEvent.preventDefault)
				theEvent.preventDefault();
		}
	}
}

function onlydecimal(evt) {
	var theEvent = evt || window.event;
	var key = theEvent.which;
	var k = theEvent.keyCode;
	key = String.fromCharCode(key);
	var regex = /\d/;
	if (!regex.test(key)) {
		if (k != 46 && k != 9 && k != 8 && k != 13 && k != 36 && k != 35
				&& k != 37 && k != 38 && k != 39 && k != 40 && key != ','
				&& key != '.' && key != '-') {
			theEvent.returnValue = false;
			if (theEvent.preventDefault)
				theEvent.preventDefault();
		}
	}
}

