angular.module("appPedido", []);



angular.module("appPedido").controller("pedidocontroller", function ($scope, $http) { 

	
	const dadosPedido = {

		showformnovopedido 			: false,
		desabilitarButtonnovopedido : false,
	 	pedidoscarregados 			: false,
	 	errobackendcarregarpedidos 	: false,
	 	showrespostadeacao			: false,
	 	mensagemrespostadeacao		: false,
	  	pedidos 					: [],
	  	statusRetorno  				: "",
	  	desahabilitarButtonnovopedido : false,
	  	totalPedido 		: "R$ 0,00",
	  	itenspedido			: [],
	  	produtos 			: [],
	  	produtoSelecionado 	: [],
	  	quantidade 			: 1,
	  	novoPedido 			: {
	  		contato				: "",
			entrega 			: "",
			troco   			: 0,
	  		itens 				: []
	  	}	  	
	};

	prepararNovoPedido = function(){

		dadosPedido.showformnovopedido 				= true;
		dadosPedido.desahabilitarButtonnovopedido 	= true;
		dadosPedido.contato 						= "";
		dadosPedido.entrega 						= "";
		dadosPedido.troco   						= 0;
		dadosPedido.quantidade 						= 1;
		dadosPedido.produtoSelecionado 				= [];
	  	dadosPedido.itens 							= [];
	  	dadosPedido.produtos 						= [];
	  	dadosPedido.totalPedido 					= "R$ 0,00";
	};

	limparNovoPedido = function(){

		dadosPedido.contato 			= "";
		dadosPedido.entrega 			= "";
		dadosPedido.troco   			= 0;
		dadosPedido.quantidade 			= 1;
		dadosPedido.produtoSelecionado 	= [];
	  	dadosPedido.itens       		= [];
	  	dadosPedido.totalPedido 		= "R$ 0,00";
	};


	retornarconfigpadrao = function() {

		dadosPedido.showformnovopedido 			= false;
		dadosPedido.desabilitarButtonnovopedido = false;
	 	dadosPedido.errobackendcarregarpedidos 	= false;
	   	dadosPedido.statusRetorno  				= "";
	  	dadosPedido.desahabilitarButtonnovopedido	= false;
	};


	showretornoacao = function(mensagem) {

		dadosPedido.showrespostadeacao = true;
		dadosPedido.mensagemrespostadeacao = mensagem;
	};

	
	var carregarPedidos = function(){

		$http.get("http://localhost:8080/atendimento/pedidosdodia").then(function (response) {

		   	dadosPedido.pedidos = response.data;
		    dadosPedido.pedidoscarregados = true;
		}, function myError(response) {

			var status = response.status;
			if (status != 200){
				dadosPedido.errobackendcarregarpedidos = true;
			}
			dadosPedido.statusRetorno = response.statusText;
 			dadosPedido.pedidoscarregados = false;
		}
		);
	};
	
	carregarPedidos();
	limparNovoPedido();
	$scope.dadosPedido = dadosPedido;
	
	$scope.criarNovoPedido  = function(){

		$http.get("http://localhost:8080/cadastro/produto/all").then(function (response) {

		   dadosPedido.produtos =  response.data;
		});
		prepararNovoPedido();
	};


	$scope.additem = function(produtosel, qtd){
		
		 if (qtd == null){
		 	qtd = 1;
		 }
		 dadosPedido.novoPedido.itens.push({
		 	quantidade: qtd,
            valor: produtosel.valor,
            descricao : produtosel.descricao,
            total : qtd * produtosel.valor
		 });

		dadosPedido.totalPedido = calcularTotalpedido(dadosPedido);
		$scope.dadosPedido = dadosPedido;
		
	};

	calcularTotalpedido = function(){

		dadosPedido.totalPedido = 'R$ 0,00';
		var valor = 0;
		for (i in dadosPedido.novoPedido.itens){
			valor = valor + (dadosPedido.novoPedido.itens[i].quantidade *  dadosPedido.novoPedido.itens[i].valor);
			dadosPedido.totalPedido = 'R$ ' + valor;
		};
		return dadosPedido.totalPedido;
	};


	$scope.addpedido = function(novoPedido){

		
		$http.post("http://localhost:8080/atendimento", novoPedido).then(function (response) {
						

			var mensagem = "Pedido (" + novoPedido.contato + " - " +  novoPedido.entrega + ") Salvo!";
			limparNovoPedido();
			retornarconfigpadrao();
			carregarPedidos();
			showretornoacao(mensagem);
		});

	};


	$scope.pedidopronto = function(pedido){

		$http.post("http://localhost:8080/atendimento/pedidopronto/" + pedido.id).then(function (response) {
			
			var mensagem = "Pedido (" + pedido.contato + " - " +  pedido.entrega + ") Pronto!";
			limparNovoPedido();
			retornarconfigpadrao();
			carregarPedidos();
			showretornoacao(mensagem);
		});

	};


	$scope.carregarItensPedido  = function(idpedido){

		$http.get("http://localhost:8080/atendimento/itensdopedido/" + idpedido).then(function (response) {

		  $scope.itensdopedido =  response.data;
		});
	};


	$scope.pedidoentregue = function(pedido){

		$http.post("http://localhost:8080/atendimento/pedidoentregue/" + pedido.id).then(function (response) {
			
			var mensagem = "Pedido (" + pedido.contato + " - " +  pedido.entrega + ") Entregue!";
			limparNovoPedido();
			retornarconfigpadrao();
			carregarPedidos();
			showretornoacao(mensagem);
		});

	};


	$scope.pedidocancelado = function(pedido){

		$http.post("http://localhost:8080/atendimento/pedidocancelado/" + pedido.id).then(function (response) {
			
			var mensagem = "Pedido (" + pedido.contato + " - " +  pedido.entrega + ") Cancelado!";
			limparNovoPedido();
			retornarconfigpadrao();
			carregarPedidos();
			showretornoacao(mensagem);
		});

	};


	$scope.apresentarTabela = function(){

		return dadosPedido.pedidoscarregados && !dadosPedido.errobackendcarregarpedidos;
	};

	$scope.apresentarMsgNaoHaPedidos = function(){

		return !dadosPedido.pedidoscarregados && dadosPedido.errobackendcarregarpedidos;
	};

	$scope.apresentarMsgErroCarregarPedidos = function(){

		return dadosPedido.errobackendcarregarpedidos;
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

