$(document).ready(function(){
	$("#bsc_avancada").hide();
	
	$(".btn_escondeBscAvancada").click(function(){
		esconde_bscAvancada();
	});
});



function exibe_bscAvancada(){
	$("#bsc_avancada").show("slow");
	$(".area_input_busca").hide("slow");
}

function esconde_bscAvancada(){
	$("#bsc_avancada").hide("slow");
	$(".area_input_busca").show("slow");
}

