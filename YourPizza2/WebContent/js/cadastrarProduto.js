var CadastrarProduto = {

    init: function(){
        CadastrarProduto.setForm();
    },
    
  	setForm: function(){
  		$("#cad").click(function(){
  			
	//  			validar formulario
  			
  			$.post("Produto", { nome: $("#prod").val(), valor: $("#val").val(), tipo: $("#tipo").val() }, function(result){
  				$(location).attr("href", "produtos.html");
  		    });
  		});
    }
};
window.onload = CadastrarProduto.init;