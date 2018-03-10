angular.module("appPedido", []);



angular.module("appPedido").controller("pedidocontroller", function ($scope, $http) { 

	$scope.showformnovopedido = false;
	$scope.habilitarButtonnovopedido = false;
 	$scope.pedidoscarregados = false;
 	$scope.errobackendcarregarpedidos = false;
  	$scope.produtoSelecionado=[];
  	$scope.itensselecionadas = [];
  	$scope.totalPedido = 'R$ 0,00';


	var carregarPedidos = function(){

		$http.get("http://localhost:8080/atendimento/pedidosdodia").then(function (response) {

		    var data = response.data;
		    var status = response.status;
		    var statusText = response.statusText;
		    var headers = response.headers;
		    var config = response.config;
		    $scope.pedidos = data;
		    $scope.pedidoscarregados = true;
		}, function myError(response) {

			var status = response.status;
			if (status != 200){
				$scope.errobackendcarregarpedidos = true;
			}

			$scope.statusRetorno = response.statusText;
 			$scope.pedidoscarregados = false;

		}
		);
	};
	
	carregarPedidos();

	$scope.novopedido = function(){


		$scope.itenspedido = [];
		$scope.qtd = 1;
		
		$scope.showformnovopedido = true;
		$scope.habilitarButtonnovopedido = true;

		$http.get("http://localhost:8080/cadastro/produto/all").then(function (response) {

		   $scope.produtos =  response.data;
		});

	};


	$scope.additem = function(produtosel, qtd){
		
		 if (qtd == null){
		 	qtd = 1;
		 }
		 $scope.itensselecionadas.push({
		 	quantidade: qtd,
            valor: produtosel.valor,
            descricao : produtosel.descricao,
            total : qtd * produtosel.valor
		 });

		 calcularTotalpedido();
	};

	calcularTotalpedido = function(){

		$scope.totalPedido = 'R$ 0,00';
		var valor = 0;
		for (i in $scope.itensselecionadas){
			valor = valor + ($scope.itensselecionadas[i].quantidade *  $scope.itensselecionadas[i].valor);
			$scope.totalPedido = 'R$ ' + valor;
		};
	};


	$scope.addpedido = function(pedido, itensselecionadas){

		pedido.itens = itensselecionadas;


		$http.post("http://localhost:8080/atendimento", pedido).then(function (response) {

			carregarPedidos();
			$scope.showformnovopedido = false;
			$scope.habilitarButtonnovopedido = false;
		 	$scope.pedidoscarregados = false;
		 	$scope.errobackendcarregarpedidos = false;
		  	$scope.produtoSelecionado=[];
		  	$scope.itensselecionadas = [];
		  	$scope.totalPedido = 'R$ 0,00';
		  	delete 	$scope.pedido;  
		  	delete  $scope.itensselecionadas;
		});

	};


	$scope.pedidopronto = function(idpedido){

		$http.post("http://localhost:8080/atendimento/pedidopronto/" + idpedido).then(function (response) {
			carregarPedidos();
			$scope.showformnovopedido = false;
			$scope.habilitarButtonnovopedido = false;
		 	$scope.pedidoscarregados = false;
		 	$scope.errobackendcarregarpedidos = false;
		  	$scope.produtoSelecionado=[];
		  	$scope.itensselecionadas = [];
		  	$scope.totalPedido = 'R$ 0,00';
		  	delete 	$scope.pedido;  
		  	delete  $scope.itensselecionadas;
		});

	};


	$scope.pedidoentregue = function(idpedido){

		$http.post("http://localhost:8080/atendimento/pedidoentregue/" + idpedido).then(function (response) {
			carregarPedidos();
			$scope.showformnovopedido = false;
			$scope.habilitarButtonnovopedido = false;
		 	$scope.pedidoscarregados = false;
		 	$scope.errobackendcarregarpedidos = false;
		  	$scope.produtoSelecionado=[];
		  	$scope.itensselecionadas = [];
		  	$scope.totalPedido = 'R$ 0,00';
		  	delete 	$scope.pedido;  
		  	delete  $scope.itensselecionadas;
		});

	};


	$scope.pedidocancelado = function(idpedido){

		$http.post("http://localhost:8080/atendimento/pedidocancelado/" + idpedido).then(function (response) {
			carregarPedidos();
			$scope.showformnovopedido = false;
			$scope.habilitarButtonnovopedido = false;
		 	$scope.pedidoscarregados = false;
		 	$scope.errobackendcarregarpedidos = false;
		  	$scope.produtoSelecionado=[];
		  	$scope.itensselecionadas = [];
		  	$scope.totalPedido = 'R$ 0,00';
		  	delete 	$scope.pedido;  
		  	delete  $scope.itensselecionadas;
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

