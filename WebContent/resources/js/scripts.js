
	
 function beforeLogin(){
    $("#beforelogin").html("Estamos autenticando o usuário. Só um instante...");
 }

 function loginSucess(){
       $("#formLogin").hide("slow");
       $("#titulo").hide("slow");
       $("#beforelogin").html("Aguarde..." + '<div id="followingBallsG"><div id="followingBallsG_1" class="followingBallsG"> </div><div id="followingBallsG_2" class="followingBallsG"></div> <div id="followingBallsG_3" class="followingBallsG"></div><div id="followingBallsG_4" class="followingBallsG"></div></div>');
       $("#beforelogin").show("slow");
       
       setTimeout(function () { window.location.href = "/psc-ModuloLogistica/index.xhtml" }, 5000);
 }

 function loginError(){
    $("#errormessage").html("Usuário não encontrado");
 }
    
