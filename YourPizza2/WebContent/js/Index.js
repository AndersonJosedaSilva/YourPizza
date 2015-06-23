var Index = {

    init: function(){
        Index.setForm();
        Index.getPromocoes();
    },
    
  	setForm: function(){
  		$("#log1").click(function(){
  			$.post("Login", { login: $("#usu").val(), password: $("#login").val() }, function(result){
  				 $(location).attr("href", result);
  		    });
  		});
    },
    
    getPromocoes: function(){
    	$.get("Promocoes", function(result) {
			$("#promocoes").html(result)
		});
    }
};

window.onload = Index.init;
