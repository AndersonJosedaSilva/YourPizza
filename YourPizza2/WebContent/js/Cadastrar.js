var Cadastrar = {

    init: function(){
        Cadastrar.setForm();
        Cadastrar.setButtonCancel();
    },
    
  	setForm: function(){
  		$("#cad").click(function(){
//  			validar formulario
  			
  			$.post("Usuario", { nome: $("#nome").val(), senha: $("#senha").val(), endereco: $("#endereco").val(), telefone:$("#telefone").val(), login:$("#login").val() }, function(result){
  				$(location).attr("href", "index.html");
  		    });
  		});
    },
    setButtonCancel: function() {
    	$("#cancel").click(function() {
    		$(location).attr("href", "index.html");
		});
	}
};
window.onload = Cadastrar.init;