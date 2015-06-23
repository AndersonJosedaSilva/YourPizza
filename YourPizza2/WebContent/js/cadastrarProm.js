var CadastrarProm = {

    init: function(){
        CadastrarProm.setForm();
    },
    
  	setForm: function(){
  		$("#cad").click(function(){
  			
	//  			validar formulario
  			
  			$.post("promocao", { nome: $("#prod").val(), valor: $("#val").val() }, function(result){
  				$(location).attr("href", "produtos.html");
  		    });
  		});
    }
};
window.onload = CadastrarProm.init;